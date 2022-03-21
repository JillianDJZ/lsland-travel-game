package PROJECT;

/**
 * the_enum "SpecificIsland" listed the names of five islands.
 */
enum SpecificIsland {NAME1, NAME2, NAME3, NAME4, NAME5}; // put on the five islands;

public class ItemsInfo extends Items 
{
	
	private SpecificIsland buyingIsland;
	private int numberOfItem;

	

	public ItemsInfo(String aName, int theSize, int buying , int selling , SpecificIsland islandName, int theNumber) {
		super(aName, theSize, buying , selling); // need to check the Items class constructer.
		buyingIsland = islandName;	
		numberOfItem = theNumber;
	}
	
	// need a change selling price method in super class
	
	

}
