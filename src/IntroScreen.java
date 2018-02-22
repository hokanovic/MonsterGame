import com.googlecode.lanterna.terminal.Terminal;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IntroScreen {

/*
    public static void Klocka() {
        String tid = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        String[][] strArr = {
                {"023456789",   "012356789",    "023456789"},
                {"045689",      "1",             "0234789"},
                {"02345689",    "12345689",     "023456789"},
                {"0268",        "1",            "03456789"},
                {"0123568",     "0123568",      "0123456789"}
        };
        for (int k = 0; k < 5; k++, System.out.println())
            for (int i = 0; i < tid.length(); i++) {
                if ((i % 2 == 0) && (i != 0))
                    System.out.print(((k == 1) || (k == 3)) ? "  #  " : "     ");
                for (int j = 0; j < 3; j++)
                    if (strArr[k][j].indexOf(tid.charAt(i)) != -1)
                        System.out.print(j == 2 ? "# " : "#");
                    else
                        System.out.print(j == 2 ? "  " : " ");
            }
    }
*/



    public static void drawIntro(Terminal terminal) {
        System.out.println("Terminal " + terminal);
        System.out.println("drawIntro");

            String textStr = "Game of T";
            String[][] strArr = {
                    {"",    "T",      "T",        "TG",    "TG",    "TG",     "G",       "T"},
                    {"T",    "",       "G",       "T",    "",    "TG",       "GT",       "GT"},
                    {"",    "G",      "T",        "T",    "",    "",           "GT",     "GT"},
                    {"G",   "Gm",     "T",        "aTef",    "amfe",    "ae",       "e",     "m"},
                    {"Gm",   "Gm",    "amTef",       "amTfo",    "amfo",    "amfe",    "aem",    "em"},
                    {"Gm",   "Geam",    "eoTf",        "mT",    "mo",    "ao",       "aem",    "m"},
                    {"Gm",   "Gemf",       "eTof",    "amTf",    "amf",    "Gaeo",    "Gaom",    "Gm"},
                    {"Gm",   "Gemf",       "aeTof",    "mTe",    "mee",    "ao",        "Goam",    "Gm"},
                    {"Gm",   "Gema",        "afTe",    "meTfo",    "mo",    "ao",    "Goam",    "GmT"},
                    {"m",    "Gema",       "GefTa",    "GeTfm",    "Tm",    "ao",    "aTGm",    "ame"},
                    {"m",    "m",        "Gea",    "GaeTm",    "GaeTm",    "GaTe",    "aem",    "m"}
            };
//        IntroScreen.drawIntro(terminal);

        for (int i = 0; i < 11; i++) {
            int kol = 0;
            for (int j = 0; j < textStr.length(); j++,kol += 9) {
                for (int k = 0; k < 8; k++) {
                    if (strArr[i][k].indexOf(textStr.charAt(j)) != -1) {
                        terminal.moveCursor((kol+k),i);
                        terminal.putCharacter('#');
                    }
                    else {
                        terminal.moveCursor((kol+k),i);
                        terminal.putCharacter(' ');
                    }
                }
            }
        }





/*        System.out.println(textStr + " " + textStr.length());
        int kk;
        for (int k = 0; k < 11; k++) {
            kk = 0;
            for (int i = 0; i < textStr.length(); i++, kk += 9) {
                System.out.println("rad " + i + " av " + textStr.length());
                for (int j = 0; j < 8; j++) {
                    if (strArr[k][j].indexOf(textStr.charAt(i)) != -1) {
                        terminal.moveCursor(j, kk);
                        terminal.putCharacter('#');
                    } else {
                        terminal.moveCursor(j, kk);
                        terminal.putCharacter(' ');
                    }
                }
            }
        }*/
    }


}
