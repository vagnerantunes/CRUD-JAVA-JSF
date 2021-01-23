package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categoria {	
	//chave primaria e autoincremento
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;	
	
	@Column(length = 50, nullable = false)
	private String nome;
}
