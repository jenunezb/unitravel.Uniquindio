package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

public interface AdministradorHotelServicio {

    Hotel crearHotel(Hotel hotel) throws Exception;

    Hotel obtenerHotel(Integer codigo)throws Exception;

    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    AdminHotel obtenerAdminhotel(String codigo)throws Exception;

}
