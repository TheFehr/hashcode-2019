package sha.bfj;

import java.util.ArrayList;
import java.util.List;

public class Slide {
  Image[] images = new Image[2];
  List<String> tags = new ArrayList<>();

  public Slide(Image horizontalImage ){
    this.images[0] = horizontalImage;
    tags.addAll(horizontalImage.getTags());
  }

  public Slide(Image verticalImage1, Image verticalImage2){
    this.images[0] = verticalImage1;
    this.images[1] = verticalImage2;
    this.tags.addAll(verticalImage1.getTags());
    this.tags.addAll(verticalImage2.getTags());
  }


  public Image[] getImages() {
    return images;
  }

  public List<String> getTags() {
    return tags;
  }
}
