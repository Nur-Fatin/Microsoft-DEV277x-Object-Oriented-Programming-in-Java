import java.awt.*;
public class WhiteTiger extends Critter{
    private int moves;
    private boolean infected;

    public WhiteTiger() {
        moves=0;
        infected = false;
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        if(infected==true){
            return "TGR";

        } else {
            return "tgr";
        }
    }

    public Action getMove(CritterInfo info) {
        moves++;
        if(info.getFront()==Neighbor.OTHER) {
            infected = true;
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
