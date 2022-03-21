package PROJECT;

public class Upgrade {
	
	private String name = new String("None");
	private int buyPrice;
	private int sellPrice;
	private String explain = new String("Explain what this upgrade does");

	public Upgrade(String theName, String theExplain, int theBuyPrice, int theSellPrice) {
		name = theName;
		explain = theExplain;
		buyPrice = theBuyPrice;
		sellPrice = theSellPrice;
				
	}

	public String getName() {
		return name;
	}
	
	public int getSellPrcie() {
		return sellPrice;
	}
	
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public String getExplain() {
		return explain;
	}
}
