package co.edu.uniquindio.unitravel.entidades;

import lombok.NonNull;

import java.util.Map;

public class Cliente extends Persona{

    public Cliente(@NonNull Ciudad ciudad, String cedula, String nombre, String email, Map<String, String> telefono) {
        super(ciudad, cedula, nombre, email, telefono);

    }
}