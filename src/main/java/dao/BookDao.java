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

/**
 *
 * @author matluna
 */
public class BookDao {
    
    public List<Book> findAll(String title) throws Exception {
        
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String condition = (title != null) ? "WHERE title LIKE '%" +title +"%';" : ";";
        String query = "SELECT * FROM libro " + condition;
        ResultSet rs = stmt.executeQuery(query);
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            String titleTemp = rs.getString("title");
            String descriptionTemp = rs.getString("description");
            int pagesTemp = rs.getInt("pages");
            int yearTemp = rs.getInt("year");
            int idTemp = rs.getInt("id");
            
            books.add(Book.builder()
                    .id(idTemp)
                    .title(titleTemp)
                    .description(descriptionTemp)
                    .pages(pagesTemp)
                    .year(yearTemp)
                    .build());
        }
        return books;
    }
    
    public void save(Book book) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "INSERT INTO libro (title, pages, year, description) VALUES ('"+book.title+"',"+book.pages+","+book.year+", '"+book.description+"');";
        stmt.executeUpdate(query);
    }
    
    public void update(int id, Book book) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "UPDATE libro SET title = '"+book.title+"', pages = "+book.pages+", year = "+book.year+", description = '"+book.description+"' WHERE id = "+id+";";
        stmt.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception{
        Connection connection = MySqlConnector.getInstance();
        Statement stmt = connection.createStatement();
        String query = "DELETE FROM libro WHERE id = "+id+";";
        stmt.executeUpdate(query);
    }
    
}
