package controller;

import model.entity.AvaliacaoSensorial;
import model.repository.AvaliacaoSensorialRepository;
import model.repository.LoteDeCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AvaliacaoSensorialController {

    @Autowired
    private AvaliacaoSensorialRepository avaliacaoRepository;

    @Autowired
    private LoteDeCafeRepository loteDeCafeRepository; // Necessário para o formulário

    /**
     * Mapeia a URL "/avaliacoes", busca todas as avaliações e as envia para a página de listagem.
     */
    @GetMapping("/avaliacoes")
    public String listarAvaliacoes(Model model) {
        model.addAttribute("avaliacoes", avaliacaoRepository.findAll());
        return "avaliacoes/list.html";
    }

    /**
     * Mapeia a URL "/avaliacoes/form", exibe o formulário e envia a lista de lotes de café
     * para preencher o campo de seleção (dropdown).
     */
    @GetMapping("/avaliacoes/form")
    public String exibirFormularioAvaliacao(@ModelAttribute("avaliacao") AvaliacaoSensorial avaliacao, Model model) {
        model.addAttribute("lotes", loteDeCafeRepository.findAll());
        return "avaliacoes/form.html";
    }
}