/**
 * 
 */
package core;

import java.util.*;

/**
 * This class models a store on an Island.
 * @author Prableen
 *
 */
public class Stores 
{
	//List of items for sale in the store
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
			
	//List of items that that can be bought by the store
	private ArrayList<Item> itemsCanBuy = new ArrayList<Item>();
	
	/**
	 * ???????????????????
	 */
	public Stores(){}
	
	/**
	 * Creates an island with the given Items for sale at the store and the items that the store can buy.
	 * @param itemsForSale list of items for sale on at the store.
	 * @param itemsCanBuy list of items that the island can buy.
	 */
	public Stores(ArrayList<Item> itemsForSale, ArrayList<Item> itemsCanBuy) 
	{
		this.itemsForSale = itemsForSale;
		this.itemsCanBuy = itemsCanBuy;
	}
	
	
	/**
	 * Gets a unmodifiable list of Items for sale on the island.
	 * @return Unmodifiable list of items for sale.
	 */
	public List<Item> getListItemsForSale() 
	{
		return Collections.unmodifiableList(itemsForSale);
	}

	/**
	 * Gets a unmodifiable list of Items that the store can buy.
	 * @return Unmodifiable list of items can sold to the store.
	 */
	public List<Item> getListItemsCanBuy() 
	{
		return  Collections.unmodifiableList(itemsCanBuy);
	}
	
	
	public Item buyItem(String name, String islandName)
	{	
		for (Item i: itemsForSale)
		{
			if (i.getName() == name)
			{	
				Item item = new Item(i.getName(),i.getSize(),i.getSellingPrice(), -1,islandName,"The item has not been sold to any island");
				return item;
				
			}
		}
		
		return null;
	}

	public int sellItem(Item item)
	{
		for (Item i: itemsCanBuy)
		{
			if (i.getName() == item.getName())
			{	
				
				return i.getBuyingPrice();
			}
		}
		return 0;
	}
}
