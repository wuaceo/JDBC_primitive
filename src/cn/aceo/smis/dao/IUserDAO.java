package cn.aceo.smis.dao;

import java.util.List;

import cn.aceo.smis.domain.User;

public interface IUserDAO {
	User user=new User();
	/**
	 * ���������׷�Ӽ�¼��
	 * @param user ��Ҫ������û�����
	 */
	void save(User user);
	/**
	 * ɾ������
	 * @param id �û���Ϣ������ֵ
	 */
	void delete(Long id);
	/**
	 * �����û���Ϣ����
	 * @param id �û���Ϣ������ֵ
	 * @param newUser �µ��û�����
	 */
	void update(Long id,User newUser);
	/**
	 * �����û�ID��ѯһ���û�����Ϣ
	 * @param id �û���Ϣ������ֵ
	 * @return ����û����ھͷ����û���������û������ھͷ���null
	 */
	User get(Long id);
	/**
	 * ��ѯ���е��û���Ϣ
	 * @return �����û���Ϣ���������������Ϊ�գ��ͷ���һ���յļ���
	 */
	List<User> listAll();
}
