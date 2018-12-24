package cn.joyair.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.joyair.mvcproject.utils.JdbcUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * dao层的基本类，被具体的DAO类去继承。
 * @author Administrator
 *
 * @param <T>： 针对将操作各数据表的映射
 */
public class BaseDao<T> {
	
	private static final int ArrayList = 0;

	QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public BaseDao() {
		// 用baseDao的构造方法初始化clazz属性
		//拿到调用者父类的类型，其实就是BaseDao泛型T的具体类型 
		Type superType = this.getClass().getGenericSuperclass();
		if(superType instanceof ParameterizedType) {
			// 父类Type 强转为子类 ParameterizedType，目的是为了调用getActualTypeArguments方法
			ParameterizedType pt = (ParameterizedType) superType;
			Type[] tarry = pt.getActualTypeArguments(); //返回类型数组，第一个元素就是T的类型
			if (tarry[0] instanceof Class) {
				clazz = (Class<T>)tarry[0];
			}
			
		}
	}
	
	
	/**
	 * 
	 * null的位置传入BaseDao<T>里边T真正用 的时候的类型Class T.class  用到反射。
	   *   例如user对象，teacher对象，student对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object... args) {
		Connection conn = null;
		T entity =null;
		try {
			conn = JdbcUtils.getConnection();
			entity =queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		
		return entity;
	}
	
	
	
	/**
	 * 传入conn，可在service层实现事务控制
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	
	public T get(Connection conn , String sql,Object... args) {
		T entity =null;
		try {
			entity =queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		
		return entity;
	}
	
	
	/**
	 * 获取多条记录的通用方法，使用泛型才能实现通用
	 * @return
	 */
	
	public List<T> getList(String sql, Object... args){
		
		Connection conn = null;
		List<T> list = null;
		try {
			conn = JdbcUtils.getConnection();
			list =queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		
		return list;
		
	}
	
	
	/**
	 * 实现insert,update,delete通用更新方法
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql, Object... args) {
		
		Connection conn = null;
		int rows = 0;
		try {
			conn = JdbcUtils.getConnection();
			rows =queryRunner.update(conn, sql, args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		
		return rows;
		
	}
	
	/**
	 * 通用的返回sql语句的结果只有一个数值的类型的查询，用户个数，count(id)
	 * @return
	 */
	public Object getValue(String sql, Object... args) {
		
		Connection conn = null;
		Object obj = null;
		try {
			conn = JdbcUtils.getConnection();
			obj = queryRunner.query(conn, sql, new ScalarHandler<Object>(), args );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConn(conn);
		}
		
		return obj;
		
	}


	
		
	
}
