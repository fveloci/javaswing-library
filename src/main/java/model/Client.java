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
public class Client {
    
    public int id;
    public String name;
    public String surname;
    public long dni;
    public String phone;
    public String address;
    
}
