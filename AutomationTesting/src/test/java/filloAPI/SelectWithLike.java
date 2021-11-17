package filloAPI;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectWithLike {

	public static void main(String[] args) throws FilloException {
		// TODO Auto-generated method stub
		
		Fillo fillo = new Fillo();
		Connection connection =fillo.getConnection("D:\\FilloTestData.xlsx");
		
		String strQuery ="Select * from UserData where Phone like '%5%' " ;
		Recordset rs = connection.executeQuery(strQuery);
		
		while(rs.next())
		{
			System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		}

	}

}
