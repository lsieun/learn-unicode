package run;

import lsieun.unicode.utils.UnicodeUtils;

public class UnicodePrint {
    public static void main(String[] args) {
        // ASCII
        UnicodeUtils.print(0x0020, 0x007F);
        // Box-drawing character
        UnicodeUtils.print(0x2505, 0x257F);
    }
}