package helloworld;

/**
 * Created by Yimbo on 2017.07.02..
 */

/**
 * HelloBello object class.
 */
public class HelloBello {

  private final long id;
  private final String content;

  /**
   * HelloBello object constructor.
   * @param id id of the request.
   * @param content the contents of the request.
   */
  public HelloBello(long id, String content) {
    this.id = id;
    this.content = content;
  }

  /**
   * Returns the id as long.
   * @return id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the contents as string.
   * @return contents.
   */
  public String getContent() {
    return content;
  }
}
