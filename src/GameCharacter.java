import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class GameCharacter {


    protected int positionx;
    protected int positiony;
    protected float cumulativex;
    protected float cumulativey;
    protected Terminal terminal;
    protected TerminalSize terminalsize;
    protected int steps;
    protected int caught;

    public GameCharacter(int positionx, int positiony, Terminal terminal, TerminalSize size){
        positionx = positionx;
        positiony = positiony;
        terminal = terminal;
        terminalsize = size;
        steps = 0;
        drawCharacter(positionx, positiony);
    }

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
