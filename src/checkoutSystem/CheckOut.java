package checkoutSystem;

import java.util.*;

import model.Item;
public class CheckOut {
    private Map<String, Item> items;
    private Map<String, Map<String, Integer>> pricingRules;

    public CheckOut(Map<String, Map<String, Integer>> pricingRules) {
        this.items = new HashMap<>();
        this.pricingRules = pricingRules;
    }

    public void scan(String sku) {
        if (items.containsKey(sku)) {
            items.get(sku).setQuantity(items.get(sku).quantity + 1);
        } else {
            Item item;
            if (pricingRules.containsKey(sku)) {
                item = new Item(sku, pricingRules.get(sku).get("unitPrice"),
                        pricingRules.get(sku).getOrDefault("specialPrice", 0),
                        pricingRules.get(sku).getOrDefault("specialQuantity", 0));
            } else {
                //TODO: We can add also any other operation or log any error here
//                System.out.println("This item : " + sku + " is not int the pricing rules");
                item = new Item(sku, 0, 0, 0);
            }
            item.setQuantity(1);
            items.put(sku, item);
        }
    }

    public int total() {
        int total_price = 0;
        for (Item item : items.values()) {
            total_price += item.calculatePrice();
        }
        return total_price;
    }
}
