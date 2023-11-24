/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;

import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author ibrah
 */
public class RJJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        main.Global_work_path=".\\Globalworkpath";

        Start frame=new Start();
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("./IconImages/RBPI_noclick.png").getImage());
        
    }
    
}
