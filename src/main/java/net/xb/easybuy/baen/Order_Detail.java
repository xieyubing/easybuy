package net.xb.easybuy.baen;

/**
 * Created by asus on 2017/6/19.
 */
public class Order_Detail {
    int eod_id;
    int eo_id;
    int ep_id;
    int eod_quantity;
    double eod_cost;

    public int getEod_id() {
        return eod_id;
    }

    public void setEod_id(int eod_id) {
        this.eod_id = eod_id;
    }

    public int getEo_id() {
        return eo_id;
    }

    public void setEo_id(int eo_id) {
        this.eo_id = eo_id;
    }

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public int getEod_quantity() {
        return eod_quantity;
    }

    public void setEod_quantity(int eod_quantity) {
        this.eod_quantity = eod_quantity;
    }

    public double getEod_cost() {
        return eod_cost;
    }

    public void setEod_cost(double eod_cost) {
        this.eod_cost = eod_cost;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "eod_id=" + eod_id +
                ", eo_id=" + eo_id +
                ", ep_id=" + ep_id +
                ", eod_quantity=" + eod_quantity +
                ", eod_cost=" + eod_cost +
                '}';
    }
}
