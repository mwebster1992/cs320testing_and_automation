package snhu_weekthree.contact;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class ContactServiceTest {

	@Test
	public void addContactTest() {
		ContactService cs = new ContactService();
		
		cs.addContact("1234567890", "Mark", "Webster", "9192249242", "2004 Homestead Road");			
		assertFalse(cs.contactsList.isEmpty());
		assertTrue(cs.contactsList.containsKey("1234567890"));
		
		assertTrue(cs.contactsList.get("1234567890").getFirstName().equals("Mark")); //verifying that contact info equals what we passed in
		assertTrue(cs.contactsList.get("1234567890").getLastName().equals("Webster"));			
		assertTrue(cs.contactsList.get("1234567890").getPhoneNum().equals("9192249242"));
		assertTrue(cs.contactsList.get("1234567890").getAddress().equals("2004 Homestead Road"));
	}

	@Test
	public void addContactThrowsExceptionsForBadInput() {
		ContactService cs = new ContactService();
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact(null, "Mark", "Webster", "9192249242", "2004 Homestead Road");}); // null id
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", null, "Webster", "9192249242", "2004 Homestead Road");}); // null first name
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", null, "9192249242", "2004 Homestead Road");}); // null last name
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", "Webster", null, "2004 Homestead Road");}); // null phone num
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", "Webster", "9192249242", null);}); // null address
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("12345678901", "Mark", "Webster", "9192249242", "2004 Homestead Road");}); // ID too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Alexanderovksy", "Webster", "9192249242", "2004 Homestead Road");}); // first name too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", "Websterovsky", "9192249242", "2004 Homestead Road");}); //last name too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", "Webster", "91922492420", "2004 Homestead Road");}); //phone too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.addContact("1234567890", "Mark", "Webster", "9192249242", "2004 Homestead Road at the corner of happy and healthy in NC, SC, and GA");});	//addrss too long	
	}
	
	@Test
	public void deleteContactTest() {
		ContactService cs = new ContactService();
		cs.addContact("1234", "Mark", "Webster", "9192249242", "2004 Homestead Road");	//adds
		assertFalse(cs.contactsList.isEmpty()); // verifies add to map
		assertTrue(cs.contactsList.containsKey("1234")); // verifies key is in map
		cs.deleteContact("1234");
		assertFalse(cs.contactsList.containsKey("1234")); // verifies key is no longer in map
	}
	
	@Test
	public void deleteContactThrowsExceptionForEmptyOrNonExistent() {
		ContactService cs = new ContactService();
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.deleteContact("1234567890");}); // contact list is empty
		
		cs.addContact("1234", "Mark", "Webster", "9192249242", "2004 Homestead Road");	//contact added
		assertFalse(cs.contactsList.isEmpty());
		assertTrue(cs.contactsList.containsKey("1234"));
	
		Assert.assertThrows(RuntimeException.class, () -> {cs.deleteContact("1234567890");}); // contact list has objects, but not one with matching ID

	}
	
	@Test
	public void updatecontactTest() {
		ContactService cs = new ContactService();
		
		cs.addContact("1234567890", "Mark", "Webster", "9192249242", "2004 Homestead Road");	//initial contact		
		assertFalse(cs.contactsList.isEmpty());
		assertTrue(cs.contactsList.containsKey("1234567890"));
		
		cs.updateContact("1234567890", "Tim", "Lebron", "9196547890", "123 Peacock Ave"); // contact with updated info
		
		assertFalse(cs.contactsList.get("1234567890").getFirstName().equals("Mark")); // verifying contact doesn't have old info
		assertFalse(cs.contactsList.get("1234567890").getLastName().equals("Webster"));
		assertFalse(cs.contactsList.get("1234567890").getPhoneNum().equals("9192249242"));
		assertFalse(cs.contactsList.get("1234567890").getAddress().equals("2004 Homestead Road"));

		assertTrue(cs.contactsList.get("1234567890").getFirstName().equals("Tim")); // verifying contact has new info
		assertTrue(cs.contactsList.get("1234567890").getLastName().equals("Lebron"));
		assertTrue(cs.contactsList.get("1234567890").getPhoneNum().equals("9196547890"));
		assertTrue(cs.contactsList.get("1234567890").getAddress().equals("123 Peacock Ave"));		
	}

	@Test
	public void updateContactThrowsExceptionsforBadInput() {
		ContactService cs = new ContactService();
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Alexanderovksy", "Webster", "9192249242", "2004 Homestead Road");}); // contact list is empty
		
		cs.addContact("1234567890", "Mark", "Webster", "9192249242", "2004 Homestead Road");	//adding initial contact		
		assertFalse(cs.contactsList.isEmpty());
		assertTrue(cs.contactsList.containsKey("1234567890"));
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234", "Ivy", "Greer", "9192349245", "1789 Homefront Lane");}); // contact doesn't exist
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", null, "Webster", "9192249242", "2004 Homestead Road");}); // null first name
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", null, "9192249242", "2004 Homestead Road");}); // null last name
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", "Webster", null, "2004 Homestead Road");}); // null phone num
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", "Webster", "9192249242", null);}); // null address
		
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Alexanderovksy", "Webster", "9192249242", "2004 Homestead Road");}); // first name too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", "Websterovsky", "9192249242", "2004 Homestead Road");}); //last name too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", "Webster", "91922492420", "2004 Homestead Road");}); //phone too long
		Assert.assertThrows(RuntimeException.class, () -> {cs.updateContact("1234567890", "Mark", "Webster", "9192249242", "2004 Homestead Road at the corner of happy and healthy in NC, SC, and GA");});	//addrss too long	
	}
	
}
