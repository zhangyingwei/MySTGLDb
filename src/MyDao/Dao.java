package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author fengche
 *���ݷ��ʵ���
 */
public class Dao {
	private Connection con  = null;//����һ�����Ӷ���
	/**
	 *������
	 *�׳�һ���쳣
	 */
	public Dao() throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	/**
	 *��ȡ���ӵķ���
	 *�׳�һ���쳣
	 */
	public Connection getcon() throws Exception{
		con = DriverManager.getConnection("jdbc:odbc:db_stgl","","");
		return con;
	}
	/**
	 *�ر����ӵķ���
	 *�׳�һ���쳣
	 */
	public void closecon() throws Exception{
		this.con.close();
	}
}
