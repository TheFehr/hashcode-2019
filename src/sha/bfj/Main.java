package sha.bfj;

import sha.bfj.utils.FileIO;
import sha.bfj.utils.Parser;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    try {
      String[] fileList = FileIO.list("data");

      for (String file : fileList) {
        System.out.println(file);

        List<Image> images = Parser.parse(FileIO.read("data/" + file));
        System.out.println(images);

        for (Image image : images) {
          System.out.println(image.toString());
        }


        break; // FOR DEBUGGING: REMOVE FOR THE OTHER TESTING
      }
    } catch (Exception e) {

    }
  }
}
