package sha.bfj;

import sha.bfj.utils.FileIO;
import sha.bfj.utils.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    try {
      String[] fileList = FileIO.list("data");

      for (String file : fileList) {
        System.out.println(file);

        List<Image> images = Parser.parse(FileIO.read("data/" + file));

        ArrayList<Image> verticalImages = new ArrayList<>();
        ArrayList<Image> horizontalImages = new ArrayList<>();
        for (Image image : images) {
          if (image.orientation == Orientation.H) {
            horizontalImages.add(image);
          } else {
            verticalImages.add(image);
          }
        }

        SlideShow slideShow = new SlideShow();

        for (int i = 0; i < ((verticalImages.size() % 2) == 0 ? verticalImages.size() : verticalImages.size() - 1); i += 2) {
          slideShow.addSlides(new Slide(verticalImages.get(i), verticalImages.get(i+1)));
        }

        for (Image image : horizontalImages) {
          slideShow.addSlides(new Slide(image));
        }



        break; // FOR DEBUGGING: REMOVE FOR THE OTHER TESTING
      }
    } catch (Exception e) {

    }
  }
}
