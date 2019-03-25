package bitcoinViz.web.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import bitcoinViz.web.model.Table;

public class TXwC extends Table {

	private Connection conn;
	private String sql = "SELECT tx_hash, output_idx, source, destination, value, timestamp FROM txo ";
	private ArrayList<String> param;
	private String where;

	@Override
	public void init(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void fill() throws SQLException {
		PreparedStatement ps = this.conn.prepareStatement(sql + where + "ORDER BY timestamp ASC");
		for(int i = 0; i < param.size(); i++ ) {
			ps.setString(i+1, param.get(i));
		}
		ResultSet rs = ps.executeQuery();
		fill(rs);
		rs.close();
		ps.close();
	}

	@Override
	public String getTitle() {
		return "All Transactions";
	}

	@Override
	public String[] getTHs() {
		return new String[] { "tx_hash", "output_idx", "source", "destination", "value", "timestamp" };
	}
	
	public static void main(String[] args) {
		for(String i : new TXwC().getTHs()){
			System.out.print("<th>"+i+"</th>");
		}
	}

	@Override
	public void setParameters(HttpServletRequest req) {
		StringBuffer where = new StringBuffer();
		this.param = new ArrayList<String>();
		boolean related = false;
		related |= appendWhere("source=?", req.getParameter("source"), where, param);
		related |= appendWhere("destination=?", req.getParameter("destination"), where, param);
		if (!related)
			appendWhere("source=? or destination=?", req.getParameter("related"), where, param);
		appendWhere("timestamp>?", req.getParameter("time_l"), where, param);
		appendWhere("timestamp<?", req.getParameter("time_r"), where, param);
		appendWhere("timestamp like ?", req.getParameter("month"), where, param);
		this.where = " WHERE 1=1 " + where.toString();
	}

	private boolean appendWhere(String condition, String obj, StringBuffer where, List<String> m) {
		return appendWhere(condition, obj, where, m, i->i);
	}
	private boolean appendWhere(String condition, String obj, StringBuffer where, List<String> m, Function<String, String> tr) {
		if (obj != null && obj.length() > 0) {
			where.append(" and " + condition + " ");
			condition.chars().filter(i -> i=='?').forEach(_a -> m.add(tr.apply(obj)));
			return true;
		}
		return false;
	}

}
