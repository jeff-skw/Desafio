package com.challenge.develcode.business;


import com.challenge.develcode.model.persistence.Pessoa;

import java.util.List;

public interface PessoaService {
    List<Pessoa> getPessoas();

    Pessoa getPessoa(Long id);

    Pessoa cadastrarPessoa(Pessoa pessoa);

    void excluirPessoa(Long id);
}