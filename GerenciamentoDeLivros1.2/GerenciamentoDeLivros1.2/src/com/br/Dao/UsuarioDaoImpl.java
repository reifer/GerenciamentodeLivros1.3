package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con = null;

	public UsuarioDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Usuario u) throws GenericDaoException {
		String sql = "INSERT INTO usuario ()" + "VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getTipo());
			stmt.setString(5, u.getTelefone());
			stmt.executeUpdate();
			// System.out.println(u.getNome());
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Usuario pesquisarPorId(int id) throws GenericDaoException {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setTelefone(rs.getString("telefone"));
				u.setTipo(rs.getString("tipo"));
				// System.out.println(rs.getString("id"));

			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return u;
	}
	//HEITOR PODE FAZER ISSO AQUI
	@Override
	public List<Usuario> getAllUser() throws GenericDaoException {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM usuario";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				//u.setId(rs.getString("id"));
				//u.setEmail(rs.getString("email"));
				//u.setTelefone(rs.getString("telefone"));
				//u.setTipo(rs.getString("tipo"));
				// System.out.println(rs.getString("id"));
				lista.add(u);

			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		//System.out.println(lista);
		return lista;
	}

	@Override
	public void salvar(Usuario u) throws GenericDaoException {
		String sql = "UPDATE usuario SET nome = ?, email = ?, telefone = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getTelefone());
			stmt.setInt(4, u.getId());
			// stmt.setBoolean(5, u.getTipo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void remover(String nome) throws GenericDaoException {
		String sql = "DELETE FROM usuario WHERE nome = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}
}