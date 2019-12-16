/* Extra class represents for the condiments that the user can add into coffee cup
 * @author Nhan Vo
 */
package CoffeePot;

public class Extra implements Price{
	private String name;
	private double price;
	// Custom Constructor 
	public Extra(String name,double price) {
		this.name=name;
		this.price=price;
	}
	// method to get the price of condiment
	public double getPrice() {
		return price;
	}
	// Method to get the name of condiment
	public String getName() {
		return name;
	}
	
}
