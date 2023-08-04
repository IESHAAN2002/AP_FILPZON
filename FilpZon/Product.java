package FilpZon;

public class Product{
    private final String Details;
    private final float Product_ID;

    private float Price;
    private int Quantity;
    Category category;

//    ArrayList<String> details = new ArrayList<String>();

    public Product(float product_id, float price, String Details, int quantity) {
        this.Product_ID = product_id;
        this.Details = Details;
        this.Price=price;
//        ArrayList<String> details = new ArrayList<String>();
        this.Quantity = quantity;
    }



    public void Add_Product(float product_ID,String Details, float price,int quantity){
        Product newProduct = new Product(product_ID,price,Details, quantity);
        category.Products.add(newProduct);
    }

    public String getDetails() {
        return Details;
    }

    public float getProduct_ID() {
        return Product_ID;
    }

    public float getPrice() {
        return Price;
    }


    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
