package cn.aceo.smis.dao;

import java.util.List;

import cn.aceo.smis.domain.User;

public interface IUserDAO {
	User user=new User();
	/**
	 * 保存操作（追加记录）
	 * @param user 需要保存的用户对象
	 */
	void save(User user);
	/**
	 * 删除操作
	 * @param id 用户信息的主键值
	 */
	void delete(Long id);
	/**
	 * 更新用户信息操作
	 * @param id 用户信息的主键值
	 * @param newUser 新的用户对象
	 */
	void update(Long id,User newUser);
	/**
	 * 根据用户ID查询一个用户的信息
	 * @param id 用户信息的主键值
	 * @return 如果用户存在就返回用户对象，如果用户不存在就返回null
	 */
	User get(Long id);
	/**
	 * 查询所有的用户信息
	 * @return 返回用户信息结果集。如果结果集为空，就返回一个空的集合
	 */
	List<User> listAll();
}
