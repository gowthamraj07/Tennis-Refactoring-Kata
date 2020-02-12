
public class TennisGame2 implements TennisGame {
    public final Player player1 = new Player();
    public int player2Point = 0;

    public String player2Score = "";

    public String getScore() {
        if (isTie()) {
            return constructTieScore();
        }

        if (isPlayer1Win()) {
            return "Win for player1";
        }

        if (isPlayer2Win()) {
            return "Win for player2";
        }

        if (isAdvantageForPlayer1()) {
            return "Advantage player1";
        }

        if (isAdvantageForPlayer2()) {
            return "Advantage player2";
        }

        player1.score = constructScore(player1.point);
        player2Score = constructScore(player2Point);
        return player1.score + "-" + player2Score;
    }

    private boolean isAdvantageForPlayer2() {
        return player2Point > player1.point && isGamePointOrAbove(player1.point);
    }

    private boolean isAdvantageForPlayer1() {
        return player1.point > player2Point && isGamePointOrAbove(player2Point);
    }

    private boolean isPlayer2Win() {
        return player2Point >= 4 && player1.point >= 0 && (player2Point - player1.point) >= 2;
    }

    private boolean isPlayer1Win() {
        return player1.point >= 4 && player2Point >= 0 && (player1.point - player2Point) >= 2;
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
        if (isGamePointOrAbove(player1.point)) {
            return "Deuce";
        }
        return constructScore(player1.point) + "-All";
    }

    private boolean isGamePointOrAbove(int playerPoint) {
        return playerPoint >= 3;
    }

    private boolean isTie() {
        return player1.point == player2Point;
    }

    public void player1Scores() {
        player1.point++;
    }

    public void player2Scores() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player))
            player1Scores();
        else
            player2Scores();
    }
}