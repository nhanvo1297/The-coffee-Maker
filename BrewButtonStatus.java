/*Enumeration class for the status of brew button 
 * Brew Button has two states : isPressed by user, and isNotPressed.
 */
package BrewButton;

public enum BrewButtonStatus {
	isPressed, isNotPressed;
	
	public BrewButtonStatus getBrewButtonStatus() {
		return this;
	}
}
