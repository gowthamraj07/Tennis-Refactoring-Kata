
public class TennisGame2 implements TennisGame {
    public static final String TIE_SCORE_SUFFIX = "-All";
    public static final String PLAYER_1_WINS = "Win for player1";
    public static final String PLAYER_2_WINS = "Win for player2";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String PLAYER_1 = "player1";
    public static final String SCORE_SEPARATOR = "-";

    public final Player player1 = new Player();
    public final Player player2 = new Player();

    public void wonPoint(String player) {
        if (PLAYER_1.equals(player))
            player1.scores();
        else
            player2.scores();
    }

    public String getScore() {
        if (isTie()) {
            return constructTieScore();
        }

        if (player1Wins()) {
            return PLAYER_1_WINS;
        }

        if (player2Wins()) {
            return PLAYER_2_WINS;
        }

        if (isAdvantageForPlayer1()) {
            return ADVANTAGE_PLAYER_1;
        }

        if (isAdvantageForPlayer2()) {
            return ADVANTAGE_PLAYER_2;
        }

        return formatScore();
    }

    private String formatScore() {
        return player1.score + SCORE_SEPARATOR + player2.score;
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
            return Score.DEUCE;
        }
        return player1.score + TIE_SCORE_SUFFIX;
    }

    private boolean isGamePointOrAbove(int playerPoint) {
        return playerPoint >= 3;
    }

    private boolean isTie() {
        return player1.point == player2.point;
    }
}