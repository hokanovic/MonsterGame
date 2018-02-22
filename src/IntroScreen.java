import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IntroScreen {

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



}
