/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CustomerController implements Initializable {
    
     private static final String customerTable = "customer";
     @FXML private Text actiontarget;   
     @FXML private TextField tf_cusid;
     @FXML private TextField tf_cusname;
     @FXML private TextField tf_cusaddress;
     @FXML private TextField tf_cusphone;
     String cusid;
     String cusname;
     String cusaddress;
     String cusphone;
     int int_cusid;
     int int_cusphone;
     connect con=new connect();

    public void add(){
        cusid=tf_cusid.getText();
        cusname=tf_cusname.getText();
        cusaddress=tf_cusaddress.getText();
        cusphone=tf_cusphone.getText();
        System.out.println("add id:"+cusid+" name:"+cusname+" add:"+cusaddress+" phone:"+cusphone);    
        int_cusid= Integer.parseInt(cusid);
        int_cusphone= Integer.parseInt(cusphone);        
        insertCustomer(int_cusid, cusname, cusaddress, int_cusphone);
       //con.insertCustomer(1, "nilak", "nilaadd", 037);
    }
    public void update(){
        updateCustomer(int_cusid, cusname, cusaddress, int_cusphone);
    }
    public void delete(){        
        System.out.println("delete id:"+cusid+" name:"+cusname+" add:"+cusaddress+" phone:"+cusphone);
        deleteCustomer(int_cusid);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void insertCustomer(int id, String name, String address, int phone) {
        try {
            Statement st = connect.getcon().createStatement();
            String sqlins = "INSERT INTO " + customerTable + " VALUES(" + id + ",\'" + name + "\',\'" + address + "\'," + phone + ")";
            st.execute(sqlins);
            st.close();
            actiontarget.setText("Inserted successfully");
        } catch (Exception ex) {
            actiontarget.setText("Insertion failure");
            System.out.println("Insert error " + customerTable + ex);
        }
    }

    public void deleteCustomer(int id) {
        try {
            Statement ps = connect.getcon().createStatement();
            String sqldel = "DELETE FROM " + customerTable + " WHERE id=" + id + "";
            ps.execute(sqldel);
            ps.close();
            System.out.println("deleted " + id);
            actiontarget.setText("Deleted successfully");
        } catch (Exception ex) {
            actiontarget.setText("Deletion failure");
            System.out.println("Delete error " + customerTable + ex);
        }
    }

    public void updateCustomer(int id, String name, String address, int phone) {
        try {
            Statement ps = connect.getcon().createStatement();
            String sqlup = "UPDATE " + customerTable + " SET "
                    + "name=\'" + name + "\', address=\'" + address + "\', phone=" + phone + " WHERE id=" + id + "";
            ps.execute(sqlup);
            ps.close();
            actiontarget.setText("Updated successfully");
            System.out.println("Updated " + id);
        } catch (Exception ex) {
            actiontarget.setText("Update failure");
            System.out.println("Update error " + customerTable + ex);
        }
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
    
                @FXML
    public void CustomerDetails(){

        try {
            URL location = getClass().getResource("cussTableview.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            Parent root1 = (Parent) fxmlLoader.load(location.openStream());
            
            cussTableViewController ctr=(cussTableViewController)fxmlLoader.getController();
            
            Scene scene = new Scene(root1);
            
            RuwanBook.getStage().setTitle("Customer Details");
            RuwanBook.getStage().setScene(scene);  

            RuwanBook.getStage().show();

        } catch (IOException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
