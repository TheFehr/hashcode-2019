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

      System.out.println(">> Parsed file");

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
      List<Slide> slides = verticalCombinator.getSlides();
      slideShow.addSlides(slides);

      System.out.println(">> Added vertical slides to slideshow");

//      for (int i = 0; i < ((verticalImages.size() % 2) == 0 ? verticalImages.size() : verticalImages.size() - 1); i += 2) {
//        slideShow.addSlides(verticalCombinator.getSlides());
//      }

      for (Image image : horizontalImages) {
        slideShow.addSlides(new Slide(image));
      }

      System.out.println(">> Added horizontal slides to slideshow");

      SlidesCombinator slidesCombinator = new SlidesCombinator(slideShow);

      SlideShow sortedSlideShow = slidesCombinator.getSlideShow();

      System.out.println(">> Slideshow sorted");

      FileIO.write("output/" + file, sortedSlideShow.export());

      System.out.println("= File written!");

//      break; // FOR DEBUGGING: REMOVE FOR THE OTHER TESTING
    }
  }
}
