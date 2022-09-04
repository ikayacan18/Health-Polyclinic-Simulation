import java.util.LinkedList;

public class Clinic extends Named{

	
	private LinkedList<Doctor> doctorList;
	
	//constructor (used in main class)
	public Clinic(String name) {
		this.name=name;
		doctorList=new LinkedList<Doctor>();
	}

	//alternative constructor (not used in main class)
	public Clinic(String name, LinkedList<Doctor> doctorList) {
		this.name=name;

		if(doctorList.size()==0) {  //because at least 1 at most 5 doctors.
			doctorList.add(new Doctor("Default Doctor", 132, 10, 0.5));
		}
		else if(doctorList.size()>5) {
			System.out.println("Doctor number cannot be bigger than 5.");
			while(doctorList.size()>5) {
				doctorList.remove(0);
			}
		}

		this.doctorList=doctorList;
	}
	
	
	//Add new doctor to clinic's doctor list
	public void addDoctor(Doctor d) {
		doctorList.add(d);
	}

	//getter-setter
	public LinkedList<Doctor> getDoctorList() {
		return doctorList;
	}
	
	public void setDoctorList(LinkedList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}



}
