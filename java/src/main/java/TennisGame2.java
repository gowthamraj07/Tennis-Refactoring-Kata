
public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String P1res = "";
    public String P2res = "";

    public String getScore() {
        String score = "";
        if (player1Point == player2Point && player1Point < 4) {
            if (player1Point == 0)
                score = "Love";
            if (player1Point == 1)
                score = "Fifteen";
            if (player1Point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Point == player2Point && player1Point >= 3)
            score = "Deuce";

        if (player1Point > 0 && player2Point == 0) {
            if (player1Point == 1)
                P1res = "Fifteen";
            if (player1Point == 2)
                P1res = "Thirty";
            if (player1Point == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (player2Point > 0 && player1Point == 0) {
            if (player2Point == 1)
                P2res = "Fifteen";
            if (player2Point == 2)
                P2res = "Thirty";
            if (player2Point == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (player1Point > player2Point && player1Point < 4) {
            if (player1Point == 2)
                P1res = "Thirty";
            if (player1Point == 3)
                P1res = "Forty";
            if (player2Point == 1)
                P2res = "Fifteen";
            if (player2Point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                P2res = "Thirty";
            if (player2Point == 3)
                P2res = "Forty";
            if (player1Point == 1)
                P1res = "Fifteen";
            if (player1Point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player1";
        }

        if (player2Point > player1Point && player1Point >= 3) {
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