package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class Top3EachMonth extends Table{

	private Connection conn;

	@Override
	public void init(Connection conn) throws SQLException {
		this.conn = conn;
	}

	@Override
	public void fill() throws SQLException {
		// TODO Auto-generated method stub
		Statement stat = conn.createStatement();
		fill(stat.executeQuery("SELECT rowID, data from tabledata where tableID='MAIN:TOP10PERMONTH'"));
		stat.close();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Top10 Active Accounts";
	}

	@Override
	public String[] getTHs() {
		// TODO Auto-generated method stub
		return new String[]{
				"month",
				"records"
		};
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

}
