/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.time.LocalDate;

/**
 *
 * @author hallgato
 */
public class Model {

    private Student fighter;
    private Student fighter2;

    public Student getStudent() {
        return fighter;
    }
    
    public Student getStudent2() {
        return fighter2;
    }

    public Model() {
        fighter = new Student("DOM",10,10, 55, LocalDate.parse("1991-12-03"));
        fighter2 = new Student("ÁKOS",10,10, 55, LocalDate.parse("1991-12-03"));
    }
}
