/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Leonardo Prestes
 */
public class Player {
    private static Player instance;
    
    private String name;
    private int record;
    private double time;

    private Player() {
       
    }

    public static Player getInstance(){
        if(instance == null){
            instance = new Player();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    @Override
    public String toString(){
        return name+ "   Attempts: "+record+"   Time: "+time;
    }
}
