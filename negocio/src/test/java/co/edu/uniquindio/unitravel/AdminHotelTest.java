package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminHotelTest {
    @Autowired
    private AdminHotelRepo adminHotelRepo;

    @Test
    public void registrarAdminHotel(){
        AdminHotel admin = new AdminHotel("2","pedro","admin4@unitravel.co",null,null,"123");
        AdminHotel adminHotelGuardado = adminHotelRepo.save(admin);

        Assertions.assertNotNull(adminHotelGuardado);
    }
}
