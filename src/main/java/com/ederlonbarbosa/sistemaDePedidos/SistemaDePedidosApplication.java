package com.ederlonbarbosa.sistemaDePedidos;

import java.util.Arrays;

import com.ederlonbarbosa.sistemaDePedidos.domain.Cidade;
import com.ederlonbarbosa.sistemaDePedidos.domain.Estado;
import com.ederlonbarbosa.sistemaDePedidos.repositories.CidadeRepository;
import com.ederlonbarbosa.sistemaDePedidos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ederlonbarbosa.sistemaDePedidos.domain.Categoria;
import com.ederlonbarbosa.sistemaDePedidos.domain.Produto;
import com.ederlonbarbosa.sistemaDePedidos.repositories.CategoriaRepository;
import com.ederlonbarbosa.sistemaDePedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SistemaDePedidosApplication.class, args);
    }

    @Override
    public void run(String... args){
        Categoria informatica = new Categoria("Informática");
        Categoria escritorio = new Categoria("Escritório");

        Produto computador = new Produto("Computador", 2000.00);
        Produto impressora = new Produto("Impressora", 800.00);
        Produto mouse = new Produto("Mouse", 80.00);

        informatica.getProdutos().addAll(Arrays.asList(computador, impressora, mouse));
        escritorio.getProdutos().add(impressora);

        computador.getCategorias().add(informatica);
        mouse.getCategorias().add(informatica);
        impressora.getCategorias().addAll(Arrays.asList(informatica, escritorio));

        categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
        produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));

        Estado minasGerais = new Estado("Minas Gerais");
        Estado saoPaulo = new Estado("São Paulo");

        Cidade uberlandia = new Cidade("Uberlandia", minasGerais);
        Cidade cidadeSaoPaulo = new Cidade("São Paulo", saoPaulo);
        Cidade campinas = new Cidade("Campinas", saoPaulo);

        minasGerais.getCidades().add(uberlandia);
        saoPaulo.getCidades().addAll(Arrays.asList(cidadeSaoPaulo, campinas));

        estadoRepository.saveAll(Arrays.asList(minasGerais, saoPaulo));
        cidadeRepository.saveAll(Arrays.asList(uberlandia, cidadeSaoPaulo, campinas));
    }
}
