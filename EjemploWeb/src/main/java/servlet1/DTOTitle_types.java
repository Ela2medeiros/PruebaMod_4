package servlet1;

import java.sql.*;


public class DTOTitle_types {
	
	public static boolean insert(Connection conn, Title_types title_types) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("INSERT INTO title_types VALUES (?,?)" );
			pst.setString(1, title_types.getTitle_no());
			pst.setString(2, title_types.getTitle());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static Title_types select(Connection conn, Title_types title_types) {
		PreparedStatement pst;
		
		try {
			pst = conn.prepareStatement("SELECT * FROM title_types WHERE title_no=?" );
			pst.setString(1, title_types.getTitle_no());
			ResultSet rs = pst.executeQuery();
			rs.next();
			title_types = new Title_types(rs.getString("title_no"), rs.getString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return title_types;
	}
	
	public static boolean update(Connection conn, Title_types title_types) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("UPDATE title_types SET title=? WHERE title_no=?" );
			pst.setString(1, title_types.getTitle());
			pst.setString(2, title_types.getTitle_no());
			if (pst.executeUpdate() > 0) {
				vret = true;
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
	
	public static boolean delete(Connection conn, Title_types title_types) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("DELETE FROM title_types WHERE title_no=?" );
			pst.setString(1, title_types.getTitle_no());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
	
}