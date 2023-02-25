package model;

public class Item {

    private String sku;
    private int unitPrice;
    private int specialPrice;
    private int specialQuantity;
    public int quantity;

    public Item(String sku, int unitPrice, int specialPrice, int specialQuantity) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
        this.specialQuantity = specialQuantity;
        this.quantity = 0;
    }

    public int calculatePrice() {
        if (specialPrice != 0 && quantity >= specialQuantity) {
            int specialOffers = quantity / specialQuantity;
            int regularPriceItems = quantity % specialQuantity;
            return specialOffers * specialPrice + regularPriceItems * unitPrice;
        } else {
            return quantity * unitPrice;
        }
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
