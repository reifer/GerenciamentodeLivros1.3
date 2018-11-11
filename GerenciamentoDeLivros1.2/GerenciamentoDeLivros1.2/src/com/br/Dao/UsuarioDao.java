package com.br.Dao;


import java.util.List;

import com.br.Models.Usuario;

public interface UsuarioDao {
	public void adiciona(Usuario u) throws GenericDaoException;
	public void remover(String nome) throws GenericDaoException;
	public void salvar(Usuario u) throws GenericDaoException;
	public Usuario pesquisarPorId(int id) throws GenericDaoException;
	public List<Usuario> getAllUser() throws GenericDaoException;
}
