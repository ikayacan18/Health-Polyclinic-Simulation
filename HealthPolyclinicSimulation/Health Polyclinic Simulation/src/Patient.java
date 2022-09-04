
public class Patient extends Named implements infoUpdatable,Comparable<Patient>{
	
	private String gender;
	private int age;
	private int tckn;
	private String oldDrugs="";
	private String oldIllnesses="";
	
	//constructor
	public Patient(String name, String gender, int age, int tckn) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.tckn = tckn;
	}
	
	@Override
	public int compareTo(Patient p) {
		if (age > p.age) return 1;
		if (age < p.age) return -1;
		if (age == p.age) {
			return gender.compareTo(p.gender); //Male comes later. (if ages are equal.)
		}
		return 0;
	}
	public String getOldDrugs() {
		return oldDrugs;
	}
	
	//adding drugs
	@Override
	public void addOldDrugs(String drugNames) {
		oldDrugs+=" "+drugNames;
	}
	public String get0ldIllnesses() {
		return oldIllnesses;
	}
	//adding illnesses
	@Override
	public void addOldIllnesses(String illnesses) {
		oldIllnesses+=" "+illnesses;
	}
	
	//other getters-setters
	
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public int getTckn() {
		return tckn;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setTckn(int tckn) {
		this.tckn = tckn;
	}
	
	@Override
	public String toString() {
		return "[Name=" + name + ", Gender=" + gender + ", Age=" + age + ", TCKN=" + tckn + ", Old Drugs="
				+ oldDrugs + ", Old Illnesses=" + oldIllnesses + "]";
	}
	
	
}
