/* Coffee class represent for type of coffee that the user can select.
 *  3 types of coffee : Strong, Medium, Light
 * @author Nhan vo
 */

package CoffeePot;
public enum Coffee implements Price {
	strongCoffee("Strong Coffee"), 
	mediumCoffee("Medium Coffee"), 
	lightCoffee("Light Coffee");
	private String coffee;
	private Coffee(final String coffee) {
		this.coffee=coffee;
	}
	// Method to return the selected coffee. 
	public String coffeeSelected() {
		return coffee;
	}
	// method to get the price of coffee.
	public double getPrice() {
		return 1.10;
	}
	
}
