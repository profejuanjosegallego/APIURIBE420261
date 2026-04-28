package com.example.ComercioAPP.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ComercioAPP.modelos.Pedido;

@Repository
public interface IPedidoRepositorio extends JpaRepository <Pedido, UUID>{

}
