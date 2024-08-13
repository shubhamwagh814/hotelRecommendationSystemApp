package org.hotel.config;

import java.sql.*;
public class DBHelper {
	protected DBConfig db=DBConfig.getInstance();
	protected Connection c=DBConfig.getConnection();
	protected PreparedStatement ps=DBConfig.getStatement();
	protected ResultSet rs=DBConfig.getResultSet();
}