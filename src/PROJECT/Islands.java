import java.util.*;

/**
 * This class models an island.
 * @author Prableen
 *
 */
public class Islands 
{
	//Name of the Island
	private String name;
	
	//An object of type Store
	private Stores store = new Stores();
	
	//List of routes
	private ArrayList<Route> islandRoutes = new ArrayList<Route>();
	
	
	/**
	 * Creates an island with a given name, routes to other islands, store on the island.  
	 */
	public Islands(ArrayList<Route> islandRoutes,String name, Stores store) 
	{
		this.islandRoutes = islandRoutes;
		this.name = name;
		this.store = store;
	}
	
	
	
	/**
	 * Gets the name of the island.
	 * @return The name of the island.
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Provides access to the store.
	 * @return Object of type Stores.
	 */
	public Stores dock()
	{
		return store;
	}
	
	
	
	
	/**
	 * Provides a description of the items store can buy on the given island.
	 * @return A description all the items store can buy. 
	 */
	public StringBuilder getItemsStoreCanBuy()
	{
		StringBuilder items = new StringBuilder();
		List<Item> listItems = store.getListItemsCanBuy();
		items.append(String.format("On %s island you can sell the following items:\n", name));
		int count = 1;
		for(Item i:listItems)
		{
			items.append(String.format("(%d) %d kilograms of %s for %d gold bars\n",count,i.getSize(), i.getName(),i.getBuyingPrice()));
			count += 1;
		}
		return items;
	}
	
	
	/**
	 * Provides a description of the island and items store can sell.
	 * @return A description all the items store can sell. 
	 */
	public StringBuilder getItemsStoreCanSell()
	{	
		StringBuilder items = new StringBuilder();
		List<Item> listItems = store.getListItemsForSale();
		items.append(String.format("On %s island you can buy the following items:\n", name));
		int count = 1;
		for(Item i:listItems)
		{
			items.append(String.format("(%d) %d kilograms of %s for %d gold bars\n",count,i.getSize(), i.getName(),i.getSellingPrice()));
			count += 1;
		}
		return items;
	}
	
	
	/**
	 * Provides a description of available routes to other islands.
	 * @return A description of available routes.
	 */
	
	public StringBuilder getIslandRoutes()
	{
		StringBuilder paths = new StringBuilder();
		paths.append(String.format("Current routes from %s are as under:\n", getName()));
		int count = 1;
		for(Route r:islandRoutes)
		{
			paths.append(String.format("(%d) %s is %d Kilometers away, it will take %d days to travel and has a %s sailing risk\n",count, r.getIslandName(),r.getDistance(),r.getNumberOfDays(),r.getSailingRisk()));
			count += 1;
		}
	
		return paths;
	}
	
	public Route getRoute(int index)
	{
		return islandRoutes.get(index);
	}
}
