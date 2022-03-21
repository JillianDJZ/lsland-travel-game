import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ship class.
 * Dongjin Zhou
 */
	
public class Ship {
	
	private String name;
	private int sailSpeed = 100;
	private int maximumCrew = 30;
	private int cargoCapicity = 50;
	private String shipCondition = "Little damage";
	private ArrayList <Upgrade> upgradeList = new ArrayList <Upgrade>();
	private ArrayList <Item> cargoItems = new ArrayList <Item> (); 
	private ArrayList <Item> itemsSold = new ArrayList <Item> (); 
	private int remainingCapicity = 30;
	

	public Ship(String aName, int aSpeed, int theMaximumCrew, int theCargoCapicity) {
		name = aName;
		sailSpeed = aSpeed;
		maximumCrew = theMaximumCrew;
		cargoCapicity = theCargoCapicity;
		remainingCapicity = theCargoCapicity;
	}
	public void emptyCabin() {
		for(Item i: cargoItems) {
			itemsSold.add(i);
		}
		cargoItems.clear();
		remainingCapicity = cargoCapicity;
	}
	
	public ArrayList <Item> getCapicityItems(){
		return cargoItems;
	}
	
	public int getMaximumCrew() {
		return maximumCrew;
	}
	
	public int getTotalCapicity() {
		return cargoCapicity;
	}
	
	public int getRemainingCapicity() {
		return remainingCapicity;
	}
	
	public String addItem(Item item) {
		
		cargoItems.add(item);
		remainingCapicity -= item.getSize();
		String itemName = item.getName();
		if(itemName.charAt(itemName.length()-1) == 's')	{return String.format("%s have been loaded succesfully on board.\nThe remaining capacity is: %d", itemName,remainingCapicity);}
		else	{return String.format("%s has been loaded succesfully on board.\nThe remaining capacity is: %d", itemName,remainingCapicity);}
		
	}
	
	public String removeItem(Item item, int sellingPrice, Islands island) 
	{
		for(Item currentItem: cargoItems)
		{
			String currentItemName = currentItem.getName();
			if ( currentItemName == item.getName())
			{
				cargoItems.remove(currentItem);
				remainingCapicity += currentItem.getSize();
				currentItem.setSellingPrice(sellingPrice);
				currentItem.setIslandSoldAt(island.getName());
				itemsSold.add(currentItem);	
				if(currentItemName.charAt(currentItemName.length()-1) == 's'){return String.format("%s have been succefssfully removed.\nThe remaining capacity is: %d", currentItemName,remainingCapicity);}
				else{return String.format("%s has been succefssfully removed.\nThe remaining capacity is: %d", currentItemName,remainingCapicity);}
				
			}		
		}
		return "Can't remove the item, Can't find it!";
	}
	
	public StringBuilder getCargoContent()
	{
		StringBuilder content = new StringBuilder();
		int count = 1;
		content.append("*****************************************(Cargo content)**********************************************\n\n");
		content.append("******************************************************************************************************\n\n");
		if (cargoItems.size() == 0){content.append("There is no cargo on board\n\n");}
		for(Item item : cargoItems)
		{
			content.append(String.format("(%d) %s which occupying %d Kilograms of cargo capacity\n",count, item.getName(),item.getSize()));
			count += 1;
		}
		content.append("******************************************************************************************************\n\n");
		content.append("******************************************************************************************************\n\n");
		return content;
	}
	public String getShipConditon() {
		return shipCondition;
	}
	
	public void setShipCondition(String newConditon) {
		shipCondition = newConditon;
	}
	
	public ArrayList <Upgrade> getUpgradeList(){
		return upgradeList;
	}
	
	public void addUpgrade(Upgrade theUpgrade) {
		upgradeList.add(theUpgrade);
	}
	
	public void removeUpgrade(Upgrade theUpgrade) {
		upgradeList.remove(theUpgrade);
	}

	public String plusSpeed(int number) {
		sailSpeed += number;
		return String.format("The velocity of %d was added, and now the velocity is %d." ,number, sailSpeed);
	}
	
	public String subtractSpeed(int number) {
		sailSpeed -= number;
		return String.format("The velocity of %d was subtracted, and now the velocity is %d." ,number, sailSpeed);
	}
	
	public int getSpeed() {
		return sailSpeed;
	}
	
	public String plusCapicity(int number) {
		cargoCapicity += number;
		remainingCapicity += number;
		return String.format("The cabin space has been increased by %d. \n Now the total capacity is %d. \nThe current remaining capacity is %d." ,number, cargoCapicity , remainingCapicity);
	}
	
	public String subtractCapicity(int number) {
		cargoCapicity -= number;
		remainingCapicity -= number;
		return String.format("The cabin space has been decreased by %d. \n Now the total capacity is %d. \nThe current remaining capacity is %d." ,number, cargoCapicity , remainingCapicity);
	}
	
	public StringBuilder getAttributes()
	{
		StringBuilder attriblutes = new StringBuilder();
		attriblutes.append(String.format(("Name				:%s\n"), name));
		attriblutes.append(String.format(("Sail speed			:%s\n"),sailSpeed));
		attriblutes.append(String.format(("Maximum crew			:%s\n"),maximumCrew));
		attriblutes.append(String.format(("Cargo capicity			:%s\n"),cargoCapicity));
		return attriblutes;
	}
	
	public StringBuilder getTransection()
	{
		StringBuilder transection = new StringBuilder();
		transection.append("************************************(Items Bought)************************************\n");
		transection.append("**************************************************************************************\n\n\n");
		int count = 1;
		for(Item item: cargoItems)
		{
			transection.append(String.format("(%d) %s for %d gold bars from %s island\n",count, item.getName(),item.getBuyingPrice(),item.getIslandBoughtFrom()));
			count += 1;
		}
		transection.append("************************************(Items Sold)**************************************\n");
		transection.append("**************************************************************************************\n\n\n");
		count = 1;
		for(Item item: itemsSold)
		{
			transection.append(String.format("(%d) %s for %d gold bars to %d island",count, item.getName(),item.getSellingPrice(),item.getIslandSoldAt()));
			count += 1;
		}
		return transection;
	}
	public List<Item> getListCargoItems() 
	{
		return Collections.unmodifiableList(cargoItems);
	}
}
