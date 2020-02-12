
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String player1Score = "";
    public String player2Score = "";

    public String getScore() {
        String score = "";
        if (isTie() ) {
            return constructTieScore(score);
        }

        if (player1Point > 0 && player2Point == 0) {
            if (player1Point == 1)
                player1Score = "Fifteen";
            if (player1Point == 2)
                player1Score = "Thirty";
            if (player1Point == 3)
                player1Score = "Forty";

            player2Score = "Love";
            score = player1Score + "-" + player2Score;
        }
        if (player2Point > 0 && player1Point == 0) {
            if (player2Point == 1)
                player2Score = "Fifteen";
            if (player2Point == 2)
                player2Score = "Thirty";
            if (player2Point == 3)
                player2Score = "Forty";

            player1Score = "Love";
            score = player1Score + "-" + player2Score;
        }

        if (player1Point > player2Point && isBelowGamePoint()) {
            if (player1Point == 2)
                player1Score = "Thirty";
            if (player1Point == 3)
                player1Score = "Forty";
            if (player2Point == 1)
                player2Score = "Fifteen";
            if (player2Point == 2)
                player2Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }
        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                player2Score = "Thirty";
            if (player2Point == 3)
                player2Score = "Forty";
            if (player1Point == 1)
                player1Score = "Fifteen";
            if (player1Point == 2)
                player1Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player1";
        }

        if (player2Point > player1Point && isGamePointOrAbove()) {
            score = "Advantage player2";
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for player1";
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String constructTieScore(String score) {
        if (isGamePointOrAbove()) {
            return "Deuce";
        }
        if (player1Point == 0)
            score = "Love";
        if (player1Point == 1)
            score = "Fifteen";
        if (player1Point == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    private boolean isGamePointOrAbove() {
        return player1Point >= 3;
    }

    private boolean isBelowGamePoint() {
        return player1Point < 4;
    }

    private boolean isTie() {
        return player1Point == player2Point;
    }

    public void P1Score() {
        player1Point++;
    }

    public void P2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}