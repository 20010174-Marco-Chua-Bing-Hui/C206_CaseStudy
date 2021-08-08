
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private UserAccount ua1;
	private UserAccount ua2;
	
	private Categories c1;
	private Categories c2;
	
	private Item s1;
	private Item s2;
	private Item s3;
	private Item s4;
	
	private bid bid1;
	private bid bid2;
	
	private ArrayList<UserAccount> AccountList;
	
	private ArrayList<Categories> categoryList;
	
	private ArrayList<Item> ItemList;
	
	private ArrayList<bid> BidList;

	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		
		ua1 = new UserAccount("Anthea", "student", "12345@myrp.edu.sg", "123abc");
		ua2 = new UserAccount("Betty", "student", "55647@myrp.edu.sg", "456def");
		
		AccountList = new ArrayList<UserAccount>();
		
		
		c1 = new Categories("Watch");
		c2 = new Categories("Bags");
	
		categoryList= new ArrayList<Categories>();
		
		
		s1 = new Item("Pokemon Card", "Charizard", 50, "22 June 2020", "30 June 2020", 10);
	    s2 = new Item("Gaming Mouse", "Razer", 70, "21 January 2020", "29 January 2020", 10);
	    s3 = new Item("Airpods", "Apple", 150, "15 May 2020", "25 May 2020", 10);
	    s4 = new Item("Gucci", "Cardholder", 200, "2 Feburary 2020", "15 Feburary 2020", 10);

	    ItemList = new ArrayList<Item>();
		
		
		bid1 = new bid(1, "Pokemon", "alice@hotmail.com", "roar@gmail.com", 20.00);
		bid2 = new bid(2, "Ball", "hawt@hotmail.com", "hello@gmail.com", 10.00);
		
		BidList = new ArrayList<bid>();
		
		
	}

//	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
//		assertTrue("C206_CaseStudy_SampleTest ",true);
//	
//	}
	
	@Test
	public void addUserAccountTest() {
		
//      User list is not null, so that can add a new user account - boundary
		assertNotNull("Check if there is valid UserAccount arraylist to add to", AccountList);
		
//		Given an empty list, after adding 1 user, the size of the user list is 1 - normal
		
//		The user which is just added is as same as the first user of the list
		
		C206_CaseStudy.addUserAccount(AccountList, ua1);
		assertEquals("Check that UserAccount arraylist size is 1", 1, AccountList.size());
		assertSame("Check that UserAccount is added", ua1, AccountList.get(0));
		
//		Add another user test the size of the list is 2? -normal
//		The user just added is as same as the second user of the list
		
		C206_CaseStudy.addUserAccount(AccountList, ua2);
		assertEquals("Check that UserAccount arraylist size is 2", 2, AccountList.size());
		assertSame("Check that User is added", ua2, AccountList.get(1));
		
		
	}
	
	@Test
	public void retrieveAllUserAccountTest() {
		
//		Test if UserList is not null but empty - boundary
		assertNotNull("Test if there is valid User Account arraylist to retrieve user account", AccountList);
		
//		Test if the list of user retrieved from the User Account is empty - boundary
		
		String allUser = C206_CaseStudy.retrieveAllUserAccount(AccountList);
		
		String testOutput = "";
		assertEquals("Check that retrieveAllUserAccount", testOutput, allUser);
		
//		Given an empty list, after adding 2 user, test if the size of the User list is 2 - normal
		
		C206_CaseStudy.addUserAccount(AccountList, ua1);
		C206_CaseStudy.addUserAccount(AccountList,ua2);
		
		assertEquals("Test that User Account arraylist size is 2", 2, AccountList.size());
		
//		Test if the expected output string same as the list of User Account retrieved from AccountList
		
		allUser = C206_CaseStudy.retrieveAllUserAccount(AccountList);
		testOutput = String.format("%-10s %-20s %-30s %-20s\n","Anthea", "student", "12345@myrp.edu.sg", "123abc" );
		testOutput += String.format("%-10s %-20s %-30s %-20s\n", "Betty", "student", "55647@myrp.edu.sg", "456def" );
		
		assertEquals("Test that viewAllUserAccount", testOutput, allUser);
		
	}
	
	@Test
	public void deleteUserTest() {
		
//		Test if user list is not null but empty - boundary
		assertNotNull("Test if there is valid User Account arraylist to retrieve user account", AccountList);
		
//		Test if the list of users retrieved from the user list is empty - boundary
	
		assertEquals("Test that userAccountList arrayList size is 0", 0,AccountList.size());
		
//		Given an empty List, after adding 2 user, test if the size of the list is 2 - normal
		
		C206_CaseStudy.addUserAccount(AccountList, ua1);
		C206_CaseStudy.addUserAccount(AccountList, ua2);
		
		assertEquals("Test that UserAccount arraylist size is 2", 2, AccountList.size());
		
//		Test if the user in the list is possible to be deleted 
//		Check if the UserAccount is in the array list is not the deleted one
		
		assertSame("Check that User is added", ua1, AccountList.get(0));
		AccountList.remove(ua1);
		
		assertEquals("Test that User arraylist is 1 ", 1, AccountList.size());
		assertSame("Test that useraccount has only 1 user inside", ua2, AccountList.get(0));
		
	}
	
	
	@Test
	public void addCategoryTest() {
		
//		Category list is not null, so that can add a new Category - boundary
		assertNotNull("Check if there is valid Categories arraylist to add to", categoryList);
		
//		Given an empty Category, after adding 1 Category, the size of the list is 1 - normal
		
//		The Category just added is as same as the first Category of the list
		
		C206_CaseStudy.addCategory(categoryList, c1);
		assertEquals("Check that Catogories arraylist size is 1", 1, categoryList.size());
		assertSame("Check that Catgories is added", c1, categoryList.get(0));
		
//		Add another Category. test the size of the list is 2? -normal
//		The Category just added is as same as the second Category of the list
		
		C206_CaseStudy.addCategory(categoryList, c2);
		assertEquals("Check that Catogories arraylist size is 2", 2, categoryList.size());
		assertSame("Check that Catgories is added", c2, categoryList.get(1));
		
	}
	
	@Test
	public void retrieveAllCategoryTest() {
		
//		Test if Category is not null but empyt - boundary
		assertNotNull("Test if there is valid Categories arraylist to retrieve item", categoryList);
		
//		Test if the list of category retrieved from the Categories is empty - boundary
		
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		
		String testOutput = "";
		assertEquals("Check that viewAllCategory", testOutput, allCategory);
		
//		Given an empty list, after adding 2 Category, test if the size of the Category is 2 - normal
		
		C206_CaseStudy.addCategory(categoryList, c1);
		C206_CaseStudy.addCategory(categoryList, c2);
		
		assertEquals("Test that Categories arraylist size is 2", 2, categoryList.size());
		
//		Test if the expected output string same as the list of category retrieved from categories
		
		allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		testOutput = String.format("%d. %s\n", (1), "Watch");
		testOutput += String.format("%d. %s\n", (2), "Bags");
		
		assertEquals("Test that viewAllCategory", testOutput, allCategory);
		
	}
	
	@Test
	public void deleteCategoryTest() {
		
//		Test if Category is not null but empty - boundary
		assertNotNull("Test if there is valid Categories arraylist to retrieve item", categoryList);
		
//		Test if the list of category retrieved from the Categories is empty - boundary
		
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		
		String testOutput = "";
		assertEquals("Check that viewAllCategory", testOutput, allCategory);
		
//		Given an empty list, after adding 2 Category, test if the size of the list is 2 - normal
		
		C206_CaseStudy.addCategory(categoryList, c1);
		C206_CaseStudy.addCategory(categoryList, c2);
		
		
		assertEquals("Test that Categories arraylist size is 2", 2, categoryList.size());
		
//		Test if the Category in the list is possible to be deleted 
//		Check if the Category is in the array list is not the deleted one
		
		assertSame("Check that Catgories is added", c1, categoryList.get(0));
		categoryList.remove(c1);
		
		assertEquals("Test that Categories arraylist is 1 ", 1, categoryList.size());
		assertSame("Test that Categories has only 1 item inside", c2, categoryList.get(0));
		
	}
	
	@Test
	  public void testAddItem() {
	      //Order list is not null (to add new objects)
	      assertNotNull("Test if there is a valid Item arraylist to add to", ItemList);
	      
	      //Given an empty list, after adding 1 object, size of list will be 1
	      C206_CaseStudy.addItem(ItemList, s1);
	      assertEquals("Test if the Item arraylist size is 1: ", 1, ItemList.size());

	      //Add another object. Is the size of the list is 2?
	      C206_CaseStudy.addItem(ItemList, s2);
	      assertEquals("Test if the Item arraylist size is 2: ", 2, ItemList.size());
	  }
	
	@Test
    public void testRetrieveAllItem() {
    // test if Item list is not null but empty, so that can add new Item
    assertNotNull("Test if there is valid Item arraylist to add to ", ItemList);
    
    // test if the list of Item retrieved from the ItemList is empty
    
    String allItem = C206_CaseStudy.retrieveAllItem(ItemList);
    String  testOutput ="";
    assertEquals("Check ViewAllItemList", testOutput, allItem);
    
    //Given an empty list, after adding 2 Items , test if the size of the list is 2 
    C206_CaseStudy.addItem(ItemList, s1);
    C206_CaseStudy.addItem(ItemList, s2);
    assertEquals("Test if that Item arraylist size is 2?", 2, ItemList.size());
    
    //test if the expected output string same as the list of Items retrieved from the Item_test
    allItem = C206_CaseStudy.retrieveAllItem(ItemList);
    
  }
	
	@Test
	  public void testviewAllItem() {
	    //Test that ItemList is not null before viewing orders
	    assertNotNull("Test if there is a valid Item arraylist to view",ItemList);
	    
	    //Given an empty list, after adding 2 items, test if the size of the list is 2
	    C206_CaseStudy.addItem(ItemList, s1);
	    C206_CaseStudy.addItem(ItemList, s2);
	    assertEquals("Test if that Item arraylist size is 2: ", 2, ItemList.size());
	    
	    //test if the expected output string same as the list of orders retrieved from the C206_CaseStudy
	    String allItem = C206_CaseStudy.retrieveAllItem(ItemList);
	    String testOutput = "";
	    allItem = C206_CaseStudy.retrieveAllItem(ItemList);
	    testOutput = String.format("%-10s %40s %-10.f %-10s %-10s %-10.f\n",  "Pokemon Card", "Charizard", 50, "22 June 2020", "30 June 2020", 10);
	    testOutput += String.format("%-10s %40s\n", "Gaming Mouse", "Razer", 70, "21 January 2020", "29 January 2020", 10);
	    assertEquals("Check that getItem", testOutput, allItem);
	  }
	
	@Test
	  public void testdeleteItem() {
	      C206_CaseStudy.addItem(ItemList, s1);
	      C206_CaseStudy.addItem(ItemList, s2);
	      
	      //Test that ItemList is not null before deleting items
	      assertNotNull("Test if there is a valid Item arraylist to delete from", ItemList);
	      
	      //Test that ItemList has 1 object after deleting one item
	      C206_CaseStudy.deleteItem(ItemList);
	      assertEquals("Test if CustomerOrder arraylist has 1 object: " , 1, ItemList.size());
	      
	      //Test that orderList is empty after deleting second order
	      C206_CaseStudy.deleteItem(ItemList);
	      assertEquals("Test if Itemarraylist is empty: " , 0, ItemList.size());
    }
	
	@Test
	  public void retrieveAllBidTest() {
	   // Done by Marco
	   // Test if Bid list is not null but empty, so that can add a new bid - boundary
	    assertNotNull("Test if there is valid Bid arraylist to add to", BidList);
	    
		//test if the list of bids retrieved from the Auction Shop is empty - boundary
		String allBids= C206_CaseStudy.retrieveAllBid(BidList);
		String testOutput = "";
		assertEquals("Check that viewAllBid", testOutput, allBids);
		//Given an empty list, after adding 2 bids, test if the size of the list is 2 - normal
		C206_CaseStudy.addBid(BidList, bid1);
	    C206_CaseStudy.addBid(BidList, bid2);
	    assertEquals("Test that Bid arraylist size is 2", 2, BidList.size());
	   
	   
	}
	
	@Test
	public void addBidtest() {
		// bid list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid bid arraylist to add to", BidList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addBid(BidList, bid1);		
		assertEquals("Test that bid arraylist size is 1", 1, BidList.size());
		assertSame("Test that bid is added", bid1, BidList.get(0));
		
		  //Add another bid. test The size of the list is 2? - normal
		  //The bid just added is as same as the second bid of the list
		  C206_CaseStudy.addBid(BidList, bid2);
		  assertEquals("Test that bid arraylist size is 2", 2, BidList.size());
		  assertSame("Test that bid is added", bid2, BidList.get(1));
		  
	}
	
	@Test
	public void DeleteBidTest() {
	    //Done by Marco
	    // Test if bid list is not null but empty, so that can add a new bid
	    assertNotNull("Test if there is valid Bid arraylist to add to", BidList);
	    
	    BidList.add(bid1);
	    BidList.add(bid2);
	    assertEquals("Test if that Bid arraylist size is 2?", 2, BidList.size());
	    
	    BidList.remove(0);
	    assertEquals("Test if that Bid arraylist size is 1?", 1, BidList.size());    
	  }
	
	
	
	@After
	public void tearDown() throws Exception {
		
		ua1 = null;
		ua2 = null;
		AccountList = null;
		
		c1 = null;
		c2 = null;
		categoryList = null;
		
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		ItemList = null;
		
		bid1 = null;
		bid2 = null;
		BidList = null;
	}
}

