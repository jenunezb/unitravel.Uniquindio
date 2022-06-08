package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
       Usuario buscado = obtenerUsuario(usuario.getCedula());
       if (buscado!=null){
           throw new Exception("El código del usuario ya está registrado");
           
        }
       Usuario usuarioEmail=obtenerUsuario(usuario.getEmail());

        //Falta hacer el proceso con el correo electrónico segun el video 11 de Servicios
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Usuario buscado = obtenerUsuario(usuario.getCedula());
        if(usuario==null){
            throw new Exception("El usuario no existe");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String cedula){
        return usuarioRepo.findById(cedula).orElse(null);
    }

    @Override
    public void eliminarUsuario(String cedula)  throws Exception{
    Usuario usuario = obtenerUsuario(cedula);

    if(usuario==null){
        throw new Exception("El usuario no existe");
    }
    usuarioRepo.delete(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

}
