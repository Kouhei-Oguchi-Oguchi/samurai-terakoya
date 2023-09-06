package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BorrowReturnLogic;
import model.MedicalEquipment;
import model.ReturnDate;
/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
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
		String datetimeValue = request.getParameter("Return-time");
		String medicalEquimentValue = request.getParameter("medicalEquiment");
		boolean hasValidationErrow = false;
		String errorMessage = "";
		if (!medicalEquimentValue.matches("[1-9][0-9]{3}")) {
			hasValidationErrow = true;
			errorMessage = "4桁番号が正しくありません";
		}
		if (datetimeValue.isEmpty()) {
			hasValidationErrow = true;
			errorMessage = "返却日が入力されていません";
		}
		if(hasValidationErrow) {
		 request.setAttribute("errorMessage", errorMessage);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Return.jsp");
		 dispatcher.forward(request, response);
		}else {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime Returndays = LocalDateTime.parse(datetimeValue, fmt);
			ReturnDate returndays = new ReturnDate(Returndays);
			returndays.setReturndays(Returndays);
			int meNO = Integer.parseInt(medicalEquimentValue);
			MedicalEquipment medicalEquipmen = new MedicalEquipment(meNO);
			BorrowReturnLogic Bo = new BorrowReturnLogic();
			Bo.ReturnExecute(meNO,Returndays);
			HttpSession session = request.getSession();
			session.setAttribute("returndays", returndays);
			session.setAttribute("medicalEquipmen", medicalEquipmen);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ReturnDone.jsp");
			dispatcher.forward(request, response);
		}
	}
}
