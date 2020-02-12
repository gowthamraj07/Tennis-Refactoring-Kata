
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String player1Score = "";
    public String player2Score = "";

    public String getScore() {
        String score = "";
        if (isTie()) {
            return constructTieScore();
        }

        if (isPlayer1Win()) {
            return "Win for player1";
        }

        if (isPlayer2Win()) {
            return "Win for player2";
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

    private String constructTieScore() {
        if (isGamePointOrAbove(player1Point)) {
            return "Deuce";
        }
        String score = constructScore(player1Point);
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

    public void player1Scores() {
        player1Point++;
    }

    public void player2Scores() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Scores();
        else
            player2Scores();
    }
}