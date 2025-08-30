package com.pcs.cadastro_servicos.infrastructure.entitys;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter //obter informações
@AllArgsConstructor
@NoArgsConstructor //construtores para acessar a classe
@Builder // usado para fazer update
@Table(name = "servico") // para indicar que é uma tabela
@Entity

// Tabela que sera salva no banco de dados

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // gera id automaticamente
    private Integer id;

    // colunas da tabela
    
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "protocolo", unique = true)
    private String protocolo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpfCliente", unique = true)
    private String cpfCliente;

    @Column(name = "telefone", unique = true)
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valorTotal")
    private Double valorTotal;
}
