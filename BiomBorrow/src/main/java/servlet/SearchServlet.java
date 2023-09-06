package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BorrowReturnLogic;
import model.MedicalEquipment;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicalEquimentValue = request.getParameter("medicalEquipment");
		int meNO = Integer.parseInt(medicalEquimentValue);
		BorrowReturnLogic Bo = new BorrowReturnLogic();
		MedicalEquipment medicalEquipmentValue = Bo.getMedicalEquipmentByMeNo(meNO);
	    
		String imageFileName;
		if ("JM-OT707".equals(medicalEquipmentValue.getModelNumber())) {
			imageFileName = "/BiomBorrow/images/OT-707.jpeg";;
		}else if("JM-OT808".equals(medicalEquipmentValue.getModelNumber())){
			imageFileName = "/BiomBorrow/images/OT-808.jpeg";
		}else if("JM-OT808P".equals(medicalEquipmentValue.getModelNumber())){
			imageFileName = "/BiomBorrow/images/OT-808.jpeg";
		}else {
			imageFileName = "/BiomBorrow/images/default.jpg";
		}
		HttpSession session = request.getSession();
		session.setAttribute("medicalEquipmentValue",medicalEquipmentValue);
		session.setAttribute("imageFileName",imageFileName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp");
		dispatcher.forward(request, response);
	}
}
