package filloAPI;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class InsertDemo {

	public static void main(String[] args) throws FilloException {
		
		
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("D:\\FilloTestData.xlsx");
		
		String strQuery = "Insert into UserData(FirstName,LastName,Phone,Email) values('First8','Last8','888888888','8@gmail.com')";
		connection.executeUpdate(strQuery);
		
		connection.close();

	}

}
