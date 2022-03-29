/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attendance;

import java.util.ArrayList;

/**
 *
 * @author abdelrhman
 */
public class Query {
    public int id ;
    public String name ;
    public boolean perctange ;
    public ArrayList <AttendanceQuery> Att = null;

    public Query(int id, String name, boolean perctange) {
        this.id = id;
        this.name = name;
        this.perctange = perctange;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPerctange() {
        return perctange;
    }

    
}
