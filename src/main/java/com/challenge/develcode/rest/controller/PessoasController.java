package com.challenge.develcode.rest.controller;

import com.challenge.develcode.business.PessoaService;
import com.challenge.develcode.model.persistence.Pessoa;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
@Slf4j
public class PessoasController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Validated Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.cadastrarPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.ok(pessoaService.getPessoas());
    }

    @SneakyThrows
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.getPessoa(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
