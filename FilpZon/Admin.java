package FilpZon;

import java.util.ArrayList;
import java.util.Objects;

public class Admin implements fellow {
    Category category;
    Portal portal;
    Deals deals;
    private final String Name;
    private final String Password;

    public static ArrayList<Admin> Authorised_Login = new ArrayList<>();




    public Admin(String name, String password) {
//        super(name, password);
        this.Name = name;
        this.Password = password;

    }

    @Override
    public Boolean Login(String username, String password) {
        for (Admin A : Authorised_Login) {
            if (Objects.equals(A.getName(), username) && Objects.equals(A.getPassword(), password)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean CheckId(Float id, String type) {
        Category check = new Category(id, type);
        if (check.CheckId(id) == true)
            return true;
        else
            return false;
    }


    public void AddCategory(Float id, String type, String pname, float pid, float price, int quantity) {
        Category category = new Category(id, type);
        category.AddCategory(id, type, pname, pid, price, quantity);
        System.out.println("Category Added !!!");
    }

    public void AddProduct(float Cat_ID, float ID, String Details, float Price, int quantity) {
        category.add_Product(Cat_ID, ID, Details, Price, quantity);
    }

    public void DeleteProduct(float cat_ID, float product_ID) {
        category.Delete_Product(cat_ID, product_ID);
    }

    public void SetDiscount(float ID) {

    }
    public void AddGiveDeals(float Cat_ID_1,float pro_ID_1,float Cat_Id_2,float pro_ID_2,float com_price){
        for(int i=0;i<category.getListOfProducts().size();i++) {
            if(portal.getlistofcategory().get(Cat_ID_1).getListOfProducts().get(i).getProduct_ID()==pro_ID_1)
                if(portal.getlistofcategory().get(Cat_Id_2).getListOfProducts().get(i).getProduct_ID()==pro_ID_2){
                    Deals D = new Deals(pro_ID_1,pro_ID_2,com_price);
                    deals.p_deal.add(D);
                    deals.Deals.add(D);
                }
        }
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }


    @Override
    public void add() {

    }
}


