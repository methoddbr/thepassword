/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Model.Player;
import Model.Record;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.dbUtil;

/**
 *
 * @author metho
 */
public class PlayerPersistence {
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void registerRecord(Player j) throws SQLException {
        String sql = "INSERT INTO PLAYER (NAME, RECORD, TIME)"
                + "VALUES (?, ?, ?)";
        try{
            ps = dbUtil.getConnetion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, j.getName());
            ps.setInt(2, j.getRecord());
            ps.setDouble(3, j.getTime());

            ps.execute();
            
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
        }catch(SQLException ex) {
            Logger.getLogger(PlayerPersistence.class.getName()).log(Level.SEVERE, null, ex);

        }
    
    }
    public void cleanRecords() {
        String sql = "TRUNCATE TABLE PLAYER";
        
        try {
            ps = dbUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList<Record> listRecords(){
        String sql = "SELECT * FROM PLAYER ORDER BY RECORD, TIME LIMIT 5";
        ArrayList<Record> list = new ArrayList();
        
        try {
            ps = dbUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString(1);
                int record = rs.getInt(2);
                double time = rs.getDouble(3);
                
                Record a = new Record();
                a.setName(name);
                a.setRecord(record);
                a.setTime(time);
                list.add(a); 

            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
