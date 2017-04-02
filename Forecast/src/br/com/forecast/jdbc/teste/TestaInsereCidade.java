package br.com.forecast.jdbc.teste;

import br.com.forecast.jdbc.dao.CidadeDao;
import br.com.forecast.jdbc.modelo.Cidade;

public class TestaInsereCidade {

	public static void main(String[] args) throws ClassNotFoundException {

		 // pronto para gravar
		 Cidade cidade = new Cidade();
		 cidade.setNome("São Leão");
		 cidade.setUf("SC");
		 cidade.setPais("Brasil");
		 
		 // grave nessa conexão!!!
		 CidadeDao dao = new CidadeDao();
		
		 dao.adiciona(cidade);
		 
		 System.out.println("Gravado!");

	}

}
