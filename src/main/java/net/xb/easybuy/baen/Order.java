package net.xb.easybuy.baen;

import java.util.Date;

/**
 * Created by asus on 2017/6/19.
 */
public class Order {

    int eo_id;
    String eo_user_id;
    String eo_user_name;
    String eo_user_address;
    Date eo_create_time;
    double eo_cost;
    int eo_status;
    int eo_type;

    public int getEo_id() {
        return eo_id;
    }

    public void setEo_id(int eo_id) {
        this.eo_id = eo_id;
    }

    public String getEo_user_id() {
        return eo_user_id;
    }

    public void setEo_user_id(String eo_user_id) {
        this.eo_user_id = eo_user_id;
    }

    public String getEo_user_name() {
        return eo_user_name;
    }

    public void setEo_user_name(String eo_user_name) {
        this.eo_user_name = eo_user_name;
    }

    public String getEo_user_address() {
        return eo_user_address;
    }

    public void setEo_user_address(String eo_user_address) {
        this.eo_user_address = eo_user_address;
    }

    public Date getEo_create_time() {
        return eo_create_time;
    }

    public void setEo_create_time(Date eo_create_time) {
        this.eo_create_time = eo_create_time;
    }

    public double getEo_cost() {
        return eo_cost;
    }

    public void setEo_cost(double eo_cost) {
        this.eo_cost = eo_cost;
    }

    public int getEo_status() {
        return eo_status;
    }

    public void setEo_status(int eo_status) {
        this.eo_status = eo_status;
    }

    public int getEo_type() {
        return eo_type;
    }

    public void setEo_type(int eo_type) {
        this.eo_type = eo_type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "eo_id=" + eo_id +
                ", eo_user_id=" + eo_user_id +
                ", eo_user_name='" + eo_user_name + '\'' +
                ", eo_user_address='" + eo_user_address + '\'' +
                ", eo_create_time=" + eo_create_time +
                ", eo_cost=" + eo_cost +
                ", eo_status=" + eo_status +
                ", eo_type=" + eo_type +
                '}';
    }
}
