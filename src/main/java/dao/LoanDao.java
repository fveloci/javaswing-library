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
import model.Loan;

/**
 *
 * @author matluna
 */
public class LoanDao {
    
    public List<Loan> findAll(String search) throws Exception {
        
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String condition = (search != null) ? "WHERE book_title LIKE '%" +search +"%' or client_name LIKE '%"+search+"%';" : ";";
        String query = "SELECT * FROM loan " + condition;
        ResultSet rs = stmt.executeQuery(query);
        List<Loan> loans = new ArrayList<>();
        while (rs.next()) {
            String titleTemp = rs.getString("book_title");
            String nameTemp = rs.getString("client_name");
            String dateTemp = rs.getString("date");
            int timeTemp = rs.getInt("time");
            int cIdTemp = rs.getInt("client_id");
            int bIdTemp = rs.getInt("book_id");
            int idTemp = rs.getInt("id");
            
            loans.add(Loan.builder()
            .book_id(bIdTemp)
                    .book_title(titleTemp)
                    .client_id(cIdTemp)
                    .client_name(nameTemp)
                    .date(dateTemp)
                    .devolucion(timeTemp)
                    .id(idTemp).build());
        }
        return loans;
    }
    
    public void save(Loan loan) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "INSERT INTO loan (client_id, client_name, book_id, book_title, date, time) VALUES ("+loan.client_id+",'"+loan.client_name+"',"+loan.book_id+", '"+loan.book_title+"', '"+loan.date+"', "+loan.devolucion+");";
        stmt.executeUpdate(query);
    }
    
    public void update(int id, Loan loan) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "UPDATE loan SET client_id = "+loan.client_id+", client_name = '"+loan.client_name+"', book_id = "+loan.book_id+", book_title = '"+loan.book_title+"', date = '"+loan.date+"', time = "+loan.devolucion+" WHERE id = "+id+";";
        
        stmt.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "DELETE FROM client WHERE id = "+id+";";
        stmt.executeUpdate(query);
    }
    
}
