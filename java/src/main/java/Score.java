public class Score {
    public static final String LOVE = "Love";

    String constructScore(int point) {
        if (point == 0)
            return "Love";
        if (point == 1)
            return "Fifteen";
        if (point == 2)
            return "Thirty";

        return "Forty";
    }
}