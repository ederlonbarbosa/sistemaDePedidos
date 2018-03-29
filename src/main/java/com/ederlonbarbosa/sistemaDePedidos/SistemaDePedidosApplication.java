package com.ederlonbarbosa.sistemaDePedidos;

import java.util.Arrays;
import java.util.Date;

import com.ederlonbarbosa.sistemaDePedidos.domain.*;
import com.ederlonbarbosa.sistemaDePedidos.domain.enums.StatusPagamento;
import com.ederlonbarbosa.sistemaDePedidos.domain.enums.TipoCliente;
import com.ederlonbarbosa.sistemaDePedidos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SistemaDePedidosApplication.class, args);
    }

    @Override
    public void run(String... args){

        // CATEGORIA E PRODUTO
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

        // ESTADO E CIDADE
        Estado minasGerais = new Estado("Minas Gerais");
        Estado saoPaulo = new Estado("São Paulo");

        Cidade uberlandia = new Cidade("Uberlandia", minasGerais);
        Cidade cidadeSaoPaulo = new Cidade("São Paulo", saoPaulo);
        Cidade campinas = new Cidade("Campinas", saoPaulo);

        minasGerais.getCidades().add(uberlandia);
        saoPaulo.getCidades().addAll(Arrays.asList(cidadeSaoPaulo, campinas));

        estadoRepository.saveAll(Arrays.asList(minasGerais, saoPaulo));
        cidadeRepository.saveAll(Arrays.asList(uberlandia, cidadeSaoPaulo, campinas));

        // CLIENTE E ENDERECO
        Cliente mariaSilva = new Cliente("Maria Silva", "maria@gmail.com", "123456789", TipoCliente.PESSOA_FISICA);

        mariaSilva.getTelefones().addAll(Arrays.asList("1234-5678", "2345-6789"));

        Endereco enderecoRuaDasFlores = new Endereco("Rua das Flores", "123", "Apto 231", "Flores Bonitas", "12334-234", mariaSilva, uberlandia);
        Endereco enderecoAvenidaMatos = new Endereco("Avenida Matos", "143", "Apto 121", "Centro", "53456-564", mariaSilva, cidadeSaoPaulo);

        mariaSilva.getEnderecos().addAll(Arrays.asList(enderecoRuaDasFlores, enderecoAvenidaMatos));

        clienteRepository.save(mariaSilva);
        enderecoRepository.saveAll(Arrays.asList(enderecoRuaDasFlores, enderecoAvenidaMatos));

        // PEDIDO E PAGAMENTO
        Pedido primeiroPedido = new Pedido(new Date(), mariaSilva, enderecoAvenidaMatos);
        Pedido segundoPedido = new Pedido(new Date(), mariaSilva, enderecoRuaDasFlores);

        Pagamento pagamentoComCartao = new PagamentoComCartao(StatusPagamento.QUITADO, primeiroPedido, 6);
        primeiroPedido.setPagamento(pagamentoComCartao);

        Pagamento pagamentoComBoleto = new PagamentoComBoleto(StatusPagamento.PENDENTE, segundoPedido, new Date(), new Date());
        segundoPedido.setPagamento(pagamentoComBoleto);

        mariaSilva.getPedidos().addAll(Arrays.asList(primeiroPedido, segundoPedido));

        pedidoRepository.saveAll(Arrays.asList(primeiroPedido, segundoPedido));
        pagamentoRepository.saveAll(Arrays.asList(pagamentoComBoleto, pagamentoComCartao));

        Pagamento p = new PagamentoComBoleto();

    }
}
