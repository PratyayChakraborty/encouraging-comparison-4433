package masai.com.Utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=new DBUtil().provConnection();
		if(conn==null) {
			System.out.println("Not connected...");
			
		}else {
			System.out.println("Conected...");
		}
	}

}
