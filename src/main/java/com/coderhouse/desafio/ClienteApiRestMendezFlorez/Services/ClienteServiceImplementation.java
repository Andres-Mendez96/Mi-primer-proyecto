package com.coderhouse.desafio.ClienteApiRestMendezFlorez.Services;

import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.Cliente;
import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models.ClienteEdad;
import com.coderhouse.desafio.ClienteApiRestMendezFlorez.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ClienteServiceImplementation implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepositorio;

    @Override
    public ClienteEdad buscarPorDni(Integer dni) {

        //Encuentro al cliente solicitado en base a su DNI
        Cliente recibirCliente = clienteRepositorio.findById(dni).orElse(null);

        //Creo una variable para almacenar el resultado del metedo que hice para hayar la edad del cliente
        Integer edadDelCliente = calcularEdad(recibirCliente);

        //Creo un objeto que represente el cliente que quiero mostrar y le paso la informacion requerida
        ClienteEdad clienteAMostrar = new ClienteEdad(recibirCliente.getDni(), recibirCliente.getNombre(),
                recibirCliente.getApellido(), edadDelCliente);

        return clienteAMostrar;

    }

    @Override
    public Integer calcularEdad(Cliente cliente) {

        // Formato de referencia para la fecha de nacimiento en dia/mes/anio
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Se ajusta el formato de la fecha de nacimiento del cliente al formato requerido anteriormente
        LocalDate fechaNacimiento = LocalDate.parse(cliente.getFechaNacimiento(), formatter);

        // Variable con la fecha actual para hacer la comparacion de fechas y calcular la edad
        LocalDate fechaActual = LocalDate.now();

        // Mecanismo para calcular la edad
        Integer edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if(fechaNacimiento.getDayOfYear() > fechaActual.getDayOfYear()){
            edad--;
        }


        return edad;
    }

    @Override
    public Cliente crear(Cliente cliente) throws Exception {
        if (buscarPorDni(cliente.getDni()) == null) {
            return clienteRepositorio.save(cliente);
        }
        else {
            throw new Exception( "Cliente ya existe");
        }
    }

    @Override
    public List<Cliente> buscarTodosLosClientes() {
        return clienteRepositorio.findAll();
    }


}






