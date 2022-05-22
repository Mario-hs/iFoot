package les.ifoot.model;

import java.io.Serializable;

import javax.persistence.*;

// import les.ifoot.model.Espaco;
import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity

public class TransferenciaDinheiroEspaco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private Date dataTransferenciaEspaco;

	private Float valor;

	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;

}
