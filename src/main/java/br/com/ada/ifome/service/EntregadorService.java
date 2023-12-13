package br.com.ada.ifome.service;

import br.com.ada.ifome.model.Entregador;
import br.com.ada.ifome.repository.EntregadorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntregadorService {

    @Autowired
    EntregadorRepository entregadorRepository;
    private final String BRASIL = "Brasil";
    private final String ARGENTINA = "Argentina";

    public Entregador save(Entregador entregador) {
        cpfIsValido(entregador.getCpf());
        rgIsValido(entregador.getRg());
        cnhIsValid(entregador.getCnh());
        modeloIsValid(entregador.getAnoModelo());
        placaIsValid(entregador.getPlaca(), entregador.getPais());
        renavamIsValid(entregador.getRenavam(), entregador.getAnoModelo());
        return entregadorRepository.save(entregador);
    }

    public boolean cpfIsValido(String cpf) {
        if (cpf.matches("\\d{11}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Quantidade de digitos do cpf Incorreto");
        }

    }

    public boolean rgIsValido(String rg) {
        if (rg.matches("\\d{7}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Quantidade de digitos do RG Incorreto");
        }

    }

    public boolean cnhIsValid(String cnh) {
        if (cnh.matches("\\d{11}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Quantidade de digitos do CNH Incorreto");
        }
    }

    public boolean modeloIsValid(int anoModelo) {
        if (anoModelo >= 2010) {
            return true;
        } else {
            throw new IllegalArgumentException("O modelo não pode operar");
        }
    }

    public boolean renavamIsValid(String renavam, int anoModelo) {
        if (anoModelo >= 2010 && anoModelo < 2013) {
            if (renavam.matches("\\d{9}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Qtd de digitos incorretos para o Renavam informado" +
                        "para o ano do seu modelo");
            }
        } else if (anoModelo >= 2013) {
            if (renavam.matches("\\d{11}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Qtd de digitos incorretos para o Renavam informado" +
                        "para o ano do seu modelo");
            }
        }
        return false;
    }

    public boolean placaIsValid(String placa, String pais) {
        if (pais.equals(BRASIL)) {
            if (placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Placa incorreta");
            }
        } else if (pais.equals(ARGENTINA)) {
            if (placa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Placa incorreta");
            }
        }
        return false;
    }

}
