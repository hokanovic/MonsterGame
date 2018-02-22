import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterOne extends GameCharacter {

    private int positionx;
    private int positiony;
    private float cumulativex;
    private float cumulativey;
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
        this.cumulativex = 0.0f;
        drawCharacter(positionx, positiony);
    }

    @Override

    public void moveCharacter(){

    }

    @Override
    public void moveCharacter(Player player){
        eraseCharacter(positionx, positiony);
        if(this.cumulativex > 1.1)
            this.cumulativex = 0;
        else if(this.cumulativex <= 1.1)
            this.cumulativex += 0.2;
        if(player.getPositionx() > positionx && this.cumulativex >= 1) {
            positionx++;
        }
        else if(player.getPositionx() < positionx && this.cumulativex >= 1) {
            positionx--;
        }
        if(player.getPositiony() > positiony && this.cumulativex >= 1) {
            positiony++;
        }
        else if(player.getPositiony() < positiony && this.cumulativex >= 1) {
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

    public float getCumulativex() {
        return cumulativex;
    }
    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
}


