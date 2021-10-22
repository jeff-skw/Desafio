package com.challenge.develcode.business.impl;

import com.challenge.develcode.business.PessoaService;
import com.challenge.develcode.business.exception.NotFoundException;
import com.challenge.develcode.business.repository.PessoasRepository;
import com.challenge.develcode.model.persistence.Pessoa;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoasRepository pessoasRepository;

    @Override
    public List<Pessoa> getPessoas() {
        return pessoasRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Pessoa getPessoa(Long idPessoas) {
        Optional<Pessoa> pessoa = pessoasRepository.findById(idPessoas);
        if (pessoa.isPresent())
            return pessoa.get();
        throw new NotFoundException();
    }

    @Override
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoasRepository.save(pessoa);
    }

    @SneakyThrows
    @Override
    public void excluirPessoa(Long idPessoa) {
        Optional<Pessoa> pessoa = pessoasRepository.findById(idPessoa);
        if (pessoa.isEmpty())
            throw new NotFoundException();
        pessoasRepository.deleteById(idPessoa);
    }

}
