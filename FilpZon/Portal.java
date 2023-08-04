package FilpZon;
import java.util.*;

public class Portal {
    static Admin admin;
    static Category category;
    static Customer customer;
    HashMap<Float,Category> listofcategory =new HashMap<Float,Category>();

    public HashMap<Float,Category> getlistofcategory() {
        return listofcategory;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("WELCOME TO FLIPZON!!!");
            System.out.println("""
                    1) Enter as Admin
                    2) Explore the Product Catalog
                    3) Show Available Deals
                    4) Enter as Customer
                    5) Exit the Application""");
            System.out.println("Select one of the following options: ");
            int Select_opt = sc.nextInt();
            if (Select_opt == 1) {
                    Admin Ad = new Admin("Ieshaan", "Iesh");
                    Admin.Authorised_Login.add(Ad);
                    System.out.println("Dear Admin,");
                    System.out.println("Please enter your Username ");
                    String User_name = sc.next();
                    System.out.println("Please enter your Password ");
                    String Pass_word = sc.next();
                    Admin person = new Admin(User_name, Pass_word);
                    if (person.Login(User_name, Pass_word)) {
                            System.out.println("Welcome " + User_name);
                            System.out.println("Please choose any one of the following actions: \n" +
                                    "1) Add category\n" +
                                    "2) Delete category\n" +
                                    "3) Add Product\n" +
                                    "4) Delete Product\n" +
                                    "5) Set Discount on Product\n" +
                                    "6) Add giveaway deal\n" +
                                    "7) Back");
                            System.out.println("Enter Option : ");
                            int Admin_option = sc.nextInt();
                            if (Admin_option == 1) {
                                System.out.println("Add category ID ");
                                float cat_ID = sc.nextFloat();
                                String a = " ";
                                if (Admin.CheckId(cat_ID, a) != true) {
                                    System.out.println("Add name of the category ");
                                    String category = sc.nextLine();
                                    System.out.println();
                                    System.out.println("Add a Product ");
                                    System.out.println("Product ID: ");
                                    float product_ID = sc.nextFloat();
                                    System.out.println("Product Details: ");
                                    String Details = sc.nextLine();
                                    System.out.println();
                                    System.out.println("Product Price: ");
                                    Float price = sc.nextFloat();
                                    System.out.println("Product Quantity: ");
                                    int quantity = sc.nextInt();
                                    admin.AddCategory(cat_ID, category, Details, product_ID, price, quantity);
                                } else
                                    System.out.println("ID already exists, enter unique ID");
                            }
                            if (Admin_option == 2) {
                                System.out.println("Enter the category ID you want to delete ");
                                float ID = sc.nextFloat();
                                String a = " ";
                                Category del_category = new Category(ID, a);
                                del_category.deleteCategory(ID);
                            }
                            if (Admin_option == 3) {
                                System.out.println("Enter category ID to add product ");
                                float cat_ID = sc.nextFloat();
                                System.out.println("Enter Product ID ");
                                float product_ID = sc.nextFloat();
                                for (int i = 0; i < category.ListOfProducts.size(); i++) {
                                    if (category.ListOfProducts.get(i).getProduct_ID() == product_ID) {
                                        System.out.println("Sorry Please Enter a unique ID, this ID is already been uesed ");
                                        break;
                                    }
                                }
                                System.out.println("Enter Product Details ");
                                String Details = sc.nextLine();
                                System.out.println();
                                System.out.println("Enter Product Price ");
                                float price = sc.nextFloat();
                                System.out.println("Product Quantity: ");
                                int quantity = sc.nextInt();
                                admin.AddProduct(cat_ID, product_ID, Details, price, quantity);
                                //product specific user input
                            }
                            if (Admin_option == 4) {
                                System.out.println("Enter category ID to delete product ");
                                float cat_ID = sc.nextFloat();
                                System.out.println("Enter Product ID ");
                                float product_ID = sc.nextFloat();
                                admin.DeleteProduct(cat_ID, product_ID);

                            }
                            if (Admin_option == 5) {
                                System.out.println("Dear Admin give the Product ID you want to add discount for ");
                                System.out.println("Enter the Category ID : ");
                                float cat_ID = sc.nextFloat();
                                System.out.println("Enter the Product ID : ");
                                float pro_ID = sc.nextFloat();
                                System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms) ");
                                float arr[] = new float[3];
                                for (int i = 0; i < 3; i++) {
                                    arr[i] = sc.nextFloat();
                                }
                            }
                            if (Admin_option == 6) {
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                System.out.println("Enter Category ID ");
                                float first_cat_ID = sc.nextFloat();
                                System.out.println("Enter the first Product ID : ");
                                float first_pro_ID = sc.nextFloat();
                                System.out.println("Enter Category ID ");
                                float second_cat_ID = sc.nextFloat();
                                System.out.println("Enter the second Product ID : ");
                                float second_pro_ID = sc.nextFloat();
                                System.out.println("Enter the combined price(Should be less than their combined price): ");
                                float com_price = sc.nextFloat();
//                                admin.AddGiveDeals(first_cat_ID, first_pro_ID, second_cat_ID, second_pro_ID, com_price);
                                //connect with the class

                            }
                            if (Admin_option == 7) {
                                break;
                            }
                    }
            }
            if (Select_opt == 2) {
                customer.Explore_Product_Catalog();
            }
            if (Select_opt == 3) {

            }
            if (Select_opt == 4) {
                while (true) {
                    System.out.println("1) Sign up\n" +
                            "2) Log in\n" +
                            "3) Back");
                    System.out.println("Select option ");
                    int choose_opt = sc.nextInt();
                    if (choose_opt == 1) {
                        System.out.println("Enter Name ");
                        String new_cutom_name = sc.next();
                        System.out.println();
                        System.out.println("Enter Password ");
                        String new_cutom_password = sc.next();
                        System.out.println();
                        System.out.println("Enter Age ");
                        int age = sc.nextInt();
                        System.out.println();
                        System.out.println("Enter Phone Number ");
                        long phoneNumber = sc.nextLong();
                        System.out.println();
                        System.out.println("Enter Email ID ");
                        String email_id = sc.next();
                        System.out.println();
                        String Status = "Normal";
                        float balance = 1000;
                        Customer new_custom = new Customer(new_cutom_name, new_cutom_password, age, phoneNumber, email_id, Status, balance);
                        new_custom.Signup(new_cutom_name, new_cutom_password, age, phoneNumber, email_id, Status, balance);
                    }
                    if (choose_opt == 2) {
                        System.out.println("Enter Name ");
                        String cutom_name = sc.next();
                        System.out.println();
                        System.out.println("Enter Password ");
                        String cutom_password = sc.next();
                        System.out.println();
                        System.out.println("Enter Email ID ");
                        String email_id = sc.next();
                        System.out.println();
                        String status = " ";
                        float balance = 10;
                        int age = 0;
                        long phoneNumber = 2;
                        Customer C = new Customer(cutom_name, cutom_password, age, phoneNumber, email_id, status, balance);
                        if (C.Login(cutom_name, cutom_password)==true) {
                            while (true) {
                                System.out.println("Welcome " + cutom_name);
                                System.out.println("1) browse products\n" +
                                        "2) browse deals\n" +
                                        "3) add a product to cart\n" +
                                        "4) add products in deal to cart\n" +
                                        "5) view coupons\n" +
                                        "6) check account balance\n" +
                                        "7) view cart\n" +
                                        "8) empty cart\n" +
                                        "9) checkout cart\n" +
                                        "10) upgrade customer status\n" +
                                        "11) Add amount to wallet\n" +
                                        "12) back");
                                System.out.println("Enter option ");
                                int opt = sc.nextInt();
                                if (opt == 1) {
                                    for (int i = 0; i < category.Products.size(); i++) {
                                        System.out.println(category.Products.get(i).getProduct_ID());
                                        System.out.println(category.Products.get(i).getDetails());
                                        System.out.println(category.Products.get(i).getPrice());
                                    }
                                }
                                if (opt == 2) {

                                }
                                if (opt == 3) {
                                    System.out.println("You want add a product to your cart \n Enter Category ID ");
                                    float cat_id = sc.nextFloat();
                                    System.out.println("Enter Product ID ");
                                    float pro_id = sc.nextFloat();
                                    System.out.println("Enter Quantity ");
                                    int quant = sc.nextInt();
                                    customer.Add_product_to_cart(cat_id, pro_id, quant);

//                                    return function
                                }
                                if (opt == 4) {

                                }
                                if (opt == 5) {


                                }
                                if (opt == 6) {
                                    for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                        if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                            System.out.println("Your account Balance is: ₹ " + customer.getAuthentication_login().get(i).getBalance());
                                            break;
                                        }
                                    }
                                }
                                if (opt == 7) {
                                    System.out.println("Your cart has following items ");
                                    for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                        if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                            if (customer.getAuthentication_login().get(i).ItemsOnCart.size() == 0) {
                                                System.out.println("Cart is empty ");
                                            } else {
                                                for (int j = 0; j < customer.getAuthentication_login().get(i).getItemsOnCart().size(); j++) {
                                                    for (Map.Entry<Float, Integer> entry : customer.ItemsOnCart.entrySet()) {
                                                        float pro_id = entry.getKey();
                                                        for (int k = 0; k < category.Products.size(); k++) {
                                                            if (category.Products.get(k).getProduct_ID() == pro_id) {
                                                                System.out.println(category.Products.get(k).getDetails());
                                                                System.out.println(category.Products.get(k).getPrice());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (opt == 8) {
                                    for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                        if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name)
                                            customer.getAuthentication_login().get(i).ItemsOnCart.clear();
                                        System.out.println("Cart is Empty Now ");
                                        break;
                                    }
                                }
                                if (opt == 9) {
                                    for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                        if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                            customer.make_payment(i);
                                        }

                                    }
                                    if (opt == 10) {
                                        System.out.println("Purchasing Subscription ");
                                        System.out.println("Enter the statues you want to upgrade to ");
                                        String upgrade = sc.next();
                                        if (upgrade == "Elite") {
                                            for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                                if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                                    if (customer.getAuthentication_login().get(i).getStatus() == "Normal") {
                                                        float amount = customer.getAuthentication_login().get(i).getBalance();
                                                        float new_amount = amount - 300;
                                                        if (new_amount < 0) {
                                                            System.out.println("Sorry Insufficient amount");
                                                            break;
                                                        }
                                                        customer.getAuthentication_login().get(i).setBalance(new_amount);
                                                        customer.getAuthentication_login().get(i).setStatus(upgrade);
                                                        System.out.println("We have upgraded your membership from Normal to Elite for a month");
                                                    }
                                                    if (customer.getAuthentication_login().get(i).getStatus() == "Prime") {
                                                        float amount = customer.getAuthentication_login().get(i).getBalance();
                                                        float new_amount = amount - 300;
                                                        if (new_amount < 0) {
                                                            System.out.println("Sorry Insufficient amount");
                                                            break;
                                                        }
                                                        customer.getAuthentication_login().get(i).setBalance(new_amount);
                                                        customer.getAuthentication_login().get(i).setStatus(upgrade);
                                                        System.out.println("We have upgraded your membership from Prime to Elite for a month");
                                                    }
                                                }
                                            }
                                        }
                                        if (upgrade == "Prime") {
                                            for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                                if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                                    if (customer.getAuthentication_login().get(i).getStatus() == "Normal") {
                                                        float amount = customer.getAuthentication_login().get(i).getBalance();
                                                        float new_amount = amount - 200;
                                                        if (new_amount < 0) {
                                                            System.out.println("Sorry Insufficient amount");
                                                            break;
                                                        }
                                                        customer.getAuthentication_login().get(i).setBalance(new_amount);
                                                        customer.getAuthentication_login().get(i).setStatus(upgrade);
                                                        System.out.println("We have upgraded your membership from Normal to Prime for a month");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (opt == 11) {
                                        System.out.println("Enter the amount you want to add to the wallet ");
                                        float add_money = sc.nextFloat();
                                        for (int i = 0; i < customer.Authentication_login.size(); i++) {
                                            if (customer.getAuthentication_login().get(i).getName() == cutom_name && customer.getAuthentication_login().get(i).getName() == cutom_name) {
                                                float curr_money = customer.getAuthentication_login().get(i).getBalance();
                                                float updated_money = curr_money + add_money;
                                                customer.getAuthentication_login().get(i).setBalance(updated_money);
                                                System.out.println("Money added to wallet ");
                                                break;
                                            }
                                        }
                                    }
                                    if (opt == 12) {
                                        System.out.println("Bye " + cutom_name + " !!!");
                                        break;
                                    }
                                }


                            }
                        }
                        if (choose_opt == 3) {
                            break;
                        }
                    }
                }
            if (Select_opt == 5) {
                break;
            }

//                    if(choose_opt==3){break;}
            }
        }
    }

    }




