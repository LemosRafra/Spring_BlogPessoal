package com.blogpessoal.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O titulo é obrigatório!!")
	@Size(min = 5, max = 100, message = "O mínimo é de 5 caracteres e o máximo de 100 :/")
	@Column(name="titulo")
	private String titulo;
	
	@NotNull(message = "O titulo é obrigatório!!")
	@Size(min = 10, max = 1000, message = "O mínimo é de 10 caracteres e o máximo de 1000 :/")
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}


}
