public class Score {
    public static final String LOVE = "Love";

    String constructScore(int playerPoint) {
        if (playerPoint == 0)
            return "Love";
        if (playerPoint == 1)
            return "Fifteen";
        if (playerPoint == 2)
            return "Thirty";

        return "Forty";
    }
}