package com.coderhouse.desafio.ClienteApiRestMendezFlorez.Services;

import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.Cliente;
import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.ClienteEdad;

import java.util.List;

public interface ClienteService {

    ClienteEdad buscarPorDni (Integer dni);

    Integer calcularEdad (Cliente cliente);

    Cliente crear (Cliente cliente) throws Exception;

    List<Cliente> buscarTodosLosClientes ();
}
