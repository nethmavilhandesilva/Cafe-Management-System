
package dao;

import javax.swing.JOptionPane;


public class Tables {
    public static void main(String[]args){
        try{
            String userTable="create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
            String adminDetails="insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status)values('Admin','admin@gmail.com','0702758300','colombo','12345','what is name of your dog?','ABC','true')";
            String categoryTable="create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable="create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price  varchar(200))";
            String billTable="create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            DbOperations.setDataDelete(billTable,"Bill Table Table Created Successfully");
          // DbOperations.setDataDelete(userTable,"User Table Created Successfully");
           // DbOperations.setDataDelete(adminDetails,"Admin Detais Added Successfully");
           // DbOperations.setDataDelete(categoryTable,"Category Table Created Successfully Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
}
