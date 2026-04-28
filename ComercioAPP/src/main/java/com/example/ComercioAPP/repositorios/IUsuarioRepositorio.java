package com.example.ComercioAPP.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ComercioAPP.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,UUID>{

    //Personalizando busquedas en la tabla USUARIO


    //Buscando por nombres
    List<Usuario>findByNombres(String nombres);

    //Buscando por Correo
    Optional<Usuario>findByCorreo(String correo);

}
