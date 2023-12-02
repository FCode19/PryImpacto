/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Detalle;
import model.Pedido;
import util.MySQLConexion;

/**
 *
 * @author diego8658
 */
public class NegocioPed {
    public List<Pedido> lisPed(int id){
    List<Pedido> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select p.pedido_id, c.nombre, p.fecha from pedidos p inner join clientes c on p.Cliente_id=c.Cliente_id where p.Cliente_id=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setInt(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Pedido p=new Pedido();
       p.setId(rs.getInt(1));
       p.setClient(rs.getString(2));
       p.setFecha(rs.getString(3));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public int GrabaFac(int id, List<Detalle> lista) {
        int ped=0;
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql="{call spPedido(?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1,id);
            ResultSet rs=st.executeQuery();
            rs.next();//leer el resultado
            ped=rs.getInt(1);
            // para grabar en el detalle
            sql="{call spDetalle(?,?,?)}";
            CallableStatement st2=cn.prepareCall(sql);
            for (Detalle p:lista){
            st2.setInt(1,ped);
            st2.setInt(2,p.getId());
            st2.setInt(3,p.getCan());
            st2.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ped;
}
}
