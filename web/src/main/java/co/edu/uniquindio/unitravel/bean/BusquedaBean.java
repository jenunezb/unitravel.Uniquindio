package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;

    @Autowired
    private UsuarioServicio usuarioServicio;

    // @Value("#{params['busqueda']} de BusquedaBean no me sirve
    private String busquedaParam;

    private List<Hotel> hoteles;
    @PostConstruct
    public void inicializar(){
        if(busquedaParam!=null && !busquedaParam.isEmpty()){
            hoteles=usuarioServicio.buscarHotelesNombre(busquedaParam);
        }else{
            hoteles=new ArrayList<>();
        }

    }
    public String buscar() {
        return "resultados_busqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }
}
