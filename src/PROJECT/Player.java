import java.lang.Math;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Class that models a player.
 * Dongjin Zhou
 */

public class Player {
	
	
	private String name;
	private int remainingDays = 35;
	private int accountBalance = 1000;
	private Ship shipToCaptain;
	private Islands currentIsland;
	private Islands homeIsland;

	
	public Player(String playerName, int totalDays, Ship theShipIsChoose, Islands theStartIsland)
	{
		name = playerName;
		remainingDays = totalDays;
		shipToCaptain = theShipIsChoose;
		homeIsland = theStartIsland;
		currentIsland = theStartIsland;	
	}
	
	public String getName()
	{
		return name;
	}
	public int remainingDays()
	{
		return remainingDays;
	}
	public int getBalance() {
		return accountBalance;
	}
	
	public void addBalance(int i) {
		accountBalance += i;
	}
	
	public Ship getShipToCaptain() {
		return shipToCaptain;
	}
	
	public int getRepairCost(){
		int cost = 0;
		switch(shipToCaptain.getShipConditon())
		{ 
		case "Perfect": cost = 0; break;
		case "Little damage": cost = 50; break;
		case "Damage": cost = 150; break;
		case "Very Bad" : cost = 1000; 
		}
		return cost;
	}
	
	public String repair() {
		int cost = getRepairCost();
		if(accountBalance >= cost)
		{
			accountBalance -= cost;
			shipToCaptain.setShipCondition("Perfect");
			String s1 = new String("***************************************************Fixing the ship***************************************************\n\n");
			String s2 = new String("***************************************************Fixing the ship***************************************************\n\n");
			String s3 = String.format("The ship has been repaired for %d gold bars and it is ready for its next voyage."
											+ "\nYour current balance is %d.",cost,accountBalance);
			return s1 + s2 + s3;
		}
		else{return "You have insufficient funds to repair your ship";}
		
	}
	
	
	public String buyitems(Item item, int number) {
		Item i = currentIsland.dock().buyItem(item.getName(), currentIsland.getName());
		int cost = number * item.getSellingPrice();
		if (accountBalance >= cost && shipToCaptain.getRemainingCapicity() - i.getSize() > 0)
		{	String itemName = i.getName();
			accountBalance -= cost;
			while(number > 0) 
			{
				shipToCaptain.addItem(i);
				number --;
				
			}
			if(itemName.charAt(itemName.length()-1) == 's'){return String.format("The purchase was approved and %s are being loaded on board.\nYou have %d gold bars remaining.",itemName,accountBalance);}
			else{return  String.format("The purchase was approved and %s is being loaded on board.\nYou have %d gold bars remaining.",itemName,accountBalance);}
			
		}
		else
		{
			if (accountBalance < cost){return "Insufficient funds";}
			else{return "You do not have enough cargo space on your ship";}
			
		}
			
	}
	
	public String sellitems(Item item, int number) {
		
		int quantity = number;
		List<Item> cargoItems = shipToCaptain.getListCargoItems();
		for (Item cargoItem: cargoItems)
		{
			if(item.getName() == cargoItem.getName())
			{
				int sellprice = currentIsland.dock().sellItem(item);
				item.setSellingPrice(sellprice);
				item.setIslandSoldAt(currentIsland.getName());
				int moneyGet = number * (sellprice);
				
				while(number > 0) {
					shipToCaptain.removeItem(item, sellprice, currentIsland);
					number --;}
				accountBalance += moneyGet;
				return String.format("By selling %d kilograms of %s you have earned %d gold bars.\n Your current balance is %d gold bars", quantity*item.getSize(),item.getName(), moneyGet,accountBalance);
			}
		}
		if(item.getName().charAt(item.getName().length()-1) == 's'){return String.format("%s are not in the cargo", item.getName());}
		else {return String.format("%s is not in the cargo", item.getName());}
	}
	   
	
	public String checkRoute(Route r) {
		int crewCost = (int) ((r.getDistance() * shipToCaptain.getMaximumCrew() * 0.5) / shipToCaptain.getSpeed());
		if(shipToCaptain.getShipConditon() == "Perfect") 
		{
			return "Great, ship is perfect!";
			
		}
		else if(accountBalance < crewCost) 
		{
			return "Sorry, you don't have enough money to pay the sailors.You can try taking a shorter route.";
		}
		else
		{
			return "Sorry, you have to fix your ship first, please make your ship in perfect condition.";
		}
		
	}
	
 //it has changed
	public String goSail(Route route, Islands island) {
		if (checkRoute(route) == "Great, ship is perfect!") {
			accountBalance -= route.getDistance() / shipToCaptain.getSpeed() * shipToCaptain.getMaximumCrew() * 0.5;
			remainingDays -= route.getNumberOfDays();	
			currentIsland = island;
			return String.format("Great, ship is perfect!\nThe crew have been payed to sail and you have %d gold bars left", accountBalance);
		}
		return checkRoute(route);	
	}
	
	public String getEvent(Route r) {
		// integer 0 is the event of pirate
		// integer 1 is the event of bad weather
		// integer 2 is the event of sailor rescue
		// bigger than 3 is nothing happen
		String level = r.getSailingRisk();
		int range;
		if (level == "Very High") { range = 2;}
		else if (level == "High") { range = 5;}
		else if (level == "Medium") {range = 8;}
		else {range = 20;}
		int num = 0 + (int)(Math.random() * (range+1));
		if (num == 0) {return "Pirate is coming!";}
		else if (num == 1) {return "Oh! Bad weather!";}
		else if (num == 2) {return "You meet a sailor overboard.";}
		else {return "Safe sailing, nothing happened.";}
	}
	
	
	public String runEvent(String eventName) {
		if (eventName == "Oh! Bad weather!") {
			BadWeather weather = new BadWeather();
			return weather.passTheEvent(this);
			}
		else if (eventName == "You meet a sailor overboard.") {
			SailorRescue sailorRescue = new SailorRescue();
			return sailorRescue.passTheEvent(this);
		}
		else if (eventName == "Safe sailing, nothing happened.") {
			return "How lucky you are!";}
		else 
		{return "Let us choose a direction to stop the pirates!\n"
				+ "(0) the front\n"
				+ "(1) the rear\n"
				+ "(2) the left side\n"
				+ "(3) the right side";}
	}
	
	
	// the int num is the user choosed from 0,1,2,3
	public String againstPirates(int num) {
		Pirate pir = new Pirate();
		return pir.getPiratesOnBoard(this, num);
	}
	
	public void setBalance(int i) {
		accountBalance = i;
	}
	
	public String givePiratesTheyWant() {
		Pirate pir = new Pirate();
		return pir.passTheEvent(this);
	}
	
	public ArrayList<Upgrade> upgradeCanBuy(ArrayList<Upgrade> upgrades){
		ArrayList<Upgrade> alreadyUpgrade = shipToCaptain.getUpgradeList();
		ArrayList<Upgrade> resultList = new ArrayList<Upgrade>();
		for (Upgrade theUpgrade : upgrades) {
			if(!alreadyUpgrade.contains(theUpgrade)) {resultList.add(theUpgrade);}
		}
		return resultList;
	}
	
	
	
	public ArrayList<Upgrade>upgradeCanSell(){
		return shipToCaptain.getUpgradeList();
	}
	
	public String buyUpgrade(Upgrade theUpgrade) {
		accountBalance -= theUpgrade.getBuyPrice();
		shipToCaptain.addUpgrade(theUpgrade);
		String result = new String();
		switch(theUpgrade.getName()) {
		 case "Guns": result = "Now that you've bought enough guns, your chances of fighting off pirates have doubled.";break;
		 case "Cannon": result = "The cannons are on board, and now you can fight off all the pirates.";break;
		 case "Sails": shipToCaptain.plusSpeed(100); result = "The sails have been put on the ship.";break;
		 case "Motor": shipToCaptain.plusSpeed(500); result = "The motor has been put on the ship."; break;
		 case "Shelf": shipToCaptain.plusCapicity(200000); result = "With these shelves, you can store more goods.";  break;
		 case "Craue": shipToCaptain.plusCapicity(600000); result =  "With the craue, you can store more goods."; 
		}
		return result;
	
	}
	
	
	//new added
	public String sellUpgrade(Upgrade theUpgrade) {
		accountBalance += theUpgrade.getSellPrcie();
		shipToCaptain.removeUpgrade(theUpgrade);
		String result = new String();
		switch(theUpgrade.getName()) {
		 case "Guns": result = "Your guns have been selled.";break;
		 case "Cannon": result = "Your cannon has been selled.";break;
		 case "Sails": shipToCaptain.subtractSpeed(100); result = "Your sails have been selled.";break;
		 case "Motor": shipToCaptain.subtractSpeed(500); result = "Your motor has been selled."; break;
		 case "Shelf": shipToCaptain.subtractCapicity(200000); result = "Your shelf has been selled.";  break;
		 case "Craue": shipToCaptain.subtractCapicity(600000); result =  "Your craue has been selled."; 
		}
		return result;
	
	}
	
	public Islands getCurrentIsland()
	{
		return currentIsland;
	}
	
}
