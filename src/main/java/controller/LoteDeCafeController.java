package controller;

import model.entity.LoteDeCafe;
import model.repository.FazendaRepository;
import model.repository.LoteDeCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoteDeCafeController {

    @Autowired
    private LoteDeCafeRepository loteDeCafeRepository;

    @Autowired
    private FazendaRepository fazendaRepository; // Necessário para o formulário

    /**
     * Mapeia a URL "/lotes", busca todos os lotes e os envia para a página de listagem.
     */
    @GetMapping("/lotes")
    public String listarLotes(Model model) {
        model.addAttribute("lotes", loteDeCafeRepository.findAll());
        return "lotes/list.html";
    }

    /**
     * Mapeia a URL "/lotes/form", exibe o formulário e envia a lista de fazendas
     * para preencher o campo de seleção (dropdown).
     */
    @GetMapping("/lotes/form")
    public String exibirFormularioLote(@ModelAttribute("lote") LoteDeCafe lote, Model model) {
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "lotes/form.html";
    }
}