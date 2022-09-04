
/*Super class for Doctor, Patient, Clinic, Drug. They all have name field. By using this superclass
 * I get rid of the need to implement getters and setters for name in those classes.
 */
public class Named {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
