package ruwanbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SupplierController implements Initializable{
    
     @FXML private TextField supID;
     @FXML private TextField supName;
     @FXML private TextField supAddress;
     @FXML private TextField supPhone;
     @FXML private TextField supCompnay;
     
     String supplierID;
     String supplierName;
     String supplierAddress;
     String supplierPhone;
     String supplierCompany;
     int int_supphone;
     int int_supId;
     connect con=new connect();
      
      @FXML
     public void addSupplier(){
     
         supplierID = supID.getText();
         supplierName = supName.getText();
         supplierAddress = supAddress.getText();
         supplierPhone = supPhone.getText();
         supplierCompany = supCompnay.getText();
         int_supId = Integer.parseInt(supplierID);
         int_supphone = Integer.parseInt(supplierPhone);
         System.out.println("add id:"+int_supId+" name:"+supplierName+" add:"+supplierAddress+" phone:"+int_supphone+ "company"+supplierCompany); 
         //System.out.println(supplierID);
         con.insertSupplier(int_supId, supplierName, supplierAddress, int_supphone,supplierCompany);
     
     
     }
     
      @FXML
         public void updateSupplier(){
         supplierID = supID.getText();
         supplierName = supName.getText();
         supplierAddress = supAddress.getText();
         supplierPhone = supPhone.getText();
         supplierCompany = supCompnay.getText();
         int_supId = Integer.parseInt(supplierID);
         int_supphone = Integer.parseInt(supplierPhone);
        System.out.println("update id:"+int_supId+" name:"+supplierName+" add:"+supplierAddress+" phone:"+int_supphone+ "company"+supplierCompany); 
        con.updateSupplier(int_supId, supplierName, supplierAddress, supplierPhone);
    }
         
           @FXML
        public void deleteSupplier(){  
         supplierID = supID.getText();

         int_supId = Integer.parseInt(supplierID);
      
        System.out.println("delete id:"+int_supId+" name:"+int_supphone+" add:"+supplierAddress+" phone:"+supplierPhone);
        con.deleteSupplier(int_supId);
    }
     
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
    
        @FXML
    public void backToMainMenu(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
    
    
}
