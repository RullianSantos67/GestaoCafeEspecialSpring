package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "avaliacoes_sensoriais")
public class AvaliacaoSensorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A pontuação é obrigatória")
    @DecimalMin(value = "0.0", message = "A pontuação não pode ser menor que 0")
    @DecimalMax(value = "100.0", message = "A pontuação não pode ser maior que 100")
    private BigDecimal pontuacaoGeral;

    @NotBlank(message = "As notas aromáticas são obrigatórias")
    private String notasAromaticas;

    @NotBlank(message = "A acidez é obrigatória")
    private String acidez;

    @NotBlank(message = "O corpo é obrigatório")
    private String corpo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_de_cafe_id", unique = true) // Garante que a avaliação é única por lote
    @NotNull(message = "O lote de café é obrigatório")
    private LoteDeCafe loteDeCafe;

    // Construtor padrão
    public AvaliacaoSensorial() {}

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BigDecimal getPontuacaoGeral() { return pontuacaoGeral; }
    public void setPontuacaoGeral(BigDecimal pontuacaoGeral) { this.pontuacaoGeral = pontuacaoGeral; }
    public String getNotasAromaticas() { return notasAromaticas; }
    public void setNotasAromaticas(String notasAromaticas) { this.notasAromaticas = notasAromaticas; }
    public String getAcidez() { return acidez; }
    public void setAcidez(String acidez) { this.acidez = acidez; }
    public String getCorpo() { return corpo; }
    public void setCorpo(String corpo) { this.corpo = corpo; }
    public LoteDeCafe getLoteDeCafe() { return loteDeCafe; }
    public void setLoteDeCafe(LoteDeCafe loteDeCafe) { this.loteDeCafe = loteDeCafe; }
}