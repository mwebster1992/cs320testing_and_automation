package snhu_weekthree.contact;

public class Contact {

	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
//Constructors
	
	Contact() {
		this.contactID = null;
		this.firstName = null;
		this.lastName = null;
		this.phoneNum = null;
		this.address = null;
	}
	
	Contact(String ID, String first, String last, String phone, String addrss) {
		checkID(ID);
		checkFirstName(first);
		checkLastName(last);
		checkPhoneNum(phone);
		checkAddress(addrss);
		
		this.contactID = ID;
		this.firstName = first;
		this.lastName = last;
		this.phoneNum = phone;
		this.address = addrss;
	}
	
	public String getContactID() {  //accessors
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNum() {
		return this.phoneNum;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setFirstName(String first) {  //mutators
		this.firstName = first;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public void setPhoneNum(String phone) {
		this.phoneNum = phone;
	}
	
	public void setAddress(String addrss) {
		this.address = addrss;
	}
	
	public void checkID(String cID) { //error-checking methods
		if(cID.isBlank()) {
			throw new RuntimeException("Contact ID cannot be empty");
		}
		else if(cID.length() > 10) {
			throw new RuntimeException("Contact ID cannot be longer than 10 characters");
		}
		else {
			return;
		}
	}
	
	public void checkFirstName(String first) { 
		if(first.isBlank()) {
			throw new RuntimeException("First name cannot be empty");
		}
		else if(first.length() > 10) {
			throw new RuntimeException("First name cannot be longer than 10 characters");
		}
		else {
			return;
		}
	}
	
	public void checkLastName(String last) {
		if(last.isBlank()) {
			throw new RuntimeException("Last name cannot be empty");
		}
		else if(last.length() > 10) {
			throw new RuntimeException("Last name cannot be longer than 10 characters");
		}
		else {
			return;
		}
	}
	
	public void checkPhoneNum(String phone) {
		if(phone.isBlank()) {
			throw new RuntimeException("Phone number cannot be empty");
		}	
		if((phone.length() > 10) || (phone.length() < 10)) {
			throw new RuntimeException("Phone number cannot be longer or shorter than ten digits");
		}
		for(int i = 0; i <= (phone.length() - 1); i++) {
			char phoneChar = phone.charAt(i);
			if(!Character.isDigit(phoneChar)) {
				throw new RuntimeException("Phone number can only contain digits");
			}
		}
	}
	
	public void checkAddress(String addrss) {
		if(addrss.isBlank()) {
			throw new RuntimeException("Address cannot be empty");
		}
		else if(addrss.length() > 30) {
			throw new RuntimeException("Address cannot be longer than 30 characters");
		}	
		else {
			return;
		}
	}
	
}
