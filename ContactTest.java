package snhu_weekthree.contact;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;



public class ContactTest {

	@Test  //tests all accessor functions run successfully
	public void testGetContactID() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getContactID().equals("1234"));
	}

	@Test
	public void testGetFirstName() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getFirstName().equals("Mark"));
	}

	@Test
	public void testGetLastName() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getLastName().equals("Webb"));
	}

	@Test
	public void testGetPhoneNum() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getPhoneNum().equals("7044871940"));
	}

	@Test
	public void testGetAddress() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getAddress().equals("123 ABC Blvd"));
	}

	@Test //verifies all mutators are successful
	public void testSetFirstName() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getFirstName().equals("Mark"));
		con.setFirstName("David");
		assertTrue(con.getFirstName().equals("David"));
	}

	@Test
	public void testSetLastName() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getLastName().equals("Webb"));
		con.setLastName("Webber");
		assertTrue(con.getLastName().equals("Webber"));
	}

	@Test
	public void testSetPhoneNum() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getPhoneNum().equals("7044871940"));
		con.setPhoneNum("9198675309");
		assertTrue(con.getPhoneNum().equals("9198675309"));	
	}

	@Test
	public void testSetAddress() {
		Contact con = new Contact("1234", "Mark", "Webb", "7044871940", "123 ABC Blvd");
		assertTrue(con.getAddress().equals("123 ABC Blvd"));
		con.setAddress("789 XYZ Lane");
		assertTrue(con.getAddress().equals("789 XYZ Lane"));
	}

	@Test // verifies that error-checking methods throw exceptions when presented with bad input
	public void testCheckID() {
		Contact con = new Contact();
		Assert.assertThrows(RuntimeException.class, () -> {con.checkID(null);}); //null id
		Assert.assertThrows(RuntimeException.class, () -> {con.checkID("12345678901");}); //id too long

	}

	@Test
	public void testCheckFirstName() {
		Contact con = new Contact();
		Assert.assertThrows(RuntimeException.class, () -> {con.checkFirstName(null);}); //null first name
		Assert.assertThrows(RuntimeException.class, () -> {con.checkFirstName("Aleksandersky");}); //first too long

	}

	@Test
	public void testCheckLastName() {
		Contact con = new Contact();
		Assert.assertThrows(RuntimeException.class, () -> {con.checkLastName(null);}); //null last name
		Assert.assertThrows(RuntimeException.class, () -> {con.checkLastName("Aleksandersky");}); //last too long
	}

	@Test
	public void testCheckPhoneNum() {
		Contact con = new Contact();
		Assert.assertThrows(RuntimeException.class, () -> {con.checkPhoneNum(null);}); //null phone num
		Assert.assertThrows(RuntimeException.class, () -> {con.checkPhoneNum("91922492420");}); //phone too long
		Assert.assertThrows(RuntimeException.class, () -> {con.checkPhoneNum("704487194!");}); //phone contains non-digit characters
	}

	@Test
	public void testCheckAddress() {
		Contact con = new Contact();
		Assert.assertThrows(RuntimeException.class, () -> {con.checkAddress(null);}); //null address
		Assert.assertThrows(RuntimeException.class, () -> {con.checkAddress("Old Trafford, Ferguson Stand, Woodward Out Skybox, First Seat Reserved, Rangnick In Avenue");}); //address too long
	}

}
