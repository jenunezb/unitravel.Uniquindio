package co.edu.uniquindio.unitravel.servicios;
import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdministradorHotelImpl implements  AdministradorHotelServicio{

    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private AdminHotelRepo adminHotelRepo;


    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception{
        Hotel buscado = obtenerHotel(hotel.getCodigo());
        if (buscado!=null){
            throw new Exception("El hotel ya está registrado");
        }
        return hotelRepo.save(hotel);
    }


    @Override
    public Hotel obtenerHotel(Integer codigo){
        return hotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public AdminHotel obtenerAdminhotel(String codigo) throws Exception {
        return adminHotelRepo.findById(codigo).orElse(null);
    }
}
