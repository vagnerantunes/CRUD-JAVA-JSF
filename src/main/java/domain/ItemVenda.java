package domain;

import java.math.BigDecimal;

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
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(nullable = false)
	private Integer quantidadeParcial;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal valorParcial;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Lote lote;	
}
