package FilpZon;

import java.util.ArrayList;
import java.util.HashMap;

public class Deals {
    ArrayList<Deals> Deals = new ArrayList<>();
    private float P1;
    private float P2;
    private float com_price;
    ArrayList<Deals> p_deal = new ArrayList<>();
    public Deals(float p1,float p2,float com_price){
        this.P1= p1;
        this.P2= p2;
        this.com_price=com_price;
        this.p_deal=new ArrayList<>();
    }



    public float getP2() {
        return P2;
    }

    public float getP1() {
        return P1;
    }

    public float getCom_price() {
        return com_price;
    }

    public void setCom_price(float com_price) {
        this.com_price = com_price;
    }
}
