package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.services.WijnService;

/**
 * Servlet implementation class WijnServlet
 */
@WebServlet("/details.htm")
public class WijnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/wijn.jsp";
	private static final String REDIRECT_URL = "%s/index.htm";
	private final transient WijnService wijnService = new WijnService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String wijnid = request.getParameter("wijn");
			if (wijnid != null) {
				wijnService.read(Long.parseLong(wijnid)).ifPresent(wijn -> request.setAttribute("wijn", wijn));
			}

			request.getRequestDispatcher(VIEW).forward(request, response);
		} catch (NullPointerException | IllegalArgumentException ex) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		int aantal = 0;
		Long wijnid = null;
		try {
			aantal = Integer.parseInt(request.getParameter("aantal"));
			wijnid = Long.parseLong(request.getParameter("wijn"));
			if (aantal < 1) {
				fouten.put("aantal", "Aantal moet een positief geheel getal zijn");
			}

		} catch (NullPointerException | IllegalArgumentException ex) {
			fouten.put("aantal", "Aantal moet een positief geheel getal zijn");
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		}

		if (fouten.isEmpty()) {
			HttpSession session = request.getSession();
			HashMap<Long, Integer> mandje = (HashMap<Long, Integer>) session.getAttribute("mandje");
			if (mandje == null) {
				mandje = new HashMap<Long, Integer>();
			}

			mandje.put(wijnid, aantal);
			session.setAttribute("mandje", mandje);
			response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));

		} else {
			request.setAttribute("fouten", fouten);
			this.doGet(request, response);
		}

	}
}
