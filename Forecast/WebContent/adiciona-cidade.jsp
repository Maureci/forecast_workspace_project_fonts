<!DOCTYPE html>
<%@ page import="java.util.*, org.apache.commons.lang.StringEscapeUtils,br.com.forecast.cidade.servlet.HTMLEntities,
		br.com.forecast.jdbc.modelo.Cidade" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forecast</title>
</head>
<%
List<Cidade> cidades = (List<Cidade>)session.getAttribute("cidades");
%>

	<body>
    <h1>Adiciona Cidades</h1>
    <hr />
    <form action="adicionaCidade" method="POST">
      Nome: <input type="text" name="nome" /><br />
      UF: <input type="text" name="uf" /><br />
      Pa�s: <input type="text" name="pais" /><br />
      
      <input type="submit" value="Gravar" />
    </form>
    <table>
      <tr>
		<td>Cidade</td>
		<td>Estado</td>
		<td>Pa�s</td>
	  </tr><tr></tr>
      <%
if(cidades!=null) {
      for (Cidade cidade : cidades ) {
      %>
        <tr>
          <td><%=cidade.getNome() %></td> 
          <td><%=cidade.getUf() %></td>
          <td><%=cidade.getPais() %></td>
          <td><a href="previsao.html?cidade=<%=HTMLEntities.htmlentities(cidade.getNome())%>">Tempo</a></td>
        </tr>
      <%
      }
}
      %>
    </table>
  
</body>
</html>