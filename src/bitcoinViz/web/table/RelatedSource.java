package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class RelatedSource extends Table{

	private PreparedStatement ps;

	@Override
	public void init(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		this.ps = conn.prepareStatement("SELECT source, destination, value, timestamp FROM txo where source=?");
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		
		String source = req.getParameter("source");
		if(source==null || source.length() == 0)
			throw new UnsupportedOperationException();
		
		try {
			ps.setString(1, source);
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
		return "Related Transactions";
	}

	@Override
	public String[] getTHs() {
		// TODO Auto-generated method stub
		return new String[]{
				"source",
				"destination",
				"value",
				"timestamp"
		};
	}

}
