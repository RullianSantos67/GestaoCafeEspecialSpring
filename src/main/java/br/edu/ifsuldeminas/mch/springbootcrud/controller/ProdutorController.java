package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Produtor;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.ProdutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class ProdutorController {

    @Autowired
    private ProdutorRepository produtorRepository;

    @GetMapping("/produtores")
    public String listar(Model model) {
        model.addAttribute("produtores", produtorRepository.findAll());
        return "produtores/list";
    }

    /**
     * ESTE É O MÉTODO QUE ESTAVA FALTANDO.
     * Ele é mapeado para a rota /produtores/novo e retorna a página do formulário.
     */
    @GetMapping("/produtores/novo")
    public String novo(@ModelAttribute("produtor") Produtor produtor) {
        return "produtores/form";
    }

    @PostMapping("/produtores/salvar")
    public String salvar(@Valid @ModelAttribute("produtor") Produtor produtor, BindingResult result) {
        if (result.hasErrors()) {
            return "produtores/form";
        }
        produtorRepository.save(produtor);
        return "redirect:/produtores";
    }

    @GetMapping("/produtores/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Optional<Produtor> produtorOpt = produtorRepository.findById(id);
        if (produtorOpt.isEmpty()) {
            throw new IllegalArgumentException("Produtor inválido.");
        }
        model.addAttribute("produtor", produtorOpt.get());
        return "produtores/form";
    }

    @GetMapping("/produtores/delete/{id}")
    public String deletar(@PathVariable("id") Long id) {
        if (!produtorRepository.existsById(id)) {
            throw new IllegalArgumentException("Produtor inválido.");
        }
        produtorRepository.deleteById(id);
        return "redirect:/produtores";
    }
}