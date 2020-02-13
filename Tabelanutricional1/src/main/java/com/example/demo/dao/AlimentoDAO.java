package com.example.demo.dao;

import org.hibernate.mapping.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Alimento;

public interface AlimentoDAO extends JpaRepository<Alimento, Integer> {
	
	List findByNomeContainingIgnoreCase(String nome, Sort sort);
	
	
	@Query("select c from Alimento c where c.nome = :nome")
	public Alimento findByNomeIgnoreCase(@Param("nome") String nome);
	
	@Query("select c from Alimento c where c.id = :id")
	public Alimento findByid(@Param("id") Integer id);
	
}
