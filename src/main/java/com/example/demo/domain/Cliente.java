package com.example.demo.domain;

import com.example.demo.domain.enums.TipoCliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String cpfCnpj;
    private Integer tipo;

    private List<Endereco> enderecos = new ArrayList<>();

    private Set<String> telefones  = new HashSet<>();

    public Cliente(Integer id, String nome, String email, String cpfCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo.getCod();
    }

    public TipoCliente getTipo(){
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo){
        this.tipo = tipo.getCod();
    }
}
