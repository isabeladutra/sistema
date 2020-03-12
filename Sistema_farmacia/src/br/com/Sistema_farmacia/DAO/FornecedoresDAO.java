package br.com.Sistema_farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void excluir(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
		
	}
   
	public static void main(String[] args) {
		/*Fornecedores f1 = new Fornecedores();
		f1.setDescricao("DESCRICAO 1");
		
		FornecedoresDAO fdao= new FornecedoresDAO();
		try {
			fdao.salvar(f1);
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao salvar!");
			e.printStackTrace();
		}*/
		 Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1);
		
		FornecedoresDAO fdao= new FornecedoresDAO();
		try {
			fdao.excluir(f1);
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao deletar!");
			e.printStackTrace();
		}
     }
	
	
}
