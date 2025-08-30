package com.pcs.cadastro_servicos.controller;

import com.pcs.cadastro_servicos.business.ServicoService;
import com.pcs.cadastro_servicos.infrastructure.entitys.Servico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // para dizer que é um padrão rest
@RequestMapping("/servico")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping // para gravar dados
    public ResponseEntity<Void> salvarServico(@RequestBody Servico servico) {
        servicoService.salvarServico(servico);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Servico> buscarServicoPorProtocolo(@RequestParam String protocolo) {
        return ResponseEntity.ok(servicoService.buscarServicoPorProtocolo(protocolo));
    }


    @DeleteMapping
    public ResponseEntity<Void> deletarServicoPorProtocolo(@RequestParam String protocolo) {
        servicoService.deletarServicoPorProtocolo(protocolo);
        return ResponseEntity.ok().build();
    }

    @PutMapping //atualiza tudo
    public ResponseEntity<Void> atualizarServicoPorProtocolo(@RequestParam String protocolo, @RequestBody Servico servico){
        servicoService.atualizarServicoPorProtocolo(protocolo, servico);
        return ResponseEntity.ok().build();
    }
}