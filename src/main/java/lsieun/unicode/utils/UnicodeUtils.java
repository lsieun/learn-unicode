package lsieun.unicode.utils;

import lsieun.utils.radix.HexUtils;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Formatter;

public class UnicodeUtils {
    private static final String EMPTY = "";
    public static final String HEADER_FORMAT = "|          | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | A | B | C | D | E | F |";
    public static final String SEPARATOR_FORMAT = "|----------|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|";
    public static final String CELL_FORMAT = "| U+%-6s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s | %1s |";

    public static void print(int from, int to) {
        print(from, to, System.out);
    }

    public static void print(int from, int to, OutputStream out) {
        int rowStart = findBaseNum(from);
        int rowStop = findBaseNum(to);

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("%s%n", HEADER_FORMAT);
        fm.format("%s%n", SEPARATOR_FORMAT);
        for (int i = rowStart; i <= rowStop; i += 16) {
            String line = getLine(i, from, to);
            fm.format("%s%n", line);
        }
        String result = sb.toString();

        PrintWriter writer = new PrintWriter(out);
        writer.println(result);
        writer.flush();
    }

    private static int findBaseNum(int val) {
        return val / 16 * 16;
    }

    private static String getLine(int columnStart, int from, int to) {
        String[] array = new String[17];
        array[0] = HexUtils.charToHex((char) columnStart).toUpperCase();
        for (int i = 0; i < 16; i++) {
            int codePoint = columnStart + i;
            if (codePoint >= from && codePoint <= to) {
                array[i + 1] = getUnicodeValue(codePoint);
            }
            else {
                array[i + 1] = EMPTY;
            }
        }

        return String.format(CELL_FORMAT, (Object[]) array);
    }

    public static String getUnicodeValue(int codePoint) {
        if (Character.isValidCodePoint(codePoint) && Character.isDefined(codePoint)) {
            char[] chars = Character.toChars(codePoint);
            return String.valueOf(chars);
        }
        return EMPTY;
    }
}
