package FilpZon;

import java.util.ArrayList;

public class Category {
    private float ID;
    private String Type;

    Portal portal;

    ArrayList<Product> ListOfProducts;
    Product product;

    public Category(float id,String type) {
        this.ID = id;
        this.Type=type;
        this.ListOfProducts = new ArrayList<Product>();
        Portal P = new Portal();
    }
    ArrayList<Product> Products = new ArrayList<Product>();
    public Boolean CheckId(Float id) {
            if(portal.listofcategory.containsKey(id)==true)
                return true;
        return false;
    }

    public ArrayList<Product> getProducts(){
        return Products;
    }
    public ArrayList<Product> getListOfProducts() {
        return ListOfProducts;
    }
    public void AddCategory(Float id,String Cat_name,String Details,float product_id,float price,int quantity) {
        Category C = new Category(id,Cat_name);
        portal.listofcategory.put(id,C);
        product.Add_Product(product_id, Details,price,quantity);
        Product P=new Product(product_id,price,Details, quantity);
        ListOfProducts.add(P);
    }

    public void deleteCategory(float ID){
        portal.listofcategory.remove(ID);
        System.out.println("Category Deleted successfully!!! ");
    }

    public void add_Product(float Cat_ID,float ID, String Details, float Price,int quantity){
        if (portal.listofcategory.containsKey(Cat_ID)){
            Product P_obj = new Product(ID,Price,Details, quantity);
            P_obj.Add_Product(ID,Details,Price,quantity);
            System.out.println("Product Added Successfully !!! ");
        }
    }
    public void Delete_Product(float cat_ID,float product_ID){
        for(int i=0;i<ListOfProducts.size();i++) {
            if(portal.getlistofcategory().get(cat_ID).getListOfProducts().get(i).getProduct_ID()==product_ID){
                portal.getlistofcategory().get(cat_ID).getListOfProducts().remove(i);
            }
        }
        System.out.println("Product Successfully removed !!! ");
    }

    public float getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }
}


