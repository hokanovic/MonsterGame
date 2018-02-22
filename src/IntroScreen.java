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



    public static void drawIntro(Terminal terminal) throws InterruptedException {
        System.out.println("Terminal " + terminal);
        System.out.println("drawIntro");

            String textStr = "Game";
            String[][] strArr = {
                    {"",    "T",           "Th",        "TG",         "TG",          "TG",            "G",            "T"},
                    {"T",    "h",        "Gh",       "T",             "",               "TG",       "GT",            "GT"},
                    {"h",    "Gh",         "hT",        "T",         "",               "",       "GT",             "GT"},
                    {"G",   "Gmh",          "TOrh",        "aOTef",        "aOmfe",    "aerh",            "eh",           "m"},
                    {"Gm",   "GhrOm",         "amhTref",       "amTOfo",    "amrOhfo",    "aOrmhfe",    "aheOrm",         "emh"},
                    {"GmOr",   "GehOram",       "eorhTf",        "mTrh",    "mo",       "arOo",         "aehOrm",           "mh"},
                    {"GOm",   "GehrOmf",       "eThrof",    "amTf",    "amf",        "GaeOo",         "GahoOm",         "Ghm"},
                    {"GOm",   "GehmOrf",       "aeTrhof",    "mTe",    "mee",        "aoO",             "GoOham",         "Ghm"},
                    {"GOm",   "GehrOma",        "ahrfPTe",    "meTfo",    "mo",        "aOo",          "Goahm",           "GmhT"},
                    {"m",    "GehrOma",       "GefrhOTa",    "GeTOrfm",    "Tm",       "aOo",           "aThGm",           "ahme"},
                    {"m",    "mrh",           "GerOha",    "GaeTOm",    "GaeOTm",      "GaTe",    "ahem",                 "mh"}
            };
//        IntroScreen.drawIntro(terminal);
int radjusterare = 10;
int kolumnjusterare = 15;
        for (int i = 0; i < 11; i++) {
            int kol = 0;
            for (int j = 0; j < textStr.length(); j++,kol += 9) {
                for (int k = 0; k < 8; k++) {
                    if (strArr[i][k].indexOf(textStr.charAt(j)) != -1) {
                        terminal.moveCursor((kol+k)+kolumnjusterare,i+radjusterare);
                        terminal.putCharacter(' ');
                        terminal.applyBackgroundColor(3);
//                        terminal.applyForegroundColor(3);

                    }
                }
            }
        }



        Thread.sleep(3000);
        terminal.clearScreen();

        terminal.applyBackgroundColor(0);
//                        terminal.applyForegroundColor(3);




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
