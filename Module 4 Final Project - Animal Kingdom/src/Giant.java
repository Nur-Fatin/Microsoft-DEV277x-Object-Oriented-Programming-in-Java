import java.awt.*;

public class Giant extends Critter{
    private int moves;
    private String wordDisplay;

    public Giant() {
        moves = 0;
        wordDisplay = " ";
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        if (moves == 6) {
            wordDisplay = "fee";
            return wordDisplay;
        } else if (wordDisplay.equals("fee") && moves % 6 == 0) {
            wordDisplay = "fie";
            return wordDisplay;
        } else if (wordDisplay.equals("fie") && moves % 6 == 0) {
            wordDisplay = "foe";
            return wordDisplay;
        } else if (wordDisplay.equals("foe" ) && moves % 6 == 0) {
            wordDisplay = "fum";
            return wordDisplay;
        }  else if (wordDisplay.equals("fum" ) && moves % 6 == 0) {
            wordDisplay = "fee";
            return wordDisplay;
        } else {
            return wordDisplay;
        }
    }

    public Action getMove(CritterInfo info) {
            moves++;
            if(info.getFront()==Neighbor.OTHER) {
                return Action.INFECT;

            } else if (info.getFront() == Neighbor.WALL) {
                return Action.RIGHT;

            } else {
                return Action.HOP;
            }
    }
}
