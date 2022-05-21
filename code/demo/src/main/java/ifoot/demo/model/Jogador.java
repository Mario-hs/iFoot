package ifoot.demo.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Jogador implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataNascimentoDate;

    private Integer cpf;

    private String emailJogador;

    private String senhaJogador;

    private Integer qtdAdvertencia;

    private String bairro;

    private Float carteira;

    @ManyToOne
    @JoinColumn(name = "Posicao-id")
    private Posicao posicao;
    
}
