package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "lotes_de_cafe")
public class LoteDeCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Código do lote é obrigatório")
    private String codigoLote;

    @NotBlank(message = "A variedade é obrigatória")
    private String variedade;

    @NotBlank(message = "O processamento é obrigatório")
    private String processamento;

    @NotNull(message = "A data da colheita é obrigatória")
    @PastOrPresent(message = "A data da colheita não pode ser no futuro")
    private LocalDate dataColheita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fazenda_id")
    @NotNull(message = "A fazenda é obrigatória")
    private Fazenda fazenda;

    @OneToOne(mappedBy = "loteDeCafe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private AvaliacaoSensorial avaliacao;

    // Construtor padrão
    public LoteDeCafe() {}

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigoLote() { return codigoLote; }
    public void setCodigoLote(String codigoLote) { this.codigoLote = codigoLote; }
    public String getVariedade() { return variedade; }
    public void setVariedade(String variedade) { this.variedade = variedade; }
    public String getProcessamento() { return processamento; }
    public void setProcessamento(String processamento) { this.processamento = processamento; }
    public LocalDate getDataColheita() { return dataColheita; }
    public void setDataColheita(LocalDate dataColheita) { this.dataColheita = dataColheita; }
    public Fazenda getFazenda() { return fazenda; }
    public void setFazenda(Fazenda fazenda) { this.fazenda = fazenda; }
    public AvaliacaoSensorial getAvaliacao() { return avaliacao; }
    public void setAvaliacao(AvaliacaoSensorial avaliacao) { this.avaliacao = avaliacao; }
}