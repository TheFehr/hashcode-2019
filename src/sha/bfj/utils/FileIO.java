package sha.bfj.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileIO {
  public static String[] list(String path) {
    File f = new File(path);
    FilenameFilter ff = (dir, name) -> name.endsWith(".txt");

    String[] list = f.list(ff);
    if (list != null) {
      Arrays.sort(list);
    }

    return list;
  }

  public static List<String> read(String path) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(path));
    List<String> lines = new ArrayList<>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      lines.add(line);
    }

    sc.close();
    return lines;
  }

  public static void write(String path, String[] content) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    writer.write(String.join("\n", content));
    writer.close();
  }
}
