package sha.bfj.utils;

import sha.bfj.Image;
import sha.bfj.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Parser {
  public static List<Image> parse(List<String> lines) {
    Integer integer = Integer.parseInt(lines.get(0));
    List<Image> images = new ArrayList<>(integer);

    for (int i = 1; i < lines.size(); i++) {
      String[] c = lines.get(i).split(" ");
      Image image = new Image(i - 1, Orientation.valueOf(c[0]));

      for (int j = 2; j < c.length; j++) {
        image.addTag(c[j]);
      }
      images.add(image);
    }

    return images;
  }
}
