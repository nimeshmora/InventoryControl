/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rukshani
 */
public class connect {

    private static final String customerTable = "customer";
    private static final String employeeTable = "employee";
    private static final String productTable = "product";
    private static final String supplierTable = "SUPPLIER";

    public static Connection getcon() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            System.out.println("ok1");
            String dbURL = "jdbc:derby://localhost:1527/InventoryManagement;create=true";
            //Connect and create a database if not exist in the memory:
            System.out.println("connected");
            String user = "APP";
            String password = "a";
            Connection con = DriverManager.getConnection(dbURL, user, password);
            System.out.println("ok2");
            return con;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("not ok " + ex);
        }
        return null;
    }
    
    
      public void createTableCustomer() throws SQLException {
           Statement st = connect.getcon().createStatement();
         try{ st.execute("CREATE TABLE "
            + customerTable
           + "(id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25) NOT NULL,address VARCHAR(50), phone INTEGER)");
          System.out.println("Created table "+ customerTable);
       } catch(SQLException e){
           
           if(tableAlreadyExists(e)){
           
           }else{
               throw e;
           }
           
       }}
      
    public void createTableSupplier() throws SQLException {       
        Statement st = connect.getcon().createStatement();
       try{ st.execute("CREATE TABLE "
          + supplierTable
          + "(id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25), address VARCHAR(50), phone INTEGER,company VARCHAR(25))");
        System.out.println("Created table "+ supplierTable);
    } catch(SQLException e){
           
           if(tableAlreadyExists(e)){
           
           }else{
               throw e;
           }
           
       }}
          
    public void createTableProduct() throws SQLException {
        Statement st = connect.getcon().createStatement();
       try{ st.execute("CREATE TABLE "
          + productTable
          + "(serialnumber INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25), description VARCHAR(75), price INTEGER,quantity INTEGER, category VARCHAR(25), brand VARCHAR(25),totalprice INTEGER, supplierId INTEGER, stocklevel INTEGER, imageurl VARCHAR(75),"
                + "FOREIGN KEY(supplierId) REFERENCES supplier(id))");
        System.out.println("Created table "+ productTable);
    }catch(SQLException e){
           
           if(tableAlreadyExists(e)){
           
           }else{
               throw e;
           }
           
       }}
      
      public boolean tableAlreadyExists(SQLException e){
      
          boolean exists;
          if(e.getSQLState().equals("X0Y32")){
          exists = true;
          }else{
           exists = false;
          }
      return exists;
      }

//    public void insertCustomer(int id, String name, String address, int phone) {
//        try {
//            Statement st = connect.getcon().createStatement();
//            String sqlins = "INSERT INTO " + customerTable + " VALUES(" + id + ",\'" + name + "\',\'" + address + "\'," + phone + ")";
//            st.execute(sqlins);
//            st.close();
//
//        } catch (SQLException ex) {
//            System.out.println("Insert error " + customerTable + ex);
//        }
//    }
//
//    public void deleteCustomer(int id) {
//        try {
//            Statement ps = connect.getcon().createStatement();
//            String sqldel = "DELETE FROM " + customerTable + " WHERE id=" + id + "";
//            ps.execute(sqldel);
//            System.out.println("deleted " + id);
//        } catch (SQLException ex) {
//            System.out.println("Delete error " + customerTable + ex);
//        }
//    }
//
//    public void updateCustomer(int id, String name, String address, int phone) {
//        try {
//            Statement ps = connect.getcon().createStatement();
//            String sqlup = "UPDATE " + customerTable + " SET "
//                    + "name=\'" + name + "\', address=\'" + address + "\', phone=" + phone + " WHERE id=" + id + "";
//            ps.execute(sqlup);
//
//            System.out.println("Updated " + id);
//        } catch (SQLException ex) {
//            System.out.println("Update error " + customerTable + ex);
//        }
//    }

    public void createTableEmployee() throws SQLException {//        
        try{Statement st = connect.getcon().createStatement();
        st.execute("CREATE TABLE "
          + employeeTable
          + "(username VARCHAR(25) NOT NULL PRIMARY KEY, password VARCHAR(25),name VARCHAR(25),address VARCHAR(50), phone INTEGER)");
        System.out.println("Created table "+ employeeTable);
        } catch(SQLException e){
           
           if(tableAlreadyExists(e)){
           
           }else{
               throw e;
           }
           
       }}
    
    public void insertEmployee(String username, String password, String name, String address, int phone) {
        try {
            Statement st = connect.getcon().createStatement();
            String sqlins = "INSERT INTO " + employeeTable + " VALUES(\'" + username + "\',\'" + password + "\',\'" + name + "\',\'" + address + "\'," + phone + ")";
            st.execute(sqlins);
            st.close();
        } catch (SQLException ex) {
            System.out.println("Insert error " + employeeTable + ex);
        }
    }

    public void deleteEmployee(String username) {
        try {
            Statement ps = connect.getcon().createStatement();
            String sqldel = "DELETE FROM " + employeeTable + " WHERE username=\'" + username + "\'";
            ps.execute(sqldel);
        } catch (SQLException ex) {
            System.out.println("Delete error " + employeeTable + ex);
        }
    }

    /*   public void insertSupplier(String id, String name, String address, String company, String phone) {
     try {
     Statement st = connect.getcon().createStatement();
     System.out.println(id + " " + name + " " + address + " " + company + " " + phone);
     // String supplierT = "SUPPLIER";
     String sqlins = "INSERT INTO " + supplierTable + " VALUES(" + id + ",\'" + name + "\',\'" + address + "\'," + phone + ")";
     st.execute(sqlins);
     st.close();

     } catch (SQLException ex) {
     System.out.println("Insert error " + supplierTable + ex);
     }
     }*/


    void insertSupplier(int int_supId, String supplierName, String supplierAddress, int int_supphone, String supplierCompany) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            Statement st = connect.getcon().createStatement();
            System.out.println(int_supId + " " + supplierName + " " + supplierAddress + " " + int_supphone + " " + supplierCompany);
            // String supplierT = "SUPPLIER";
            String sqlins = "INSERT INTO " + supplierTable + " VALUES(" + int_supId + ",\'" + supplierName + "\',\'" + supplierAddress + "\'," + int_supphone + ",\'" + supplierCompany + "\')";
            st.execute(sqlins);
            st.close();

        } catch (SQLException ex) {
            System.out.println("Insert error " + supplierTable + ex);
        }

    }

    void updateSupplier(int int_supId, String supplierName, String supplierAddress, String supplierPhone) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(int_supId);
        try {
            Statement ps = connect.getcon().createStatement();
            String sqlup = "UPDATE " + supplierTable + " SET "
                    + "NAME=\'" + supplierName + "\', ADDRESS=\'" + supplierAddress + "\', PHONE=" + supplierPhone + " WHERE ID=" + int_supId + "";
            ps.execute(sqlup);

            System.out.println("Updated " + int_supId);
        } catch (SQLException ex) {
            System.out.println("Update error " + supplierTable + ex);
        }

    }

    void deleteSupplier(int int_supId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            Statement ps = connect.getcon().createStatement();
            String sqldel = "DELETE FROM " + supplierTable + " WHERE id=" + int_supId + "";
            ps.execute(sqldel);
            System.out.println("deleted " + int_supId);
        } catch (SQLException ex) {
            System.out.println("Delete error " + supplierTable + ex);
        }

    }

//    public void insertProduct(int productID, String productDes, String productCategory, String productBrand, String prodSuppName, int noOfItems) {
//        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        try {
//            Statement st = connect.getcon().createStatement();
//            System.out.println(productID + " " + productDes + " " + productCategory + " " + productBrand + " " + prodSuppName + " " + noOfItems);
//            // String supplierT = "SUPPLIER";
//            String sqlins = "INSERT INTO " + productTable + " VALUES(" + productID + ",\'" + productDes + "\',\'" + productCategory + "\',\'" + productBrand + "\',\'" + prodSuppName + "\'," + noOfItems + ")";
//            st.execute(sqlins);
//            st.close();
//
//        } catch (SQLException ex) {
//            System.out.println("Insert error " + productTable + ex);
//        }
//
//    }

//    public void updateProduct(int productID, String productDes, String productCategory, String productBrand, String prodSuppName, int noOfItems) {
//        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println(productID);
//        try {
//            Statement ps = connect.getcon().createStatement();
//            String sqlup = "UPDATE " + productTable + " SET "
//                    + "productid=\'" + productID + "\', description=\'" + productDes + "\', noofitems=" + noOfItems + " WHERE PRODUCTID=" + productID + "";
//            ps.execute(sqlup);
//
//            System.out.println("Updated " + productID);
//        } catch (SQLException ex) {
//            System.out.println("Update error " + productTable + ex);
//        }
//
//    }

    void deleteProduct(int int_productId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           try {
            Statement ps = connect.getcon().createStatement();
            String sqldel = "DELETE FROM " + productTable + " WHERE serialnumber=" + int_productId + "";
            ps.execute(sqldel);
            System.out.println("deleted " + int_productId);
        } catch (SQLException ex) {
            System.out.println("Delete error " + productTable + ex);
        }
    
    }
    
    void insertProduct(int int_serialNumber, String proName, String proDescription, int int_price, int int_quantity, String proCategory, String proBrand, int int_totPrice, int int_suppId, int int_stockLevel, String imageUrl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            Statement st = connect.getcon().createStatement();
            System.out.println(int_serialNumber + " " + proName + " " + proDescription + " " + int_price + " " + int_quantity + " " + proCategory);
            // String supplierT = "SUPPLIER";
                String sqlins = "INSERT INTO " + productTable + " VALUES(" + int_serialNumber + ",\'" + proName + "\',\'" + proDescription + "\'," + int_price + "," + int_quantity + ",\'" + proCategory + "\',\'" + proBrand + "\'," + int_totPrice + "," + int_suppId + "," + int_stockLevel + ",\'" + imageUrl + "\')";
               st.execute(sqlins);
            st.close();

        } catch (SQLException ex) {
            System.out.println("Insert error " + productTable + ex);
        }
    }

    void updateProduct(int int_serialNumber, String proName, String proDescription, int int_price, int int_quantity, String proCategory, String proBrand, int int_totPrice, int int_suppId, int int_stockLevel, String imageUrl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
            System.out.println(int_serialNumber);
        try {
            Statement ps = connect.getcon().createStatement();
            String sqlup = "UPDATE " + productTable + " SET "
                    + "NAME=\'" + proName + "\', DESCRIPTION=\'" + proDescription + "\', PRICE=" + int_price + " WHERE SERIALNUMBER=" + int_serialNumber + "";
            ps.execute(sqlup);

         //   System.out.println("Updated " + int_supId);
        } catch (SQLException ex) {
            System.out.println("Update error " + supplierTable + ex);
        }
    
    }
}
/* String sqlup = "UPDATE " + supplierTable + " SET "
                    + "NAME=\'" + supplierName + "\', ADDRESS=\'" + supplierAddress + "\', PHONE=" + supplierPhone + " WHERE ID=" + int_supId + "";
            ps.execute(sqlup);*/
