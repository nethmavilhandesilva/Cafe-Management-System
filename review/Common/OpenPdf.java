/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadini Kavindya
 */
public class OpenPdf {
     public static void OpenById(String id){
    try{
     if((new File("C:\\Users\\Sadini Kavindya\\Desktop\\NVDS CODING"+id+".pdf")).exists()){ 
         Process p=Runtime
                 .getRuntime()
                 .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\Sadini Kavindya\\Desktop\\NVDS CODING" +id+".pdf");
     }  
     else{
         JOptionPane.showMessageDialog(null,"File is not Exsist");
     }  
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
}
    

