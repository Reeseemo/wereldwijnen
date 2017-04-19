package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Wijn;
import be.vdab.services.BestelbonLijnService;
import be.vdab.services.BestelbonService;
import be.vdab.services.WijnService;
import be.vdab.valueobjects.BestelbonLijn;

/**
 * Servlet implementation class MandjeServlet
 */
@WebServlet("/mandje.htm")
public class MandjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";
	private final transient WijnService wijnService = new WijnService();
	private final transient BestelbonService bestelbonService = new BestelbonService();
	private final transient BestelbonLijnService bestelbonLijnService = new BestelbonLijnService();
	private static final String REDIRECT_URL = "%s/index.htm";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Wijn> wijnInMandje = new ArrayList<>();
		HttpSession session = request.getSession();
		HashMap<Long, Integer> mandje = (HashMap<Long, Integer>) session.getAttribute("mandje");
		if (mandje != null && !mandje.isEmpty()) {
			for (HashMap.Entry<Long, Integer> entry : mandje.entrySet()) {
				Optional<Wijn> optionalWijn = wijnService.read(entry.getKey());
				if (optionalWijn.isPresent()) {
					wijnInMandje.add(optionalWijn.get());
				}

			}

			request.setAttribute("wijnInMandje", wijnInMandje);
			request.setAttribute("mandje", mandje);
		}

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		if (!Bestelbon.isNaamValid(naam)) {
			fouten.put("naam", "naam verplicht");
		}
		String straat = request.getParameter("straat");
		if (!Bestelbon.isStraatValid(straat)) {
			fouten.put("straat", "straat verplicht");
		}
		String huisNr = request.getParameter("huisNr");
		if (!Bestelbon.isHuisNrValid(huisNr)) {
			fouten.put("huisNr", "huisNr verplicht");
		}
		String postcode = request.getParameter("postcode");
		if (!Bestelbon.isPostCodeValid(postcode)) {
			fouten.put("postcode", "postcode verplicht");
		}
		String gemeente = request.getParameter("gemeente");
		if (!Bestelbon.isGemeenteValid(gemeente)) {
			fouten.put("gemeente", "gemeente verplicht");
		}
		short bestelwijze = 0;
		try {
			bestelwijze = new Short(request.getParameter("bestelwijze"));
		} catch (Exception e) {
			fouten.put("bestelwijze", "bestelwijze verplicht");
		}

		if (fouten.isEmpty()) {
			Bestelbon bestelbon = new Bestelbon(naam, straat, huisNr, postcode, gemeente, bestelwijze);
			try {
				bestelbonService.create(bestelbon);
				try {
					HttpSession session = request.getSession();
					HashMap<Long, Integer> mandje = (HashMap<Long, Integer>) session.getAttribute("mandje");

					if (mandje != null && !mandje.isEmpty()) {
						for (HashMap.Entry<Long, Integer> entry : mandje.entrySet()) {
							BestelbonLijn bblijn = new BestelbonLijn(entry.getKey(), entry.getValue());
//							bestelbon.getBestelbonlijnen().add(bblijn);
							try {
								bestelbonLijnService.create(bblijn);
							} catch (Exception e) {
								fouten.put("Bestelbonlijn", "Bestelbonlijn mislukt");
							}

						}
					}

				} catch (Exception e) {
					fouten.put("Bestelbonlijn", "Bestelbonlijn mislukt");
				}

				response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
			} catch (Exception e) {
				fouten.put("Bestelbon", "Bestelbon mislukt");
			}

		}
		if (!fouten.isEmpty()) {
			request.setAttribute("fouten", fouten);
			doGet(request, response);
		}

	}
}
