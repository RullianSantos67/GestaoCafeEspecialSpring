package controller;

import model.entity.Fazenda;
import model.repository.FazendaRepository;
import model.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FazendaController {

    @Autowired
    private FazendaRepository fazendaRepository;
    
    @Autowired
    private ProdutorRepository produtorRepository; // Necessário para o formulário

    /**
     * Mapeia a URL "/fazendas", busca todas as fazendas e as envia para a página de listagem.
     */
    @GetMapping("/fazendas")
    public String listarFazendas(Model model) {
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "fazendas/list.html";
    }

    /**
     * Mapeia a URL "/fazendas/form", exibe o formulário e envia a lista de produtores
     * para preencher o campo de seleção (dropdown).
     */
    @GetMapping("/fazendas/form")
    public String exibirFormularioFazenda(@ModelAttribute("fazenda") Fazenda fazenda, Model model) {
        model.addAttribute("produtores", produtorRepository.findAll());
        return "fazendas/form.html";
    }
}