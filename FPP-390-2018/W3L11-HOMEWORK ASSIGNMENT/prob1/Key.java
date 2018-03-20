package prob1;

public class Key {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Key(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	//Override equals
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Key k = (Key) obj;
		return this.firstName.equals(k.firstName) && this.lastName.equals(k.lastName);
	}
	//Override hashCode
	public int hashCode() {
		int result = 17; //seed
		int hashFirst = firstName.hashCode();
		int hashSecond = lastName.hashCode();
		result += 31 * result + hashFirst;
		result += 31 * result + hashSecond;
		return result;
	}
}
