package com.li.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.li.domain.CustomerBean;
import com.li.domain.DrugsBean;
import com.li.domain.StaffBean;
import com.li.service.CustomerService;
import com.li.service.DrugsService;
import com.li.service.StaffsService;
import com.li.service.impl.CustomerServiceImpl;
import com.li.service.impl.DrugsServiceImpl;
import com.li.service.impl.StaffsServiceImpl;

/**
 * 处理入库管理界面点击添加入库记录的请求
 */
public class InsertInHouseDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			DrugsService service = new DrugsServiceImpl();
			List<DrugsBean> druglist = service.findAll();
			StaffsService service3 = new StaffsServiceImpl();
			List<StaffBean> stafflist = service3.findAll();
			
			request.setAttribute("druglist", druglist);
			request.setAttribute("stafflist", stafflist);
			
			request.getRequestDispatcher("/jsp/insertInRecord.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
