package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Livro;

public class LivroDaoImpl implements LivroDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con = null;

	public LivroDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e1) {
			// e1.printStackTrace();
			throw new GenericDaoException(e1);
		}
	}

	@Override
	public void adiciona(Livro l) throws GenericDaoException {
		String sql = "INSERT INTO livro ()" + "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, l.getNome());
			stmt.setString(3, l.getGenero());
			stmt.setString(4, l.getAutor());
			stmt.setString(5, l.getEditora());
			stmt.setBoolean(6, l.isStatus());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Livro pesquisarPorId(int id) throws GenericDaoException {
		Livro l = new Livro();
		String sql = "SELECT * FROM livro WHERE idlivro = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				l.setId(rs.getInt("idlivro"));
				l.setNome(rs.getString("nome"));
				l.setGenero(rs.getString("genero"));
				// System.out.println(rs.getString("genero"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return l;
	}

	@Override
	public List<Livro> pesquisarPorAutor(String autor) throws GenericDaoException {
		List<Livro> lista = new ArrayList<>();
		String sql = "SELECT * FROM livro WHERE autor like ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, "%" + autor + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Livro l = new Livro();
				l.setNome(rs.getString("nome"));
				// System.out.println(rs.getString("nome"));
				l.setGenero(rs.getString("genero"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				lista.add(l);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return lista;
	}

	@Override
	public void salvar(int id, Livro l) throws GenericDaoException {
		String sql = "UPDATE livro SET nome = ?, genero = ?, autor = ?, editora = ? " + "WHERE idlivro = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, l.getNome());
			stmt.setString(2, l.getGenero());
			stmt.setString(3, l.getAutor());
			stmt.setString(4, l.getEditora());
			stmt.setLong(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void remover(int id) throws GenericDaoException {
		String sql = "DELETE FROM livros WHERE idlivro = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}
}