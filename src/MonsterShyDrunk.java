import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterShyDrunk extends MonsterShy {


    private int positionx;
    private int positiony;
    private float cumulativex;
    private float cumulativey;
    private Terminal terminal;
    private TerminalSize terminalsize;


    public MonsterShyDrunk(){
        this.positionx = 0;
        this.positiony = 0;
    }

    public MonsterShyDrunk(int positionx, int positiony, Terminal terminal, TerminalSize size){
        this.positionx = positionx;
        this.positiony = positiony;
        this.terminal = terminal;
        this.terminalsize = size;
        this.cumulativex = 0;
        this.cumulativey = 0;
        drawCharacter(positionx, positiony);
    }

    @Override

    public void moveCharacter(){

    }

    @Override

    public void moveCharacter(GameCharacter drunk) {
        eraseCharacter(positionx, positiony);

        if(drunk.getPositionx() > positionx+1 ) {
            positionx++;
        }
        else if(drunk.getPositionx() < positionx-1) {
            positionx--;
        }
        if(drunk.getPositiony() > positiony+1) {
            positiony++;
        }
        else if(drunk.getPositiony() < positiony-1 ) {
            positiony--;
        }
        drawCharacter(positionx, positiony);
    }


    @Override

    public void drawCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter('!');
    }

    @Override

    public void eraseCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter(' ');
    }

    @Override
    public int getPositionx() {
        return positionx;
    }

    @Override
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    @Override
    public int getPositiony() {
        return positiony;
    }

    @Override
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
    public float getCumulativex() {
        return cumulativex;
    }

}