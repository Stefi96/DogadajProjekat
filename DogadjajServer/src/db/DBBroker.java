package db;

import domen.DomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import property.PropertyReader;

public class DBBroker {
        
    Connection connection;
    public void loadDrive() throws ClassNotFoundException{
        
            Class.forName(PropertyReader.getInstance().getDriver());
            //System.out.println("Load driver");
       
    }
      public void testParametars(String url, String username, String password) throws SQLException {
         //System.out.println("Broker in");
         try {
             loadDrive();
             connection=DriverManager.getConnection(url,username,password);
         } catch (SQLException ex) {
             throw new SQLException("Parametars are not correct");
         } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver not found");
         }
        
    }
    public void openConnection(){
        try {
            loadDrive();
            connection = DriverManager.getConnection(PropertyReader.getInstance().getURL(),PropertyReader.getInstance().getUsername(),PropertyReader.getInstance().getPassword());
            connection.setAutoCommit(false);
            //System.out.println("Connected to the database!");
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
         }
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ResultSet selectObject(DomenskiObjekat dom) throws SQLException {
        String sql = "Select * from "+dom.vratiImeTabele()+ dom.vratiAlias()+ dom.vratiJoin()+dom.whereConn();
        System.out.println(sql);
        Statement s = connection.createStatement();
        return s.executeQuery(sql);
    }

    public void deleteObject(DomenskiObjekat dom) throws SQLException {
        String sql = "Delete from "+ dom.vratiImeTabele()+" where "+ dom.vratiPK();
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    }

    public void insertObject(DomenskiObjekat dom) throws SQLException {
        String sql = "INSERT INTO "+dom.vratiImeTabele()+dom.vratiPoljaZaInsert()+" VALUES ("+dom.vratiVrednostZaInsert()+")";        
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    }

    public void updateObject(DomenskiObjekat dom) throws SQLException {
        String sql = "UPDATE "+dom.vratiImeTabele()+ " SET "+dom.vratiVrednostZaPromenu()+" WHERE "+dom.vratiPK();
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    }
  
    public int getID(DomenskiObjekat dom) throws SQLException {
        String sql = "SELECT max("+dom.vratiTabelaID()+") as id from "+dom.vratiImeTabele();
        System.out.println(sql);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        Integer id = 1;
        while(rs.next()){
            id = rs.getInt("id");
        } 
        return id;
    }
}
