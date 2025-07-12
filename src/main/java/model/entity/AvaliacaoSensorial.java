package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_sensoriais")
public class AvaliacaoSensorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal pontuacaoGeral;
    private String notasAromaticas;
    private String acidez;
    private String corpo;

    public AvaliacaoSensorial() {
    }

    public AvaliacaoSensorial(Integer id) {
        this.id = id;
        this.pontuacaoGeral = BigDecimal.ZERO;
        this.notasAromaticas = "";
        this.acidez = "";
        this.corpo = "";
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(BigDecimal pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public String getNotasAromaticas() {
        return notasAromaticas;
    }

    public void setNotasAromaticas(String notasAromaticas) {
        this.notasAromaticas = notasAromaticas;
    }

    public String getAcidez() {
        return acidez;
    }

    public void setAcidez(String acidez) {
        this.acidez = acidez;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}