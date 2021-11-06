package run;

import lsieun.utils.io.FileUtils;

public class WriteText {
    public static void main(String[] args) {
        String filepath = PathManager.getFilePath("sample.txt");
        byte[] bytes = new byte[]{72, 101, 108, 108, 111};
        FileUtils.writeBytes(filepath, bytes);
    }
}