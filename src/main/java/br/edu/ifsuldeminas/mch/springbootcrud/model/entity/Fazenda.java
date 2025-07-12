package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fazendas")
public class Fazenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da fazenda é obrigatório")
    private String nomeFazenda;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotNull(message = "A altitude é obrigatória")
    @Positive(message = "A altitude deve ser um número positivo")
    private Integer altitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtor_id")
    @NotNull(message = "O produtor é obrigatório")
    private Produtor produtor;

    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoteDeCafe> lotes = new ArrayList<>();

    // Construtor padrão
    public Fazenda() {}

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeFazenda() { return nomeFazenda; }
    public void setNomeFazenda(String nomeFazenda) { this.nomeFazenda = nomeFazenda; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public Integer getAltitude() { return altitude; }
    public void setAltitude(Integer altitude) { this.altitude = altitude; }
    public Produtor getProdutor() { return produtor; }
    public void setProdutor(Produtor produtor) { this.produtor = produtor; }
    public List<LoteDeCafe> getLotes() { return lotes; }
    public void setLotes(List<LoteDeCafe> lotes) { this.lotes = lotes; }
}