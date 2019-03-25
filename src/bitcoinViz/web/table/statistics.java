package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class statistics extends Table{

	private PreparedStatement ps;

	@Override
	public void init(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		this.ps = conn.prepareStatement("SELECT source, destination, count(*) cnt, sum(value) "
				+ "FROM ("
				+ "	SELECT source, destination, value "
				+ "	FROM txo where timestamp>? and timestamp<?"
				+ ") a "
				+ "GROUP BY source, destination "
				+ "ORDER BY cnt DESC");
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		
		String time1 = req.getParameter("time1");
		String time2 = req.getParameter("time2");
		if(time1==null || time1.length() == 0)
			throw new UnsupportedOperationException();
		if(time2==null || time2.length() == 0)
			throw new UnsupportedOperationException();
		
		try {
			ps.setString(1, time1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ps.setString(2, time2);
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
		return "Statistics of Addresses";
	}

	@Override
	public String[] getTHs() {
		// TODO Auto-generated method stub
		return new String[]{
				"source",
				"destination",
				"count",
				"value"
		};
	}

}
