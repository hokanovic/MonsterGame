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
    }

    @Override

    public void moveCharacter(){

    }

    @Override
    public void moveCharacter(Player player){
        eraseCharacter(positionx, positiony);
        if(player.getPositionx() + player.getPositiony() > this.positionx + this.positiony){
            positionx = positiony+positionx ;
            drawCharacter(positionx, positiony);
        }
        else if(player.getPositionx() + player.getPositiony() < this.positionx + this.positiony){
            positionx = positiony-positionx ;
            drawCharacter(positionx, positiony);
        }
        else if(player.getPositionx() - player.getPositiony() < this.positionx + this.positiony){
            positionx = positiony-positionx ;
            drawCharacter(positionx, positiony);
        }
        else if(player.getPositionx() - player.getPositiony() > this.positionx + this.positiony){
            positionx = positiony+positionx ;
            drawCharacter(positionx, positiony);
        }


    }


    @Override

    public void drawCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter('D');
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
}


