import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterOne extends GameCharacter {

    private int positionx;
    private int positiony;
    private int playerpositionx;
    private int playerpositiony;
    private Terminal terminal;
    private TerminalSize terminalsize;


    public MonsterOne(){
        this.positionx = 0;
        this.positiony = 0;
    }

    public MonsterOne(int positionx, int positiony, Terminal terminal, TerminalSize size){
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
        this.playerpositionx = player.getPositionx();
        this.playerpositiony = player.getPositiony();
        eraseCharacter(positionx, positiony);
        if(playerpositionx > positionx) {
            positionx++;
        }
        else if(playerpositionx < positionx) {
            positionx--;
        }
        if(playerpositiony > positiony) {
            positiony++;
        }
        else if(playerpositiony < positiony) {
            positiony--;
        }
        drawCharacter(positionx, positiony);


    }


    @Override

    public void drawCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter('X');
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


