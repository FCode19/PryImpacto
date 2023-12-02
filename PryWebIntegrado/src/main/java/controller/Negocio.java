package controller;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.MySQLConexion;

public class Negocio {
    
    public List<Categoria> LisCat(){
    List<Categoria> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select categoria_id, nombre from categorias";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Categoria p=new Categoria();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public List<Proveedores> LisProve(){
    List<Proveedores> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select proveedor_id, nombre from proveedores";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Proveedores p=new Proveedores();
       p.setId(rs.getInt(1));
       p.setNombre(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public List<GStock> LisStock(){
    List<GStock> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="SELECT stock, nombre from productos ORDER BY stock asc";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       GStock p=new GStock();
       p.setStock(rs.getInt(1));
       p.setNombre(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public List<GPed> LisPedCli(){
    List<GPed> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select c.nombre, COUNT(*) as nropedidos FROM clientes c inner join pedidos p WHERE c.Cliente_id = p.Cliente_id GROUP BY c.Cliente_id ORDER BY nropedidos DESC";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       GPed p=new GPed();
       p.setNroped(rs.getInt(2));
       p.setNombre(rs.getString(1));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }
    
    public Proveedores consultaprov(int id){
        Connection cn=MySQLConexion.getConexion();
        Proveedores p=null;
        String sql="select Proveedor_id, nombre, email, direccion, telefono from proveedores where proveedor_id=?";
        try{
           PreparedStatement st=cn.prepareStatement(sql);
           st.setInt(1, id);
           //enlazar los atributos con  cada ?
          ResultSet rs=st.executeQuery();
           if(rs.next()){
              p=new Proveedores();
              p.setId(rs.getInt(1));
              p.setNombre(rs.getString(2));
              p.setEmail(rs.getString(3));
              p.setDirec(rs.getString(4));
              p.setTelef(rs.getString(5));
          }
         }catch(Exception ex){
            ex.printStackTrace();
        }
    return p;
    }
}
