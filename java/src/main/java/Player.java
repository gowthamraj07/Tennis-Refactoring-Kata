public class Player {
    public int point = 0;
    public String score = Score.LOVE;

    public void scores() {
        point++;
        score = new Score().constructScore(point);
    }
}