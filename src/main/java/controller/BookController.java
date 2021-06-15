/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import java.util.List;
import model.Book;

/**
 *
 * @author matluna
 */
public class BookController {
    
    BookDao bookDao = new BookDao();
    
    public List<Book> findAll(String title) throws Exception{
        return bookDao.findAll(title);
    }
    
    public void save(Book book) throws Exception{
        bookDao.save(book);
    }
    
    public void update(int id, Book book) throws Exception{
        bookDao.update(id, book);
    }
    
    public void delete(int id) throws Exception{
        bookDao.delete(id);
    }
    
}
