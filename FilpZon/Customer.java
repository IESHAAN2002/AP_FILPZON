package FilpZon;

import java.util.*;

public class Customer implements fellow {
    private final String Name;
    private final String Password;
    private final int Age;
    private final long phoneNumber;
    private final String email_ID;
    private String Status;
    private Float Balance;

    HashMap<Integer,Float> Coupons = new HashMap<>();

    Category category;
    Portal portal;
    Cart cart;


    ArrayList<Customer> Authentication_login = new ArrayList<Customer>();

    public ArrayList<Customer> getAuthentication_login(){
        return Authentication_login;
    }
    HashMap<Float,Integer> ItemsOnCart;

    public Customer(String name, String password, int age, long phoneNumber, String email_id, String status, Float balance) {
//        super(name, password);
        this.Name = name;
        this.Password = password;
        this.Age = age;
        this.phoneNumber = phoneNumber;
        this.email_ID = email_id;
        this.Status = status;
        this.Balance = balance;
        this.ItemsOnCart = new HashMap<>();
        this.Coupons = new HashMap<>();
    }
    public void Signup(String new_cutom_name, String new_cutom_password,int age,long phoneNumber,String email_id, String status, float balance) {
        Customer C = new Customer(new_cutom_name,new_cutom_password,age,phoneNumber,email_id,status,balance);
        Authentication_login.add(C);
        System.out.println("Customer successfully registered!!! ");
    }
    public HashMap<Float,Integer> getItemsOnCart(){
        return ItemsOnCart;
    }

    public HashMap<Integer,Float> getCoupons(){
        return Coupons;
    }
    @Override
    public Boolean Login(String username, String password) {
        for(int i=0;i<Authentication_login.size();i++){
            Customer C = Authentication_login.get(i);
            if(Objects.equals(username, C.getName()) && Objects.equals(password, C.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public void add() {

    }

    public void Explore_Product_Catalog(){
        for(int m=0;m<category.Products.size();m++){
            System.out.println(category.getProducts().get(m).getProduct_ID());
            System.out.println(category.getProducts().get(m).getDetails());
            System.out.println(category.getProducts().get(m).getPrice());
        }
    }

    public void Add_product_to_cart(float cat_id,float pro_id,int quantity){
        for(int i=0;i<category.ListOfProducts.size();i++) {
            if(portal.getlistofcategory().get(cat_id).getListOfProducts().get(i).getProduct_ID()==pro_id){
                if(portal.getlistofcategory().get(cat_id).getListOfProducts().get(i).getQuantity()>=quantity){
                    ItemsOnCart.put(pro_id,quantity);
                    int num = portal.getlistofcategory().get(cat_id).getListOfProducts().get(i).getQuantity();
                    int quant = num-quantity;
                    portal.getlistofcategory().get(cat_id).getListOfProducts().get(i).setQuantity(quant);
                }
                else
                    System.out.println("We are out of Stock :( ");
            }
        }
    }
    public void make_payment(int idx){
        double total=0;
        for(int i=0;i<getAuthentication_login().get(idx).ItemsOnCart.size();i++){
            for(Map.Entry<Float, Integer> entry:ItemsOnCart.entrySet()){
                float pro_id = entry.getKey();
                for(int k=0;k<category.Products.size();k++){
                    if(category.Products.get(k).getProduct_ID()==pro_id){
                        float price=category.Products.get(k).getPrice();
                        float quantity=category.Products.get(k).getQuantity();
                        total=total+(price*quantity);
                    }
                }
            }
        }
        if (getAuthentication_login().get(idx).getBalance()<total){
            System.out.println("Balance insufficient ");
        }
        else{
            if(Objects.equals(getAuthentication_login().get(idx).getStatus(), "Normal")){
                double del_charge = 100 + 0.05*total;
                System.out.println("Delivery Charge is : "+del_charge);
                System.out.println("Original Price was : "+total);
                System.out.println("Discount Price is : "+ total);
                double Total_cost = del_charge + total;
                System.out.println("Total Cost is : "+Total_cost);
                System.out.println("Your item will be delivered within 7-10 days");
            }

            if(Objects.equals(getAuthentication_login().get(idx).getStatus(), "Prime")){
                double del_charge = 100 + 0.02*total;
                System.out.println("Delivery Charge is : "+del_charge);
                double Discount_price = total-0.05*total;
                double best_couPon_price=10000000000000000000000000.00;
                for(int j=0;j<getAuthentication_login().get(idx).Coupons.size();j++){
                    if(getAuthentication_login().get(idx).Coupons==null){break;}
                    for(Map.Entry<Integer, Float> entry:Coupons.entrySet()){
                        float ent = entry.getValue()/100;
                        double CouPon_price=total-total*ent;
                        if(CouPon_price<best_couPon_price){
                            best_couPon_price=CouPon_price;
                        }
                    }
                }
                if(Discount_price>best_couPon_price){Discount_price=best_couPon_price;}
                System.out.println("Original Price was : "+total);
                System.out.println("Discount Price is : "+Discount_price);
                double Total_cost = del_charge + Discount_price;
                System.out.println("Total Cost is : "+Total_cost);
                System.out.println("Your item will be delivered within 3-6 days");
                if(Total_cost>5000){
                    System.out.println("CONGRATULATION!!!! YOU HAVE RECEIVED 2 DISCOUNT COUPONS ");
                    for(int i=0;i<2;i++) {
                        float random_int = (float) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                        getCoupons().put(i,random_int);
                    }
                }

            }
            if(Objects.equals(getAuthentication_login().get(idx).getStatus(), "Elite")){
                double del_charge = 100;
                System.out.println("Delivery Charge is : "+del_charge);
                double Discount_price = total-0.1*total;
                double best_couPon_price=10000000000000000000000000.00;
                for(int j=0;j<getAuthentication_login().get(idx).Coupons.size();j++){
                    if(getAuthentication_login().get(idx).Coupons==null){break;}
                    for(Map.Entry<Integer, Float> entry:Coupons.entrySet()){
                        float ent = entry.getValue()/100;
                        double CouPon_price=total-total*ent;
                        if(CouPon_price<best_couPon_price){
                            best_couPon_price=CouPon_price;
                        }
                    }
                }
                if(Discount_price>best_couPon_price){Discount_price=best_couPon_price;}
                System.out.println("Original Price was : "+total);
                System.out.println("Discount Price is : "+Discount_price);
                double Total_cost = del_charge + Discount_price;
                System.out.println("Total Cost is : "+Total_cost);
                System.out.println("Your item will be delivered within 2 days");
                if(Total_cost>5000){
                    System.out.println("CONGRATULATION!!!! YOU HAVE RECEIVED 4 DISCOUNT COUPONS ");
                    for(int i=0;i<4;i++) {
                        float random_int = (float) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                        getCoupons().put(i,random_int);
                    }
                }

            }
        }
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public Float getBalance() {
        return Balance;
    }

    public void setBalance(Float balance) {
        Balance = balance;
    }


    public int getAge() {
        return Age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail_ID() {
        return email_ID;
    }
}
