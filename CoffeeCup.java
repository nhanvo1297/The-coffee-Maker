// Coffee Cup class represent for a cup of coffee, include coffee and condiments.
package CoffeePot;

import java.util.*;
public class CoffeeCup {
		private List<Extra> extra;
		private Coffee coffee;
		// custom constructor for Coffee Cup
		public CoffeeCup(Coffee coffee){
			this.coffee=coffee;
			extra=new ArrayList<Extra>();
		}
		// method to add more condiments into coffee cup
		public void addExtra(Extra...ex) {
			extra=Arrays.asList(ex);
		}
		// Method to get total cost of coffee cup
		public double getPrice() {
			double cost = coffee.getPrice();
			
			for(Extra ex : extra) {
				cost+=ex.getPrice();
			}
			return cost;
		}
		// method to get String of coffee condiments
		public String toString() {
			String s ="";
			for(Extra ex: extra) {
				s=s + ex.getName()+" ";
			}
			return s+ coffee.coffeeSelected();
		}
		
}
