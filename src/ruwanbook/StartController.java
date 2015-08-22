/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author rukshani
 */
public class StartController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     public void signinpage(){    
       
       connect con=new connect();
        try {
            con.createTableCustomer();
            con.createTableEmployee();
            con.createTableSupplier();
            con.createTableProduct();
            
//            con.insertEmployee("r", "r", "rukshani","kuru", 037);
//            con.insertEmployee("ra", "ra", "ravishani","kuru", 0372);
//            con.insertEmployee("nila", "nila", "nilakshika","kuru", 0372);
//            con.insertEmployee("NILA", "nila", "nilakshika","kuru", 0372);
            
        //   con.deleteEmployee("NILA");
                        
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
        }  
         
       
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Signin.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
     
     public void loginpage(){        
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));           
            Scene scene = new Scene(root1,400,400);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }

}
