import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Player extends GameCharacter {




    public Player(int positionx, int positiony, Terminal terminal, TerminalSize size){
        super(positionx, positiony, terminal, size);
    }

    @Override

    public void moveCharacter(){

    }

    public void moveCharacter(String key){

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
                if(positiony < terminalsize.getRows()-1) {
                    this.eraseCharacter(positionx, positiony);
                    positiony++;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            case "ArrowLeft" : {
                if(positionx > 0) {
                    this.eraseCharacter(positionx, positiony);
                    positionx--;
                    this.drawCharacter(positionx, positiony);
                }
                break;
            }
            case "ArrowRight" : {
                if(positionx < terminalsize.getColumns()-1) {
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
        terminal.applyForegroundColor(6);
//        terminal.applyBackgroundColor(0);
//        terminal.putCharacter('\u2588');
        terminal.putCharacter('O');
        terminal.applyForegroundColor(7);
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

    @Override
    public float getCumulativex() {
        return cumulativex;
    }
    public void setCumulativex(float cumulativex) {
        this.cumulativex = cumulativex;
    }
}
