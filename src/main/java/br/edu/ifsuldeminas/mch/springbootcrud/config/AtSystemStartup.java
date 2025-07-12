package br.edu.ifsuldeminas.mch.springbootcrud.config;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.*;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class AtSystemStartup implements CommandLineRunner {

    @Autowired
    private ProdutorRepository produtorRepository;
    @Autowired
    private FazendaRepository fazendaRepository;
    @Autowired
    private LoteDeCafeRepository loteDeCafeRepository;
    @Autowired
    private AvaliacaoSensorialRepository avaliacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco já tem dados para não inserir novamente
        if (produtorRepository.count() == 0) {
            System.out.println("Populando banco de dados com dados iniciais...");

            // Criando Produtor
            Produtor produtor1 = new Produtor();
            produtor1.setNomeCompleto("João da Silva");
            produtor1.setCpf("11122233344");
            produtor1.setRegiao("Sul de Minas");
            produtor1.setAnosDeExperiencia(20);
            produtorRepository.save(produtor1);

            // Criando Fazenda e associando ao Produtor
            Fazenda fazenda1 = new Fazenda();
            fazenda1.setNomeFazenda("Fazenda Esperança");
            fazenda1.setCidade("Muzambinho");
            fazenda1.setAltitude(1100);
            fazenda1.setProdutor(produtor1);
            fazendaRepository.save(fazenda1);

            // Criando Lote de Café e associando à Fazenda
            LoteDeCafe lote1 = new LoteDeCafe();
            lote1.setCodigoLote("LOTE-001-2025");
            lote1.setVariedade("Catuaí Vermelho");
            lote1.setProcessamento("Natural");
            lote1.setDataColheita(LocalDate.of(2025, 6, 15));
            lote1.setFazenda(fazenda1);
            loteDeCafeRepository.save(lote1);

            // Criando Avaliação e associando ao Lote
            AvaliacaoSensorial avaliacao1 = new AvaliacaoSensorial();
            avaliacao1.setPontuacaoGeral(new BigDecimal("87.5"));
            avaliacao1.setNotasAromaticas("Chocolate, caramelo e frutas amarelas");
            avaliacao1.setAcidez("Cítrica média");
            avaliacao1.setCorpo("Aveludado");
            avaliacao1.setLoteDeCafe(lote1);
            avaliacaoRepository.save(avaliacao1);
            
            System.out.println("Dados iniciais inseridos com sucesso!");
        }
    }
}