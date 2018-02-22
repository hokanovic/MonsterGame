import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;

public class Main  {

    public static Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    public static TerminalSize size = terminal.getTerminalSize();

    public static void main(String[] args) throws InterruptedException {



        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
//        String start = "GAME OF THRONES";
//        lanternString(terminal, start);
//        Thread.sleep(1000);
//        terminal.clearScreen();

        //IntroScreen.drawIntro(terminal);


        int randx;
        int randy;
        int randy2;
        int randy3;
        Player player = new Player(size.getColumns()/2, size.getRows()/2, terminal, size);
        GameCharacter[] monsters = new GameCharacter[10];
        MonsterShy[] shies = new MonsterShy[4];
        for (int i = 0; i < 9 ; i+=2) {
            randy = (int) Math.floor(Math.random()*size.getRows());
            randy2 = (int) Math.floor(Math.random()*size.getRows());
            monsters[i] = new MonsterDrunken(0, randy2, terminal, size);
            monsters[i + 1] = new MonsterStaggered(30, randy, terminal, size);
        }
        monsters[9] = new MonsterOne(0, 0, terminal, size);
        for (int i = 0; i < shies.length ; i+=2) {
            randx = (int) Math.floor(Math.random()*size.getColumns());
            randy3 = (int) Math.floor(Math.random()*size.getRows());
            shies[i] = new MonsterShy(randx, randy3, terminal, size);
            shies[i+1] = new MonsterShyDrunk(randy3, randx, terminal, size);
        }

        while(true){

            Key key;
            do{
                Thread.sleep(5);
                key = terminal.readInput();
                if(key != null){
                    player.moveCharacter(key.getKind().toString());
                    for (int i = 0; i < monsters.length; i++) {
                        monsters[i].moveCharacter(player);
                    }
                    for (int i = 0; i < shies.length ; i+=2) {
                        shies[i].moveCharacter(player);
                        shies[i+1].moveCharacter(monsters[i]);

                    }
                    checkCollision(player, monsters, shies);
                }
            }
            while(key == null);
        }

    }

   public static void checkCollision(Player player, GameCharacter[] monsters, MonsterShy[] shies) throws InterruptedException{

        for(int i = 0; i < monsters.length; i++){
            if(player.getPositionx() == monsters[i].getPositionx() && player.getPositiony() == monsters[i].getPositiony()){
                String s = "GAME OVER !";
                terminal.clearScreen();
                lanternString(terminal, s);
                Thread.sleep(5000);
                System.exit(0);
            }
        }
       for(int i = 0; i < shies.length; i++) {
           if(player.getPositionx() == shies[i].getPositionx() && player.getPositiony() == shies[i].getPositiony()){
               player.drawCharacter(shies[i].getPositionx(), shies[i].getPositiony());
               shies[i].setPositionx(size.getColumns()*2);
               shies[i].setPositiony(size.getRows() * 2);
               player.setCaught(1);
               if(player.getCaught() == shies.length)
                   winScreen();

           }
       }


   }

    public static void lanternString(Terminal t, String s){

        for(int i = 0; i < s.length(); i++){

            t.moveCursor(i+44, 14);
            t.putCharacter(s.charAt(i));

        }

    }

    public static void winScreen() throws InterruptedException{
        String s = "WIN !";
        terminal.clearScreen();
        lanternString(terminal, s);
        Thread.sleep(5000);
        System.exit(0);

    }

}
