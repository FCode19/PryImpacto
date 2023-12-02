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
import model.Detalle;
import util.MySQLConexion;

/**
 *
 * @author diego8658
 */
public class NegocioDet {
    public List<Detalle> lisDet(int id){
    List<Detalle> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select d.detalle_id,p.nombre,d.producto_id,p.preciounitario,d.cantidad from detallespedidos d inner join productos p on d.producto_id=p.producto_id where d.pedido_id=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Detalle p=new Detalle();
       p.setId(rs.getInt(1));
       p.setProduN(rs.getString(2));
       p.setProduc(rs.getInt(3));
       p.setUnit(rs.getDouble(4));
       p.setCan(rs.getInt(5));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   } 
}
