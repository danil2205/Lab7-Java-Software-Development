package flowers;

/**
 * The `Rose` class represents a type of flower, specifically a Rose, extending the `Flowers` class.
 * It provides a constructor to create a Rose object with specified attributes such as price, length, and level of freshness.
 */
public class Rose extends Flowers {
  /**
   * Creates a new `Rose` object.
   *
   * @param price                The price of the rose.
   * @param length               The length of the rose.
   * @param levelOfFreshness     The level of freshness of the rose.
   */
  public Rose(int price, int length, int levelOfFreshness) {
    super(length, levelOfFreshness);
    super.setTotalPrice(price);
  }
}
