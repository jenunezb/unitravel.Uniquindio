package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;

import java.util.List;

public interface UsuarioServicio {

        Usuario registrarUsuario(Usuario usuario) throws Exception;


        Usuario actualizarUsuario(Usuario usuario) throws Exception;

        Usuario obtenerUsuario(String cedula);

        void eliminarUsuario(String cedula) throws Exception;

        List<Usuario> listarUsuarios();

        List<Hotel> buscarHotelesNombre(String nombreHotel);

}
