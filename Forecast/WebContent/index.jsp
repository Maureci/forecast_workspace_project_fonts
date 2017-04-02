<%@ page import="java.util.*,
		br.com.forecast.jdbc.dao.CidadeDao,
		br.com.forecast.jdbc.modelo.Cidade" %>
<html>
  <body>
    <table>
      <tr>
		<td>Cidade</td>
		<td>Estado</td>
		<td>Pa�s</td>
	  </tr><tr></tr>
      <%
      CidadeDao dao = new CidadeDao();
      List<Cidade> cidades = dao.getLista();
      
      for (Cidade cidade : cidades ) {
      %>
        <tr>
          <td><%=cidade.getNome() %></td> 
          <td><%=cidade.getUf() %></td>
          <td><%=cidade.getPais() %></td>
          <td><a href="previsao.html?cidade=<%=cidade.getNome()%>">Tempo</a></td>
        </tr>
      <%
      }
      %>
    </table>
    <p>  
    	<input type="submit" name="Submit" value="voltar">  
	</p>  
  </body>
</html>