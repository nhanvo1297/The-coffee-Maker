/* Coffee Pot class represent for the pot in Coffee Maker 
 * the pot has maximum volume is 12
 * @author Nhan Vo
 */

package CoffeePot;
import Spray.Spray;
import Volume.Volume;
import java.util.*;

public class CoffeePot implements Volume {
	Coffee coffee;
	private int volume=12;		// original volume is 0 the pot is empty
	
	public static int numberOfCup=12;
	// custom constructor to determine type of coffee will have in the pot
	public CoffeePot(Spray spray){
		coffee = getCoffee(spray);
	}
	// Method to get type coffee in the pot
	public Coffee getCoffee(Spray spray) {
		Coffee coffee=null;
		
		switch(spray.getSprayState()) {
			case lowLightSpray:
				coffee=Coffee.lightCoffee;
				break;
				
			case mediumSpray:
				coffee=Coffee.mediumCoffee;
				break;
				
			case fastStrongSpray:
				coffee=Coffee.strongCoffee;
				break;
		}
		return coffee;	
	}
	// Method to set the volume of coffee inthe pot after pour a cup
	public void pourAcup() {
		numberOfCup-=1; // the volume of coffee in the pot decrease 1 cup
	}
	// Method to get current volume of the pot
	public int getVolume() {
		return volume;
	}
	// Method to set the volume for the pot
	public void setVolume(int volume) {
		this.volume=volume;
		numberOfCup= 12 - volume;
	}
			
	
	
	
	
}
