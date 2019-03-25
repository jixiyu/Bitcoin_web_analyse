package bitcoinViz.web.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public abstract class Table {
	public static abstract class Parameter{}
	
	private String[][] data;

	public abstract void init(Connection conn) throws SQLException;

	public abstract void fill() throws SQLException;

	public abstract String getTitle();

	public abstract String[] getTHs();

	public String[][] getData(){
		return this.data;
	}
	public void setData(String[][] data){
		this.data = data;
	}
	
	protected void fill(ResultSet rs) throws SQLException {
		List<String[]> lst = new LinkedList<>();
		while (rs.next()) {
			String[] r = new String[getTHs().length];
			for (int i = 0; i < r.length; i++)
				r[i] = rs.getString(i + 1);
			lst.add(r);
		}
		data = lst.toArray(new String[0][]);
	}

	public abstract void setParameters(HttpServletRequest req) ;
	public Object export() {
		return new Object(){
			public String[] th = getTHs();
			public String[][] data = getData();
		};
	}
}
