package sha.bfj;

import java.util.ArrayList;
import java.util.List;

public class Image {
  int id;
  Orientation orientation;
  List<String> tags;

  public Image(int id, Orientation orientation) {
    this.id = id;
    this.orientation = orientation;
    tags = new ArrayList<>();
  }

  public void addTag(String s) {
    tags.add(s);
  }


  public List<String> getTags() {
    return tags;
  }

  @Override
  public String toString() {
    return "Image{" +
      "id=" + id +
      ", orientation=" + orientation +
      ", tags=" + tags +
      '}';
  }

}

