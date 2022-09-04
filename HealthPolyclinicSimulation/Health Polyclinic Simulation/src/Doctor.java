import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Doctor extends Named{
	
	private int ID;
	private TreeMap<String, String> schedule=new TreeMap<String,String>();
	private int visitCost;
	private TreeMap<String,Patient> registeredPatients = new TreeMap<String,Patient>();
	private double doctorsProfitPercentage;
	
	//constructor
	public Doctor(String name, int ID, int visitCost,double doctorsProfitPercentage) {
		this.name=name;
		this.ID=ID;
		this.visitCost=visitCost;
		this.doctorsProfitPercentage=doctorsProfitPercentage;
		schedule.put("09.00-09.30","-");
		schedule.put("09.30-10.00","-");
		schedule.put("10.00-10.30","-");
		schedule.put("10.30-11.00","-");
		schedule.put("11.00-11.30","-");
		schedule.put("11.30-12.00","-");
		
		schedule.put("13.30-14.00","-");
		schedule.put("14.00-14.30","-");
		schedule.put("14.30-15.00","-");
		schedule.put("15.00-15.30","-");
		schedule.put("15.30-16.00","-");
		schedule.put("16.00-16.30","-");
		schedule.put("16.30-17.00","-");
	}
	
	//creating arraylist consisting of available hours of doctor to show in registration
	public ArrayList<String> getAvailableHours(){
		ArrayList<String> availableHours=new ArrayList<String>();
		for(Entry<String, String> entry : schedule.entrySet()) {
			if (entry.getValue().equals("-")) {
				availableHours.add(entry.getKey());
			}
		}
		return availableHours;
	}
	
	//getters-setters
	public TreeMap<String,Patient> getRegisteredPatients(){
		return registeredPatients;
	}

	public int getID() {
		return ID;
	}

	public TreeMap<String, String> getSchedule() {
		return schedule;
	}

	public int getVisitCost() {
		return visitCost;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setSchedule(TreeMap<String, String> schedule) {
		this.schedule = schedule;
	}

	public void setVisitCost(int visitCost) {
		this.visitCost = visitCost;
	}

	public double getDoctorsProfitPercentage() {
		return doctorsProfitPercentage;
	}
	
	
	
}
