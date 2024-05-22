package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserDTO dto = new UserDTO();
		UserModel model = new UserModel();
		if (id != null) {
			dto = model.findByPk(Integer.parseInt(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO dto = new UserDTO();
		String id = req.getParameter("id");
		String op = req.getParameter("operation");
		UserModel model = new UserModel();
		
		dto.setName(req.getParameter("name"));
		dto.setLastname(req.getParameter("lastname"));
		
		
		try {
			dto.setUserdate(sdf.parse(req.getParameter("date")));
		} catch (java.text.ParseException e) {
			
			e.printStackTrace();
		}
		
		
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("dto", dto);
			req.setAttribute("msg", "User record updated successfully");
		}
		if (op.equalsIgnoreCase("save")) {
			req.setAttribute("dto", dto);
			model.add(dto);
			req.setAttribute("msg", "User record added successfully");

		}if (op.equalsIgnoreCase("reset")) {
//			req.setAttribute("dto", dto);
			RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
			rd.forward(req, resp);

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

}
}
