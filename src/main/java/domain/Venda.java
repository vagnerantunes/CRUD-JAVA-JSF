package domain;

import java.math.BigDecimal;
import java.time.LocalTime;

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
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(nullable = false)
	private LocalTime horario;
	
	@Column(nullable = false)
	private Integer quantidadeTotal;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;		
}