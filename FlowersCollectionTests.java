import flowers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

@SuppressWarnings("all")
public class FlowersCollectionTests {

  @Test
  void testEmptyCollection() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    assertTrue(flowersCollection.isEmpty());
    assertEquals(0, flowersCollection.size());
  }

  @Test
  void testAddAndSize() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers rose = new Rose(150, 20, 1);

    assertTrue(flowersCollection.add(lilyFresh));
    assertFalse(flowersCollection.isEmpty());
    assertEquals(1, flowersCollection.size());

    assertTrue(flowersCollection.add(rose));
    assertEquals(2, flowersCollection.size());
  }

  @Test
  void testAddNullElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.add(null);
    });
  }

  @Test
  void testAddDuplicateElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.add(lilyFresh);
      flowersCollection.add(lilyFresh);
    });
  }

  @Test
  void testAddAll() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers rose = new Rose(150, 20, 1);

    List<Flowers> flowerList = Arrays.asList(lilyFresh, rose);

    assertTrue(flowersCollection.addAll(flowerList));
    assertEquals(2, flowersCollection.size());
  }

  @Test
  void testAddAllDuplicateElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers rose = new Rose(150, 20, 1);
    List<Flowers> flowerList = Arrays.asList(lilyFresh, rose);
    flowersCollection.addAll(flowerList);

    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.addAll(flowerList);
    });
  }

  @Test
  void testAddAllNullElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers tulip = new Tulip(40, 30, 2);
    ArrayList<Flowers> flowers = new ArrayList<>();
    flowers.add(tulip);
    flowers.add(null);

    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.addAll(flowers);
    });
  }

  @Test
  void testRemove() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers rose = new Rose(150, 20, 1);

    assertTrue(flowersCollection.add(rose));
    assertEquals(1, flowersCollection.size());

    assertTrue(flowersCollection.remove(rose));
    assertTrue(flowersCollection.isEmpty());

    assertFalse(flowersCollection.remove(rose));
  }

  @Test
  void testRemoveNullElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.remove(null);
    });
  }

  @Test
  void testRemoveAll() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    List<Flowers> flowerList = Arrays.asList(lilyOld, tulip);

    assertTrue(flowersCollection.addAll(flowerList));
    assertEquals(2, flowersCollection.size());

    assertTrue(flowersCollection.removeAll(flowerList));
    assertTrue(flowersCollection.isEmpty());
  }

  @Test
  void testRemoveAllWithNullElement() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers tulip = new Tulip(40, 30, 2);
    ArrayList<Object> flowers = new ArrayList<>();
    flowers.add(tulip);
    flowers.add(null);

    assertThrows(FlowersCollectionException.class, () -> {
      flowersCollection.removeAll(flowers);
    });
  }

  @Test
  void testClear() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers rose = new Rose(150, 20, 1);
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    List<Flowers> flowerList = Arrays.asList(lilyFresh, rose, lilyOld, tulip);
    flowersCollection.addAll(flowerList);

    assertFalse(flowersCollection.isEmpty());
    flowersCollection.clear();
    assertTrue(flowersCollection.isEmpty());
  }

  @Test
  void testContains() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers tulip = new Tulip(40, 30, 2);

    assertFalse(flowersCollection.contains(tulip));
    flowersCollection.add(tulip);
    assertTrue(flowersCollection.contains(tulip));
  }

  @Test
  void testContainsAll() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    List<Flowers> flowerList = Arrays.asList(lilyFresh, lilyOld);

    assertFalse(flowersCollection.containsAll(flowerList));
    flowersCollection.addAll(flowerList);
    assertTrue(flowersCollection.containsAll(flowerList));

    flowerList = Arrays.asList(lilyFresh, lilyOld, tulip);
    assertFalse(flowersCollection.containsAll(flowerList));
  }

  @Test
  void testIterator() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    flowersCollection.addAll(Arrays.asList(lilyOld, tulip));

    Iterator<Flowers> iterator = flowersCollection.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(lilyOld, iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(tulip, iterator.next());
    assertFalse(iterator.hasNext());
    assertThrows(FlowersCollectionException.class, () -> {
      iterator.next();
    });
  }

  @Test
  void testToArray() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    flowersCollection.addAll(Arrays.asList(lilyOld, tulip));

    Object[] flowerArray = flowersCollection.toArray();
    assertEquals(2, flowerArray.length);
    assertArrayEquals(new Object[]{lilyOld, tulip}, flowerArray);
  }

  @Test
  void testToArrayWithArgument() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    flowersCollection.addAll(Arrays.asList(lilyOld, tulip));

    Flowers[] flowerArray = new Flowers[2];
    Flowers[] resultArray = flowersCollection.toArray(flowerArray);

    assertArrayEquals(new Flowers[]{lilyOld, tulip}, resultArray);
  }

  @Test
  void testRetainAll() {
    FlowersCollection<Flowers> flowersCollection = new FlowersCollection<>();
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);

    List<Flowers> flowerList = Arrays.asList(lilyFresh, lilyOld);

    flowersCollection.addAll(Arrays.asList(lilyFresh, lilyOld, tulip));
    assertTrue(flowersCollection.retainAll(flowerList));
    assertEquals(2, flowersCollection.size());
    assertTrue(flowersCollection.containsAll(flowerList));
  }
}
