/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Percistence.MySqlConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Client;

/**
 *
 * @author matluna
 */
public class ClientDao {
    
    public List<Client> findAll(String search) throws Exception {
        
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String condition = (search != null) ? "WHERE name LIKE '%" +search +"%' or surname LIKE '%"+search+"%' or dni LIKE '%"+search+"'%;" : ";";
        String query = "SELECT * FROM client " + condition;
        ResultSet rs = stmt.executeQuery(query);
        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            String nameTemp = rs.getString("name");
            String surnameTemp = rs.getString("surname");
            long dniTemp = rs.getLong("dni");
            String phoneTemp = rs.getString("phone");
            String addressTemp = rs.getString("address");
            int idTemp = rs.getInt("id");
            
            clients.add(Client.builder()
            .name(nameTemp)
            .surname(surnameTemp)
            .dni(dniTemp)
            .address(addressTemp)
            .phone(phoneTemp)
            .id(idTemp).build());
        }
        return clients;
    }
    
    public void save(Client client) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "INSERT INTO client (name, surname, dni, phone, address) VALUES ('"+client.name+"','"+client.surname+"',"+client.dni+", '"+client.phone+"', '"+client.address+"');";
        stmt.executeUpdate(query);
    }
    
    public void update(int id, Client client) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "UPDATE client SET name = '"+client.name+"', surname = '"+client.surname+"', dni = "+client.dni+", phone = '"+client.phone+"', address = '"+client.address+"' WHERE id = "+id+";";
        stmt.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "DELETE FROM client WHERE id = "+id+";";
        stmt.executeUpdate(query);
    }
    
}
