/* Brew Button class represent for Brew Button in Coffee Maker.
 * @author Nhan Vo
 * 
 */
package BrewButton;

public class BrewButton {
	private BrewButtonStatus button;
	public BrewButton(){
		button=BrewButtonStatus.isNotPressed;
	}
	// Method to set the state of brew button
	public void pressBrewButton() {
		button=BrewButtonStatus.isPressed;
	}
	// method to set the state of brew button
	public void depressBrewButton() {
		button=BrewButtonStatus.isNotPressed;
	}
	// method the check the state of brew button.
	public boolean isBrewButtonPressed() {
		if(button==BrewButtonStatus.isPressed) {
			return true;
		}
		else {
			return false;
		}
	}
}
