package midterm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import midterm.model.UserRegistration;
import midterm.model.UserSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		UserRegistration.Role role = userSession.getRole();
		String currentPage = userSession.getCurrentPage();
		String dispatcher = "/login";
		switch (role) {
		case ADMIN:
			if ("adminDashboard".equals(currentPage)) {
				if (action == null) {
					dispatcher = "adminDashboard";
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("addMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "addMovie";
				} else if ("editMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "editMovie";
				} else if ("viewMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewMovie";
				}
			} else if ("userProfile".equals(currentPage)) {
				if (action == null) {
					userSession.setCurrentPage("adminDashboard");
				} else if ("addMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "addMovie";
				} else if ("viewMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewMovie";
				}

			} else if ("addMovie".equals(currentPage)) {
				if (action == null) {
					userSession.setCurrentPage("adminDashboard");
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("viewMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewMovie";
				}
			} else if ("editMovie".equals(currentPage)) {
				if (action == null) {
					userSession.setCurrentPage("adminDashboard");
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("addMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "addMovie";
				} else if ("viewMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewMovie";
				}
			} else if ("viewMovie".equals(currentPage)) {
				if (action == null) {
					userSession.setCurrentPage("adminDashboard");
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("addMovie".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "addMovie";
				}
			}

			request.getRequestDispatcher(dispatcher).forward(request, response);
			break;

		case CUSTOMER:
			if ("userDashboard".equals(currentPage)) {
				if (action == null) {
					dispatcher = "userDashboard";
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("movieBooking".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "movieBooking";
				} else if ("viewBooking".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewBooking";
				}
			} else if ("userProfile".equals(currentPage)) {
				if (action == null) {
					userSession.setCurrentPage("userDashboard");
				} else if ("userProfile".equals(action)) {
					dispatcher = "userProfile";
				} else if ("viewBooking".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewBooking";
				}
			} else if ("movieBooking".equals(currentPage)) {
				if (action == null) {
					dispatcher = "userDashboard";
				} else if ("userProfile".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userProfile";
				} else if ("userDashboard".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "userDashboard";
				} else if ("viewBooking".equals(action)) {
					userSession.setCurrentPage(currentPage);
					dispatcher = "viewBooking";
				}
			}

			request.getRequestDispatcher(dispatcher).forward(request, response);
			break;

		default:
			session.invalidate();
			response.sendRedirect("index.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
