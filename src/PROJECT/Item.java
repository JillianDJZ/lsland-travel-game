package core;

/**
 * Class that models an Item.
 * @author Prableen
 */
public class Item {
	
	//Name of the item
	private String name;
	
	//Size of the item
	private int size;
	
	//Price for which the item can be bought for
	private int buyingPrice;
	
	//Price  for which the item can be sold for
	private int sellingPrice;
	
	//Name of the Island the Item was bought from
	private String islandBoughtFrom;
	
	//Name of the Island the Items was sold at
	private String islandSoldAt;
	

	
	
	
	/**
	 * Creates an item of given name, size, buying price, selling price Island sold at and Island bought from.
	 *
	 * @param name The name of the item
	 * @param size The size of the item
	 * @param buyingPrice The buying price of the item
	 * @param sellingPrice The selling price of the item
	 * @param islandBoughtFrom The name of the Island the item was bought from
	 * @param islandSoldAt The name of the Island the item was sold at
	 */
	public Item(String name, int size, int buyingPrice,int sellingPrice, String islandBoughtFrom, String islandSoldAt)
	{
		this.name = name;
		this.size = size;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.islandSoldAt = islandSoldAt;
		this.islandBoughtFrom = islandBoughtFrom;
	}
	
	
	/**
	 * Gets the buying price of this item.
	 *
	 * @return The buying price of the item
	 */
	public int getBuyingPrice()
	{
		return buyingPrice;
	}
	
	
	/**
	 * Gets the name of the Island the item was brought from
	 * @return the name of the island the item was sold at
	 */
	public String getIslandBoughtFrom()
	{
		return islandBoughtFrom;
	}
	
	
	
	/**
	 * Gets the name of the Island the item is sold at
	 * @return the name of the island the item was sold at
	 */
	public String getIslandSoldAt()
	{
		return islandSoldAt;
	}
	
	
	
	/**
	 * Gets the selling price of this item.
	 *
	 * @return The selling price of the item
	 */
	public int getSellingPrice()
	{
		return sellingPrice;
		
	}
	
	
	/**
	 * Gets the size of this item.
	 *
	 * @return The size of the item
	 */
	
	public int getSize()
	{
		return size;
	}
	/**
	 * Gets the name of this item.
	 * @return The name of the item
	 */
	public String getName()
	{
		return name;
	}
	
	void setBuyingPrice(int price)
	{
		buyingPrice = price;
	}
	
	public void setSellingPrice(int price)
	{
		sellingPrice = price;
	}
	public void setIslandBoughtFrom(String name)
	{
		islandBoughtFrom = name;
	}
	public void setIslandSoldAt(String name)
	{
		islandSoldAt = name;
	}
}