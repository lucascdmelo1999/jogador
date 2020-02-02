package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clube;

public interface ClubeDAO extends JpaRepository<Clube, Integer> {

}
