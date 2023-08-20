package dao;

import connection.ConnectDB;
import entity.*;
import jakarta.mail.Authenticator;
import jakarta.mail.*;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.*;
import jakarta.mail.internet.MimeMessage;
import java.sql.*;
import java.util.*;

public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6)));
            }        
        } catch (Exception e) {}
        return list;
    }
    
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Category(rs.getInt(1),
                                     rs.getString(2)));                             
            }
        } catch (Exception e) {}
        return list;
    }
    
    public List<Product> getProductByCateID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n" + "where category_id = ?";

        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6)));
            }         
        } catch (Exception e) {}
        return list;
    }
    
    public Product getProductBypID(String pID) {
        String query = "select * from product where product_id = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pID);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6));
            }  
        } catch (Exception e) {}
        return null;
    }
    
    public List<Product> getRandomProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product order by rand() limit 6";
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query);
            //ps.setInt(1, limit);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6)));
            }
        } catch (Exception e) {}
        return list;
    }
    
    public int getTotalProduct() {
        String query = "select count(*) from product";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }
    
    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product limit 6 offset ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6)));
            }
        } catch (Exception e) {}
        return list;
    }
    
    public int getTotalByCateID(String cID) {
        String query = "select count(*) from product where category_id = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cID);
            rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {}
        return 0;
    }
    
    public List<Product> getPagingByCateID(String cID, int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where category_id = ? limit 6 offset ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cID);
            ps.setInt(2, (index-1)*6);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(3),
                                   rs.getString(4),
                                   rs.getInt(5),
                                   rs.getInt(6)));
            }        
        } catch (Exception e) {}       
        return list;
    }
    
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from login";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Account(rs.getString(1),rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {}
        return list;
    }
    
    public Account login(String username, String password) {
        String query = "select * from login where username = ? and password = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }          
        } catch (Exception e) {}
        return null;
    }
    
    public Account signup(String user, String pass, String gmail) {
        String query = "insert into login(username, password, gmail) value(?,?,?)";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.executeUpdate();
        } catch (Exception e) {}
        return null;
    }
    
    public Account checkExistUser(String username) {
        String query = "select * from login where username = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {}
        return null;
    }
    
    public Account checkExistGmail(String gmail) {
        String query = "select * from login where gmail = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {}
        return null;
    }
    
    public Account checkBoth(String user, String gmail) {
        String query = "select * from login where username = ? and gmail = ?";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, gmail);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }         
        } catch (Exception e) {}
        return null;
    }
    
    public void sendEmail(String toReceiptEmail, String username) {
        //pass: ewvlxlhrlxglsdsn
        //final String from = "kientrungak@gmail.com";
        //final String pass = "ewvlxlhrlxglsdsn";
        final String from = "fasionprojectkfpt17@gmail.com";
        final String pass = "sdoqhhgrpownzowo";
        Properties props = new Properties(); 
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
       // props.put("mail.user", "kiennctqe170207@fpt.edu.vn"); 
       
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        };
        
        Session session = Session.getInstance(props, auth);
        //final String to = "ielts2k3@gmail.com";
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toReceiptEmail, false));
            msg.setSubject("Thank You for Subscribing");
            String emailMess = "Dear " + username +",\n\n";
            emailMess += "Thank you for registering on our website. We appreciate your subscription.";
            msg.setText(emailMess, "UTF-8");
            Transport.send(msg);
        } catch (Exception e) {}
    }
    
    /*
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.sendEmail("ielts2k3@gmail.com");
        
    }
    */
    
    
    
    void register(String user, String pass, String gmail) {
        String query = "insert into customer(customer_id, username,password,customer_name, email,address,status)\n"
                        + "values(?,?,?,?,?,?, 0)";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            //rs = ps.executeQuery();
            
        } catch (Exception e) {}
        
            
    }
}
