package run;

import lsieun.unicode.utils.UnicodeUtils;

public class HelloWorld {
    public static void main(String[] args) {
//        char ch = '\u0041';
//        System.out.println(ch);
//        System.out.println(UnicodeUtils.getHeaderFormat());
        UnicodeUtils.print(0x2500, 0x257F);
    }
}