package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer> {

}
