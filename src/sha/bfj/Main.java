package sha.bfj;

import sha.bfj.utils.FileIO;
import sha.bfj.utils.Parser;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
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
      VerticalCombinator verticalCombinator = new VerticalCombinator(verticalImages);

//      for (int i = 0; i < ((verticalImages.size() % 2) == 0 ? verticalImages.size() : verticalImages.size() - 1); i += 2) {
//        slideShow.addSlides(verticalCombinator.getSlides());
//      }

      for (Image image : horizontalImages) {
        slideShow.addSlides(new Slide(image));
      }

      FileIO.write("output/" + file, slideShow.export());

      break; // FOR DEBUGGING: REMOVE FOR THE OTHER TESTING
    }
  }
}
