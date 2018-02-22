import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

    public class MonsterShy extends GameCharacter {

        private int positionx;
        private int positiony;
        private float cumulativex;
        private float cumulativey;
        private Terminal terminal;
        private TerminalSize terminalsize;


        public MonsterShy(){
            this.positionx = 0;
            this.positiony = 0;
        }

        public MonsterShy(int positionx, int positiony, Terminal terminal, TerminalSize size){
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

        public void moveCharacter(Player player) {
            if (player.getPositionx() - this.positionx < 5 || this.positionx - player.getPositionx() < 5 || player.getPositiony() - this.positiony < 5 || this.positiony - player.getPositiony() < 5) {
                if (player.getPositionx() > this.positionx && this.positionx > 0) {
                    this.cumulativex += 0.5;
                    if (this.cumulativex > 1) {
                        eraseCharacter(this.positionx, this.positiony);
                        this.positionx--;
                        this.cumulativex = 0;
                        drawCharacter(this.positionx, this.positiony);
                    }
                } else if (player.getPositionx() < this.positionx && this.positionx < terminalsize.getColumns()) {
                    this.cumulativex -= 0.5;
                    if (this.cumulativex < -1) {
                        eraseCharacter(this.positionx, this.positiony);
                        this.positionx++;
                        this.cumulativex = 0;
                        drawCharacter(this.positionx, this.positiony);
                    }
                }
                if (player.getPositiony() > this.positiony && this.positiony > 0) {
                    this.cumulativey += 0.5;
                    if (this.cumulativey > 1) {
                        eraseCharacter(this.positionx, this.positiony);
                        this.positiony--;
                        this.cumulativex = 0;
                        drawCharacter(this.positionx, this.positiony);
                    }
                } else if (player.getPositiony() < this.positiony  && this.positiony < terminalsize.getRows()) {
                    this.cumulativey -= 0.5;
                    if (this.cumulativey < -1) {
                        eraseCharacter(this.positionx, this.positiony);
                        this.positiony++;
                        this.cumulativey = 0;
                        drawCharacter(this.positionx, this.positiony);
                    }


                }


            }
        }


        @Override

        public void drawCharacter(int positionx, int positiony){
            terminal.moveCursor(positionx, positiony);
            terminal.putCharacter('S');
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




