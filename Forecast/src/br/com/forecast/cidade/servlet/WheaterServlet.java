package br.com.forecast.cidade.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/tempo")
public class WheaterServlet extends HttpServlet {

	private static final String APIID = "eb8b1a9405e659b2ffc78f0a520b1a46";

	public void doGet(HttpServletRequest request, HttpServletResponse httpResponse) throws IOException {
		PrintWriter out = httpResponse.getWriter();
		Client client = Client.create();

		String cidade = request.getParameter("cidade");
		WebResource webResource = client
				.resource("http://samples.openweathermap.org/data/2.5/forecast?q=" + cidade + "&appid=" + APIID);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		out.println(output);
	}

}
