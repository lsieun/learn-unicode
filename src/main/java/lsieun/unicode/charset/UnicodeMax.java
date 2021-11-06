package lsieun.unicode.charset;

/**
 * 我想看看：Unicode的最大值在int中占什么位置
 * 看到结果后：还小的很呢
 */
public class UnicodeMax {
    public static void main(String[] args) {
        int unicode_min = 0x0000;
        int unicode_max = 0x10FFFF;
        int int_max = Integer.MAX_VALUE;
        System.out.println("Unicode MIN: " + unicode_min);
        System.out.println("Unicode MAX: " + unicode_max);
        System.out.println("Integer MAX: " + int_max);
        System.out.println(0x10FFFF - (0xDFFF-0xD800));
        System.out.println(Character.UnicodeBlock.of('宋'));
//        Unicode MIN: 0
//        Unicode MAX: 1114111
//        Integer MAX: 2147483647
    }
}