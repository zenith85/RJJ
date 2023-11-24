/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author ibrah
 */
public class CurrentTime {
    public static String findtime(){
        Calendar cal = Calendar.getInstance();
        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        //System.out.println(cal.YEAR+"-"+cal.MONTH+"-"+cal.DAY_OF_MONTH+" ");
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;//because jan is 0 in jave (fuck this stupid language
        int day=cal.get(Calendar.DAY_OF_MONTH);
        //int hour=cal.get(Calendar.HOUR);//thisis used for AM PM
        int hour=cal.get(Calendar.HOUR_OF_DAY);//This is a military time zone 24 hours div
        int minutes=cal.get(Calendar.MINUTE);
        
        //System.out.println("Currenty time has been called " +year+"-"+month+"-"+day+" "+hour+":"+minutes);
        return year+"-"+month+"-"+day+" "+hour+":"+minutes;
    }
}
