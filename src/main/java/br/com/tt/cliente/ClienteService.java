package br.com.tt.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ClienteService {
	
	List<Cliente> consulta(){
		List<Cliente> clientes = new ArrayList<>();

		clientes.add(new Cliente(1L, "Carlos", "032", new Date()));
		clientes.add(new Cliente(2L, "Jose", "033", new Date()));
		clientes.add(new Cliente(3L, "Maria", "034", new Date()));
		clientes.add(new Cliente(4L, "Joao", "035", new Date()));
		
		return clientes;
		
	}

}
