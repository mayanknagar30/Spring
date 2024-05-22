package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;


@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	UserDTO dto = new UserDTO();
	UserModel model = new UserModel();
	List list = model.search(dto);
	req.setAttribute("list", list);
	RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
	rd.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		UserDTO dto = new UserDTO();
		UserModel model = new UserModel();
		if (op.equalsIgnoreCase("delete")) {
			if(ids!=null) {
				for(String id:ids) {
					UserDTO deletedto = new UserDTO();
					deletedto.setId(Integer.parseInt(id));
					model.delete(deletedto);
					req.setAttribute("msg","Record delete sucessfully");
//					RequestDispatcher rd = req.getRequestDispatcher("CarListView.jsp");
//					rd.forward(req, resp);
				}
			}else {
				req.setAttribute("msg","Select Atleast one record");
			}
		}
		if(op.equalsIgnoreCase("new")){
			resp.sendRedirect("UserCtl");
			return;
		}
		if(op.equals("search")){
	
			dto.setName(req.getParameter("name"));
		}
		if(op.equals("Search")){
			
			dto.setId(Integer.parseInt(req.getParameter("id")));
		}
		List list=model.search(dto);
		req.setAttribute("list",list);
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}

}
