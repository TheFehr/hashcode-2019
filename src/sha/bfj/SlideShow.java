package sha.bfj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlideShow {
  List<Slide> slides = new ArrayList<>();

  public void addSlides(Slide... slide) {
    slides.addAll(Arrays.asList(slide));
  }

  public void addSlides(List<Slide> slide) {
    slides.addAll(slide);
  }

  public String[] export() {
    ArrayList<String> lines = new ArrayList<>();
    lines.add(slides.size() + "");
    for (Slide slide : slides) {
      lines.add(slide.toIdString());
    }

    return lines.toArray(new String[0]);
  }
}
