package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificaCarta
 */
@WebServlet("/VerificaCarta")
public class VerificaCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificaCarta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ciao");
		String action = request.getParameter("action");
		String flag =null;
		PrintWriter out = response.getWriter();
	
			if(action != null) {
			
				 flag = request.getParameter("indirizzo");
			}
			if (flag!=null) 
			{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello_carta.jsp");
				dispatcher.forward(request, response);
			}
			else {
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Seleziona un indirizzo');");
				   out.println("location='carrello_indirizzo.jsp';");
				   out.println("</script>");
			}   
		
	}

}
