package net.xb.easybuy.baen;

/**
 * Created by asus on 2017/6/19.
 */
public class Product {

    int ep_id;
    String ep_name;
    String ep_description;
    double ep_price;
    int ep_stock;
    int epc_id;
    int epc_child_id;
    String ep_file_name;

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public String getEp_name() {
        return ep_name;
    }

    public void setEp_name(String ep_name) {
        this.ep_name = ep_name;
    }

    public String getEp_description() {
        return ep_description;
    }

    public void setEp_description(String ep_description) {
        this.ep_description = ep_description;
    }

    public double getEp_price() {
        return ep_price;
    }

    public void setEp_price(double ep_price) {
        this.ep_price = ep_price;
    }

    public int getEp_stock() {
        return ep_stock;
    }

    public void setEp_stock(int ep_stock) {
        this.ep_stock = ep_stock;
    }

    public int getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public int getEpc_child_id() {
        return epc_child_id;
    }

    public void setEpc_child_id(int epc_child_id) {
        this.epc_child_id = epc_child_id;
    }

    public String getEp_file_name() {
        return ep_file_name;
    }

    public void setEp_file_name(String ep_file_name) {
        this.ep_file_name = ep_file_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ep_id=" + ep_id +
                ", ep_name='" + ep_name + '\'' +
                ", ep_description='" + ep_description + '\'' +
                ", ep_price='" + ep_price + '\'' +
                ", ep_stock=" + ep_stock +
                ", epc_id=" + epc_id +
                ", epc_child_id=" + epc_child_id +
                ", ep_file_name='" + ep_file_name + '\'' +
                '}';
    }
}
