/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static rjj.main.Global_work_path;

/**
 *
 * @author ibrah
 */
public class Clients_configurator {

    public static void IP_Addresser() {
        //this direcotry is unique, its the application directory so put text file contains 4 IP addresses regarding clients
        File indestbeff = new File(".\\Globalworkpath\\IP_Addresses.txt");
        //File indestbeff = new File("\\RelayJ\\Globalworkpath\\IP_Addresses.txt");
       try ( Scanner finn = new Scanner(indestbeff)) {
        //try (Scanner finn = new Scanner(new FileInputStream(indestbeff))){
            while (finn.hasNext()) {
              main.btn_Client_1.setText(finn.nextLine());
              main.btn_Client_2.setText(finn.nextLine());
              main.btn_Client_3.setText(finn.nextLine());
              main.btn_Client_4.setText(finn.nextLine());
            }
            finn.close();
        } catch (Exception e) {
        }
    }
    
    public static void Client_Namer(){
        //this direcotry is unique, its the application directory so put text file contains names regarding clients
        //File indestbeff = new File("C:\\Users\\ibrah\\Documents\\NetBeansProjects\\RelayJ\\Globalworkpath\\Clients_Names.txt");
        File indestbeff = new File(".\\Globalworkpath\\Clients_Names.txt");

        //try ( Scanner finn = new Scanner(indestbeff)) {
        try (Scanner finn = new Scanner(new FileInputStream(indestbeff),"UTF-8")){
            while (finn.hasNext()) {
              main.Client_1_name.setText(finn.nextLine());
              
              main.Channel_list_lable_client_1.setText(main.Client_1_name.getText());
              main.Client_2_name.setText(finn.nextLine());
              
              main.Channel_list_lable_client_2.setText(main.Client_2_name.getText());
              main.Client_3_name.setText(finn.nextLine());
              
              main.Channel_list_lable_client_3.setText(main.Client_3_name.getText());
              main.Client_4_name.setText(finn.nextLine());
              
              main.Channel_list_lable_client_4.setText(main.Client_4_name.getText());
            }
            finn.close();
        } catch (Exception e) {
        }
        
    }
}    

