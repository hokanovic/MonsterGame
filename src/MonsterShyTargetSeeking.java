import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MonsterShyTargetSeeking extends MonsterShy {

        private int positionx;
        private int positiony;
        private float cumulativex;
        private float cumulativey;
        boolean upperleft;
        boolean lowerright;
        private Terminal terminal;
        private TerminalSize terminalsize;


        public MonsterShyTargetSeeking(){
            this.positionx = 0;
            this.positiony = 0;
        }

        public MonsterShyTargetSeeking(int positionx, int positiony, Terminal terminal, TerminalSize size){
            this.positionx = positionx;
            this.positiony = positiony;
            this.terminal = terminal;
            this.terminalsize = size;
            this.cumulativex = 0;
            this.cumulativey = 0;
            this.upperleft = false;
            this.lowerright = false;
            drawCharacter(positionx, positiony);
        }

        @Override

        public void moveCharacter(){

        }

        @Override

        public void moveCharacter(GameCharacter drunk) {
            eraseCharacter(positionx, positiony);


            if(positionx < 1 && positiony < 1)
                this.upperleft = true;
            else if(positionx > terminalsize.getColumns()-2 && positiony > terminalsize.getRows()-2)
                this.lowerright = true;
            if(this.upperleft)

            if(positionx < terminalsize.getColumns() ) {
                positionx++;
            }
            else if(positiony > 0) {
                positionx--;
            }
            if(positiony < terminalsize.getRows()) {
                positiony++;
            }
            else if(positiony > 0 ) {
                positiony--;
            }
            drawCharacter(positionx, positiony);
        }


        @Override

        public void drawCharacter(int positionx, int positiony){
            terminal.moveCursor(positionx, positiony);
            terminal.putCharacter('!');
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



