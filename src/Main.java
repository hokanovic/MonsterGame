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

        int randx;
        int randy;
        Player player = new Player(15, 15, terminal, size);
        GameCharacter[] monsters = new GameCharacter[4];
        for (int i = 0; i < 4 ; i++) {
            randx = (int) Math.floor(Math.random()*size.getColumns());
            randy = (int) Math.floor(Math.random()*size.getRows());
            System.out.println("randx and y are: "+randx+" ,"+randy);
            monsters[i] = new MonsterOne(randx, randy, terminal, size);
        }

        while(true){

            Key key;
            do{
                Thread.sleep(5);
                key = terminal.readInput();
                if(key != null){
                    player.moveCharacter(key.getKind().toString());
                    for(GameCharacter m : monsters)
                        m.moveCharacter(player);
                    checkCollision(player, monsters);
                }
            }
            while(key == null);
        }

    }

   public static void checkCollision(Player player, GameCharacter[] monsters) throws InterruptedException{

        for(int i = 0; i < monsters.length; i++){
            if(player.getPositionx() == monsters[i].getPositionx() && player.getPositiony() == monsters[i].getPositiony()){
                String s = "GAME OVER !";
                terminal.clearScreen();
                lanternString(terminal, s);
                Thread.sleep(5000);
                System.exit(0);
            }
        }



   }

    public static void lanternString(Terminal t, String s){

        for(int i = 0; i < s.length(); i++){

            t.moveCursor(i+44, 14);
            t.putCharacter(s.charAt(i));

        }

    }
}
