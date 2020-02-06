package com.example.demo.service;


import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.JogadorDAO;
import com.example.demo.model.Jogador;

@Service
public class JogadorService {

	@Autowired
	private JogadorDAO jogadorDAO;
	
	public List<Jogador>listarTodos(Sort ordenacao) {
		return this.jogadorDAO.findAll(ordenacao);
	}
	
	public Jogador obterPorId(Integer id) {
		return this.jogadorDAO.getOne(id);
	}
	
	public Jogador findJogadorByNome(String nome) {
		return jogadorDAO.findByNomeIgnoreCase(nome);
	}
	
	public Jogador findJogadorByApelido(String apelido) {
		return jogadorDAO.findByApelidoIgnoreCase(apelido);
	}
	
	public void save(Jogador jogador) {
		this.jogadorDAO.save(jogador);
	}
	
	public boolean salvarJogador(Jogador jogador)throws ServiceException, MessagingException {
		
		// Verificar a existencia de um participante com o cpf
		
		if (this.findJogadorByNome(jogador.getNome()) != null) {
			throw new ServiceException("Já existe um jogador com este nome");
		} 
		else if (this.findJogadorByApelido(jogador.getApelido()) != null) {
			throw new ServiceException("Já existe um jogador com este apelido");
		}  //else {
			
				//String senhaCriptografada;
				//try {
					//senhaCriptografada = Util.criptografarSenha(jogador.getSenha());
				//jogador.setSenha(senhaCriptografada);
				//	this.jogadorDAO.save(jogador);	
			//	} catch (Exception e) {
					// TODO: handle exception
				//}
				this.save(jogador);
				return true;
	       
		}	
		 
	
	public void remover(Integer id) {
		this.jogadorDAO.deleteById(id);
	}
}
