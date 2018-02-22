import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class GameCharacter {

    private int positionx;
    private int positiony;
    private float cumulativex;
    private float cumulativey;
    private Terminal terminal;
    private TerminalSize terminalsize;

    public void moveCharacter(){

    }

    public void moveCharacter(Player player){

    }

    public void drawCharacter(int positionx, int positiony){

    }

    public void eraseCharacter(int positionx, int positiony){

    }

    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public float getCumulativex() {
        return cumulativex;
    }

    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
}
