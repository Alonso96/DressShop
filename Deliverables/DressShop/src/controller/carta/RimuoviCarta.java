package controller.carta;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.carta.CartaDiCreditoBean;
import model.carta.CartaDiCreditoModel;
import model.carta.CartaDiCreditoModelDM;
import model.utente.UtenteBean;



@WebServlet("/RimuoviCarta")
public class RimuoviCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartaDiCreditoModel<CartaDiCreditoBean> model = new CartaDiCreditoModelDM();
    public RimuoviCarta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized (session) {
			UtenteBean utente=(UtenteBean)session.getAttribute("utente");
			if(utente==null)
			{
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else
			{
				String carta=(request.getParameter("numero_carta"));
				try {
					model.doDelete(carta);
					request.getRequestDispatcher("MostraCarte").forward(request, response);
				} catch (SQLException e) {
					request.getRequestDispatcher("MostraCarte.jsp").forward(request, response);
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
