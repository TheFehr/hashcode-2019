package sha.bfj;

import sha.bfj.Slide;

import java.util.HashSet;
import java.util.Set;

public class SlidePair {
  public int uniqueA = 0;
  int middle = 0;
  int uniqueB = 0;

  SlidePair(Slide a, Slide b) {
    Set<String> aTags = a.getTags();
    Set<String> bTags = b.getTags();
    Set<String> allTags = a.getTags();
    allTags.addAll(b.getTags());

    Set<String> uniqueATags = new HashSet<String>(aTags);
    uniqueATags.removeAll(bTags);

    Set<String> uniqueBTags = new HashSet<String>(bTags);
    uniqueATags.removeAll(aTags);

    Set<String> middleTags = new HashSet<String>(allTags);
    middleTags.removeAll(uniqueATags);
    middleTags.removeAll(uniqueBTags);

    this.uniqueA = uniqueATags.size();
    this.uniqueB = uniqueBTags.size();
    this.middle = middleTags.size();
  }
}
