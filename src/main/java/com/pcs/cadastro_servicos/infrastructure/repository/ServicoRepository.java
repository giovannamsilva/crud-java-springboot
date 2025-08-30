package com.pcs.cadastro_servicos.infrastructure.repository;

import com.pcs.cadastro_servicos.infrastructure.entitys.Servico;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


// interface que extende JPA porque ja tem métodos prontos (como salvar, deletar...)


public interface ServicoRepository extends JpaRepository<Servico, Integer> { // <nome da tabela, tipo do campo>

    Optional<Servico> findByProtocolo(String protocolo); // serve para procurar um objeto Servico no
                                                        // banco de dados pelo seu protocolo

    @Transactional //caso dê algum erro, ele não pode deletar esse serviço
    void deleteByProtocolo(String protocolo); // serve para deletar um serviço

}
