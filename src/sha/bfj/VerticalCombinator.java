package sha.bfj;

import java.util.ArrayList;
import java.util.List;

public class VerticalCombinator {
  List<Image> verticals = new ArrayList<>();
  List<Slide> slides = new ArrayList<>();

  public VerticalCombinator(List<Image> verticals) {
    this.verticals = verticals;


  }

  public List<Slide> getSlides() {
    return slides;
  }
}
