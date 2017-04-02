package br.com.forecast.jdbc.teste;

import br.com.forecast.jdbc.dao.CidadeDao;
import br.com.forecast.jdbc.modelo.Cidade;

public class TestaInsereCidade {

	public static void main(String[] args) throws ClassNotFoundException {

		 // pronto para gravar
		 Cidade cidade = new Cidade();
		 cidade.setNome("S�o Le�o");
		 cidade.setUf("SC");
		 cidade.setPais("Brasil");
		 
		 // grave nessa conex�o!!!
		 CidadeDao dao = new CidadeDao();
		
		 dao.adiciona(cidade);
		 
		 System.out.println("Gravado!");

	}

}
