package hashcode.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * FileIO
 */
public class FileIO {
    public static String[] list(String path) {
        File f = new File(path);
        FilenameFilter ff = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".in");
            }
        };

        return f.list(ff);
    }

    public static String read(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner sc = new Scanner(f);

        sc.useDelimiter("\\n");

        return sc.next();
    }

    public static void write(String path, String[] content) {

    }
}
