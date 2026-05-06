package com.example.ComercioAPP.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ComercioAPP.modelos.Usuario;
import com.example.ComercioAPP.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired //Inyectar la dependencia a quien al repositorio
    private IUsuarioRepositorio repositorio;


    //OBJETIVO: activar mediante funciones las consultas
    //que quiero ofrecer en mi tabla Usuario

    //llevar/Guardar/Registrar/Ingresar (POST)
    public Usuario guardar_usuario(Usuario datosUsuario){
        
        Usuario resultadoTransaccion=repositorio.save(datosUsuario);
        return resultadoTransaccion;

    }

    //traer/leer/buscar/obtener (GET)

    //buscar todos los registro de la tabla
    public List<Usuario> listar_usuarios(){
        List<Usuario> resultadoTransaccion=repositorio.findAll();
        return resultadoTransaccion;
    }

    //buscar 1 usuario por ID
    public Usuario buscar_usuario_por_id(UUID id){
        Optional<Usuario> usuario_que_estoy_buscando_transaccion=repositorio.findById(id);
        if(usuario_que_estoy_buscando_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario que buscas no existe en BD"
            );
        }
        return usuario_que_estoy_buscando_transaccion.get();
    }



    //modificar/cambiar/actualizar (PUT)
    public Usuario modificar_Usuario(UUID id, Usuario datosUsuarioNuevos){
        Optional<Usuario>usuario_que_estoy_buscando_transaccion=repositorio.findById(id);
        if(usuario_que_estoy_buscando_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "EL usuario que quiere modificar no existe en BD"
            );
        }
        //Cambio los datos que me envieen
        //nombres y la contraseña
        Usuario usuario_encontrado_en_bd=usuario_que_estoy_buscando_transaccion.get();

        usuario_encontrado_en_bd.setNombres(datosUsuarioNuevos.getNombres());
        usuario_encontrado_en_bd.setContarseña(datosUsuarioNuevos.getContarseña());

        return repositorio.save(usuario_encontrado_en_bd);
    }

    //eliminar (DELETE)
    public boolean eliminar_usuario(UUID id){
        Optional<Usuario>usuario_que_estoy_buscando_transaccion=repositorio.findById(id);
        if(usuario_que_estoy_buscando_transaccion.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario que quiere elimianr no existe en BD"
            );
        }
        repositorio.deleteById(id);
        return true;
    }




}
