package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.LandService;
import be.vdab.services.SoortService;
import be.vdab.services.WijnService;

/**
 * Servlet implementation class WijnServlet
 */
@WebServlet("/details.htm")
public class WijnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/wijn.jsp";
	private final transient WijnService wijnService = new WijnService();
	private final transient LandService landService = new LandService();
	private final transient SoortService soortService = new SoortService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String soortid = request.getParameter("soort");
			String wijnid = request.getParameter("soort");
			if (wijnid != null) {
				if (id != null) {
					if (soortid != null) {
						landService.read(Long.parseLong(id)).ifPresent(land -> request.setAttribute("land", land));
						soortService.read(Long.parseLong(soortid))
								.ifPresent(soort -> request.setAttribute("soort", soort));
						wijnService.read(Long.parseLong(wijnid)).ifPresent(wijn -> request.setAttribute("wijn", wijn));
					}
				}
			}

			request.getRequestDispatcher(VIEW).forward(request, response);
		} catch (NullPointerException | IllegalArgumentException ex) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
