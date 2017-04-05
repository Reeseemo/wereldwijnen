package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.LandService;
import be.vdab.services.SoortService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final transient LandService landService = new LandService();
	private final transient SoortService soortService = new SoortService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("landen", landService.findAll());
		String id = request.getParameter("id");
		String soortid = request.getParameter("soort");
		if (id != null) {
			landService.read(Long.parseLong(id)).ifPresent(land -> request.setAttribute("land", land));
			if (request.getParameter("soort") != null) {
				request.setAttribute("soorten", soortService.findByCountry(Long.parseLong(id)));
				soortService.read(Long.parseLong(soortid)).ifPresent(soort -> request.setAttribute("soort", soort));

			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
