/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Bhashi
 */
public class ProductDetails {
 
        private final SimpleStringProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty supaddress;
        private final SimpleStringProperty companyName;
        private final SimpleStringProperty phone;
       // double noOfItems;
       //double PricePerPiece;
        
 
        public ProductDetails(String ID, String lName, String address, String company, String sPhone) {
            this.id = new SimpleStringProperty(ID);
            this.name = new SimpleStringProperty(lName);
            this.supaddress = new SimpleStringProperty(address);
            this.companyName = new SimpleStringProperty(company);
            this.phone = new SimpleStringProperty(sPhone);
           // this.noOfItems = noitems;
            //this.PricePerPiece = price;
            System.out.println(sPhone);
        }

  
 
        public String getFirstName() {
            return id.get();
        }
 
        public void setFirstName(String fName) {
            id.set(fName);
        }
 
        public String getLastName() {
            return name.get();
        }
 
        public void setLastName(String lName) {
            name.set(lName);
        }
            public String getAddress() {
            return supaddress.get();
        }
 
        public void setAddress(String address) {
            supaddress.set(address);
        }
        
        public String getCompany() {
            return companyName.get();
        }
 
        public void setCompany(String company) {
            companyName.set(company);
        }
        
        public String getPhone() {
            return phone.get();
        }
 
        public void setSupplier(String sPhone) {
            phone.set(sPhone);
        }
    
    }

