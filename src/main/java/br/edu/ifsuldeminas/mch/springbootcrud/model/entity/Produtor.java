package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtores") // Definindo o nome da tabela
public class Produtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @NotBlank(message = "A região é obrigatória")
    private String regiao;

    @NotNull(message = "Anos de experiência são obrigatórios")
    @Min(value = 0, message = "Anos de experiência não podem ser negativos")
    private Integer anosDeExperiencia;

    @OneToMany(mappedBy = "produtor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fazenda> fazendas = new ArrayList<>();

    // Construtor padrão
    public Produtor() {}

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getRegiao() { return regiao; }
    public void setRegiao(String regiao) { this.regiao = regiao; }
    public Integer getAnosDeExperiencia() { return anosDeExperiencia; }
    public void setAnosDeExperiencia(Integer anosDeExperiencia) { this.anosDeExperiencia = anosDeExperiencia; }
    public List<Fazenda> getFazendas() { return fazendas; }
    public void setFazendas(List<Fazenda> fazendas) { this.fazendas = fazendas; }
}