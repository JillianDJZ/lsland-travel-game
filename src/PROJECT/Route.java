/**
 * 
 */
package core;

/**
 * @author Prab
 *
 */
public class Route 
{	
	
	private String islandName; 
	private int distance; 
	private String sailingRisk;
	private int days;

	/**
	 * 
	 */
	public Route(String islandName, int distance, String sailingRisk) 
	{
		this.islandName = islandName;
		this.distance = distance;
		this.sailingRisk = sailingRisk;
		this.days = distance / 100;
	}
	
	public int getDistance()
	{
		return distance;
	}
	public String getIslandName()
	{
		return islandName;
	}
	public String getSailingRisk()
	{
		return sailingRisk;
	}
	
	public int getNumberOfDays()
	{
		return days;
	}
	public void setDays(int numDays)
	{
		days = numDays;
	}

}
