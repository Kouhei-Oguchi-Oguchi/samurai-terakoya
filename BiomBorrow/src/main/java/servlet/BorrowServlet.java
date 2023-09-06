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

import model.BorrowDate;
import model.BorrowReturnLogic;
import model.MedicalEquipment;
import model.Place;
/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowServlet() {
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
		String datetimeValue = request.getParameter("Borrow-time");
		String medicalEquimentValue = request.getParameter("medicalEquiment");
		String departmetValue = request.getParameter("department");

		boolean hasValidationErrow = false;
		String errorMessage = "";
		if (datetimeValue.isEmpty()){
			hasValidationErrow = true;
			errorMessage = "貸出日が入力されていません";
		}

		if (!medicalEquimentValue.matches("[1-9][0-9]{3}")) {
			hasValidationErrow = true;
			errorMessage = "4桁番号が正しくありません";
		}
		if (departmetValue.isEmpty()){
			hasValidationErrow = true;
			errorMessage = "部署が入力されていません";
		}
		if (hasValidationErrow) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("BorrowForm.jsp");
			dispatcher.forward(request, response);
		}else {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime BorrowDate = LocalDateTime.parse(datetimeValue, fmt);
			BorrowDate borrowdays = new BorrowDate();
			borrowdays.setBorrowdays(BorrowDate);
			int meNO = Integer.parseInt(medicalEquimentValue);
			MedicalEquipment medicalEquipmen = new MedicalEquipment();
			medicalEquipmen.setMedicalEquipmen(meNO); 
			int department = Integer.parseInt(departmetValue);
			Place place = new Place(department);
			place.setPlace(department);
			BorrowReturnLogic Bo = new BorrowReturnLogic();
			Bo.BorrowExecute(BorrowDate, meNO, department);
			HttpSession session = request.getSession();
			session.setAttribute("borrowdays", borrowdays);
			session.setAttribute("medicalEquipmen", medicalEquipmen);
			int placeNumber = place.getPlace();
			switch(placeNumber) {
			case 1:
				String placeName3EeatWard = "本館3階東";
				session.setAttribute("placename", placeName3EeatWard);
				break;
			case 2:
				String placeName3WestWard = "本館3階西";
				session.setAttribute("placename", placeName3WestWard);
				break;
			case 3:
				String placeName2WestWard = "本館2階西";
				session.setAttribute("placename", placeName2WestWard);
				break;
			case 4:
				String placeName2EeatNursingCareClinic = "介護医療院";
				session.setAttribute("placename", placeName2EeatNursingCareClinic);
				break;
			case 5:
				String placeName4SouthWard = "南館4階病棟";
				session.setAttribute("placename", placeName4SouthWard);
				break;
			case 6:
				String placeName3SouthWard = "南館3階病棟";
				session.setAttribute("placename", placeName3SouthWard);
				break;
			case 7:
				String placeName2SouthWard = "南館2階病棟";
				session.setAttribute("placename", placeName2SouthWard);
				break;
			case 8:
				String placeName1SouthWard = "南館1階病棟";
				session.setAttribute("placename", placeName1SouthWard);
				break;
			case 9:
				String placeNameNewSouthWard = "南館1階病棟";
				session.setAttribute("placename", placeNameNewSouthWard);
				break;
			case 10:
				String placeNameRehabilitation = "リハビリ";
				session.setAttribute("placename", placeNameRehabilitation);
				break;
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BorrowDone.jsp");
			dispatcher.forward(request, response);
		}
	}
}