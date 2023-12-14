package br.com.ada.ifome.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntregadorServiceTest {

    @Autowired
    EntregadorService entregadorService;

    @Test
    void testandoCpf() {
        boolean cpf = entregadorService.cpfIsValido("12345678910");
        Assertions.assertTrue(cpf);
    }
    @Test
    void testandoCnh() {
        boolean cnh = entregadorService.cnhIsValid("12345678910");
        Assertions.assertTrue(cnh);
    }

    @Test
    void testandoRg() {
        boolean rg = entregadorService.rgIsValido("1234567");
        Assertions.assertTrue(rg);
    }

    @Test
    void testandoModelo(){
        boolean anoModelo = entregadorService.modeloIsValid(2010);
        Assertions.assertTrue(anoModelo);
    }

    @Test
    void testandoPlacaBrasileira(){
        boolean placa = entregadorService.placaIsValid("DXG8B70", "Brasil");
        Assertions.assertTrue(placa);
    }

    @Test
    void testandoPlacaArgentina(){
        boolean placa = entregadorService.placaIsValid("AB123CD", "Argentina");
        Assertions.assertTrue(placa);
    }

    @Test
    void testandoRenavamAntigo(){
        boolean renavam = entregadorService.renavamIsValid("123456789", 2010);
        Assertions.assertTrue(renavam);
    }

    @Test
    void testandoRenavamAtual(){
        boolean renavam = entregadorService.renavamIsValid("12345678910", 2013);
        Assertions.assertTrue(renavam);
    }
    @Test
    void testandoSantanderAtual(){
        boolean conta = entregadorService.validaConta("12345678-0", "1234","CC","Santander");
        Assertions.assertTrue(conta);
    }

    @Test
    void testandoCpfInvalido() {
        //entregadorService.cnhIsValido("12345678910");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> entregadorService.cpfIsValido("1234567891"));
    }
    @Test
    void testandoCnhInvalido() {
        //entregadorService.cnhIsValido("12345678910");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> entregadorService.cnhIsValid("1234567891"));
    }
    @Test
    void testandoRgInvalido() {
        //entregadorService.cnhIsValido("12345678910");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> entregadorService.rgIsValido("123456"));
    }
    @Test
    void testandoModeloInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.modeloIsValid(2009));
    }

    @Test
    void testandoPlacaInvalida1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.placaIsValid("AB123CD", "Brasil"));
    }

    @Test
    void testandoPlacaInvalida2(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.placaIsValid("DXG8B70", "Argentina"));
    }

    @Test
    void testandoRenavamInvalido1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.renavamIsValid("12345678910", 2010));
    }

    @Test
    void testandoRenavamInvalido2(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.renavamIsValid("123456789", 2013));
    }

    @Test
    void testandoContaSantanderInvalida(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> entregadorService.validaConta("12345678-01", "1234","CC","Santander"));
    }

}