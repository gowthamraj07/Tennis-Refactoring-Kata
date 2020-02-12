
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String player1Score = "";
    public String player2Score = "";

    public String getScore() {
        String score = "";
        if (isTie()) {
            return constructTieScore(score);
        }

        if (isBelowGamePoint(player1Point) || isBelowGamePoint(player2Point)) {
            player1Score = constructScore(player1Point);
            player2Score = constructScore(player2Point);
            score = player1Score + "-" + player2Score;
        }

        if (isAdvantageForPlayer1()) {
            score = "Advantage player1";
        }

        if (isAdvantageForPlayer2()) {
            score = "Advantage player2";
        }

        if (isPlayer1Win()) {
            score = "Win for player1";
        }
        if (isPlayer2Win()) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isAdvantageForPlayer2() {
        return player2Point > player1Point && isGamePointOrAbove(player1Point);
    }

    private boolean isAdvantageForPlayer1() {
        return player1Point > player2Point && isGamePointOrAbove(player2Point);
    }

    private boolean isPlayer2Win() {
        return player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2;
    }

    private boolean isPlayer1Win() {
        return player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2;
    }

    private String constructScore(int playerPoint) {
        if (playerPoint == 0)
            return "Love";
        if (playerPoint == 1)
            return "Fifteen";
        if (playerPoint == 2)
            return "Thirty";

        return "Forty";
    }

    private String constructTieScore(String score) {
        if (isGamePointOrAbove(player1Point)) {
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

    private boolean isGamePointOrAbove(int playerPoint) {
        return playerPoint >= 3;
    }

    private boolean isBelowGamePoint(int playerPoint) {
        return playerPoint < 4;
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