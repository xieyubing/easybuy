package net.xb.easybuy.baen;

import java.util.Date;

/**
 * Created by asus on 2017/6/19.
 */
public class User {

    String eu_user_id;
    String eu_user_name;
    String eu_password;
    char eu_sex;
    Date eu_birthday;
    String eu_identity_code;
    String eu_email;
    String eu_mobile;
    String eu_address;
    int eu_status;

    public String getEu_user_id() {
        return eu_user_id;
    }

    public void setEu_user_id(String eu_user_id) {
        this.eu_user_id = eu_user_id;
    }

    public String getEu_user_name() {
        return eu_user_name;
    }

    public void setEu_user_name(String eu_user_name) {
        this.eu_user_name = eu_user_name;
    }

    public String getEu_password() {
        return eu_password;
    }

    public void setEu_password(String eu_password) {
        this.eu_password = eu_password;
    }

    public char getEu_sex() {
        return eu_sex;
    }

    public void setEu_sex(char eu_sex) {
        this.eu_sex = eu_sex;
    }

    public Date getEu_birthday() {
        return eu_birthday;
    }

    public void setEu_birthday(Date eu_birthday) {
        this.eu_birthday = eu_birthday;
    }

    public String getEu_identity_code() {
        return eu_identity_code;
    }

    public void setEu_identity_code(String eu_identity_code) {
        this.eu_identity_code = eu_identity_code;
    }

    public String getEu_email() {
        return eu_email;
    }

    public void setEu_email(String eu_email) {
        this.eu_email = eu_email;
    }

    public String getEu_mobile() {
        return eu_mobile;
    }

    public void setEu_mobile(String eu_mobile) {
        this.eu_mobile = eu_mobile;
    }

    public String getEu_address() {
        return eu_address;
    }

    public void setEu_address(String eu_address) {
        this.eu_address = eu_address;
    }

    public int getEu_status() {
        return eu_status;
    }

    public void setEu_status(int eu_status) {
        this.eu_status = eu_status;
    }
}
