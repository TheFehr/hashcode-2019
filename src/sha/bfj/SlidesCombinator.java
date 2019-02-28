package sha.bfj;

import java.util.*;

class SlidesCombinator {
  private SlideShow slideShow;

  SlidesCombinator(SlideShow slideShow) {
    this.slideShow = slideShow;

    HashMap<String, List<Slide>> slideTagMap = new HashMap<>();

    for (Slide slide : this.slideShow.slides) {
      for (String tag : slide.tags) {
        if (slideTagMap.get(tag) != null) {
          slideTagMap.get(tag).add(slide);
        } else {
          slideTagMap.put(tag, new ArrayList<>(Collections.singletonList(slide)));
        }
      }
    }

    Map<String, List<Slide>> sorted = sortByValue(slideTagMap);

    for (int i = 0; i < 5; i++) {
      
    }
  }

  public static Map<String, List<Slide>> sortByValue(HashMap<String, List<Slide>> map) {
    List<Map.Entry<String, List<Slide>>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.comparingByValue(Comparator.comparingInt(List::size)));
    Collections.reverse(list);

    Map<String, List<Slide>> result = new LinkedHashMap<>();
    for (Map.Entry<String, List<Slide>> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }

    return result;
  }

  public SlideShow getSlideShow() {
    return this.slideShow;
  }
}


//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SlidesCombinator {
//  SlideShow slideShow = new SlideShow();
//
//  public SlidesCombinator(SlideShow slideShow) {
//    List<Slide> slides = slideShow.slides;
//
//    slides = slides.stream().sorted(Comparator.comparingInt(slide -> slide.getTags().size())).collect(Collectors.toList());
//
//    while (slides.size() > 1) {
//      Slide searcher = slides.get(0);
//      slides.remove(searcher);
//      SlidePair match = this.findPerfectMatch(searcher, slides);
//      slides.remove(match.getBSlide());
//      this.slideShow.addSlides(match.getASlide(), match.getBSlide());
//      System.out.println(this.slideShow.slides.size() + " " + slides.size());
//    }
//
//    if (slides.size() == 1) {
//      this.slideShow.addSlides(slides.get(0));
//    }
//
//  }
//
//  private SlidePair findPerfectMatch(Slide searcher, List<Slide> matches) {
//    SlidePair highestYet = new SlidePair(searcher, matches.get(0));
//
//    for (Slide slide : matches) {
//      SlidePair tmp = new SlidePair(searcher, slide);
//
//      if (tmp.uniqueA > highestYet.uniqueA && tmp.middle > highestYet.middle && tmp.uniqueB > highestYet.uniqueB) {
//        highestYet = tmp;
//      }
//    }
//
//    return highestYet;
//  }
//
//  public SlideShow getSlideShow() {
//    return slideShow;
//  }
//}
