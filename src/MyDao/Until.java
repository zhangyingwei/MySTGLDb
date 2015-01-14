package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;
import javax.crypto.spec.PSource;
import javax.swing.JOptionPane;
/**
 * @author fengche
 *数据库操作的类
 */
public class Until {
	/**
	 *查询表内所有内容的方法
	 *又一个arraylist类型返回值
	 */
	public ArrayList<String> selectall(String T_name) throws Exception {
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取数据库连接
		ArrayList<String> arrayList = new ArrayList<String>();//声明一个arratlist对象
		String sql = "select * from " + T_name;//string类型的失去了语句
		PreparedStatement pStatement = con.prepareStatement(sql);//获取连接
		ResultSet rSet = pStatement.executeQuery();//执行sql语句
		while (rSet.next()) {
			arrayList.add(rSet.getString(1));
			arrayList.add(rSet.getString(2));
			arrayList.add(rSet.getString(3));
			arrayList.add(rSet.getString(4));
			arrayList.add(rSet.getString(5));
			arrayList.add(rSet.getString(6));
			arrayList.add(rSet.getString(7));
			arrayList.add(rSet.getString(8));
			arrayList.add(rSet.getString(9));
			arrayList.add(rSet.getString(10));
			arrayList.add(rSet.getString(11));
		}
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		return arrayList;
	}
	/**
	 *查询Club表内所有Club的name
	 */
	public ArrayList<String> selectClubName(String name,String T_name) throws Exception {
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		ArrayList<String> arrayList = new ArrayList<String>();//声明一个arraylist对象
		String sql = "select "+name+" from " + T_name;//sql语句
		PreparedStatement pStatement = con.prepareStatement(sql);//获取一个对象
		ResultSet rSet = pStatement.executeQuery();//执行sql语句
		while (rSet.next()) {
			arrayList.add(rSet.getString("ST_name"));
		}
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		return arrayList;
	}
	/**
	 *遍历每个club的成员
	 */
	public ArrayList<String> selectClubpeople(String C_name) throws Exception {
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		ArrayList<String> arrayList = new ArrayList<String>();//声明一个arraylist对象
		String sql = "select * from Student where Sxiehui='"+C_name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取一个对象
		ResultSet rSet = pStatement.executeQuery();//执行sql语句
		while (rSet.next()) {
			arrayList.add(rSet.getString(1));
			arrayList.add(rSet.getString(2));
			arrayList.add(rSet.getString(3));
			arrayList.add(rSet.getString(4));
			arrayList.add(rSet.getString(5));
			arrayList.add(rSet.getString(6));
		}
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		return arrayList;
	}
	/**
	 *查询Student表中的数据
	 */
	public ArrayList<String> selectpeople(String Sname) throws Exception {
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		ArrayList<String> arrayList = new ArrayList<String>();//声明一个arraylist对象
		String sql = "select * from Student where Sname='"+Sname+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取一个对象
		ResultSet rSet = pStatement.executeQuery();//执行sql语句
		while (rSet.next()) {
			arrayList.add(rSet.getString(1));
			arrayList.add(rSet.getString(2));
			arrayList.add(rSet.getString(3));
			arrayList.add(rSet.getString(4));
			arrayList.add(rSet.getString(5));
			arrayList.add(rSet.getString(6));
		}
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		return arrayList;
	}
	/**
	 *club表中插入数据
	 */
	public void insertClub(String name, String character, String xibie,
			String number, String place, String time, String mainpeople,
			String others1, String others2, String teacher, String jianjie)
			throws Exception {
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		String sql = "insert into Club(ST_name,ST_character,ST_xibie,ST_number,ST_place,ST_time,ST_mainpeople,ST_others1,ST_others2,ST_teacher,ST_jianjie) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取一个对象
		pStatement.setString(1, name);//填补sql语句中的？
		pStatement.setString(2, character);
		pStatement.setString(3, xibie);
		pStatement.setString(4, number);
		pStatement.setString(5, place);
		pStatement.setString(6, time);
		pStatement.setString(7, mainpeople);
		pStatement.setString(8, others1);
		pStatement.setString(9, others2);
		pStatement.setString(10, teacher);
		pStatement.setString(11, jianjie);
		pStatement.execute();//执行sql语句
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
	}
	/**
	 *student表中插入数据
	 */
	public void insertStudent(String Sname, String Sno, String Sage,
			String Sclass, String Slike, String Sxiehui) {
		Dao dao;
		try {
			dao = new Dao();//声明一个dao对象
			Connection con = dao.getcon();//获取连接
			String sql = "insert into Student(Sxiehui,Sname,Sno,Sage,Sclass,Slike) values(?,?,?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, Sxiehui);//填补sql语句中的？
			pStatement.setString(2, Sname);
			pStatement.setString(3, Sno);
			pStatement.setString(4, Sage);
			pStatement.setString(5, Sclass);
			pStatement.setString(6, Slike);
			pStatement.execute();//关闭对象
			pStatement.close();//关闭连接
			dao.closecon();
			JOptionPane.showMessageDialog(null, "添加成功！");//信息提示框
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "学号重复");//信息提示框
		}
	}
	/**
	 *修改student表中的数据
	 */
	public void updatepeople(String name,String Sname,String Sno,String Sage,String Sclass,String Slike,String Sxiehui) throws Exception{
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		String sql = "update Student set Sname='"+Sname+"',Sno='"+Sno+"',Sage='"+Sage+"',Sclass='"+Sclass+"',Slike='"+Slike+"',Sxiehui='"+Sxiehui+"' where Sname='"+name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取对象
		pStatement.executeUpdate();//执行sql语句
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		JOptionPane.showMessageDialog(null, "修改成功");//信息提示框
	}
	/**
	 *删除student表中的数据
	 */
	public void deletepeople(String Sno) throws Exception{
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		String sql = "delete from Student where Sno='"+Sno+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取对象
		pStatement.execute();//执行sql语句
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		JOptionPane.showMessageDialog(null, "删除成功");//信息提示框
	}
	/**
	 *club表中删除信息
	 */
	public void deleteClub(String ST_name) throws Exception{
		Dao dao = new Dao();//声明一个dao对象
		Connection con = dao.getcon();//获取连接
		String sql = "delete from Club where ST_name='"+ST_name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取对象
		pStatement.execute();//执行sql语句
		pStatement.close();//关闭对象
		dao.closecon();//关闭连接
		JOptionPane.showMessageDialog(null, "删除成功");//信息提示框
	}
}
