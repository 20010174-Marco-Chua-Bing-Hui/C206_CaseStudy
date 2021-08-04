
import java.util.ArrayList;



public class C206_CaseStudy {
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {

		ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
		ArrayList<Categories> categoryList = new ArrayList<Categories>();
		ArrayList<Bid> BidList = new ArrayList<Bid>();
		ArrayList<Item> ItemList = new ArrayList<Item>();
		
		accountList.add(new UserAccount("Anthea", "student", "12345@myrp.edu.sg", "123abc"));
		accountList.add(new UserAccount("Betty", "student", "55647@myrp.edu.sg", "456def"));
		categoryList.add(new Categories("Watch"));
		BidList.add(new Bid(1, "Pokemon", "alice@hotmail.com", "roar@gmail.com", 20.00));
		ItemList.add(new Item("Pokemon", "card", 5.00,"05/11/2021", "25/11/2021",5.00 ));
		
		int option = 0;
		while(option != OPTION_QUIT) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//user account option
				int Useroption = 0;

				while (Useroption != 4) {

					UserAcct();
					Useroption = Helper.readInt("Enter choice > ");

					if (Useroption == 1) {

						C206_CaseStudy.addUserAccount(accountList, null);
						UserAccount c = inputUserAccount();
						C206_CaseStudy.addUserAccount(accountList, c);

					} else if (Useroption == 2) {
						C206_CaseStudy.viewAllUserAccount(accountList);
					}else if (Useroption == 3) {
						C206_CaseStudy.deleteUser(accountList);
					}else if (Useroption == 4) {
						System.out.println("Bye to User Account");
					}
						else {
						System.out.println("Invalid option!");
					}
				}
			}else if (option == 2) {
				//category option

				int Catoption = 0;

				while (Catoption != 4) {

					categoryMenu();
					Catoption = Helper.readInt("Enter choice > ");

					if (Catoption == 1) {

						Categories c= inputCategories();
						C206_CaseStudy.addCategory(categoryList, c);

					} else if (Catoption == 2) {

						C206_CaseStudy.viewAllCategory(categoryList);
						
					}
					else if(Catoption == 3) {
						
						C206_CaseStudy.deleteCategory(categoryList);
						
					}else if (Catoption == 4) {
						System.out.println("Thank you for using Auction! Good Bye!");
					}
					else {
						System.out.println("Invalid Option");
					}
				}
			}else if (option == 3) {
			//item option
				  int itemoption = 0;
				    
			        while (itemoption != 4) {
			    
			          itemMenu();
			          itemoption = Helper.readInt("Enter choice > ");
			    
			          if (itemoption == 1) {
			    
			            Item i = inputItem();
			            C206_CaseStudy.addItem(ItemList, i);
			    
			          } else if (itemoption == 2) {
			            C206_CaseStudy.viewAllItem(ItemList);
			            C206_CaseStudy.retrieveAllItem(ItemList);
			            C206_CaseStudy.retrieveAllItem1(ItemList);
			            
			          
			            
			          }
			          else if(itemoption == 3) {
			            
			            C206_CaseStudy.deleteItem(ItemList);
			            
			          }
			          else {
			            System.out.println("Thank you for using Auction! Good Bye!");
			          }
			        }
			        
			}else if (option == 4) {
				// bid option
				int bidoption = 0;
				while (bidoption != 4) {
					C206_CaseStudy.bidMenu();
					bidoption = Helper.readInt("Enter an option > ");
					if (bidoption == 1) {
						// view all bid
						C206_CaseStudy.viewAllBid(BidList);
					}else if (bidoption == 2) {
						// add bid
						Bid bid1 = C206_CaseStudy.inputBid(BidList, ItemList);
						C206_CaseStudy.addBid(BidList, bid1);
					}else if (bidoption == 3) {
						C206_CaseStudy.deleteBid(BidList);
					}else if (bidoption == 4) {
						System.out.println("Bye to BID service.");
					}else {
						System.out.println("Invalid Option");
					}
				}
			}
		else if (option == OPTION_QUIT){
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}
		}
	}
	//mainMenu
	public static void mainMenu() {
		System.out.println("Campus Online Auction Shop (COAS)");
		System.out.println("1. User Services");
		System.out.println("2. Category Services");
		System.out.println("3. Item Services");
		System.out.println("4. Bid Services");
		System.out.println("5. Quit");
	}
	
	//UserAccount
	public static void UserAcct() {
		Helper.line(70, "-");
		System.out.println("Select User Account option");
		Helper.line(70, "-");
		System.out.println("1. Add User Account");
		System.out.println("2. View all users");
		System.out.println("3. Delete user based on email");
		System.out.println("4. Quit");
	}

	public static UserAccount inputUserAccount() {
		String name = Helper.readString("Enter user name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter password > ");

		UserAccount cc = new UserAccount(name, role, email, password);
		return cc;

	}

	public static void addUserAccount(ArrayList<UserAccount> accountList, UserAccount cc) {

		accountList.add(cc);
		System.out.println("user added");
	}

	public static String retrieveAllUserAccount(ArrayList<UserAccount> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-10s %-20s %-30s %-20s\n", accountList.get(i).getName(),
					accountList.get(i).getRole(), accountList.get(i).getEmail(), accountList.get(i).getPassword());

		}
		return output;
	}
	

	public static void viewAllUserAccount(ArrayList<UserAccount> accountList) {
		Helper.line(50, "-");
	    System.out.print("User Account List\n");
	    Helper.line(50, "-");
		String output = String.format("%-10s %-20s %-30s %-20s\n", "Name", "Role",
				"Email", "Password");
		 output += retrieveAllUserAccount(accountList);	
		System.out.println(output);
	}
	
	public static void deleteUser(ArrayList<UserAccount> accountList) {
		Helper.line(50, "-");
	    System.out.print("Delete User Account\n");
	    Helper.line(50, "-");
	    String output = String.format("%-10s %-20s %-30s %-20s\n", "Name", "Role",
				"Email", "Password");
	    output += retrieveAllUserAccount(accountList);
	    System.out.println(output);
	    
	    boolean isdelete = false;
	    
	    String searchEmail = Helper.readString("Enter User email that you wish to delete > ");
	    for (int i = 0; i < accountList.size(); i++) {
	    	if (accountList.get(i).getEmail().equalsIgnoreCase(searchEmail)) {
	    		accountList.remove(i);
	    		isdelete = true;
	    		
	    	}
	    	
	    	else {
	    		isdelete = false;
	    	}
	 
	    }
	    if(isdelete == true) {
	    	System.out.println("User account has been deleted");
	    	
	    }
	    
	    else if(isdelete == false) {
	    	System.out.println("Invalid email");
	    }
	}
	//Categories
	public static void categoryMenu() {
		Helper.line(50, "-");
		System.out.println("Select Category option");
		Helper.line(50, "-");
		System.out.println("1. Add Category(name)");
		System.out.println("2. View all categories");
		System.out.println("3. Delete category based on name");
		System.out.println("4. Quit");
	}
	
	public static Categories inputCategories() {
		String name = Helper.readString("Enter Name > ");
		
		Categories c = new Categories(name);
		return c;
		
	}	
	
	public static void addCategory(ArrayList<Categories> categoryList, Categories c) {
		
		categoryList.add(c);
		System.out.println("Category added");
		
	}
	
	public static String retrieveAllCategory(ArrayList<Categories> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

			output += String.format("%d. %s\n", (i+1), categoryList.get(i).getName());
					
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<Categories> categoryList) {
		
		Helper.line(50, "-");
		System.out.print("Category List\n");
		Helper.line(50, "-");
		
		String output = retrieveAllCategory(categoryList);	
		System.out.println(output);
	}
	
	public static void deleteCategory(ArrayList<Categories> categoryList) {
		String output = retrieveAllCategory(categoryList);
		System.out.print(output);
		
		String deleteName = Helper.readString("Enter the name of the category you wish to delete > ");
		
		boolean isDelete = false;
		
		for(int i = 0; i < categoryList.size(); i++) {
			if(deleteName.equalsIgnoreCase(categoryList.get(i).getName())) {
				categoryList.remove(i);
				isDelete = true;
				
			}
			else {
				isDelete = false;
				
			}
		}
		if (isDelete == true) {
			System.out.println("Category Successfully deleted!");
			
		}
		else if(isDelete == false) {
			System.out.println("Invalid Name entered!");
		}
		
	}
	//item
		public static void itemMenu() {
			Helper.line(70, "-");
			System.out.println("SELECT item option");
			Helper.line(70, "-");
			System.out.println("1. Add New Item");
			    System.out.println("2. View all Item ");
			    System.out.println("3. Delete Item based on Name ");
			    System.out.println("4. Quit");
			  }


			public static String showAvailability(boolean isAvailable) {
			    String avail;

			    if (isAvailable == true) {
			      avail = "yes";
			    } else {
			      avail = "no";
			    }
			    return avail;
			  }

			  public static Item inputItem() {
			    String iname = Helper.readString("Enter item name >");
			    String descrip = Helper.readString("Enter item description >");
			    double minbids = Helper.readDouble("Enter minimum bid ($10) > ");
			    double bids = Helper.readDouble("Enter bid increment > ");
			    String sdate = Helper.readString("Enter Bidding start date >");
			    String edate = Helper.readString("Enter bidding end date >");

			    Item ni = new Item(iname, descrip, bids, edate, sdate, minbids);
			    return ni;

			  }

			  public static void addItem(ArrayList<Item> ItemList, Item ni) {

			    ItemList.add(ni);

			    System.out.println("Item has been added");
			  }

			  // view item list
			  
			  public static String retrieveAllItem(ArrayList<Item> ItemList) {
			      String output = "";

			      for (int i = 0; i < ItemList.size(); i++) {


			      output += String.format("%-20s %-20s %-20.2f %-20s %-20s %.2f\n", ItemList.get(i).getItemname(),
			              ItemList.get(i).getDesc(), ItemList.get(i).getMinBid(), ItemList.get(i).getStartDate(),
			              ItemList.get(i).getEndDate(), ItemList.get(i).getBidIncre());
			      C206_CaseStudy.showAvailability(ItemList.get(i).getItemname(),
			    ItemList.get(i).getDesc(), i, output, output, i);
			      }
			      return output;
			    }
			    
			   
			  public static void viewAllItem(ArrayList<Item> ItemList) {
			      
			      Helper.line(50, "-");
			      System.out.print("Item List\n");
			      Helper.line(50, "-");
			      
			      String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "ITEM NAME", "ITEM DESCRIPTION", "MINIMUM BID", "START DATE", "END DATE", "Bid Increment");
			      output += retrieveAllItem(ItemList);
			      System.out.println(output);
			      
			    }
			  
			  public static String retrieveAllItem1(ArrayList<Item>ItemList) {
			    String output = "";
			    
			    // write your code here
			    
			    for (int i = 0; i < ItemList.size(); i++) {
			      
			      output += String.format("%-20s %-20s %-20.2f %-20s %-20s %-20.2f\n"
			          , ItemList.get(i).getItemname(),  
			          ItemList.get(i).getDesc(),ItemList.get(i).getMinBid(),ItemList.get(i).getStartDate(),ItemList.get(i).getEndDate(),ItemList.get(i).getBidIncre());
			    
			    

			    }
			    return output;
			    }

			  
			  
			  
			  
			  private static void showAvailability(String itemname, String desc,double minbid,String StartDate,String EndDate, double BidIncre) {
			  // TODO Auto-generated method stub
			  
			}
			public static void deleteItem(ArrayList<Item> ItemList) {
			    Helper.line(50, "-");
			    System.out.println("Delete Auction Item");
			    Helper.line(50, "-");
			    
			    String find = Helper.readString("Enter Item Name> ");

			    boolean isDelete = false;
			    
			    for(int i = 0; i < ItemList.size(); i++) {
			      if(ItemList.get(i).getItemname().equalsIgnoreCase(find)) {
			        ItemList.remove(i);
			        isDelete = true;
			      }
			      else {
			        isDelete = false;
			      }
			      
			    }
			    if(isDelete == true) {
			      System.out.println("Item Successfully deleted!");
			      
			    }
			    else if(isDelete == false) {
			      System.out.println("Invalid Item Name!");
			    }

			  }

			
	// bid
	public static void bidMenu() {
		Helper.line(50, "-");
		System.out.println("BID Option");
		Helper.line(50, "-");
		System.out.println("1. View all bids");
		System.out.println("2. Add bid");
		System.out.println("3. Delete bid based on ID");
		System.out.println("4. Quit");
	}
	public static String retrieveAllBid(ArrayList<Bid> BidList) {
		String output = "";
		// write your code here
		for (int i = 0; i < BidList.size(); i++) {

			output += String.format("%-10d %-20s %-20s %-20s %.2f\n", BidList.get(i).getBidId(), BidList.get(i).getName(),
			          BidList.get(i).getSellerEmail(), BidList.get(i).getBuyerEmail(), BidList.get(i).getBidPrice());
		}
		return output;
	}
public static void viewAllBid(ArrayList<Bid> BidList) {
		Helper.line(50, "-");
		System.out.println("BID LIST");
		Helper.line(50, "-");
		String output = String.format("%-10s %-20s %-20s %-20s %s\n", "Bid ID", "Item Name",
		          "Seller Email", "Buyer Email", "Current Bid Price($)");
		 output += retrieveAllBid(BidList);
		System.out.println(output);
	}
	
	public static boolean isValidBid(ArrayList<Bid> BidList, double price, ArrayList<Item> ItemList) {
		boolean isValid = false;
		for (int x = 0;x < ItemList.size(); x++) {
			for (int i = 0; i < BidList.size(); i++) {
				if (price > BidList.get(i).getBidPrice() + ItemList.get(x).getBidIncre() && price > ItemList.get(x).getMinBid()) {
					isValid = true;
				}
			}
		}
		return isValid;
	}
	public static Bid inputBid(ArrayList<Bid> BidList, ArrayList<Item> ItemList) {
		int ID = Helper.readInt("Enter Bids ID > ");
		String name = Helper.readString("Enter Item name > ");
		String buyerEmail = Helper.readString("Enter Buyer email > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		double price = Helper.readDouble("Enter Bids price > $");
		boolean isValid = isValidBid(BidList, price, ItemList);
		
		if (isValid == true) {
			Bid bid1 = new Bid(ID, name, buyerEmail, sellerEmail, price);
			return bid1;
		}else {
			return null;
		}
	}
	public static void addBid(ArrayList<Bid> BidList, Bid bid1) {

		BidList.add(bid1);
		System.out.println("Bid added");
	}
	
	public static void deleteBid(ArrayList<Bid>BidList) {
		Helper.line(50, "-");
		System.out.println("DELETE BID");
		Helper.line(50, "-");
		int searchID = Helper.readInt("Enter bid ID > ");
		boolean isDeleted = false;
		for (int i = 0; i < BidList.size();i++) {
			if (BidList.get(i).getBidId() == searchID) {
				BidList.remove(i);
				isDeleted = true;
			}else {
				isDeleted = false;
			}
					
		}if (isDeleted == true) {
			System.out.println("Bid has been deleted successfully");
		}else if (isDeleted == false) {
			System.out.println("Bid has not been deleted successfully");
		}
	}
}
