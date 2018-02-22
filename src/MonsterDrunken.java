import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterDrunken extends GameCharacter {

    private int positionx;
    private int positiony;
    private float cumulativex;
    private float cumulativey;
    private Terminal terminal;
    private TerminalSize terminalsize;


    public MonsterDrunken(){
        this.positionx = 0;
        this.positiony = 0;
    }

    public MonsterDrunken(int positionx, int positiony, Terminal terminal, TerminalSize size){
        this.positionx = positionx;
        this.positiony = positiony;
        this.terminal = terminal;
        this.terminalsize = size;
        drawCharacter(positionx, positiony);
    }

    @Override

    public void moveCharacter(){

    }

    @Override
    public void moveCharacter(Player player) {

        if (player.getPositionx() > positionx) {
            cumulativex += 0.33;
            if (cumulativex > 1) {
                eraseCharacter(positionx, positiony);
                positionx++;
                cumulativex = 0;
                drawCharacter(positionx, positiony);
            }
        } else if (player.getPositionx() < positionx) {
            cumulativex -= 0.33;
            if (cumulativex < -1) {
                eraseCharacter(positionx, positiony);
                positionx--;
                cumulativex = 0;
                drawCharacter(positionx, positiony);
            }
        }
        if (player.getPositiony() > positiony) {
            cumulativey += 0.33;
            if (cumulativey > 1) {
                eraseCharacter(positionx, positiony);
                positiony++;
                cumulativex = 0;
                drawCharacter(positionx, positiony);
            }
        } else if (player.getPositiony() < positiony) {
            cumulativey -= 0.33;
            if (cumulativey < -1) {
                eraseCharacter(positionx, positiony);
                positiony--;
                cumulativey = 0;
                drawCharacter(positionx, positiony);
            }


        }
    }


    @Override

    public void drawCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter('\u26CF');
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
    public float getCumulativex() {
        return cumulativex;
    }
    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
}


