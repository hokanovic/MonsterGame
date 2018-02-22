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

        while(true){

            Key key;
            do{
                Thread.sleep(5);
                key = terminal.readInput();
                if(key != null){
                    keyPress(key);
                }
            }
            while(key == null);
            System.out.println(key.getCharacter()+ " " + key.getKind());
        }

    }

    public static void keyPress(Key key){
        switch(key.getKind()) {
            case ArrowDown: {
                System.out.println("you pressed up");
                break;
            }
            case ArrowUp:
                break;
            case ArrowLeft:
                break;
            case ArrowRight:
                break;
            default :
                break;
        }
    }

}
