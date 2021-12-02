import java.awt.*;
import java.util.Random;

public class Tiger extends Critter{
    private int moves;
    private Color currentColor;
    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};

    public Tiger() {
        moves=0;
    }

    /* Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
     and uses that color for three moves, then randomly picks one of those colors
     again for the next three moves, then randomly picks another one of those
     colors for the next three moves, and so on.
     */
    public Color getColor() {
        Random rand = new Random();
        if (moves % 3 == 0) {
            currentColor = COLORS[rand.nextInt(COLORS.length)];
        }
        return currentColor;
    }

    public String toString() {
        return "TGR";
    }

    public Action getMove(CritterInfo info) {
        moves++;
        if(info.getFront()==Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;

        } else if(info.getFront()==Neighbor.SAME) {
            return Action.RIGHT;

        } else {
            return Action.HOP;
        }
    }
}
