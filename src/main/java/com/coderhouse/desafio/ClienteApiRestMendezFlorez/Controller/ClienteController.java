package com.coderhouse.desafio.ClienteApiRestMendezFlorez.Controller;

import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.Cliente;
import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.ClienteEdad;
import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("coderhouse/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteServicios;

    @GetMapping("/{dni}")
    public ClienteEdad buscarPorDni(@PathVariable Integer dni) {
        return clienteServicios.buscarPorDni(dni);
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) throws Exception {
        return clienteServicios.crear(cliente);
    }

    @GetMapping("")
    public List<Cliente> buscarTodosLosClientes(){
        return clienteServicios.buscarTodosLosClientes();
    }
}
