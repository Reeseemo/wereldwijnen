package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Wijn;
import be.vdab.services.WijnService;

/**
 * Servlet implementation class MandjeServlet
 */
@WebServlet("/mandje.htm")
public class MandjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";
	private final transient WijnService wijnService = new WijnService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Wijn> wijnInMandje = new ArrayList();
		HttpSession session = request.getSession();
		BigDecimal teBetalen = BigDecimal.ZERO;
		HashMap<Long, Integer> mandje = (HashMap<Long, Integer>) session.getAttribute("mandje");
		if (mandje != null && !mandje.isEmpty()) {
			for (HashMap.Entry<Long, Integer> entry : mandje.entrySet()) {
				Optional<Wijn> optionalWijn = wijnService.read(entry.getKey());
				if (optionalWijn.isPresent()) {
					wijnInMandje.add(optionalWijn.get());
					teBetalen = teBetalen
							.add(BigDecimal.valueOf(entry.getValue()).multiply(optionalWijn.get().getPrijs()));
				}

			}

			request.setAttribute("teBetalen", teBetalen);
			request.setAttribute("wijnInMandje", wijnInMandje);
			request.setAttribute("mandje", mandje);
		} /*
			 * else { wijnInMandje.clear(); }
			 */

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
