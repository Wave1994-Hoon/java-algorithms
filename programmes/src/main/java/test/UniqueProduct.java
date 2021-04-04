package test;

import java.util.HashMap;
import java.util.Map;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> onlyCountOne= new HashMap<>();
        Map<String, Integer> overCountOne = new HashMap<>();

        for (String product : products) {
            if (onlyCountOne.containsKey(product)) {
                if (overCountOne.containsKey(product)) {
                    Integer count = overCountOne.get(product);
                    overCountOne.put(product, count + 1);
                } else {overCountOne.put(product, 1);

                }
                onlyCountOne.remove(product);
                continue;
            }
            onlyCountOne.put(product, 1);
        }

        for (String product : onlyCountOne.keySet()) {
            if (onlyCountOne.get(product) > 1) {
                continue;
            }
            return product;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}