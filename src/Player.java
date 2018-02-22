import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Player extends GameCharacter {

    private int positionx;
    private int positiony;
    private int steps;
    private int caught;


    private Terminal terminal;
    private TerminalSize terminalsize;


    public Player(){
        this.positionx = 0;
        this.positiony = 0;
    }

    public Player(int positionx, int positiony, Terminal terminal, TerminalSize size){
        this.positionx = positionx;
        this.positiony = positiony;
        this.terminal = terminal;
        this.terminalsize = size;
        this.steps = 0;
        drawCharacter(positionx, positiony);
    }

    @Override

    public void moveCharacter(){

    }

    public void moveCharacter(String key){
        //System.out.println("You pressed "+key);
        switch(key){
            case "ArrowUp" : {
                if(positiony > 0) {
                    this.eraseCharacter(positionx, positiony);
                    positiony--;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            case "ArrowDown" : {
                if(positiony+1 < terminalsize.getRows()) {
                    this.eraseCharacter(positionx, positiony);
                    positiony++;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            case "ArrowLeft" : {
                if(positionx-1 > 0) {
                    this.eraseCharacter(positionx, positiony);
                    positionx--;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            case "ArrowRight" : {
                if(positionx+1 < terminalsize.getColumns()) {
                    this.eraseCharacter(positionx, positiony);
                    positionx++;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            default :
                break;
        }
    }



    @Override

    public void drawCharacter(int positionx, int positiony){
        terminal.moveCursor(positionx, positiony);
        terminal.putCharacter('O');
        steps++;
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

    public int getCaught() {
        return caught;
    }

    public void setCaught(int caught) {
        this.caught += caught;
    }
}
