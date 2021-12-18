package snhu_weekthree.contact;

import java.util.HashMap;
import java.util.Map;


public class ContactService {

		Map<String, Contact> contactsList = new HashMap<String, Contact>();
		
		public void addContact(String contactID, String firstName, String lastName, String phoneNum, String address) {
			checkForDuplicate(contactID);
			Contact con = new Contact(contactID, firstName, lastName, phoneNum, address);
			contactsList.put(contactID, con);	
		}
		

		public void checkForDuplicate(String cID) {
			if(contactsList.containsKey(cID)) {
				throw new RuntimeException("This contact already exists!");
			}
			else {
				return;
			}
		}
		
		public void deleteContact(String cID) {
			if(!contactsList.containsKey(cID)) {
				throw new RuntimeException("Contact not found!");
			}
			else if(contactsList.isEmpty()) {
				throw new RuntimeException("Contacts List is Empty!");
			}
			else {
				contactsList.remove(cID);
			}
		}
		
		public void updateContact(String cID, String first, String last, String phone, String addrss) {
			if(!contactsList.containsKey(cID)) {
				throw new RuntimeException("Contact not found!");
			}
			else if(contactsList.isEmpty()) {
				throw new RuntimeException("Contacts List is Empty!");
			}					
			else {
				contactsList.get(cID).checkFirstName(first);
				contactsList.get(cID).checkLastName(last);
				contactsList.get(cID).checkPhoneNum(phone);
				contactsList.get(cID).checkAddress(addrss);
				
				contactsList.get(cID).setFirstName(first);
				contactsList.get(cID).setLastName(last);
				contactsList.get(cID).setPhoneNum(phone);
				contactsList.get(cID).setAddress(addrss);
			}
		}
		
		
		

}
