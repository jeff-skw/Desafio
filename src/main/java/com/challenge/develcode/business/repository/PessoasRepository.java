package com.challenge.develcode.business.repository;

import com.challenge.develcode.model.persistence.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoa, Long> {

}