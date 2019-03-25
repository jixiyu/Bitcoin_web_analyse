package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class AllAddresses extends Table{

	private Connection conn;

	@Override
	public void init(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		this.conn = conn;
	}

	@Override
	public void setParameters(HttpServletRequest req) {
	}

	@Override
	public void fill() throws SQLException {
		// TODO Auto-generated method stub
		Statement stat = conn.createStatement();
		fill(stat.executeQuery("select distinct a from (select source a from txo union select destination a from txo) b "));
		stat.close();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Related Addresses";
	}

	@Override
	public String[] getTHs() {
		// TODO Auto-generated method stub
		return new String[]{
				"address",
		};
	}

}
