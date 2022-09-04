import java.util.LinkedList;

public class Drug extends Named{
	
	private double price;
	private LinkedList<Drug> conflictingDrugs=new LinkedList<Drug>();
	private double clinicsProfitPercentage;
	
	//constructor (but not used in main)
	public Drug(String name, double price,double clinicsProfitPercentage, LinkedList<Drug> conflictingDrugs) {
		this.name=name;
		this.price=price;
		this.clinicsProfitPercentage=clinicsProfitPercentage;
		this.conflictingDrugs=conflictingDrugs;
	}
	
	//constructor (used in main)
	public Drug(String name, double price,double clinicsProfitPercentage) {
		this.name=name;
		this.price=price;
		this.clinicsProfitPercentage=clinicsProfitPercentage;
	}

	//getters-setters
	public LinkedList<Drug> getConflictingDrugs() {
		return conflictingDrugs;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public void setConflictingDrugs(LinkedList<Drug> conflictingDrugs) {
		this.conflictingDrugs = conflictingDrugs;
	}

	public double getClinicsProfitPercentage() {
		return clinicsProfitPercentage;
	}
	
}
