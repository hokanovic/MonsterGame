import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterShyTargetSeeking extends MonsterShy {


        boolean upperleft;
        boolean upperright;
        boolean lowerleft;
        boolean lowerright;


        public MonsterShyTargetSeeking(int positionx, int positiony, Terminal terminal, TerminalSize size){
            super(positionx, positiony, terminal, size);
        }

        @Override

        public void moveCharacter(){

        }

        @Override

        public void moveCharacter(GameCharacter drunk) {
            eraseCharacter(positionx, positiony);


            if(positionx < 2 && positiony < 2) {
                this.upperleft = true;
                this.lowerleft = false;
            }
            else if(positionx > terminalsize.getColumns()-2 && positiony > terminalsize.getRows()-2) {
                this.lowerright = true;
                this.upperleft = false;
            }
            else if(positionx > terminalsize.getColumns()-2 && positiony < 2) {
                this.upperright = true;
                this.lowerright = false;
            }
            else if(positionx < 2 && positiony > terminalsize.getRows()-2) {
                this.lowerleft = true;
                this.upperright = false;
            }

            if(this.upperleft){
                positionx++;
                if(positiony < terminalsize.getRows())
                    positiony++;
            }
            else if(this.lowerright){
                positiony--;
            }
            else if(this.upperright){
                positionx--;
                if(positiony < terminalsize.getRows())
                    positiony++;
            }
            else if(this.lowerleft){
                positiony--;
            }
            drawCharacter(positionx, positiony);
        }


        @Override

        public void drawCharacter(int positionx, int positiony){
            terminal.moveCursor(positionx, positiony);
            terminal.applyForegroundColor(2);

//            terminal.putCharacter('\u2649');
            terminal.putCharacter('S');
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



