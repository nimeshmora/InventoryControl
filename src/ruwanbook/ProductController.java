package ruwanbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 *
 * @author rukshani
 */
public class ProductController implements Initializable {

    @FXML
    private TextField serial;
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private TextField price;
    @FXML
    private TextField quantity;
    @FXML
    private TextField category;
    @FXML
    private TextField brand;
    @FXML
    private TextField totPrice;
    @FXML
    private TextField suppId;
    @FXML
    private TextField stockLevel;
    @FXML
    private TextField image;

    String serialNumber;
    String proName;
    String proDescription;
    String proPrice;
    String proQuantity;
    String proCategory;
    String proBrand;
    String proTotPrice;
    String supplierID;
    String proStock;
    String imageUrl;
    int int_serialNumber;
    int int_price;
    int int_quantity;
    int int_totPrice;
    int int_suppId;
    int int_stockLevel;

    connect con = new connect();

    @FXML
    public void addProduct() {
        serialNumber = serial.getText();
        proName = name.getText();
        proDescription = description.getText();
        proPrice = price.getText();
        proQuantity = quantity.getText();
        proCategory = category.getText();
        proBrand = brand.getText();
        proTotPrice = totPrice.getText();
        supplierID = suppId.getText();
        proStock = stockLevel.getText();
        imageUrl = image.getText();

        System.out.println("add id:" + proName + " name:" + proPrice + " add:" + proQuantity + " phone:" + proBrand);
        int_serialNumber = Integer.parseInt(serialNumber);
        int_price = Integer.parseInt(proPrice);
        int_quantity = Integer.parseInt(proQuantity);
        int_totPrice = Integer.parseInt(proTotPrice);
        int_suppId = Integer.parseInt(supplierID);
        int_stockLevel = Integer.parseInt(proStock);
        con.insertProduct(int_serialNumber, proName, proDescription, int_price, int_quantity, proCategory, proBrand, int_totPrice, int_suppId, int_stockLevel, imageUrl);
        //con.insertCustomer(1, "nilak", "nilaadd", 037);
    }
    
          @FXML
     public void updateProduct(){
        serialNumber = serial.getText();
        proName = name.getText();
        proDescription = description.getText();
        proPrice = price.getText();
        proQuantity = quantity.getText();
        proCategory = category.getText();
        proBrand = brand.getText();
        proTotPrice = totPrice.getText();
        supplierID = suppId.getText();
        proStock = stockLevel.getText();
        imageUrl = image.getText();
        int_serialNumber = Integer.parseInt(serialNumber);
        int_price = Integer.parseInt(proPrice);
        int_quantity = Integer.parseInt(proQuantity);
        int_totPrice = Integer.parseInt(proTotPrice);
        int_suppId = Integer.parseInt(supplierID);
        int_stockLevel = Integer.parseInt(proStock);
       // System.out.println("update id:"+int_supId+" name:"+supplierName+" add:"+supplierAddress+" phone:"+int_supphone+ "company"+supplierCompany); 
          con.updateProduct(int_serialNumber, proName, proDescription, int_price, int_quantity, proCategory, proBrand, int_totPrice, int_suppId, int_stockLevel, imageUrl);
    }
         
           @FXML
        public void deleteProduct(){  
          serialNumber = serial.getText();

         int_serialNumber = Integer.parseInt(serialNumber);
      
       // System.out.println("delete id:"+int_supId+" name:"+int_supphone+" add:"+supplierAddress+" phone:"+supplierPhone);
        con.deleteProduct(int_serialNumber);
    }
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void backToMainMenu() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

            Scene scene = new Scene(root1);

            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);
            RuwanBook.getStage().show();
        } catch (Exception e) {
        }
    }

}
