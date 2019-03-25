package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class Graph extends Table{

	private PreparedStatement ps;

	@Override
	public void init(Connection conn) throws SQLException {
		this.ps = conn.prepareStatement("SELECT 'to' d, destination f, sum(value), max(timestamp) from txo where source=? group by destination union SELECT 'from' d, source f, sum(value), max(timestamp) from txo where destination=? group by source ");
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		
		String source = req.getParameter("node");
		if(source==null || source.length() == 0)
			throw new UnsupportedOperationException();
		
		try {
			ps.setString(1, source);
			ps.setString(2, source);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void fill() throws SQLException {
		// TODO Auto-generated method stub
		fill(ps.executeQuery());
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Graph";
	}

	@Override
	public String[] getTHs() {
		// TODO Auto-generated method stub
		return new String[]{
				"relationship",
				"node",
				"sum",
				"max_timestap"
		};
	}

}
