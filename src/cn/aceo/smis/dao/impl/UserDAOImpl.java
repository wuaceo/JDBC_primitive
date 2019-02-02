package cn.aceo.smis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.aceo.smis.dao.IUserDAO;
import cn.aceo.smis.domain.User;
import cn.aceo.smis.util.JdbcUtil;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User user) {
		// TODO ׷�Ӳ�ѯ
		Connection conn = null;
		Statement st = null;
		// INSERT INTO t_user (name,age) VALUES ('WB0',20)
		// String sql = "";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO t_user (name,age) VALUES ('")
				.append(user.getName()).append("',").append(user.getAge())
				.append(")");
		System.out.println(sb.toString());
		try {
			// 1����������			
			// 2����ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3������ִ�����
			st = conn.createStatement();
			// 4��ִ��SQL���
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
			JdbcUtil.close(conn, st, null);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO ɾ����ѯ
		Connection conn = null;
		Statement st = null;
		// DELETE FROM t_user WHERE id=7
		String sql = "DELETE FROM t_user WHERE id="+id;
		try {
			// 1����������			
			// 2����ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3������ִ�����
			st = conn.createStatement();
			// 4��ִ��SQL���
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
			JdbcUtil.close(conn, st, null);
			}
	}

	@Override
	public void update(Long id, User newUser) {
		// TODO ���²�ѯ
		Connection conn = null;
		Statement st = null;
		// UPDATE t_user SET name='lgd',age=15 WHERE id=15
		// String sql = "";
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE t_user SET name='").append(newUser.getName())
				.append("',age=").append(newUser.getAge()).append(" WHERE id=")
				.append(id);
		try {
			// 1����������			
			// 2����ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3������ִ�����
			st = conn.createStatement();
			// 4��ִ��SQL���
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
			JdbcUtil.close(conn, st, null);
		}
	}

	@Override
	public User get(Long id) {
		// TODO ����ID��ѯһ����Ϣ
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_user WHERE id=" + id;
		try {
			// 1����������			
			// 2����ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3������ִ�����
			st = conn.createStatement();
			// 4��ִ��SQL���
			rs = st.executeQuery(sql);
			// *****��������******
			if (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}
			// ******************
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
			JdbcUtil.close(conn, st, rs);
		}
		return null;
	}

	@Override
	public List<User> listAll() {
		// TODO ��ѯ������Ϣ
		List<User> list = new ArrayList();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_user";
		try {
			// 1����������			
			// 2����ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3������ִ�����
			st = conn.createStatement();
			// 4��ִ��SQL���
			rs = st.executeQuery(sql);
			// *****��������******
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			// ******************
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
			JdbcUtil.close(conn, st, rs);
		}
		return list;
	}

}
