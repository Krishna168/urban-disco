package demo;

public class childEmirates extends ParentAirCraft {

	public static void main(String[] args) {
		childEmirates cd=new childEmirates();
		cd.engine();
		cd.safetyGuidelines();
		cd.bodyColour();
		
		//ParentAirCraft pac=new ParentAirCraft(); the abstract class cannot be instantiated.

	}

	@Override
	public void bodyColour() {
		System.out.println("red colour is implemented on body");
		
	}

}
