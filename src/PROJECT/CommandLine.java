package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Islands;
import core.Item;
import core.Player;
import core.Route;
import core.Ship;
import core.Stores;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// this be changed
public class CommandLine 
{
	private final ArrayList<Islands> islands;
	private final ArrayList<Ship> ships;
	private final ArrayList<String> options;
	private final Player player;
	private Islands currentIsland;
	private final Ship ship;
	private final Scanner scanner = new Scanner(System.in);
	private final int totalRemainingDay;
	private final ArrayList<Upgrade> upgrades;


       

	public CommandLine(ArrayList<Islands> islands,ArrayList<Ship> ships, ArrayList<Upgrade> upgrades, ArrayList<String> options) 
	{
		this.islands = islands;
		this.ships = ships;
		this.options = options;
		this.upgrades = upgrades;
		String playerName = getName();
		totalRemainingDay = getDays();
		currentIsland = chooseHomeIsland();
		ship = chooseShip();	//Need you to finish the function, you can use homeIsland as reference
		player = new Player(playerName, totalRemainingDay, ship, currentIsland);
		
	}
	
	
	
	// This one I changed.
	public void start()
	{
		
		int play = -1;
		while(player.remainingDays() > 0)//May need updating
		{	
			play = playGame(options,player);
			if (play == 1){chooseIsland(player);}
			else if (play == 2){checkTradingOptions(islands);}
			else if (play == 3){tradeGoods(currentIsland);}
			else if (play == 4){System.out.println(ship.getShipConditon());}
			else if (play == 5){System.out.println(String.format("Ships remainig cargo capicity is %d Kilograms", ship.getRemainingCapicity()));}
			else if (play == 6){System.out.println(String.format("There are %d days left",player.remainingDays()));}
			else if (play == 7){System.out.println(String.format("You currently have %d gold bars",player.getBalance()));}
			else if (play == 8){checkShipCargo();}
			else if (play == 9){checkTransections();}
			else if (play == 10){repairShip();}
			else if (play == 11) {System.out.println(String.format("The ship condition is :\n" + player.getShipToCaptain().getShipConditon()));}
			else if (play == 12) {sellUpgrade(player);}
			else if (play == 13) {buyUpgrade(player);}
			else if (play == 14){System.exit(0);}
				
		}
		System.out.println("***********************************The game sadly ends for you as you ran out of time***********************************\n\n");
		System.out.println(String.format("You were successful in making %d gold bars",player.getBalance()));
		System.out.println("***********************************Play again and beat your personal best score***********************************");

	}
	
	
	// new added
	private void sellUpgrade(Player p) {
		ArrayList <Upgrade> alreadyBuy = p.upgradeCanSell();
		System.out.println(String.format("The upgrad you already have :"));
		int count = 0;
		for (Upgrade upgrade :alreadyBuy) {System.out.println("(" + count +") " + upgrade.getName() + " : " + upgrade.getExplain()); count++;}
		try 
        {
        	count --;
        	System.out.println("Please chose the number from 0 to" + count +" (include)");
        	String upgradeIndex = scanner.nextLine();
        	
            if (upgradeIndex.matches("[0-count]"))
            {
            	int index = Integer.parseInt(upgradeIndex);
            	Upgrade upgradeToSell = alreadyBuy.get(index);
                String result = p.sellUpgrade(upgradeToSell);
                System.out.println(result);
            }
            else{System.out.println("You must enter a number between 0 to " + count);}
        } catch (Exception e) 
        {
            
            scanner.nextLine();}
	
	
	}
	
	// This is new Add.
    private void buyUpgrade(Player p) {
    	System.out.println("Please chose the number of upgrad you want to buy:\n");
    	ArrayList <Upgrade> upgradsCanBuy = p.upgradeCanBuy(upgrades);
    	int count = 0;
    	for (Upgrade u : upgradsCanBuy) {System.out.println("(" + count +") " + u.getName() + ":" + u.getExplain());count ++ ;}
        try 
        {
        	count --;
        	System.out.println("Please chose the number from 0 to" + count +" (include)");
        	String upgradeIndex = scanner.nextLine();
        	
            if (upgradeIndex.matches("[0-count]"))
            {
            	int index = Integer.parseInt(upgradeIndex);
            	Upgrade upgradeToBuy = upgradsCanBuy.get(index);
                String result = p.buyUpgrade(upgradeToBuy);
                System.out.println(result);
            	
            }
            else{System.out.println("You must enter a number between 0 to " + count);}
        } catch (Exception e) 
        {
            
            scanner.nextLine();}
    	
    }

	
	private String questionOfGetName() {
		System.out.println("Please enter your name:");
		return "Please enter your name:";
	}
	
	private String errorOfGetName() {
		System.out.println("You must enter a name between 3 to 15 characters long with no special characters and only one space");
		return "You must enter a name between 3 to 15 characters long with no special characters and only one space";
	}
	
	
	private String getName()
	{	

		String name;
		while (true) 
		{
			questionOfGetName();
	
	        try 
	        {
	            name = scanner.nextLine();
	            if (name.matches("[a-zA-Z ]{3,15}"))
	            {
	            	return name;
	            }
	            else{errorOfGetName();}
	        } 
	        catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		}
	}
	
	private String questionOfGetDay() {
		System.out.println("Days you would like to play for?");
		return "Days you would like to play for?";
	}
	
	private String errorOfGetDay() {
		System.out.println("You must enter between a number between 20 to 50 days");
		return "You must enter between a number between 20 to 50 days";
	}
	
	private int getDays()
	{

		String days;
		while (true) 
		{
			questionOfGetDay();

	        try {
	        	days = scanner.nextLine();
	            if (days.matches("2[0-9]|3[0-9]|4[0-9]|50"))
	            {
	            	
	            	return Integer.parseInt(days);
	            }
	            else{errorOfGetDay();}
	        } catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		}
	}
	
	private Islands chooseHomeIsland()
	{

		int index;
		while (true) 
		{
	        System.out.println("Please choose your home island");
	        int count = 1;
	        for(Islands island: islands)
	        {
	        	System.out.println(String.format("(%d) %s island",count, island.getName()));
	        	count +=1;
	        }

	        try 
	        {
	        	String islandIndex = scanner.nextLine();
	            if (islandIndex.matches("[1-5]"))
	            {
	            	index = Integer.parseInt(islandIndex);
	                return islands.get(index-1);
	            }
	            else{System.out.println("You must enter a number between 1 to 5");}
	        } catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		}
	}
	private Ship chooseShip()//Need you to finish this one
	{

		int index;
		while (true) 
		{
	        System.out.println("Please choose a ship to captain");
	        int count = 1;
	        for(Ship ship: ships)
	        {
	        	System.out.println(String.format("************************************(%d)************************************",count));
	        	System.out.println(ship.getAttributes());
	        	count += 1;
	        }

	        try {
	            String strIndex = scanner.nextLine();
	            if (strIndex.matches("[1-4]"))//update the numbers
	            {
	            	index = Integer.parseInt(strIndex);
	                return ships.get(index-1);
	            }
	            else{System.out.println("You must enter a number between 1 to 4");}
	        } catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		}

	}
	
	
	//this has been changed
	private int playGame(ArrayList<String> options,Player player)
	{

		int index;
		while(true)
		{
			System.out.println("Please choose an option");
			int count = 1;
			for(String option: options)
			{
				System.out.println(String.format("(%d) %s",count, option));
				count += 1;
			}
			try 
			{
	            String strIndex = scanner.nextLine();
	            if (strIndex.matches("[0-9]|1[0-4]"))//update the numbers
	            {
	            	index = Integer.parseInt(strIndex);
	            	return index;
	                
	            }
	            else{System.out.println("You must enter a number between 1 to 12");}//Update based upon the number
	        } 
			catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		} 	
	}
	
	
	// this has be changed.
	private void chooseIsland(Player player)
	{
		int route = -1;
		while(route >= 5 || route <= 0)	
		{
			System.out.println("Pleaese choose a route from the options below to sail");
			System.out.println(currentIsland.getIslandRoutes());
			try 
			{
	            String strRoute = scanner.nextLine();
	            if (strRoute.matches("[1-4]"))
	            {
	            	route = Integer.parseInt(strRoute);
	            	Route selectedRoute = currentIsland.getRoute(route-1);
	            	
	            	String chackResult = player.checkRoute(selectedRoute);
	            	System.out.println(chackResult);
	            	if (chackResult == "Sorry, you don't have enough money to pay the sailors.You can try taking a shorter route.") {
	            		System.out.println(chackResult);
	            		return;
	            		
	            	}
	            	else if (chackResult == "Sorry, you have to fix your ship first, please make your ship in perfect condition.") {
	            		System.out.println(chackResult);
	            		return;
	            	}
	            	else {
	            	
		            	String event = player.getEvent(selectedRoute);
		            	System.out.println(event);
		            	String result = player.runEvent(event);
		            	System.out.println(result);
		            	if (result == "Let us choose a direction to stop the pirates!\n"
		        				+ "(0) the front\n"
		        				+ "(1) the rear\n"
		        				+ "(2) the left side\n"
		        				+ "(3) the right side"){
		            		String numChoose = scanner.nextLine();
		            		
		            		int num = Integer.parseInt(numChoose);
		            		String against = player.againstPirates(num);
		            		System.out.println(against);
		            		if (against == "Not good!The pirates are aboard!") {
		            			String money = player.givePiratesTheyWant();
		            			System.out.println(money);
		            			if (money.endsWith("Game over!")) {
		            				System.exit(0);
		            			}
		            		
		            		}
		            	}
	            	}
	            	
	            	
	        		String islandName = selectedRoute.getIslandName();
	        		for(Islands island: islands)
	        		{
	        			if(island.getName() == islandName)
	        			{
	        				Islands previousIsland = currentIsland;
	        				if (player.remainingDays() - selectedRoute.getNumberOfDays() > 0){player.goSail(selectedRoute, island);}
	        				currentIsland = player.getCurrentIsland();
	       
	        				
	        				if(previousIsland.getName() != currentIsland.getName())
	        				{	
	        					System.out.println(String.format("*********************************************Sailing****************************"));
	        					System.out.println(String.format("*********************************************Sailing****************************"));
	        					System.out.println(String.format("*********************************************Sailing****************************\n\n"));
	        					System.out.println(String.format("Welcome to %s %s", islandName,player.getName()));
	        					System.out.println(String.format("There are %d days left",player.remainingDays()));
	        				}
	        				break;	
	        			}
	        		}
	                
	            }
	            else{System.out.println("You must enter between a number between 1 to 4");}
	            
	        } catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }	
		}
	}
	
	
	
	public void checkTradingOptions(ArrayList<Islands> islands)
	{

		int index = -1;
		while (index < 0 || index >= 6) 
		{
	        System.out.println("Please choose an island");
	        int count = 1;
	        for(Islands island: islands)
	        {
	        	System.out.println(String.format("(%d) %s island",count, island.getName()));
	        	count += 1;
	        }

	        try 
	        {
	        	String islandIndex = scanner.nextLine();
	            if (islandIndex.matches("[1-5]"))
	            {
	            	index = Integer.parseInt(islandIndex);    
	            }
	            else{System.out.println("You must enter a number between 1 to 5");}
	        } 
	        catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
		}
		Islands currentIsland = islands.get(index-1);
	    int option = 0;   
        System.out.println("Would you like to");
        System.out.println("(1) Check items for sale");
        System.out.println("(2) Items that the island can buy");
        System.out.println("(3) Return to main menue");
        while(true)
        {
        	try 
	        {
	        	String strOption = scanner.nextLine();
	            if (strOption.matches("[1-3]"))
	            {
	            	option = Integer.parseInt(strOption);    
	            }
	            else{System.out.println("You must enter a number between 1 to 3");}
	        } 
	        catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
        	if(option == 1)			
        	{
        		System.out.println(currentIsland.getItemsStoreCanSell());
        		System.out.println("Would you like to");
                System.out.println("(1) Check items for sale");
                System.out.println("(2) Items that the island can buy");
                System.out.println("(3) Return to main menue");
        	}
        	else if (option == 2)	
        	{
        		System.out.println(currentIsland.getItemsStoreCanBuy());
        		System.out.println("Would you like to");
                System.out.println("(1) Check items for sale");
                System.out.println("(2) Items that the island can buy");
                System.out.println("(3) Return to main menue");
        		
        	}
        	else if (option == 3){break;}
        }
		
	}
	
	private void tradeGoods(Islands currentIsland)
	{
		Stores currentStore = currentIsland.dock();
		int option = -1;   
        
        while(true)
        {	
        	System.out.println("Would you like to");
            System.out.println("(1) Buy items");
            System.out.println("(2) Sell items");
            System.out.println("(3) Go back to ship");
        	try 
	        {
	        	String strOption = scanner.nextLine();
	            if (strOption.matches("[1-3]"))
	            {
	            	option = Integer.parseInt(strOption);
	            	if	(option == 1)
	            	{	
	            		List<Item> itemsForSale = currentStore.getListItemsForSale();
	            		
	            		while(true)
	            		{
	            			System.out.println("Please choose an item to buy");
	                		System.out.println(currentIsland.getItemsStoreCanSell());
	                		System.out.println(String.format("(%d) Go back to previous menu",itemsForSale.size()+1));
	            			try
	                		{
	                			String strItem = scanner.nextLine();
	                			if (strItem.matches(String.format("[1-%d]", itemsForSale.size()+1)))
	            	            {
	            	            	int itemIndex = Integer.parseInt(strItem); 
	            	            	if(itemIndex == itemsForSale.size()+1){break;}
	            	            	else{player.buyitems(itemsForSale.get(itemIndex-1), 1);}
	            	            	
	            	            }
	                			else{System.out.println(String.format("You must enter a number between 1 to %d",itemsForSale.size()+1));}
	                		}
	                		catch (Exception e) 
	            	        {
	            	            // Discard the unacceptable input
	            	            scanner.nextLine();
	            	        }	
	            		}
	            		
	            			
	            	}
	            	else if (option == 2)
	            	{
	            		List<Item> itemsCanBuy = currentStore.getListItemsCanBuy();
	            		while(true)
	            		{
	            			System.out.println("Please choose an item to sell");
		            		System.out.println(currentIsland.getItemsStoreCanBuy());
		            		System.out.println(String.format("(%d) Go back to previous menu",itemsCanBuy.size()+1));
	            			try
	                		{
	                			String strItem = scanner.nextLine();
	                			if (strItem.matches(String.format("[1-%d]", itemsCanBuy.size()+1)))
	            	            {
	            	            	int itemIndex = Integer.parseInt(strItem);
	            	            	if(itemIndex ==  itemsCanBuy.size()+1){break;}
	            	            	player.sellitems(itemsCanBuy.get(itemIndex-1), 1);
	            	            }
	                			else{System.out.println(String.format("You must enter a number between 1 to %d",itemsCanBuy.size()+1));}
	                		}
	                		catch (Exception e) 
	            	        {
	            	            // Discard the unacceptable input
	            	            scanner.nextLine();
	            	        }	
	            		}
	            	}
	            	else if (option == 3){break;}
	            	
	            }
	            else{System.out.println("You must enter a number between 1 to 3");}
	        } 
	        catch (Exception e) 
	        {
	            // Discard the unacceptable input
	            scanner.nextLine();
	        }
        }
	
	}
	
	private void checkShipCargo()
	{
		System.out.println(ship.getCargoContent());
	}
	private void checkTransections()
	{
		System.out.println(ship.getTransection());
	}
	private void repairShip()
	{
		String result = player.repair();
		System.out.println(result);
	}
}
