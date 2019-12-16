/*This class represent for the user's actions
 * The user can interact with warmer plate, filter holder, spray, boiler, brew button, coffee pot, coffee cup.
 * @author Nhan Vo
 */
package CoffeeMakerAPI;

import Boiler.Boiler;
import WarmerPlate.WarmerPlate;
import ReliefValve.ReliefValve;
import BrewButton.BrewButton;
import Spray.Spray;
import Indicator.IndicatorLight;
import FilterHolder.FilterHolder;
import CoffeePot.*;


public class CoffeeMakerAPI{
	
	private WarmerPlate plate;
	private Boiler boiler;
	private FilterHolder filterHolder;
	private Spray spray;
	private BrewButton brewButton;
	private boolean receptacle;
	private CoffeePot pot;
	private CoffeeCup cup;
	
	
	public CoffeeMakerAPI() {
		plate = new WarmerPlate();
		boiler = new Boiler();
		filterHolder = new FilterHolder();
		spray = new Spray();
		brewButton = new BrewButton();
		receptacle= false;
		cup= null;
		pot= new CoffeePot(spray);
	}
	public CoffeePot getCoffeePotStatus() {
		return pot;
	}
	public BrewButton getBrewButtonStatus() {
		return brewButton;
	}
	public WarmerPlate getWarmerPlateStatus() {
		return plate;
	}
	public Boiler getBoilerStatus() {
		return boiler;
	}
	
	public FilterHolder getfilterHolderStatus() {
		return filterHolder;
	}
	public Spray getSprayStatus() {
		return spray;
	}
	public boolean isReceptacleReady() {
		if(receptacle==true) {
			return true;
		}
		else
			return false;
	}
	// Method implements the user lift the pot from warmer.
	public void liftPotFromWarmer() throws InterruptedException  {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady has lift pot from warmer");
		plate.setNoPot();
	}
	// This method's implementation as the user press Brew button
	public void pressBrewButton() throws InterruptedException   {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady pressed Brew Button and start the brew cycle.");
		brewButton.pressBrewButton();
	}
	// The user put the empty pot on warmer
	public void putEmptyPotOnWarmer()  throws InterruptedException  {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady set empty pot on warmer.");
		plate.setEmptyPot();
	}
	// The user fill boiler with water
	public void fillBoilerWithWater() throws InterruptedException   {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady filled boiler with water.");
		boiler = boiler.fillWater();
	}
	// The user put filter and coffee ground into filter holder
	public void putFilterAndCoffeeGroundIntoFilterHolder() throws InterruptedException   {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady placed filter and coffee ground into Filter Holder.");
		filterHolder.setFilterHolderNotEmpty();
	}
	// The user load filter holder into receptacle
	public void loadFilterHolderIntoReceptacle() throws InterruptedException   {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady loaded filter holder into receptacle.");
		receptacle=true;
	}
	// The user select coffee strength
	public void selectCoffeeStrength(int x) throws InterruptedException  {
		Thread.sleep(1000);
		if(x==0) { 
			System.out.println("The Coffee Lady set coffee strength to light");
		}
		if(x==1) {
			System.out.println("The Coffee Lady set coffee strength to medium");
		}
		if(x==2) {
			System.out.println("The Coffee Lady set coffee strength to strong");
		}
		spray.setSpray(x);
		
	}
	// The user remove coffee pot
	public void removeCoffeePot() throws InterruptedException   {
		Thread.sleep(1000);
		plate.setNoPot();
	}
	// The user return coffee pot
	public void returnCoffeePot() throws InterruptedException  {
		Thread.sleep(1000);
		System.out.println("The Coffee Lady returned pot with coffee back on the warmer plate");
		plate.setPartialPot();
	}
	// The user pour a cup of coffee
	public void pourCoffeeCup() throws InterruptedException  {
		
		if(CoffeePot.numberOfCup>0) {
			cup = new CoffeeCup(pot.getCoffee(spray));
			pot.pourAcup();
			System.out.println("The Coffee Lady poured "+pot.getCoffee(spray).coffeeSelected()+"  into a cup");
		}
		else {
			Thread.sleep(1000);
			System.out.println("Out of Coffee in the pot");
		}
		
	}
	// The user add extra condiments into coffee cup
	public void addExtra(Extra...ex) {
		cup.addExtra(ex);
	}
	// Method to print the cost of coffee cup
	public void printCost() throws InterruptedException   {
		System.out.println("Coffee is ready: "+cup.toString());
		System.out.println("The cost for a coffee cup is $"+cup.getPrice());
	}
	// The user interrupt brewing process
	public void interruptBrewing(int processValue)  throws InterruptedException  {
		System.out.println("The Coffee Lady interrupted the brewing process. ");
		pot.setVolume(processValue);
		boiler.setVolume(12-processValue);
	}

	
}
