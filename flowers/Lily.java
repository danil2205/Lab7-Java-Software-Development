package flowers;

/**
 * The `Lily` class represents a type of flower, specifically a Lily, extending the `Flowers` class.
 * It provides a constructor to create a Lily object with specified attributes such as price, length, and level of freshness.
 */
public class Lily extends Flowers {
  /**
   * Creates a new `Lily` object.
   *
   * @param price                The price of the lily.
   * @param length               The length of the lily.
   * @param levelOfFreshness     The level of freshness of the lily.
   */
  public Lily(int price, int length, int levelOfFreshness) {
    super(length, levelOfFreshness);
    super.setTotalPrice(price);
  }
}
