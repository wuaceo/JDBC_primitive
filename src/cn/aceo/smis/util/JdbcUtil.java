package cn.aceo.smis.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	/*
	 * private static String driverClassName="com.mysql.jdbc.Driver"; private
	 * static String url="jdbc:mysql://localhost:3306/test"; private static
	 * String username="root"; private static String password="123456";
	 */
	private static Properties p = new Properties();
	static {
		try {
			// ���ݿ����Ӳ��������ļ�

			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties");
			p.load(in);
			// 1����������
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {

		try {

			// 2����ȡ���Ӷ���
			return DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("username"), p.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		// 5���ͷ���Դ
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}