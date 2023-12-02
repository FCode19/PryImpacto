
package jsfServlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import model.*;
import controller.NegocioCli;
import controller.NegocioPed;
import controller.NegocioDet;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class control1 implements Serializable {
    List<Cliente> liscli;
    List<Pedido> lisped;
    List<Detalle> lisdet;
    String nombre;
    int facid;
    double total;
    @PostConstruct
    
    public void init(){
        liscli= new NegocioCli().LisCli();
    }
    
    public void consulta(Cliente a){
        nombre = a.getNombre();
        lisped = new ArrayList<>();
        lisped = new NegocioPed().lisPed(a.getId());
    }
    
    public void consulta2(Pedido a){
        facid = a.getId();
        lisdet = new ArrayList<>();
        lisdet = new NegocioDet().lisDet(a.getId());
        total = 0;
        for(Detalle x:lisdet) total +=x.total();
    }
    public control1() {
        nombre = "";
        facid = 0;
    }
    
    public List<Cliente> getLiscli() {
        return liscli;
    }

    public void setLiscli(List<Cliente> liscli) {
        this.liscli = liscli;
    }

    public List<Pedido> getLisped() {
        return lisped;
    }

    public void setLisped(List<Pedido> lisped) {
        this.lisped = lisped;
    }

    public List<Detalle> getLisdet() {
        return lisdet;
    }

    public void setLisdet(List<Detalle> lisdet) {
        this.lisdet = lisdet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFacid() {
        return facid;
    }

    public void setFacid(int facid) {
        this.facid = facid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
