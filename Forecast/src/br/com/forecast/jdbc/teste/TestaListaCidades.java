package br.com.forecast.jdbc.teste;

import java.util.List;

import br.com.forecast.jdbc.dao.CidadeDao;
import br.com.forecast.jdbc.modelo.Cidade;

public class TestaListaCidades {

	public static void main(String[] args) throws ClassNotFoundException {
		
		CidadeDao dao = new CidadeDao();
		
		List<Cidade> cidades = dao.getLista();
		
		for (Cidade cidade : cidades) {
		  System.out.println("Nome: " + cidade.getNome());
		  System.out.println("UF: " + cidade.getUf());
		  System.out.println("Pais: " + cidade.getPais());
		}
	}

}
