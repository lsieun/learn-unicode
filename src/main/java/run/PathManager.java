package run;

import java.util.Objects;

public class PathManager {
    public static String getFilePath(String filename) {
        String dir = Objects.requireNonNull(WriteText.class.getResource("/")).getPath();
        String filepath = dir + filename;
        System.out.println("file://" + filepath);
        return filepath;
    }
}
