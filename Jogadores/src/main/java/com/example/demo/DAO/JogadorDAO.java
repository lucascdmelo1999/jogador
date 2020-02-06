package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer> {

	@Query("select c from Jogador c where c.nome = :nome")
	public Jogador findByNomeIgnoreCase(String nome);

	@Query("select c from Jogador c where c.apelido = :apelido")
	public Jogador findByApelidoIgnoreCase(String apelido);

}
