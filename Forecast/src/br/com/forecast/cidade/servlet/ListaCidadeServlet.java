package br.com.forecast.cidade.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.forecast.jdbc.dao.CidadeDao;
import br.com.forecast.jdbc.modelo.Cidade;

@WebServlet("/previsaoCidade")
public class ListaCidadeServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
    }

    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
    }
	
	@Override
	protected void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException {
    	
		request.getParameter("cidade");
		
        PrintWriter out = response.getWriter();
                        
        //CidadeDao dao = new CidadeDao();		
		//List<Cidade> cidades = dao.getLista(); 
		
        out.println("<html>");
        out.println("<body>");
        out.println(request.getParameter("cidade"));        
        out.println("</body>");
        out.println("</html>");
    }
}