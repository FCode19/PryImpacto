
package jsfServlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import model.*;
import controller.Negocio;
import controller.NegocioProd;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class control2 implements Serializable {
    List<SelectItem> liscat;
    List<Producto> lisprod;
    List<Proveedores> prov;
    Categoria cat;
    String nombre;
    String nombre2;
    @PostConstruct
    
    public void init(){
        lisprod= new NegocioProd().LisProdTot();
        liscat= new ArrayList<>();
        for(Categoria x:new Negocio().LisCat()){
            SelectItem item = new SelectItem(x.getId(), x.getNombre());
            liscat.add(item);
        }

    }
    
    public void consulta(){
        nombre = cat.getNombre();
        lisprod = new ArrayList<>();
        lisprod = new NegocioProd().LisProd(cat.getId());
    }
    
    public void consulta2(Producto p){
        nombre2 = p.getNombre();
        prov = new ArrayList<>();
        Proveedores prove = new Negocio().consultaprov(p.getProveid());
        prov.add(prove);
        System.out.println(""+prov.get(0).getId());
    }
    public control2() {
        nombre = "";
        nombre2 = "";
        prov = new ArrayList<>();
        cat = new Categoria();
    }

    public List<SelectItem> getLiscat() {
        return liscat;
    }

    public void setLiscat(List<SelectItem> liscat) {
        this.liscat = liscat;
    }

    public List<Producto> getLisprod() {
        return lisprod;
    }

    public void setLisprod(List<Producto> lisprod) {
        this.lisprod = lisprod;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public List<Proveedores> getProv() {
        return prov;
    }

    public void setProv(List<Proveedores> prov) {
        this.prov = prov;
    }

    
}
