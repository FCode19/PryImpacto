/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diego8658
 */
public class Detalle {
    private int id;
    private String produN;
    private int produc;
    private int can;
    private double unit;
    
    public double total(){
        return can*unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduN() {
        return produN;
    }

    public void setProduN(String produN) {
        this.produN = produN;
    }

    public int getProduc() {
        return produc;
    }

    public void setProduc(int produc) {
        this.produc = produc;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }
    
    
}
