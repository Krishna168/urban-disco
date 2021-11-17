package filloAPI;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectDemo {

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("D:\\FilloTestData.xlsx");
		
		String strQuery = "Select * from UserData";
		Recordset rs = connection.executeQuery(strQuery);
		
		List<String> phoneData = new ArrayList();
		
		//Print Total Excel Data
		while(rs.next())
		{
			System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
			phoneData.add(rs.getField("Phone"));
		}
		
		//Read data from the AddedList
		for(String e:phoneData)
		{
			System.out.println("Added data from the List is :\n" + e);
		}
		
		//Total rows in the Excel Sheet
		System.out.println("Total rows in the excel is :" + rs.getCount());
		
		//Get last row data
		rs.moveLast();
		System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		
		//Get previous row data
		rs.movePrevious();
		System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		
		//Get First row data
		rs.moveFirst();
		System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		
		//Get Next row data
		rs.moveNext();
		System.out.println(rs.getField("FirstName")+"-----"+rs.getField("LastName")+"-----"+rs.getField("Email")+"-----"+rs.getField("Phone"));
		
		//Get Total columns in the Excel Sheet
		int totalColumns = rs.getFieldNames().size();
		System.out.println("Total Columns "+ totalColumns );
		
		//Get Column Name
		String colName = rs.getFieldNames().get(0);
		System.out.println("The First Column Name is :" +colName);
		
		
		rs.close();
		connection.close();
	}

}
