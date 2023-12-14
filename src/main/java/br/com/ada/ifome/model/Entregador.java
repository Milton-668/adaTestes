package br.com.ada.ifome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_entregador")
public class Entregador {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String cnh;
    private int anoModelo;
    private String pais;
    private String placa;
    private String renavam;
    @Transient
    private Conta conta;

}