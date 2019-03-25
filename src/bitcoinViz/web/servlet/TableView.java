package bitcoinViz.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bitcoinViz.web.model.Table;

//@Singleton
public class TableView extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;

	public void init() throws ServletException {
		super.init();
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conn = DriverManager.getConnection("jdbc:mysql://10.21.238.250:3306/bitcoin", "root", "test");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);

		String clsName = req.getParameter("f");
		boolean retJSON = "json".equals(req.getParameter("ret"));
		
		if (clsName == null || clsName.length() == 0) {
			super.doGet(req, resp);
			return;
		}

		Object tabobj = null;
		try {
			tabobj = Class.forName("bitcoinViz.web.table."+clsName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			super.doGet(req, resp);
			return;
		}
		if (!(tabobj instanceof Table)) {
			req.setAttribute("errorMsg", "Wrong Method!");
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
			return;
		}

		Table tab = (Table) tabobj;
		try {
			tab.init(conn);
			tab.setParameters(req);
			tab.fill();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("tab", tab);
		if(!retJSON) {
			req.getRequestDispatcher("WEB-INF/table.jsp").forward(req, resp);
			return;
		}
		
		resp.setContentType("application/json");
		resp.getWriter().append(JSON.toJSONString(tab.export()));
		return;
	}
}
