/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static rjj.main.Global_work_path;
import static rjj.main.check_ava;
import static rjj.main.status_checker_channel_1;
import static rjj.main.status_checker_channel_2;
import static rjj.main.status_checker_channel_3;
import static rjj.main.status_checker_channel_4;


/**
 *
 * @author ibrah
 */
public class Schedule_manager {
    //variables

    //this function accept a directory then goes inside that directory and fetch data of testlist.txt
    public static String[] list_importer(String directory,String File_Name, String[] vessil) {
        int i = 0;
        try {
           
            if (new File(directory + "\\Services\\schedules").exists()) {
                 System.out.print("boop");
                File indestbeff = new File(directory + "\\Services\\schedules\\"+File_Name);//create virtual file content and fill it with the txt content                   
                try ( Scanner finn = new Scanner(indestbeff)) {//scan that file for strings 
                    while (finn.hasNext()) {
                        vessil[i] = finn.nextLine();// + "\n"; //add those strings to the vessil
                        //System.out.print(i);
                        i++;//increase i by 1 so we can fill the next line of the text file in the string
                    }
                    finn.close();
                }
            } else {
                System.out.println(directory+"not found at all");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vessil;
    }
    //this function write data from the actual lists into the files txt

    public static void list_publisher(String directory, DefaultListModel vessil) {
        try {
            if (new File(directory).exists()) {
                PrintWriter fout = new PrintWriter(new File(directory)); //create file writer that store things in the directory "directory"
                for (int i = 0; i < vessil.getSize(); i++) //loop from 0 to maximum length of a list model
                {
                    fout.println(vessil.getElementAt(i).toString());   //write down those elements as lines into the file writer
                }
                fout.close(); //close the file so it will be saved in the desired location "directory"
            } else {
                System.out.println(directory + "not found at all");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Schedule_manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void List_buffer_emptier() {

    }
    
    public static void override_publisher(String channeltxt,String override_status)
    {
        try {
            PrintWriter fout=new PrintWriter(new File(Global_work_path+"\\Services\\Services_override\\"+channeltxt+".txt"));
            fout.println(override_status);
            fout.close();
        } catch (Exception e) {
        }
    }
    
    public static String override_check(String directory,String channel_name)
    {
        String vessil=""; //create private string buffer
        try {
                File indestbeff=new File(directory+"\\Services\\Services_override\\"+channel_name+".txt");//bring the channel status
                try ( Scanner finn = new Scanner(indestbeff)) {//scan that file for strings 
                while (finn.hasNext()) {
                    vessil = finn.nextLine();//add channel c# statues to the vessil
                    System.out.print(vessil);
                    }
                finn.close();
            }
        } catch (Exception e) {
        }
        return vessil;//return override or not
    }
    
        public static String status_check(String directory,String channel_name)
    {        
        String vessil = ""; //create private string buffer        
        try {
            //File indestbefff = new File(directory + "\\Services\\Services_Status_Check\\" + channel_name + ".txt");//bring the channel status
            File indestbeff;            
            indestbeff = new File(directory + "\\Services\\Services_Status_Check\\" + channel_name + ".txt");//bring the channel status
            if (indestbeff.lastModified()>1)
            {
                try ( Scanner finn = new Scanner(indestbeff)) {//scan that file for strings 

                while (finn.hasNext()) {
                    Thread.sleep(50);
                    vessil = finn.nextLine();//add channel c# statues to the vessil
                    System.out.print(vessil+"\n");
                    
                 }     
                finn.remove();
                finn.close();
                //finn.remove();
                //indestbefff.delete();
                indestbeff.setReadable(true);
            }
            }
        } catch (Exception e) {
        }
        
        return vessil;//return override or not
    }
        public static boolean status_avail_check(String directory,String channel_name)
        {
            File status_file;            
            status_file = new File(directory + "\\Services\\Services_Status_Check\\" + channel_name + ".txt");//bring the channel status
            if (status_file.exists()){
                return true;
            }else{
                return false;
            }
        }
    
   
}

class live_check extends Thread
{  
    public void run()
    {
        while(true)
        {
            //System.out.print("Live is running");
            try {
                Thread.sleep(1000);
                check_ava();        
            } catch (Exception e) {
            }
        }
    }
}
class live_check_ch1 extends Thread
{
        public void run()
    {
        while(true)
        {
            //System.out.print("Live is running");
            try {
                Thread.sleep(200);                
                status_checker_channel_1();
            } catch (Exception e) {
            }
        }
    }
}
class live_check_ch2 extends Thread
{
        public void run()
    {
        while(true)
        {
            //System.out.print("Live is running");
            try {
                Thread.sleep(200);                
                status_checker_channel_2();
            } catch (Exception e) {
            }
        }
    }
}class live_check_ch3 extends Thread
{
        public void run()
    {
        while(true)
        {
            //System.out.print("Live is running");
            try {
                Thread.sleep(200);                
                status_checker_channel_3();
            } catch (Exception e) {
            }
        }
    }
}class live_check_ch4 extends Thread
{
        public void run()
    {
        while(true)
        {
            //System.out.print("Live is running");
            try {
                Thread.sleep(200);                
                status_checker_channel_4();
            } catch (Exception e) {
            }
        }
    }
}