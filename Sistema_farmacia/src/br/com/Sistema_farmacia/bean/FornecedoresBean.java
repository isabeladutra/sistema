package br.com.Sistema_farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.Sistema_farmacia.DAO.FornecedoresDAO;
import br.com.Sistema_farmacia.domain.Fornecedores;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	@PostConstruct

public void prepararPesquisa() {
	
	try {
		FornecedoresDAO fdao = new FornecedoresDAO();
		ArrayList<Fornecedores>lista = fdao.Listar();
		itens = new ListDataModel<Fornecedores>(lista);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
