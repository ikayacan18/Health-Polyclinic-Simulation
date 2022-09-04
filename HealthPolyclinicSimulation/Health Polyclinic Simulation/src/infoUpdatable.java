//Patient implements this interface because its drug and illness data are updatable.
public interface infoUpdatable {
	public void addOldDrugs(String drugNames);
	public void addOldIllnesses(String illnesses);
}
