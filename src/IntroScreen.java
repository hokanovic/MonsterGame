import com.googlecode.lanterna.terminal.Terminal;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IntroScreen {

    public static void drawIntro(Terminal terminal) throws InterruptedException {
        String textStr = "Game of H.E";
        String[][] strArr = {
                {"HE", "HTE", "THEh", "ETG", "TEG", "TEHG", "GEH", "HET"},
                {"ETH", "hEH", "GEhH", "TE", "E", "THEG", "GHET", "GHET"},
                {"HEh", "GEHh", "hEH", "T", "", "H", "GTH", "GHT"},
                {"GEH", "GmEHh", "TOErHh", "aOTef", "aOmfe", "aeHrh", "eHh", "mH"},
                {"GHEm", "GhrHEOm", "amhHTErHef", "amHTOfo", "amrHOhfo", "aOrmHhfe", "aheHOrm", "eHmh"},
                {"GHmEOr", "GeHhOEram", "eoHrEHhTf", "EmHTrh", "moEH", "arHOEo", "aehHOErm", "mEhH"},
                {"GOHEm", "GehHrEOmf", "eThrHEof", "amTEf", "aEmf", "GaHEOo", "GahEHOm", "GhHEm"},
                {"GHOEm", "GeHhmEOrf", "aeTrHEhof", "mTe", "mee", "aHoO", "GoOHham", "GhHm"},
                {"GHOEm", "GehHrEOma", "ahrHfEPTe", "me.Tfo", "mo.", "aHOo", "GoaHhm", "GmHhT"},
                {"mEH", "GehHrOEma", "GefrHhEOTa", "GeTOrEfm.", "TEm.", "aHOEo", "aTHhEGm", "ahHmEe"},
                {"mEH", "mrEHh", "GerOHEha", "GaeETOm.", "GaeEOTm.", "GHaETe", "ahEeHm", "mEHh"}
        };

        int radjusterare = 12;
        int kolumnjusterare = 1;
        int kol = 0;
        for (int i = 0; i < 11; i++, kol = 0)
            for (int j = 0; j < textStr.length(); j++, kol += 9)
                for (int k = 0; k < 8; k++)
                    if (strArr[i][k].indexOf(textStr.charAt(j)) != -1) {
                        terminal.moveCursor((kol + k) + kolumnjusterare, i + radjusterare);
                        terminal.putCharacter(' ');
                        terminal.applyBackgroundColor(3);
                    }

        Thread.sleep(3000);
        terminal.clearScreen();
        terminal.applyBackgroundColor(0);

    }
}
