/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoanDao;
import java.util.List;
import model.Loan;

/**
 *
 * @author matluna
 */
public class LoanController {
    
    LoanDao loanDao = new LoanDao();
    
    public List<Loan> findAll(String search) throws Exception{
        return loanDao.findAll(search);
    }
    
    public void save(Loan loan) throws Exception {
        loanDao.save(loan);
    }
    
    public void update(int id, Loan loan) throws Exception{
        loanDao.update(id, loan);
    }
    
}
