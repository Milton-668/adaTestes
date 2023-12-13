package br.com.ada.ifome.controller;

import br.com.ada.ifome.model.Entregador;
import br.com.ada.ifome.service.EntregadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrega")
public class EntregadorController {


    EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody Entregador entregador ){
        return ResponseEntity.ok(entregadorService.save(entregador));
    }
}
