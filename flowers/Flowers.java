package flowers;

/**
 * The `Flowers` class represents a basic type of flowers with attributes such as length, total price and level of freshness.
 */
public class Flowers {
  private final int length;
  private int totalPrice;
  private final int levelOfFreshness;

  /**
   * Creates a new `Flowers` object.
   *
   * @param length            The length of the flower.
   * @param levelOfFreshness  The level of freshness of the flower.
   */
  public Flowers(int length, int levelOfFreshness) {
    this.length = length;
    this.levelOfFreshness = levelOfFreshness;
  }

  /**
   * Gets the length of the flower.
   *
   * @return The length of the flower.
   */
  public int getLength() {
    return length;
  }

  /**
   * Gets the length of the flower.
   *
   * @return The length of the flower.
   */
  public int getTotalPrice() {
    return totalPrice;
  }

  /**
   * Sets the total price of the flowers.
   *
   */
  public void setTotalPrice(int price) {
    totalPrice = price * length;
  }

  /**
   * Gets the level of freshness of the flower.
   *
   * @return The freshness of the flower.
   */
  public int getLevelOfFreshness() {
    return levelOfFreshness;
  }

  /**
   * Makes the description of the flower.
   *
   * @return The description of the flower.
   */
  @Override
  public String toString() {
    return String.format("Flower: %s\nLength: %d\nTotal price: %d\nLevel of freshness: %d\n",
            this.getClass().getSimpleName(), length, totalPrice, levelOfFreshness);
  }
}
