package sha.bfj;

import java.util.*;

public class VerticalCombinator {
  private List<Slide> slides = new ArrayList<>();

  public VerticalCombinator(ArrayList<Image> verticals) {
    while(verticals.size() > 2) {
      Image searcher = verticals.get(0);
      Slide newSlide = this.findPerfectMatch(searcher, verticals);
      this.slides.add(newSlide);
      verticals.remove(searcher);
      verticals.remove(newSlide.getImages()[1]);
    }
    if (verticals.size() == 2) {
      this.slides.add(new Slide(verticals.get(0), verticals.get(1)));
    }

  }

  private Slide findPerfectMatch(Image searcher, ArrayList<Image> matches) {
    Slide highestYet = new Slide(searcher, matches.get(0));

    for (Image image : matches) {
      Slide tmp = new Slide(searcher, image);

      if (tmp.tags.size() > highestYet.tags.size()) {
        highestYet = tmp;
      }
    }

    return highestYet;
  }

  public List<Slide> getSlides() {
    return slides;
  }
}
