package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author fengche
 *数据访问的类
 */
public class Dao {
	private Connection con  = null;//声明一个连接对象
	/**
	 *主函数
	 *抛出一个异常
	 */
	public Dao() throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	/**
	 *获取连接的方法
	 *抛出一个异常
	 */
	public Connection getcon() throws Exception{
		con = DriverManager.getConnection("jdbc:odbc:db_stgl","","");
		return con;
	}
	/**
	 *关闭连接的方法
	 *抛出一个异常
	 */
	public void closecon() throws Exception{
		this.con.close();
	}
}
