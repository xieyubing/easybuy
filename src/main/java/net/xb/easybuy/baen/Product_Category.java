package net.xb.easybuy.baen;

/**
 * Created by asus on 2017/6/19.
 */
public class Product_Category {

    int epc_id;
    String epc_name;
    int epc_parent_id;

    public int getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public int getEpc_parent_id() {
        return epc_parent_id;
    }

    public void setEpc_parent_id(int epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }

    @Override
    public String toString() {
        return "Product_Category{" +
                "epc_id=" + epc_id +
                ", epc_name='" + epc_name + '\'' +
                ", epc_parent_id=" + epc_parent_id +
                '}';
    }
}
