package br.com.forecast.cidade.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import br.com.forecast.jdbc.dao.CidadeDao;
import br.com.forecast.jdbc.modelo.Cidade;

@WebServlet("/adicionaCidade")
public class AdicionaCidadeServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// busca o writer
		PrintWriter out = response.getWriter();
		CidadeDao dao = new CidadeDao();

		// buscando os parāmetros no request
		String nome = request.getParameter("nome");
		if (nome != null) {
			String uf = request.getParameter("uf");
			String pais = request.getParameter("pais");
			nome = StringEscapeUtils.escapeHtml(nome);

			// monta um objeto cidade
			Cidade cidade = new Cidade();
			cidade.setNome(nome);
			cidade.setUf(uf);
			cidade.setPais(pais);

			// salva a cidade
			
			dao.adiciona(cidade);

			// // imprime o nome da cidade que foi adicionada
			// out.println("<html>");
			// out.println("<body>");
			// out.println("Cidade " + cidade.getNome() + " adicionado com
			// sucesso");
			// out.println("</body>");
			// out.println("</html>");
		}

		List<Cidade> cidades = dao.getLista();
		HttpSession session = request.getSession();
		session.setAttribute("cidades", cidades);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adiciona-cidade.jsp");
		dispatcher.forward(request, response);
	}
}