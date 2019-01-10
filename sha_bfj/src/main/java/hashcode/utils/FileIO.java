package hashcode.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
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

    public static String[] read(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);
        sc.close();

        return arr;
    }

    public static void write(String path, String[] content) {

    }
}
