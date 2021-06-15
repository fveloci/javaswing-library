/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Builder;

/**
 *
 * @author matluna
 */
@Builder
public class Loan {
    
    public int id;
    public int book_id;
    public int client_id;
    public String book_title;
    public String client_name;
    public String date;
    public int devolucion;
    
}
