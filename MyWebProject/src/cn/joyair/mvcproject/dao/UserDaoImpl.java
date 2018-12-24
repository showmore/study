package cn.joyair.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.joyair.mvcproject.model.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int save(User user) {
		String sql="insert into `USER`(`ID`,`NAME`,`IDENTITY`,`TYPE`,`PHONE`,`IDENTITY_TYPE`,`GENDER`,`BIRTHDAY`,`BELONGS_TO`)  VALUES(?,?,?,?,?,?,?,?,?);";
		return super.update(sql, user.getId(), user.getName(), user.getIdentity(), user.getType(), user.getPhone(), user.getIdentity_type(), user.getGender(), user.getBirthday(), user.getBelongs_to());

	}

	@Override
	public int deleteUserById(String id) {
		String sql="DELETE FROM `USER` WHERE `ID`=?;";
		return super.update(sql, id);
	}

	@Override
	public int updateUser(User user) {
		String sql="UPDATE `USER` SET `NAME`=?,`IDENTITY`=?,`TYPE`=?,`PHONE`=?,`IDENTITY_TYPE`=?,`GENDER`=?,`BIRTHDAY`=?,`BELONGS_TO`=? WHERE `ID` = ?;";
		return super.update(sql, user.getName(), user.getIdentity(), user.getType(), user.getPhone(), user.getIdentity_type(), user.getGender(), user.getBirthday(), user.getBelongs_to(), user.getId());
	}

	@Override
	public User get(String id) {
		String sql = "select `ID`,`NAME`,`GENDER`,`BIRTHDAY`,`IDENTITY`,`PHONE` from `USER` WHERE  `ID` = ?;";	
		return super.get(sql, id);
	}
	
	@Override
	public User get(Connection conn, String id) {
		
		String sql = "select `NAME`,`GENDER`,`BIRTHDAY`,`IDENTITY`,`PHONE` from `USER` WHERE  `ID` = ?;";	

		return super.get(conn, sql, id);
	}

	@Override
	public List<User> getListAll() {
		
		String sql="select `ID`, `NAME`,`GENDER`,`BIRTHDAY`,`IDENTITY`,`PHONE` from `USER` ;";
		return super.getList(sql);
	}

	@Override
	public List<User> getListAll(int gd) {
		String sql="select `ID`, `NAME`,`GENDER`,`BIRTHDAY`,`IDENTITY`,`PHONE` from `USER` WHERE `GENDER` =? ;";
		return super.getList(sql, gd);
	}

	@Override
	public long getCountByName(String username) {
		String sql="SELECT count(`ID`) FROM `USER` WHERE `NAME` = ? ;";
		return (long) super.getValue(sql, username);
	}

	@Override
	public List<User> query(String username, String identity, String phone) {
		String sql = "SELECT `ID`, `NAME`, `IDENTITY`, `TYPE`, `PHONE`, `IDENTITY_TYPE`, `GENDER`, `BIRTHDAY`, `BELONGS_TO` FROM `USER` WHERE 1=1 ";
		if(username != null && !"".equals(username)){
			sql = sql + "  AND NAME LIKE '%"+username+"%'";  
		}
		if(identity != null && !"".equals(identity)){
			sql = sql + "  AND IDENTITY LIKE '%"+identity+"%'";
		}
		if(phone != null && !"".equals(phone)){
			sql = sql + "  AND PHONE LIKE '%"+phone+"%'";
		}
		
		System.out.println(sql);
		return super.getList(sql);
	}

	@Override
	public int updateUserById(User user) {
		String sql="UPDATE `USER` SET `NAME`=?,`IDENTITY`=?,`TYPE`=?,`PHONE`=?,`IDENTITY_TYPE`=?,`GENDER`=?,`BIRTHDAY`=?,`BELONGS_TO`=? WHERE `ID` = ?;";
		return super.update(sql, user.getName(), user.getIdentity(), user.getType(), user.getPhone(), user.getIdentity_type(), user.getGender(), user.getBirthday(), user.getBelongs_to(), user.getId());
	}








}
