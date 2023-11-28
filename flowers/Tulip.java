package flowers;

/**
 * The `Tulip` class represents a type of flower, specifically a Tulip, extending the `Flowers` class.
 * It provides a constructor to create a Tulip object with specified attributes such as price, length, and level of freshness.
 */
public class Tulip extends Flowers {
  /**
   * Creates a new `Tulip` object.
   *
   * @param price                The price of the tulip.
   * @param length               The length of the tulip.
   * @param levelOfFreshness     The level of freshness of the tulip.
   */
  public Tulip(int price, int length, int levelOfFreshness) {
    super(length, levelOfFreshness);
    super.setTotalPrice(price);
  }
}