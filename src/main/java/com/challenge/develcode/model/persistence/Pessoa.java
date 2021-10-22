package com.challenge.develcode.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pessoas")
@Where(clause = "deletado=false")
@SQLDelete(sql = "UPDATE pessoas SET deletado = true WHERE codigo=?")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "codigo")
    private Long codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_de_nascimento")
    private Date dataDeNascimento;

    @Column(name = "foto")
    private String foto;

    @Column
    @JsonIgnore
    private Boolean deletado = false;

}