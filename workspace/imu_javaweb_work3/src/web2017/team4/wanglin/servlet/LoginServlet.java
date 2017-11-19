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

		doPost(request, response);// 重写doGet方法，使其跳到doPost方法
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
		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取前台参数用name接收
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// 调用LoginService
		LoginService ls = new LoginService();// 初始化一个LoginService
		// Boolean flag=ls.loginNoSql(name, password);
		Boolean isExist = ls.loginService(name, password);
		if (isExist) {
			System.out.println("yes");
			HttpSession session = request.getSession();
			session.setAttribute("username", name);// 将属性保存到session会话中
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);// 跳转到index.jsp页面
		} else {
			System.out.println("no");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);// 跳转到index.jsp页面
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
