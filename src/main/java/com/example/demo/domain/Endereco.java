package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private Cliente cliente;
    private Cidade cidade;

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }
}



