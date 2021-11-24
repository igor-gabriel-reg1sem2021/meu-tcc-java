package modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuarios")
public class Encontro {
	@Id
	private Integer id;
	private Integer latitude;
	private Integer longitude;
	private String nome;

}