package sha.bfj.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileIO {
  public static String[] list(String path) {
    File f = new File(path);
    FilenameFilter ff = (dir, name) -> name.endsWith(".in");

    String[] list = f.list(ff);
    if (list != null) {
      Arrays.sort(list);
    }

    return list;
  }

  public static String[] read(String path) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(path));
    List<String> lines = new ArrayList<>();
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
