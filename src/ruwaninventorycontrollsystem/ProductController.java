/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruwaninventorycontrollsystem;

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
 * @author Nimesha Jinarajadasa
 */
public class ProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void backToMainMenu(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
           
            Scene scene = new Scene(root1);
            
            RuwanInventoryControllSystem.getStage().setTitle("easyCash");
            RuwanInventoryControllSystem.getStage().setScene(scene);  
            RuwanInventoryControllSystem.getStage().show();
          }catch(Exception e){}
    }
    
}
