package br.com.forecast.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.forecast.jdbc.ConnectionFactory;
import br.com.forecast.jdbc.modelo.Cidade;

public class CidadeDao {
	
   // a conexão com o banco de dados
   private Connection connection;
 
   public CidadeDao()  {
	   
     try {
		this.connection = new ConnectionFactory().getConnection();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
   }
   
   public void adiciona(Cidade cidade) {
     String sql = "insert into cidade " +
             "(nome,uf,pais)" +
             " values (?,?,?)";
 
     try {
         // prepared statement para inserção
         PreparedStatement stmt = connection.prepareStatement(sql);
 
         // seta os valores
         stmt.setString(1,cidade.getNome());
         stmt.setString(2,cidade.getUf());
         stmt.setString(3,cidade.getPais());
 
         // executa
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
   }
   
   public List<Cidade> getLista() {
     try {
    	 
         List<Cidade> cidades = new ArrayList<Cidade>();
         PreparedStatement stmt = this.connection.prepareStatement("select * from cidade");
         ResultSet rs = stmt.executeQuery();
 
         while (rs.next()) {
        	 
             // criando o objeto Cidade
        	 Cidade cidade = new Cidade();
        	 cidade.setId(rs.getLong("id"));
        	 cidade.setNome(rs.getString("nome"));
        	 cidade.setUf(rs.getString("uf"));
        	 cidade.setPais(rs.getString("pais"));
 
             // adicionando o objeto à lista
        	 cidades.add(cidade);
             
         }
         
         rs.close();
         stmt.close();
         return cidades;
         
     } catch (SQLException e) {
    	 
         throw new RuntimeException(e);
         
     }
	}
   
   public void altera(Cidade cidade) {
	   
	     String sql = "update cidade set nome=?, uf=?, pais=? where id=?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1, cidade.getNome());
	         stmt.setString(2, cidade.getUf());
	         stmt.setString(3, cidade.getPais());
	         stmt.setLong(4, cidade.getId());
	         stmt.execute();
	         stmt.close();
	         
	     } catch (SQLException e) {
	    	 
	         throw new RuntimeException(e);
	         
	     }
	 }
   
   public void remove(Cidade cidade) {
	     try {
	         PreparedStatement stmt = connection.prepareStatement("delete" +
	                 "from cidade where id=?");
	         stmt.setLong(1, cidade.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
