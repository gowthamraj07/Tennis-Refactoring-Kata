
public class TennisGame2 implements TennisGame {
    public final Player player1 = new Player();
    public final Player player2 = new Player();

    public void wonPoint(String player) {
        if ("player1".equals(player))
            player1.scores();
        else
            player2.scores();
    }

    public String getScore() {
        if (isTie()) {
            return constructTieScore();
        }

        if (player1Wins()) {
            return "Win for player1";
        }

        if (player2Wins()) {
            return "Win for player2";
        }

        if (isAdvantageForPlayer1()) {
            return "Advantage player1";
        }

        if (isAdvantageForPlayer2()) {
            return "Advantage player2";
        }

        return formatScore();
    }

    private String formatScore() {
        return player1.score + "-" + player2.score;
    }

    private boolean isAdvantageForPlayer2() {
        return player2.point > player1.point && isGamePointOrAbove(player1.point);
    }

    private boolean isAdvantageForPlayer1() {
        return player1.point > player2.point && isGamePointOrAbove(player2.point);
    }

    private boolean player2Wins() {
        return player2.point >= 4 && player1.point >= 0 && (player2.point - player1.point) >= 2;
    }

    private boolean player1Wins() {
        return player1.point >= 4 && player2.point >= 0 && (player1.point - player2.point) >= 2;
    }

    private String constructTieScore() {
        if (isGamePointOrAbove(player1.point)) {
            return "Deuce";
        }
        return player1.score + "-All";
    }

    private boolean isGamePointOrAbove(int playerPoint) {
        return playerPoint >= 3;
    }

    private boolean isTie() {
        return player1.point == player2.point;
    }
}