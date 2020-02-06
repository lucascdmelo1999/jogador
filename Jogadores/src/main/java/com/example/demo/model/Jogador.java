package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jogador {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String nome;
	@NotBlank
	private String apelido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datadenasc;
	@NotBlank
	private String naturalidade;
	@NotBlank
	private String nacionalidade;
	
	
	


	@ManyToOne
	private Clube clube;

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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDatadenasc() {
		return datadenasc;
	}

	public void setDatadenasc(Date datadenasc) {
		this.datadenasc = datadenasc;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	
}


