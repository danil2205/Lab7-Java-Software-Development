/*
1131 - zalikova
1131 % 2 = 1 => C2 = Set
1131 % 3 = 0 => C3 = Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%
*/

import flowers.*;
import java.util.*;

public class Lab7 {
  public static void main(String[] args) {
    Flowers testLily = new Lily(1337, 12,  4);
    Flowers lilyFresh = new Lily(50, 25, 1);
    Flowers rose = new Rose(150, 20, 1);
    Flowers lilyOld = new Lily(20, 40, 3);
    Flowers tulip = new Tulip(40, 30, 2);
    List<Flowers> flowersList = List.of(lilyFresh, rose, lilyOld, tulip);

    FlowersCollection<Flowers> flowersSetEmptyConstructor = new FlowersCollection<>();
    flowersSetEmptyConstructor.add(testLily);
    flowersSetEmptyConstructor.addAll(flowersList);

    for (Flowers flowers : flowersSetEmptyConstructor) {
      System.out.println(flowers);
    }

    System.out.println("==============================");

    FlowersCollection<Flowers> flowersSetElementArgument = new FlowersCollection<>(lilyFresh);

    for (Flowers flowers : flowersSetElementArgument) {
      System.out.println(flowers);
    }

    System.out.println("==============================");

    FlowersCollection<Flowers> flowersSetCollectionArgument = new FlowersCollection<>(flowersList);

    for (Flowers flowers : flowersSetCollectionArgument) {
      System.out.println(flowers);
    }

    System.out.println("Size of collection: " + flowersSetCollectionArgument.size() + " and is empty it: " + flowersSetCollectionArgument.isEmpty());
    System.out.println("Does collection contain all flowers: " + flowersSetCollectionArgument.containsAll(flowersList));
    System.out.println("Does lily fresh contain in collection: " + flowersSetCollectionArgument.contains(lilyFresh));
    flowersSetCollectionArgument.remove(lilyFresh);
    System.out.println("Does lily fresh contain in collection: " + flowersSetCollectionArgument.contains(lilyFresh));
    System.out.println("Collection didnt change after retainAll (must be false): " + flowersSetCollectionArgument.retainAll(flowersList));
    System.out.println("Collection cleared all after removeAll (must be true): " + flowersSetCollectionArgument.removeAll(flowersList) + " . Collection is empty: " + flowersSetCollectionArgument.isEmpty());

    flowersSetCollectionArgument.addAll(flowersList);
    System.out.println("Before clear size of collection: " + flowersSetCollectionArgument.size());
    flowersSetCollectionArgument.clear();
    System.out.println("After clear size of collection: " + flowersSetCollectionArgument.size());
  }
}