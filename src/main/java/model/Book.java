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
public class Book {
    
    public int id;
    public String title;
    public int pages;
    public int year;
    public String description;
    
}
