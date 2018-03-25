package com.ederlonbarbosa.sistemaDePedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ederlonbarbosa.sistemaDePedidos.dml.PopulaDados;

@SpringBootApplication
public class SistemaDePedidosApplication  implements CommandLineRunner{

	@Autowired
	PopulaDados populaDados;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		populaDados.popularDados();
	}
}
