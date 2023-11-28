import flowers.Flowers;

import java.util.*;

/**
 * A generic collection class implementing the Set interface.
 *
 * @param <T> The type of elements in the collection.
 */
class FlowersCollection<T extends Flowers> implements Set<T> {
  private static final int INITIAL_CAPACITY = 15;
  private static final double GROWTH_FACTOR = 1.3;

  private Object[] elements;
  private int size;

  /**
   * Creates an empty FlowersCollection with the default initial capacity.
   */
  public FlowersCollection() {
    elements = new Object[INITIAL_CAPACITY];
    size = 0;
  }

  /**
   * Creates a FlowersCollection with elements from the specified collection.
   *
   * @param collection The collection whose elements are to be placed into this collection.
   */
  public FlowersCollection(Collection<? extends T> collection) {
    this();
    addAll(collection);
  }

  /**
   * Creates a FlowersCollection with a single element.
   *
   * @param element The element to be added to the collection.
   */
  public FlowersCollection(T element) {
    this();
    add(element);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    for (Object element : elements) {
      if (Objects.equals(element, o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < size;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return (T) elements[currentIndex++];
      }
    };
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(elements, size);
  }

  @Override
  public <E> E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(elements, size, a.getClass());
    }
    System.arraycopy(elements, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public boolean add(T t) {
    ensureCapacity();
    elements[size++] = t;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], o)) {
        removeAtIndex(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object element : c) {
      if (!contains(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T element : c) {
      add(element);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    for (int i = 0; i < size; i++) {
      if (!c.contains(elements[i])) {
        removeAtIndex(i);
        modified = true;
        i--;
      }
    }
    return modified;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    for (Object element : c) {
      modified |= remove(element);
    }
    return modified;
  }

  @Override
  public void clear() {
    elements = new Object[INITIAL_CAPACITY];
    size = 0;
  }

  private void ensureCapacity() {
    if (size == elements.length) {
      int newCapacity = (int) (elements.length * GROWTH_FACTOR);
      elements = Arrays.copyOf(elements, newCapacity);
    }
  }

  private void removeAtIndex(int index) {
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    elements[--size] = null;
  }
}