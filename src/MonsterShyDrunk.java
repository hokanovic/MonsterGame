import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterShyDrunk extends MonsterShy {




    public MonsterShyDrunk(int positionx, int positiony, Terminal terminal, TerminalSize size){
        super(positionx, positiony, terminal, size);
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
        terminal.applyForegroundColor(2);

        terminal.putCharacter('\u2649');
        terminal.applyForegroundColor(7);
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
