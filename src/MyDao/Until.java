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
 *���ݿ��������
 */
public class Until {
	/**
	 *��ѯ�����������ݵķ���
	 *��һ��arraylist���ͷ���ֵ
	 */
	public ArrayList<String> selectall(String T_name) throws Exception {
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ���ݿ�����
		ArrayList<String> arrayList = new ArrayList<String>();//����һ��arratlist����
		String sql = "select * from " + T_name;//string���͵�ʧȥ�����
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		ResultSet rSet = pStatement.executeQuery();//ִ��sql���
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
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		return arrayList;
	}
	/**
	 *��ѯClub��������Club��name
	 */
	public ArrayList<String> selectClubName(String name,String T_name) throws Exception {
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		ArrayList<String> arrayList = new ArrayList<String>();//����һ��arraylist����
		String sql = "select "+name+" from " + T_name;//sql���
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡһ������
		ResultSet rSet = pStatement.executeQuery();//ִ��sql���
		while (rSet.next()) {
			arrayList.add(rSet.getString("ST_name"));
		}
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		return arrayList;
	}
	/**
	 *����ÿ��club�ĳ�Ա
	 */
	public ArrayList<String> selectClubpeople(String C_name) throws Exception {
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		ArrayList<String> arrayList = new ArrayList<String>();//����һ��arraylist����
		String sql = "select * from Student where Sxiehui='"+C_name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡһ������
		ResultSet rSet = pStatement.executeQuery();//ִ��sql���
		while (rSet.next()) {
			arrayList.add(rSet.getString(1));
			arrayList.add(rSet.getString(2));
			arrayList.add(rSet.getString(3));
			arrayList.add(rSet.getString(4));
			arrayList.add(rSet.getString(5));
			arrayList.add(rSet.getString(6));
		}
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		return arrayList;
	}
	/**
	 *��ѯStudent���е�����
	 */
	public ArrayList<String> selectpeople(String Sname) throws Exception {
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		ArrayList<String> arrayList = new ArrayList<String>();//����һ��arraylist����
		String sql = "select * from Student where Sname='"+Sname+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡһ������
		ResultSet rSet = pStatement.executeQuery();//ִ��sql���
		while (rSet.next()) {
			arrayList.add(rSet.getString(1));
			arrayList.add(rSet.getString(2));
			arrayList.add(rSet.getString(3));
			arrayList.add(rSet.getString(4));
			arrayList.add(rSet.getString(5));
			arrayList.add(rSet.getString(6));
		}
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		return arrayList;
	}
	/**
	 *club���в�������
	 */
	public void insertClub(String name, String character, String xibie,
			String number, String place, String time, String mainpeople,
			String others1, String others2, String teacher, String jianjie)
			throws Exception {
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		String sql = "insert into Club(ST_name,ST_character,ST_xibie,ST_number,ST_place,ST_time,ST_mainpeople,ST_others1,ST_others2,ST_teacher,ST_jianjie) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡһ������
		pStatement.setString(1, name);//�sql����еģ�
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
		pStatement.execute();//ִ��sql���
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
	}
	/**
	 *student���в�������
	 */
	public void insertStudent(String Sname, String Sno, String Sage,
			String Sclass, String Slike, String Sxiehui) {
		Dao dao;
		try {
			dao = new Dao();//����һ��dao����
			Connection con = dao.getcon();//��ȡ����
			String sql = "insert into Student(Sxiehui,Sname,Sno,Sage,Sclass,Slike) values(?,?,?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, Sxiehui);//�sql����еģ�
			pStatement.setString(2, Sname);
			pStatement.setString(3, Sno);
			pStatement.setString(4, Sage);
			pStatement.setString(5, Sclass);
			pStatement.setString(6, Slike);
			pStatement.execute();//�رն���
			pStatement.close();//�ر�����
			dao.closecon();
			JOptionPane.showMessageDialog(null, "��ӳɹ���");//��Ϣ��ʾ��
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ѧ���ظ�");//��Ϣ��ʾ��
		}
	}
	/**
	 *�޸�student���е�����
	 */
	public void updatepeople(String name,String Sname,String Sno,String Sage,String Sclass,String Slike,String Sxiehui) throws Exception{
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		String sql = "update Student set Sname='"+Sname+"',Sno='"+Sno+"',Sage='"+Sage+"',Sclass='"+Sclass+"',Slike='"+Slike+"',Sxiehui='"+Sxiehui+"' where Sname='"+name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.executeUpdate();//ִ��sql���
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		JOptionPane.showMessageDialog(null, "�޸ĳɹ�");//��Ϣ��ʾ��
	}
	/**
	 *ɾ��student���е�����
	 */
	public void deletepeople(String Sno) throws Exception{
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		String sql = "delete from Student where Sno='"+Sno+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.execute();//ִ��sql���
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		JOptionPane.showMessageDialog(null, "ɾ���ɹ�");//��Ϣ��ʾ��
	}
	/**
	 *club����ɾ����Ϣ
	 */
	public void deleteClub(String ST_name) throws Exception{
		Dao dao = new Dao();//����һ��dao����
		Connection con = dao.getcon();//��ȡ����
		String sql = "delete from Club where ST_name='"+ST_name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.execute();//ִ��sql���
		pStatement.close();//�رն���
		dao.closecon();//�ر�����
		JOptionPane.showMessageDialog(null, "ɾ���ɹ�");//��Ϣ��ʾ��
	}
}
