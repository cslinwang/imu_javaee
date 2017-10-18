package web2017.team4.wanglin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web2017.team4.wanglin.service.LoginService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);// ��дdoGet������ʹ������doPost����
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// ���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ��ȡǰ̨������name����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// ����LoginService
		LoginService ls = new LoginService();// ��ʼ��һ��LoginService
		// Boolean flag=ls.loginNoSql(name, password);
		Boolean isExist = ls.loginService(name, password);
		if (isExist) {
			System.out.println("yes");
			HttpSession session = request.getSession();
			session.setAttribute("username", name);// �����Ա��浽session�Ự��
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);// ��ת��index.jspҳ��
		} else {
			System.out.println("no");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);// ��ת��index.jspҳ��
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
