package br.com.Sistema_farmacia.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.Sistema_farmacia.domain.Fornecedores;

@ManagedBean (name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
private ListDataModel<Fornecedores>itens;

public ListDataModel<Fornecedores> getItens() {
	return itens;
}

public void setItens(ListDataModel<Fornecedores> itens) {
	this.itens = itens;
}
}
