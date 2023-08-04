package FilpZon;


public class Cart {
    private final float Product_ID;
    private final int Quantity;
//    ArrayList<Cart> ItemsOnCart = new ArrayList<Cart>();
    public Cart(float product_id, int quantity) {
        this.Product_ID = product_id;
        this.Quantity = quantity;
//        ItemsOnCart.put(product_id,quantity);
    }



    public float getProduct_ID() {
        return Product_ID;
    }

    public int getQuantity() {
        return Quantity;
    }
}
