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
 * dao��Ļ����࣬�������DAO��ȥ�̳С�
 * @author Administrator
 *
 * @param <T>�� ��Խ����������ݱ��ӳ��
 */
public class BaseDao<T> {
	
	private static final int ArrayList = 0;

	QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public BaseDao() {
		// ��baseDao�Ĺ��췽����ʼ��clazz����
		//�õ������߸�������ͣ���ʵ����BaseDao����T�ľ������� 
		Type superType = this.getClass().getGenericSuperclass();
		if(superType instanceof ParameterizedType) {
			// ����Type ǿתΪ���� ParameterizedType��Ŀ����Ϊ�˵���getActualTypeArguments����
			ParameterizedType pt = (ParameterizedType) superType;
			Type[] tarry = pt.getActualTypeArguments(); //�����������飬��һ��Ԫ�ؾ���T������
			if (tarry[0] instanceof Class) {
				clazz = (Class<T>)tarry[0];
			}
			
		}
	}
	
	
	/**
	 * 
	 * null��λ�ô���BaseDao<T>���T������ ��ʱ�������Class T.class  �õ����䡣
	   *   ����user����teacher����student����
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
	 * ����conn������service��ʵ���������
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
	 * ��ȡ������¼��ͨ�÷�����ʹ�÷��Ͳ���ʵ��ͨ��
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
	 * ʵ��insert,update,deleteͨ�ø��·���
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
	 * ͨ�õķ���sql���Ľ��ֻ��һ����ֵ�����͵Ĳ�ѯ���û�������count(id)
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
