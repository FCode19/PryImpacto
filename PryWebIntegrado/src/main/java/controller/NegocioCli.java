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
import model.Cliente;
import util.MySQLConexion;

/**
 *
 * @author diego8658
 */
public class NegocioCli {
    public void adiCli(Cliente c){
    Connection cn=MySQLConexion.getConexion();
    String sql="insert into clientes values(null,?,?,?,?,?)";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, c.getNombre());
       st.setString(2, c.getDirecc());
       st.setString(3, c.getEmail());
       st.setString(4, c.getTelef());
       st.setString(5, c.getContra());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public void anuCli(int id){
    Connection cn=MySQLConexion.getConexion();
    String sql="delete from clientes where cliente_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setInt(1, id);
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public void modiCli(Cliente c){
    Connection cn=MySQLConexion.getConexion();
    String sql="update clientes set nombre=?,direccion=?,email=?,telefono=?,contraseña=? where cliente_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       //enlazar los atributos con  cada ?
       st.setString(1, c.getNombre());
       st.setString(2, c.getDirecc());
       st.setString(3, c.getEmail());
       st.setString(4, c.getTelef());
       st.setString(5, c.getContra());
       st.setInt(6, c.getId());
       st.executeUpdate();
    }catch(Exception ex){
        ex.printStackTrace();
    }
  }
    
    public Cliente consulCli(int id){
    Connection cn=MySQLConexion.getConexion();
    Cliente c=null;
    String sql="select cliente_id, nombre, direccion, email, telefono, contraseña from clientes where cliente_id=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setInt(1, id);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          c=new Cliente();
          c.setId(rs.getInt(1));
          c.setNombre(rs.getString(2));
          c.setDirecc(rs.getString(3));
          c.setEmail(rs.getString(4));
          c.setTelef(rs.getString(5));
          c.setContra(rs.getString(6));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }
    return c;
  }
    
    public Cliente consulCliDic(String ema){
    Connection cn=MySQLConexion.getConexion();
    Cliente c=null;
    String sql="select cliente_id, nombre, direccion, email, telefono, contraseña from clientes where email=?";
    try{
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, ema);
       //enlazar los atributos con  cada ?
      ResultSet rs=st.executeQuery();
       if(rs.next()){
          c=new Cliente();
          c.setId(rs.getInt(1));
          c.setNombre(rs.getString(2));
          c.setDirecc(rs.getString(3));
          c.setEmail(rs.getString(4));
          c.setTelef(rs.getString(5));
          c.setContra(rs.getString(6));
      }
     }catch(Exception ex){
        ex.printStackTrace();
    }
    return c;
  }
    
    public List<Cliente> filtraraCliente(String id){
    List<Cliente> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select cliente_id, nombre, direccion, email, telefono, contraseña from clientes where nombre like ?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, id+"%");
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Cliente p=new Cliente();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setDirecc(rs.getString(3));
       p.setEmail(rs.getString(4));
       p.setTelef(rs.getString(5));
       p.setContra(rs.getString(6));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public List<Cliente> LisCli(){
    List<Cliente> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select cliente_id, nombre, direccion, email, telefono, contraseña from clientes";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Cliente p=new Cliente();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       p.setDirecc(rs.getString(3));
       p.setEmail(rs.getString(4));
       p.setTelef(rs.getString(5));
       p.setContra(rs.getString(6));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
}
