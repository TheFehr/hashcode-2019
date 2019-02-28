package sha.bfj;

import sha.bfj.SlidePair;

import java.util.ArrayList;
import java.util.List;

public class SlidesCombinator {
  SlideShow slideShow;
  List<Slide> slides = new ArrayList<>();

  public SlidesCombinator(SlideShow slideShow) {
    List<Slide> slides = slideShow.slides;

    slides.stream().sorted((slide, t1) ->
      slide.getTags().size() - t1.getTags().size()
    );

    while(slides.size() > 0) {
      Slide searcher = slides.get(0);
      SlidePair match = this.findPerfectMatch(searcher, slides);
      slides.remove(0);
      slides.remove(match);
      slideShow.addSlides(searcher);
    }

  }

  private SlidePair findPerfectMatch(Slide searcher, List<Slide> matches) {
    SlidePair highestYet = new SlidePair(searcher, matches.get(0));

    for (Slide slide : matches) {
      SlidePair tmp = new SlidePair(searcher, slide);

      if (tmp.uniqueA > highestYet.uniqueA && tmp.middle > highestYet.middle && tmp.uniqueB > highestYet.uniqueB) {
        highestYet = tmp;
      }
    }

    return highestYet;
  }
}
