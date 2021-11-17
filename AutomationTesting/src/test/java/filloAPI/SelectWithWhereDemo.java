package filloAPI;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectWithWhereDemo {

	public static void main(String[] args) throws FilloException {
		// TODO Auto-generated method stub
		Fillo fillo = new Fillo();
		Connection connection =fillo.getConnection("D:\\FilloTestData.xlsx");
		
		/*Using Single where condition
		String strQuery = "Select * from UserData where FirstName = 'First2'";
		Recordset rs = connection.executeQuery(strQuery);
		*/
		Recordset rs = connection.executeQuery("Select * from UserData").where("FirstName = 'First2'");
		
		while(rs.next())
		{
			System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		}
		System.out.println("***************************************************");
		
		//Using multiple where condition
		/*
		String strQuery1 = "Select * from UserData where FirstName = 'First1' and Email = '7@gmail.com' ";
		Recordset rs1=connection.executeQuery(strQuery1);
		*/
		Recordset rs1=connection.executeQuery("Select * from UserData").where("FirstName = 'First1'").where("Email = '1@gmail.com' ");
		
		
		while(rs1.next())
		{
			System.out.println(rs1.getField("FirstName")+"-----"+rs1.getField("LastName")+"-----"+rs1.getField("Email")+"-----"+rs1.getField("Phone"));
		}
		

	}

}
