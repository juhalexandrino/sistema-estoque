package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.util.ConnectionFactory;

public class ProdutoDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private Produto produto;

	// Inserir Produto
	public void salvar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try {
			String SQL = "INSERT INTO tb_produto(codigo, descricao, nome, quantidade) values (?, ?, ?, ?)";
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, produto.getCodigo());
			ps.setString(2, produto.getDescricao());
			ps.setString(3, produto.getNome());
			ps.setInt(4, produto.getQuantidade());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		}
	}

	// Atualizar Produto
	public void atualizar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try {
			String SQL = "UPDATE tb_produto set descricao=?, quantidade=?, nome=? WHERE codigo=?";
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(SQL);
			ps.setString(1, produto.getDescricao());
			ps.setInt(2, produto.getQuantidade());
			ps.setString(3, produto.getNome());
			ps.setInt(4, produto.getCodigo());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao atualizar dados " + sqle);
		}
	}

	// Excluir Produto
	public void excluir(Produto produto) throws Exception {
	if (produto == null) throw new Exception ("O valor passado não pode ser nulo.");
		try {
			String SQL = "DELETE FROM tb_produto WHERE codigo = ?";
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, produto.getCodigo());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		}
	}

	// Procurar Produto
	public Produto procurarProduto(int cod) throws Exception {

		try {
			String SQL = "SELECT * FROM tb_produto WHERE codigo=?";
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(SQL);
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				int quantidade = rs.getInt(2);
				String nome = rs.getString(3);
				String descricao = rs.getString(4);
				produto = new Produto(codigo, quantidade, descricao, nome);
			}
			return produto;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}

	}

	// Listar Produto
	public List<Produto> todosProdutos() throws Exception {
		try {
			String SQL = "SELECT * FROM tb_produto";
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Produto> list = new ArrayList<Produto>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				int quantidade = rs.getInt(2);
				String nome = rs.getString(3);
				String descricao = rs.getString(4);

				list.add(new Produto(codigo, quantidade, nome, descricao));

			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}
}
