package sha.bfj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Slide {
  Image[] images = new Image[2];
  Set<String> tags = new HashSet<>();

  public Slide(Image horizontalImage) {
    this.images[0] = horizontalImage;
    tags.addAll(horizontalImage.getTags());
  }

  public Slide(Image verticalImage1, Image verticalImage2) {
    this.images[0] = verticalImage1;
    this.images[1] = verticalImage2;
    this.tags.addAll(verticalImage1.getTags());
    this.tags.addAll(verticalImage2.getTags());
  }


  public Image[] getImages() {
    return images;
  }

  public Set<String> getTags() {
    return tags;
  }

  @Override
  public String toString() {
    return "Slide{" +
      "images=" + Arrays.toString(images) +
      ", tags=" + tags +
      '}';
  }
}
