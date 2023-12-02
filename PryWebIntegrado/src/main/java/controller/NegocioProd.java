/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import util.MySQLConexion;

/**
 *
 * @author diego8658
 */
public class NegocioProd {
    public List<Producto> LisProd(int id){
    List<Producto> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select p.producto_id, p.nombre, p.preciounitario, p.stock, c.nombre, v.nombre, p.proveedor_id from productos p inner join categorias c on p.categoria_id=c.categoria_id inner join proveedores v on p.proveedor_id=v.proveedor_id where p.categoria_id=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Producto p=new Producto();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setUnit(rs.getDouble(3));
       p.setStock(rs.getInt(4));
       p.setCate(rs.getString(5));
       p.setProve(rs.getString(6));
       p.setProveid(rs.getInt(7));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
   
    public void adiProd(Producto p){
    Connection cn=MySQLConexion.getConexion();
    String sql="insert into productos values(null,?,?,?,?,?)";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, p.getNombre());
       st.setDouble(2, p.getUnit());
       st.setInt(3, p.getStock());
       st.setInt(4, p.getCateid());
       st.setInt(5, p.getProveid());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public void anuProd(int id){
    Connection cn=MySQLConexion.getConexion();
    String sql="delete from productos where producto_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setInt(1, id);
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public void modProdu(Producto p){
    Connection cn=MySQLConexion.getConexion();
    String sql="update productos set nombre=?,preciounitario=?,stock=?,categoria_id=?,proveedor_id=? where producto_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setString(1, p.getNombre());
       st.setDouble(2, p.getUnit());
       st.setInt(3, p.getStock());
       st.setInt(4, p.getCateid());
       st.setInt(5, p.getProveid());
       st.setInt(6,p.getId());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public Producto consulProd(int id){
    Connection cn=MySQLConexion.getConexion();
    Producto p=null;
    String sql="select producto_id, nombre, preciounitario, stock, categoria_id, proveedor_id from productos where producto_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          p=new Producto();
          p.setId(rs.getInt(1));
          p.setNombre(rs.getString(2));
          p.setUnit(rs.getDouble(3));
          p.setStock(rs.getInt(4));
          p.setCateid(rs.getInt(5));
          p.setProveid(rs.getInt(6));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }
    return p;
  }
    
    public List<Producto> LisProdTot(){
    List<Producto> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select p.producto_id, p.nombre, p.preciounitario, p.stock, c.nombre, v.nombre, p.proveedor_id from productos p inner join categorias c on p.categoria_id=c.categoria_id inner join proveedores v on p.proveedor_id=v.proveedor_id";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Producto p=new Producto();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setUnit(rs.getDouble(3));
       p.setStock(rs.getInt(4));
       p.setCate(rs.getString(5));
       p.setProve(rs.getString(6));
       p.setProveid(rs.getInt(7));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
}
