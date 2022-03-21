package PROJECT;
import java.util.Arrays;

public class Repair {

	private String[] conditionList = {"Perfect", "Little Damage", "Damage", "Very Bad Damage", "Destroy"};
	private int[] repairPrice = {0,	4000,	10000,	20000,	30000};
	
	
	public int getRepairPrice(String condition) {
		int theIndex = Arrays.binarySearch(conditionList, condition);
		return repairPrice[theIndex];
	}


}
	


