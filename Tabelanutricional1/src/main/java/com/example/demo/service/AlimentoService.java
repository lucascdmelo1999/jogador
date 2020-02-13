package com.example.demo.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AlimentoDAO;
import com.example.demo.model.Alimento;

@Service
public class AlimentoService {

	@Autowired
	private AlimentoDAO alimentoDAO;

	public List<Alimento> listarTodos(Sort ordenacao) {
		return this.alimentoDAO.findAll(ordenacao);
	}

	public Alimento obterPorId(Integer id) {
		return this.alimentoDAO.getOne(id);
	}

	public Alimento findJogadorByNome(String nome) {
		return alimentoDAO.findByNomeIgnoreCase(nome);
	}

	public void save(Alimento alimento) {
		this.alimentoDAO.save(alimento);
	}
	
	public Alimento findByNome(String nome) {
		return alimentoDAO.findByNomeIgnoreCase(nome);
	}

	public boolean salvaralimento(Alimento alimento) throws ServiceException, MessagingException {

		if (this.findJogadorByNome(alimento.getNome()) != null) {
			throw new ServiceException("Já existe alimento com esse nome");
		}

		this.save(alimento);
		return true;

	}
	
	

	 public void remover(Integer id) {
	 this.alimentoDAO.deleteById(id);
	 }

}
