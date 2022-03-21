import java.util.ArrayList;



/**
 * @author Prableen
 *
 */
public class Main 
{

	
	/**
	 * 
	 */
	public Main() {}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		final Islands corfu = initialiseCorfu();
		final Islands crete = initialsieCrete();
		final Islands mykonos = initialsieMykonos();
		final Islands rhodes = initialsieRhodes();
		final Islands santorni = initialsieSantorni();
		
		final ArrayList<Islands> islands = new ArrayList<Islands>();
		islands.add(corfu);
		islands.add(crete);
		islands.add(mykonos);
		islands.add(rhodes);
		islands.add(santorni);
		
		final Ship nautilus = initialiseNautilus();
		final Ship endeavor = initialiseEndeavor();
		final Ship noahsArk = initialiseNoahsArk();
		final Ship fram = initialiseFram();
		
		
		final ArrayList<Ship> ships = new ArrayList<Ship>();
		ships.add(nautilus);
		ships.add(endeavor);
		ships.add(noahsArk);
		ships.add(fram);
		
		final ArrayList<Upgrade> upgrades = initialiseUpgrade();
		
		
		// this has been changed
		//final ArrayList<Upgrade> upgradeCanBuyList = initialiseUpgrade();
		final ArrayList<String> options = new ArrayList<String>();
		options.add("Sail to a new island");
		options.add("Check goods available for trade on all islands");
		options.add("Dock to trade with the current island store");
		options.add("Check ships condition");
		options.add("Check available space on the Ship");
		options.add("Check days left in the game");
		options.add("Check account balance");
		options.add("Check ships cargo content");
		options.add("Check transection history");
		options.add("Repair ship");
		options.add("Check ship condition");
		options.add("Sell upgrad");
		options.add("Buy new upgrad");	
		options.add("Quit");
		
		
		
		
		//Need you to create a method to initialse ships same as islands and then add them to a list as for the islands
		CommandLine cmd = new CommandLine(islands, ships, upgrades, options);
		cmd.start();
		
	
		
	}

	private static Islands initialiseCorfu()
	{
		String islandName = "Corfu"; 
		ArrayList<Route> islandRoutes = new ArrayList<Route>();
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
		
		Route santorini = new Route("Santorini", 100, "Very High");
		Route mykonos = new Route("Mykonos",200, "High");
		Route rhodes = new Route("Rhodes", 300, "Medium");
		Route crete = new Route("Crete", 400, "Low");
		
		islandRoutes.add(mykonos);
		islandRoutes.add(rhodes);
		islandRoutes.add(crete);
		islandRoutes.add(santorini);
		
		Item tea = new Item("Tea", 150, -1, 50,"The item has not been bought from the island","The item has not been sold to any island");
		Item horses = new Item("Horses", 800, -1, 250,"The item has not been bought from the island","The item has not been sold to any island");
		Item grain = new Item("Grain", 150, -1, 50,"The item has not been bought from the island","The item has not been sold to any island");
		Item tools = new Item("Tool", 50, -1, 100,"The item has not been bought from the island","The item has not been sold to any island");
		
		//Upgrades
		Item pistols = new Item("Pistols", 200, -1, 200,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsForSale.add(tea);
		itemsForSale.add(horses);
		itemsForSale.add(grain);
		itemsForSale.add(tools);
		itemsForSale.add(pistols);
		
		Item fruits = new Item("Fruits", 150, 60, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item paper = new Item("Paper", 200, 80, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cattle = new Item("Cattle",1000, 320, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item marble = new Item("Marble", 2000, 520, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(fruits);
		itemsCanBuy.add(paper);
		itemsCanBuy.add(cattle);
		itemsCanBuy.add(marble);
		
		//ArrayList<Item> itemsForSale, ArrayList<Item> itemsCanBuy
		Stores store = new Stores(itemsForSale, itemsCanBuy);
		Islands corfu = new Islands(islandRoutes, islandName, store);
		
		return corfu;
	}
	private static Islands initialsieCrete() 
	{
		String islandName = "Crete"; 
		ArrayList<Route> islandRoutes = new ArrayList<Route>();
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
		
		Route corfu = new Route("Corfu", 100, "Very High");
		Route santorini = new Route("Santorini", 200, "High");
		Route mykonos = new Route("Mykonos", 300, "Medium");
		Route rhodes = new Route("Rhodes", 400, "Low");
		
		islandRoutes.add(santorini);
		islandRoutes.add(rhodes);
		islandRoutes.add(mykonos);
		islandRoutes.add(corfu);
		//Item(String name, int size, int buyingPrice,int sellingPrice)
		Item spices = new Item("Spices", 100, -1, 20,"The item has not been bought from the island","The item has not been sold to any island");
		Item swords = new Item("Sword", 50, -1, 30,"The item has not been bought from the island","The item has not been sold to any island");
		Item knives = new Item("Knives", 50, -1, 30,"The item has not been bought from the island","The item has not been sold to any island");
		Item cloth = new Item("Cloth", 50, -1, 30,"The item has not been bought from the island","The item has not been sold to any island");
		
		//Upgrades
		Item imporovedNagigation = new Item("Improved Navigation System", 100, -1, 200,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsForSale.add(spices);
		itemsForSale.add(swords);
		itemsForSale.add(knives);
		itemsForSale.add(cloth);
		itemsForSale.add(imporovedNagigation);
		
		Item tea = new Item("Tea", 150, 60, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item horses = new Item("Horses", 800, 270, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item grain = new Item("Grain", 150, 60, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item tools = new Item("Tools", 50, 120, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(tea);
		itemsCanBuy.add(horses);
		itemsCanBuy.add(grain);
		itemsCanBuy.add(tools);
		
		Item fruits = new Item("Fruits", 150, 25, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item paper = new Item("Paper", 200, 35, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cattle = new Item("Cattle",1000, 150, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item marble = new Item("Marble", 2000, 250, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(fruits);
		itemsCanBuy.add(paper);
		itemsCanBuy.add(cattle);
		itemsCanBuy.add(marble);
		
		//ArrayList<Item> itemsForSale, ArrayList<Item> itemsCanBuy 
		Stores store = new Stores(itemsForSale, itemsCanBuy);
		Islands crete = new Islands(islandRoutes, islandName, store);
		
		return crete;
	}
	
	private static Islands initialsieMykonos()
	{	
		String islandName = "Mykonos"; 
		ArrayList<Route> islandRoutes = new ArrayList<Route>();
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
		Route rhodes = new Route("Rhodes", 100, "Very High");
		Route crete = new Route("Crete", 200, "High");
		Route corfu = new Route("Corfu", 300, "Medium");
		Route santorini = new Route("Santorini", 400, "Low");
		
		islandRoutes.add(santorini);
		islandRoutes.add(rhodes);
		islandRoutes.add(crete);
		islandRoutes.add(corfu);
		
		Item wood = new Item("Wood", 600, -1, 40,"The item has not been bought from the island","The item has not been sold to any island");
		Item meat = new Item("Meat", 500, -1, 20,"The item has not been bought from the island","The item has not been sold to any island");
		Item wine = new Item("Wine", 700, -1, 180,"The item has not been bought from the island","The item has not been sold to any island");
		Item rum = new Item("Rum", 650, -1, 160,"The item has not been bought from the island","The item has not been sold to any island");
		
		//Upgrade
		Item newSails = new Item("New Sails", 500, -1 ,150,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsForSale.add(wood);
		itemsForSale.add(meat);
		itemsForSale.add(wine);
		itemsForSale.add(rum);
		itemsForSale.add(newSails);
		
		Item olives = new Item("Olives", 400, 110, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cheese = new Item("Cheese", 100, 30, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item herbs = new Item("Herbs", 100, 30, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item spices = new Item("Spices", 100, 30, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(olives);
		itemsCanBuy.add(cheese);
		itemsCanBuy.add(herbs);
		itemsCanBuy.add(spices);
		
		Item swords = new Item("Swords", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item knives = new Item("Knives", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cloth = new Item("Cloth", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item tea = new Item("Tea", 650, 25, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsCanBuy.add(swords);
		itemsCanBuy.add(knives);
		itemsCanBuy.add(cloth);
		itemsCanBuy.add(tea);
		
		
		Stores store = new Stores(itemsForSale, itemsCanBuy);
		Islands mykonos = new Islands(islandRoutes, islandName, store);
		return mykonos;
		
	}
	
	private static Islands initialsieRhodes()
	{
		String islandName = "Rhodes"; 
		ArrayList<Route> islandRoutes = new ArrayList<Route>();
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
		
		Route crete = new Route("Crete", 100, "Very High");
		Route corfu = new Route("Corfu", 200, "High");
		Route santorini = new Route("Santorini", 300, "Medium");
		Route mykonos = new Route("Mykonos", 400, "Low");
		
		islandRoutes.add(santorini);
		islandRoutes.add(mykonos);
		islandRoutes.add(crete);
		islandRoutes.add(corfu);
		
		Item perfumes = new Item("Perfumes", 600, -1, 200,"The item has not been bought from the island","The item has not been sold to any island");
		Item olives = new Item("Olives", 400,-1, 100,"The item has not been bought from the island","The item has not been sold to any island");
		Item cheese = new Item("Cheese", 100, -1, 20,"The item has not been bought from the island","The item has not been sold to any island");
		Item herbs = new Item("Herbs",100, -1, 20,"The item has not been bought from the island","The item has not been sold to any island");
		
		//Upgrade
		Item rudder = new Item ("Rudder", 1000, -1, 250,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsForSale.add(perfumes);
		itemsForSale.add(olives);
		itemsForSale.add(cheese);
		itemsForSale.add(herbs);
		itemsForSale.add(rudder);
		
		Item swords = new Item("Swords", 50, 40, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item knives = new Item("Knives", 50, 40, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cloth = new Item("Cloth", 50, 40, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item tea = new Item("Tea", 650, 70, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsCanBuy.add(swords);
		itemsCanBuy.add(knives);
		itemsCanBuy.add(cloth);
		itemsCanBuy.add(tea);
		
		Item wood = new Item("Wood", 600, 20, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item meat = new Item("Meat", 500, 10, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item wine = new Item("Wine", 700, 90, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item rum = new Item("Rum", 650, 80, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsCanBuy.add(wood);
		itemsCanBuy.add(meat);
		itemsCanBuy.add(wine);
		itemsCanBuy.add(rum);

		
		
		
		Stores store = new Stores(itemsForSale, itemsCanBuy);
		Islands rhodes =new Islands(islandRoutes, islandName, store);
		return rhodes;
	}
	
	private static Islands initialsieSantorni()
	{
		String islandName = "Santorini"; 
		ArrayList<Route> islandRoutes = new ArrayList<Route>();
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
		
		Route mykonos = new Route("Mykonos", 100, "Very High");
		Route rhodes = new Route("Rhodes", 200, "High");
		Route crete = new Route("Crete", 300, "Medium");
		Route corfu = new Route("Corfu", 400, "Low");
		
		islandRoutes.add(mykonos);
		islandRoutes.add(rhodes);
		islandRoutes.add(crete);
		islandRoutes.add(corfu);
		
		Item coffee = new Item("Coffee", 150, -1, 50,"The item has not been bought from the island","The item has not been sold to any island");
		Item fruits = new Item("Fruits", 150,-1, 50,"The item has not been bought from the island","The item has not been sold to any island");
		Item paper = new Item("Paper", 200, -1, 70,"The item has not been bought from the island","The item has not been sold to any island");
		Item cattle = new Item("Cattle",1000, -1, 300,"The item has not been bought from the island","The item has not been sold to any island");
		Item marble = new Item("Marble", 2000, -1, 500,"The item has not been bought from the island","The item has not been sold to any island");
		
		//Upgrade
		Item cannons = new Item("Cannons", 2000, -1, 300,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsForSale.add(coffee);
		itemsForSale.add(fruits);
		itemsForSale.add(paper);
		itemsForSale.add(cattle);
		itemsForSale.add(marble);
		itemsForSale.add(cannons);

		
		Item wood = new Item("Wood", 600, 50, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item meat = new Item("Meat", 500, 30, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item wine = new Item("Wine", 700, 200, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item rum = new Item("Rum", 650, 180, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item perfumes = new Item("Perfumes", 600, 250, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(wood);
		itemsCanBuy.add(meat);
		itemsCanBuy.add(wine);
		itemsCanBuy.add(rum);
		itemsCanBuy.add(perfumes);
		
		Item olives = new Item("Olives", 400, 50, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cheese = new Item("Cheese", 100, 10, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item herbs = new Item("Herbs", 100, 10, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item spices = new Item("Spices", 100, 10, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		itemsCanBuy.add(olives);
		itemsCanBuy.add(cheese);
		itemsCanBuy.add(herbs);
		itemsCanBuy.add(spices);
		
		Item swords = new Item("Swords", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item knives = new Item("Knives", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item cloth = new Item("Cloth", 50, 15, -1,"The item has not been bought from the island","The item has not been sold to any island");
		Item tea = new Item("Tea", 650, 25, -1,"The item has not been bought from the island","The item has not been sold to any island");
		
		
		itemsCanBuy.add(swords);
		itemsCanBuy.add(knives);
		itemsCanBuy.add(cloth);
		itemsCanBuy.add(tea);
		
		Stores store = new Stores(itemsForSale, itemsCanBuy);
		Islands santorni =new Islands(islandRoutes, islandName, store);
		return santorni;
		
	}
	
	private static Ship initialiseNautilus() {
		Ship Nautilus = new Ship("Nautilus", 2500, 40, 400000);
		return Nautilus;
	}
	
	private static Ship initialiseEndeavor() {
		Ship Endeavor = new Ship("Endeavor", 1200, 25, 800000);
		return Endeavor;
	}
	
	private static Ship initialiseNoahsArk() {
		Ship NoahsArk = new Ship("Noah's Ark", 500, 40, 2000000);
		
		return NoahsArk;
		}
	
	private static Ship initialiseFram() {
		Ship Fram = new Ship("Fram", 500, 40, 2000000);
		
		return Fram;	}	

	private static ArrayList<Upgrade> initialiseUpgrade(){
		Upgrade Guns = new Upgrade("Guns", "more likely repel pirate.", 500, 200);
		Upgrade Cannon = new Upgrade("Cannon", "can repel pirates everytime.", 40000, 15000);
		Upgrade Sails = new Upgrade("Sails", "speed + 100", 3000, 1300);
		Upgrade Motor = new Upgrade("Motor", "speed + 500", 15000, 11000);
		Upgrade Shelf = new Upgrade("Shelf", "capicity + 200000", 4000, 2000);
		Upgrade Craue = new Upgrade("Craue", "capicity + 600000", 15000,8000);
		ArrayList<Upgrade> upgradeList = new ArrayList<Upgrade>();
		upgradeList.add(Craue);
		upgradeList.add(Shelf);
		upgradeList.add(Motor);
		upgradeList.add(Sails);
		upgradeList.add(Cannon);
		upgradeList.add(Guns);
		return upgradeList;
	}
	
		
}
