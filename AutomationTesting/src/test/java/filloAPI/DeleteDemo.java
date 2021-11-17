package filloAPI;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class DeleteDemo {

	public static void main(String[] args) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("D:\\FilloTestData.xlsx");
		
		/*Delete with some condition
		String strQuery = "Delete from Sheet2 where FirstName = 'First4' and Email = '4@gmail.com'";
		connection.executeUpdate(strQuery);
		*/
		
		//Delete the entire table.
		
		String strQuery1 = "Delete from Sheet2";
		connection.executeUpdate(strQuery1);
		
		
		connection.close();

	}

}
