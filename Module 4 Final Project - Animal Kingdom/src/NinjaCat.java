import java.awt.*;

public class NinjaCat extends Critter{



    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        return "CAT";
    }

    public Action getMove(CritterInfo info) {
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
