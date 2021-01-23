package domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Lote {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(nullable = false)
	private LocalDate dataDeFabricacao;
	
	@Column
	private LocalDate dataDeValidade;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
}
