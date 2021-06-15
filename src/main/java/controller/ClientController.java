/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientDao;
import java.util.List;
import model.Book;
import model.Client;

/**
 *
 * @author matluna
 */
public class ClientController {
    
    ClientDao clientDao = new ClientDao();
    
    public List<Client> findAll(String search) throws Exception{
        return clientDao.findAll(search);
    }
    
    public void save(Client client) throws Exception{
        clientDao.save(client);
    }
    
    public void update(int id, Client client) throws Exception {
        clientDao.update(id, client);
    }
    
    public void delete(int id) throws Exception {
        clientDao.delete(id);
    }
   
    
}
