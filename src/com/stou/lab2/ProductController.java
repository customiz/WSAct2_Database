package com.stou.lab2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/product.jsp";
	private static String LIST_PRODUCT = "/listproduct.jsp";
	private ProductDAo dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		dao = new ProductDAo();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")){
			String id = request.getParameter("id");
			dao.deleteProduct(id);
			forward = LIST_PRODUCT;
			request.setAttribute("products", dao.getAllProducts()); 
		} else if (action.equalsIgnoreCase("edit")){
			 forward = INSERT_OR_EDIT;
			 String id = request.getParameter("id");
			 Product product = dao.getProductById(id);
			 request.setAttribute("product", product);

		} else if (action.equalsIgnoreCase("listProduct")){
			forward = LIST_PRODUCT;
			request.setAttribute("products", dao.getAllProducts());
		 } else {
			 forward = INSERT_OR_EDIT;
		 }
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setId(Integer.parseInt(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setDesc(request.getParameter("desc"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		int id = Integer.parseInt(request.getParameter("id"));
		product.setId(id);
		dao.checkProduct(product);
		RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT);
		request.setAttribute("products", dao.getAllProducts());
		view.forward(request, response);
	}

}
