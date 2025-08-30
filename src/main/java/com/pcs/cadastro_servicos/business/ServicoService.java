package com.pcs.cadastro_servicos.business;

import com.pcs.cadastro_servicos.infrastructure.entitys.Servico;
import com.pcs.cadastro_servicos.infrastructure.repository.ServicoRepository;

import org.springframework.stereotype.Service;

// forma de construtor na mão

@Service // para indicar pro spring que esta é a classe de serviço
public class ServicoService {
    
    private final ServicoRepository repository;  

    public ServicoService(ServicoRepository repository){
        this.repository = repository;
    }

    // método de salvar serviços; não retorna nada
    public void salvarServico(Servico servico){   
        repository.saveAndFlush(servico);   // salva o serviço e fecha a conexão com banco de dados
    }

    // método de buscar o serviço por protocolo, tem um retorno e o retorno é o serviço
    public Servico buscarServicoPorProtocolo(String protocolo){
        return repository.findByProtocolo(protocolo).orElseThrow(
            () -> new RuntimeException ("Protocolo não encontrado")
        );
    }

    //método que deleta serviço por protocolo
    public void deletarServicoPorProtocolo(String protocolo){
        repository.deleteByProtocolo(protocolo);
    }

    // método para atualizar só o protocolo 
    public void atualizarServicoPorProtocolo(String protocolo, Servico servico){
        Servico servicoEntity = buscarServicoPorProtocolo(protocolo); // verifica se o serviço existe
        Servico servicoAtualizado = Servico.builder()

        .protocolo(protocolo)

        .email(servico.getEmail() != null ? 
        servico.getEmail() : servicoEntity.getEmail())

        .nome(servico.getNome() != null ? 
        servico.getNome() : servicoEntity.getNome())

        .cpfCliente(servico.getCpfCliente() != null ? 
        servico.getCpfCliente() : servicoEntity.getCpfCliente())
        
        .telefone(servico.getTelefone() != null ? 
        servico.getTelefone() : servicoEntity.getTelefone())

        .endereco(servico.getEndereco() != null ? 
        servico.getEndereco() : servicoEntity.getEndereco())

        .descricao(servico.getDescricao() != null ? 
        servico.getDescricao() : servicoEntity.getDescricao())

        .valorTotal(servico.getValorTotal() != null ? 
        servico.getValorTotal() : servicoEntity.getValorTotal())

        .id(servicoEntity.getId())


        .build();

        repository.saveAndFlush(servicoAtualizado);
    }
}

 