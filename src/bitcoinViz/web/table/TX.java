package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class TX extends Table {

	private Connection conn;
	private String sql = "SELECT tx_hash, output_idx, source, destination, value, timestamp FROM txo ORDER BY timestamp ASC";

	@Override
	public void init(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void fill() throws SQLException {
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		fill(rs);
	}

	@Override
	public String getTitle() {
		return "All Transactions";
	}

	@Override
	public String[] getTHs() {
		return new String[] { "tx_hash", "output_idx", "source", "destination", "value", "timestamp"};
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

}
