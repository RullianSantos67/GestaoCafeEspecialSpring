package model.repository;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {}