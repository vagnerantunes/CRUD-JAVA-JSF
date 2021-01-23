package domain;

import java.math.BigDecimal;
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
public class Produto {

	// @generatevalue = auto incremento
	// @id = cria chave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	// cria colunas...
	// @Column(length = 50, nullable = false) = altera o tamanho e deixa obrigatorio
	@Column(length = 50, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer quantidade;
	
	/*nullable informa que o preco deve ser obrigatorio. precision diz quantos
	 numeros deve conter o preco. scale diz quantos numeros depois da virgula...
	  
	 */
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal preco;

	@Column
	private LocalDate dataDeValidade;
	
	/*chave estrangeira
	 * @onetoone
	 * @manytoone
	 * somente esses dois vamos usar no começo
	 * 
	 */
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
}