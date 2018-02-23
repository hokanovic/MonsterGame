import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterStaggered extends GameCharacter {





    public MonsterStaggered(int positionx, int positiony, Terminal terminal, TerminalSize size){
        super(positionx, positiony, terminal, size);
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
        terminal.applyForegroundColor(1);
        terminal.putCharacter('\u26CF');

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
    public float getCumulativex() {
        return cumulativex;
    }
    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
}




