package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.AvaliacaoSensorial;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.AvaliacaoSensorialRepository;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.LoteDeCafeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class AvaliacaoSensorialController {

    @Autowired
    private AvaliacaoSensorialRepository avaliacaoRepository;
    @Autowired
    private LoteDeCafeRepository loteDeCafeRepository;

    @GetMapping("/avaliacoes")
    public String listar(Model model) {
        model.addAttribute("avaliacoes", avaliacaoRepository.findAll());
        return "avaliacoes/list";
    }

    @GetMapping("/avaliacoes/novo")
    public String novo(Model model) {
        model.addAttribute("avaliacao", new AvaliacaoSensorial());
        model.addAttribute("lotes", loteDeCafeRepository.findAll());
        return "avaliacoes/form";
    }

    @PostMapping("/avaliacoes/salvar")
    public String salvar(@Valid @ModelAttribute("avaliacao") AvaliacaoSensorial avaliacao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lotes", loteDeCafeRepository.findAll());
            return "avaliacoes/form";
        }
        avaliacaoRepository.save(avaliacao);
        return "redirect:/avaliacoes";
    }

    @GetMapping("/avaliacoes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<AvaliacaoSensorial> avaliacaoOpt = avaliacaoRepository.findById(id);
        if (avaliacaoOpt.isEmpty()) {
            throw new IllegalArgumentException("Avaliação inválida.");
        }
        model.addAttribute("avaliacao", avaliacaoOpt.get());
        model.addAttribute("lotes", loteDeCafeRepository.findAll());
        return "avaliacoes/form";
    }

    @GetMapping("/avaliacoes/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Avaliação inválida.");
        }
        avaliacaoRepository.deleteById(id);
        return "redirect:/avaliacoes";
    }
}