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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rukshani
 */
public class SigninController implements Initializable {
    @FXML private TextField tf_username;
    @FXML private PasswordField tf_password;
    @FXML private TextField tf_name;
    @FXML private TextField tf_address;
    @FXML private TextField tf_phone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void loginpage(){ 
        try {
            connect con=new connect();
            String username=tf_username.getText();
            String password=tf_password.getText();
            String name=tf_name.getText();
            String address=tf_address.getText();
            String phone=tf_phone.getText();
            int int_phone=Integer.parseInt(phone);
            con.insertEmployee(username, password, name, address, int_phone);            
        } catch (Exception ex) {
            System.out.println("Sign in error "+ex);
        }       
        
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));           
            Scene scene = new Scene(root1,400,400);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
                 @FXML
    public void backToLogIn(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Start.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
}
