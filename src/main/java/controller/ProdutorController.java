package controller;

import model.entity.Produtor;
import model.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ProdutorController {

    @Autowired
    private ProdutorRepository produtorRepository;

    /**
     * Mapeia a URL "/produtores", busca todos os produtores e os envia para a página de listagem.
     */
    @GetMapping("/produtores")
    public String listarProdutores(Model model) {
        model.addAttribute("produtores", produtorRepository.findAll());
        return "produtores/list.html"; 
    }

    /**
     * Mapeia a URL "/produtores/form" e exibe o formulário de cadastro vazio.
     */
    @GetMapping("/produtores/form")
    public String exibirFormularioProdutor(@ModelAttribute("produtor") Produtor produtor) {
        return "produtores/form.html";
    }
}