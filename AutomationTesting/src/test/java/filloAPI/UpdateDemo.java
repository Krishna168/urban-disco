package filloAPI;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class UpdateDemo {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("D:\\FilloTestData.xlsx");
		
		String strQuery = "Update UserData set Phone = '555666' where FirstName = 'First1' and Email = '7@gmail.com' ";
		connection.executeUpdate(strQuery);
		
		connection.close();

	}

}
