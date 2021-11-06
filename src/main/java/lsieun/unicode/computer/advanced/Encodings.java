package lsieun.unicode.computer.advanced;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class Encodings {
    public static void main(String[] arg) {
        SortedMap<String, Charset> m = Charset.availableCharsets();
        Set<String> k = m.keySet();
        System.out.println("Canonical name, Display name, Can encode, Aliases");
        for (String n : k) {
            Charset e = m.get(n);
            String d = e.displayName();
            boolean c = e.canEncode();
            System.out.print(n + ", " + d + ", " + c);
            Set<String> s = e.aliases();
            for (String a : s) {
                System.out.print(", " + a);
            }
            System.out.println();
        }
    }
}