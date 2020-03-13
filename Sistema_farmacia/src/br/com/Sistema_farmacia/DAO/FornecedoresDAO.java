package br.com.Sistema_farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.Sistema_farmacia.domain.Fornecedores;
import br.com.Sistema_farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {
	public void salvar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao)");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}

	public void excluir(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();

	}

	public void editar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();

	}

	public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));

		}
		return retorno;
	}

	
	public ArrayList<Fornecedores> Listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao aSC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		

		ResultSet resultado = comando.executeQuery();
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo"));
			
		}
		
	}
	
	public static void main(String[] args) {
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setDescricao("carlos");
		 * 
		 * FornecedoresDAO fdao= new FornecedoresDAO(); try { fdao.salvar(f1);
		 * System.out.println("Salvo com sucesso!"); } catch (SQLException e) { // TODO
		 * Auto-generated catch block System.out.println("Erro ao salvar!");
		 * e.printStackTrace(); }
		 */
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(1);
		 * 
		 * FornecedoresDAO fdao= new FornecedoresDAO(); try { fdao.excluir(f1);
		 * System.out.println("Deletado com sucesso!"); } catch (SQLException e) { //
		 * TODO Auto-generated catch block System.out.println("Erro ao deletar!");
		 * e.printStackTrace(); }
		 */

		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(2);
		 * f1.setDescricao("Isabela");
		 * 
		 * FornecedoresDAO fdao= new FornecedoresDAO(); try { fdao.editar(f1);
		 * System.out.println("Editado com sucesso!"); } catch (SQLException e) { //
		 * TODO Auto-generated catch block System.out.println("Erro ao editar!");
		 * e.printStackTrace(); }
		 */

		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1);

		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.buscaPorCodigo(f1);
			System.out.println("Resultado: " + f1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao salvar!");
			e.printStackTrace();
		}

	}
}