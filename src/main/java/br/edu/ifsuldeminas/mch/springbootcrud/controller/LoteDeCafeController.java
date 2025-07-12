package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.LoteDeCafe;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.FazendaRepository;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.LoteDeCafeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class LoteDeCafeController {

    @Autowired
    private LoteDeCafeRepository loteDeCafeRepository;
    @Autowired
    private FazendaRepository fazendaRepository;

    @GetMapping("/lotes")
    public String listar(Model model) {
        model.addAttribute("lotes", loteDeCafeRepository.findAll());
        return "lotes/list";
    }

    @GetMapping("/lotes/novo")
    public String novo(Model model) {
        model.addAttribute("lote", new LoteDeCafe());
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "lotes/form";
    }

    @PostMapping("/lotes/salvar")
    public String salvar(@Valid @ModelAttribute("lote") LoteDeCafe lote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("fazendas", fazendaRepository.findAll());
            return "lotes/form";
        }
        loteDeCafeRepository.save(lote);
        return "redirect:/lotes";
    }

    @GetMapping("/lotes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<LoteDeCafe> loteOpt = loteDeCafeRepository.findById(id);
        if (loteOpt.isEmpty()) {
            throw new IllegalArgumentException("Lote de Café inválido.");
        }
        model.addAttribute("lote", loteOpt.get());
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "lotes/form";
    }

    @GetMapping("/lotes/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        if (!loteDeCafeRepository.existsById(id)) {
            throw new IllegalArgumentException("Lote de Café inválido.");
        }
        loteDeCafeRepository.deleteById(id);
        return "redirect:/lotes";
    }
}