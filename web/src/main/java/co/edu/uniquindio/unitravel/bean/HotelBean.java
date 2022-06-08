package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@ViewScoped
public class HotelBean implements Serializable {
    @Getter @Setter
    private Hotel hotel;

    // @Value("#{upload.url}")
    private String urlImagenes;
    private ArrayList<Object> imagenes;

    @PostConstruct
    public void inicializari(){
        this.imagenes = new ArrayList<>();
    }
    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @PostConstruct
    public void inicializar(){
    hotel=new Hotel();
    }

    public void registrarHotel(){
        try{

            Ciudad ciudad=administradorHotelServicio.obtenerCiudad(5);
            hotel.setCiudad(ciudad);

            //Esto que voy a hacer está mal porque el codigo de las ciudades no es autoincrementable
            Integer codigo=3;

            hotel.setCodigo(codigo);

            AdminHotel admin=administradorHotelServicio.obtenerAdminhotel("111");
            hotel.setAdminHotel(admin);

            administradorHotelServicio.crearHotel(hotel);

            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        } catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
    }
}
