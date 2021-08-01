import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_END = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
		
		accountList.add(new UserAccount("Anthea", "student", "12345@myrp.edu.sg", "123abc"));
		accountList.add(new UserAccount("Betty", "student", "55647@myrp.edu.sg", "456def"));
		accountList.add(new UserAccount("Admin", "admin", "admin@myrp.edu.sg", "789ghi"));
		
		int option = OPTION_END;
		
		while (option == OPTION_END) {

			mainMenu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {

				register(accountList);
				
			} else if (option == 2) {
				UserAccount loginAcct = getLoginAccount(accountList);

				if (loginAcct != null) {
					if (loginAcct.getName() == "Admin") {
						runAdminProcess(accountList);
					} else {
						runSavingsProcess(loginAcct);
					}
				}
			} 
			else if (option == OPTION_END){
				System.out.println("Thank you for using Auction!");
			}
			else {
				System.out.println("Invalid option!");
			}
		}
	
	}
	private static void mainMenu() {
		Helper.line(70,  "-");
		System.out.println("Welcome to Auction!");
		Helper.line(70, "-");
		System.out.println("1. Register");
		System.out.println("2. Log in");
		System.out.println("3. Quit");
		
	}
	private static void memberMenu() {
		
		Helper.line(70, "-");
		System.out.println("Select student option ");
		Helper.line(70, "-");
		System.out.println("1. View all category ");
		System.out.println("2. View all items ");
		System.out.println("3. Show all bids ");
		System.out.println("4. Quit ");
	}
	
	public static void adminMenu() {
		Helper.line(70, "-");
		System.out.println("Select admin option ");
		Helper.line(70, "-");
		System.out.println("1. Add user account ");
		System.out.println("2. View all user ");
		System.out.println("3. Delete user based on email ");
	}
	
	public 
	


}
