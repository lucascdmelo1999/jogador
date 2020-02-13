package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Alimento {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String nome;
	@NotBlank
	private String calorias;
	@NotBlank
	private String carboidratos;
	@NotBlank
	private String sodio;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCalorias() {
		return calorias;
	}
	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
	public String getCarboidratos() {
		return carboidratos;
	}
	public void setCarboidratos(String carboidratos) {
		this.carboidratos = carboidratos;
	}
	public String getSodio() {
		return sodio;
	}
	public void setSodio(String sodio) {
		this.sodio = sodio;
	}
	
	
	

	
}
