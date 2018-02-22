import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterStaggered extends GameCharacter {

    private int positionx;
    private int positiony;
    private float cumulativex;
    private float cumulativey;
    private Terminal terminal;
    private TerminalSize terminalsize;


    public MonsterStaggered(){
        this.positionx = 0;
        this.positiony = 0;
    }

    public MonsterStaggered(int positionx, int positiony, Terminal terminal, TerminalSize size){
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
    public void moveCharacter(Player player){

        double rand = Math.random();
        double rand2 = Math.random();
        eraseCharacter(positionx, positiony);

        if(rand2 < 0.5) {
            if (player.getPositionx() > positionx) {
                if (rand > 0.5)
                    positionx++;
            } else if (player.getPositionx() < positionx) {
                if (rand > 0.5)
                    positionx--;
            }
        }
        else if(rand2 > 0.5) {
            if (player.getPositiony() > positiony) {
                if (rand > 0.5)
                    positiony++;
            } else if (player.getPositiony() < positiony) {
                if (rand > 0.5)
                    positiony--;
            }
        }
        drawCharacter(positionx, positiony);


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




