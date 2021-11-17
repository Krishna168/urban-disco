package demo;

import interfaces.CentralTraffic;
import interfaces.ContinentalTraffic;

public class AustralianTraffic implements CentralTraffic, ContinentalTraffic {

	public static void main(String[] args) {
		CentralTraffic at=new AustralianTraffic();
		at.Greengo();
		at.YelloWait();
		at.RedStop();
		
		AustralianTraffic ct=new AustralianTraffic();
		ct.trainStop();
		
		ContinentalTraffic ctt=new AustralianTraffic();
		ctt.WalkonCross();
	}

	public void RedStop() {
		System.out.println("redstop is implemented");

	}

	public void Greengo() {
		System.out.println("green go is implemented");

	}

	public void YelloWait() {
		System.out.println("yellow wait is implemented");

	}

	public void WalkonCross() {
		System.out.println("walk on cross is implemented");
	}
	
	public void trainStop()
	{
		System.out.println("trainstop is implemented");
	}

}
