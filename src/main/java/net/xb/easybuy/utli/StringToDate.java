package net.xb.easybuy.utli;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2017/6/23.
 */
public class StringToDate {

    public static Date toDate(String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        try {
            return  sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
    public static String toString(Date strDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        return  sdf.format(strDate);
    }

}
