/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 *
 * @author Bhashi
 */
public class suppTableViewController implements Initializable{
    @FXML
    TableView tblview;
    //public-Readable var listViewSupplier: javafx.scene.control.ListView;
    //var db: Database = Database.getInstance();
   // private final TableView<Details> tblview = new TableView<>();
   // private final ObservableList<Person> data =FXCollections.observableArrayList(new Person("A", "B"));
    private  ObservableList<SupplierDetails> data=FXCollections.observableArrayList(new SupplierDetails("", "","","",""));
    final HBox hb = new HBox();
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        TableColumn firstNameCol = new TableColumn("Supplier ID");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Supplier Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        TableColumn phoneCol = new TableColumn("Company");
        phoneCol.setMinWidth(100);
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        
        TableColumn companyNameCol = new TableColumn("Phone");
        companyNameCol.setMinWidth(100);
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        

 
        tblview.setItems(data);
        tblview.getColumns().addAll(firstNameCol, lastNameCol,addressCol,phoneCol,companyNameCol);
       // data.add(new Details("qq", "aa", "c","dd","E"));
                
        try {
            Statement st=connection.getcon().createStatement();
           // st.executeUpdate("INSERT INTO APP.FRIENDS (ID, \"NAME\") \n" +"VALUES (10, 'maaa')");          
           // st.execute("DELETE FROM RUKSHANI.FRIENDS WHERE id=10");
            ResultSet rs=st.executeQuery("select * from SUPPLIER");
            ResultSetMetaData rsmd=rs.getMetaData();
	    int numberOfColumns = rsmd.getColumnCount();
            System.out.println(numberOfColumns);
            
            while(rs.next()){
          //  for (int i = 1; i <= numberOfColumns; i++){
//                for(int i=1;i<=numberOfColumns;i++){
//                    System.out.print(rs.getString(i)+"    ");
                  //  data =FXCollections.observableArrayList(new Person("A", "B"));
                    //System.out.println(i);
                /*String ID = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                int phone = rs.getInt(4);
                String company = rs.getString(5);
                System.out.println(address);
                System.out.println(phone);
                data.add(new Details(ID, name, address));*/
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                data.add(new SupplierDetails(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
                    
//                }
//                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
    }

    public static void main(String[] args) {
        launch(args);
    }
 
            @FXML
    public void backToSupplier(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Supplier.fxml"));
           
            Scene scene = new Scene(root1);
            
            RuwanBook.getStage().setTitle("Suppliers");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
    
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
    


