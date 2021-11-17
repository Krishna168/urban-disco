package inheritanceConcept;

public class Developing implements BankingClient,DomainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Developing d=new Developing();
		// Return type for d is Developing, hence it can be able access the developing methods and BankingClient interface as well as DomainClient interface methods.
		d.checkBalance();
		d.payCreditCard();
		d.transferAmount();
		d.login();
		d.investments();
		
		
		//But here the return type for dr is BankingClient, hence it access only the BankingClient methods. 
		BankingClient dr=new Developing();
	//eg: dr.login(); - This is not possible in the dr object.
		dr.checkBalance();
		dr.payCreditCard();
		dr.transferAmount();
		
		
		
		DomainClient ds=new Developing();
		ds.investments();
		
		

	}

	public void payCreditCard() {
		// TODO Auto-generated method stub
		System.out.println("Credit Card is implemented");
		
	}

	public void transferAmount() {
		// TODO Auto-generated method stub
		System.out.println("Transfer Amount is implemented");
		
	}

	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Balance Check is implemented");
		
	}
	public void login()
	{
		System.out.println("login completed");
	}

	public void investments() {
		// TODO Auto-generated method stub
		System.out.println("investment is implemented");
		
	}
	
	}


