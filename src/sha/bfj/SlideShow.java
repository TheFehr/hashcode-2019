package sha.bfj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlideShow {
  List<Slide> slides = new ArrayList<>();

  public void addSlides(Slide... slide) {
    slides.addAll(Arrays.asList(slide));
  }

  public String[] export() {
    ArrayList<String> lines = new ArrayList<>();
    lines.add(slides.size() + "");
    for (Slide slide : slides) {
      lines.add(slide.exportStringBecausePhilippsToStringMethodIsShitty());
    }

    return lines;
  }
}
