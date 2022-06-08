package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar(){
      // Hotel hotel =hotelRepo.findById("1").orElse(null);
        // System.out.println(hotel);

       List <Hotel> hoteles = hotelRepo.findAllByEstrellas(5);
        hoteles.forEach(System.out::println);
    }

    @Autowired
    private HotelRepo hotelRepo;

   /*   Para que funcione necesito ingresar la ciudad y el administrador de hotel
    @Test
    public void registrarHotel(){
        Hotel hotel = new Hotel("2","Hotel pacha","Cra 14"," 7484500",5, )
        Hotel guardado = hotelRepo.save(hotel);

        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    } */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorNombre(){
        List<Hotel> hoteles = hotelRepo.findByNombreContainsIgnoreCase("c");
        System.out.println(hoteles);
}
}
