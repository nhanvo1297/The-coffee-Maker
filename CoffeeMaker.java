/* This class represents for a Coffee Maker
 * The coffee maker has many components boiler, warmer plate, relief valve, brewbutton, spray,...
 * @author Nhan Vo
 */
package CoffeeMaker;

import Boiler.Boiler;
import WarmerPlate.WarmerPlate;
import ReliefValve.ReliefValve;
import BrewButton.BrewButton;
import Spray.Spray;
import Indicator.IndicatorLight;
import CoffeeMakerAPI.CoffeeMakerAPI;
import FilterHolder.FilterHolder;
import CoffeePot.CoffeePot;

public class CoffeeMaker {
	
	private CoffeeMakerAPI api;
	private Boiler boiler;
	private WarmerPlate warmerPlate;
	private ReliefValve valve;
	private BrewButton brewButton;
	private Spray spray;
	private IndicatorLight indicatorLight;
	private FilterHolder holder;
	private CoffeePot pot;
	private boolean isBrewing;
	
	public CoffeeMaker(CoffeeMakerAPI api){
		this.api=api;
		boiler = api.getBoilerStatus();
		warmerPlate = api.getWarmerPlateStatus();
		brewButton = api.getBrewButtonStatus();
		valve = new ReliefValve();
		indicatorLight = new IndicatorLight();
		holder=api.getfilterHolderStatus();
		isBrewing =false;
		pot=api.getCoffeePotStatus();
				
	}
	// Method to check whether the warmer is ready to brew coffee.
	public boolean isWarmerReady() {
		if(warmerPlate.hasEmptyPot()|warmerPlate.hasPartialPot()) {
			return true;
		}
		else
			return false;
	}
	// method to check whether the boiler is ready to brew coffee.
	public boolean isBoilerReady() {
		if(boiler.isReady()) {
			return true;
		}
		else 
			return false;
	}
	// Method to check the receptacle is ready to brew
	public boolean isReceptacleReady() {
		if(api.isReceptacleReady()) {
			return true;
		}
		else
			return false;
	}
	// Method to check the filter holder is ready to brew
	public boolean isFilterHolderReady() {
		if(!holder.isFilterHolderEmpty()){
			return true;
		}
		else
			return false;
	}
	// method to check whether the brew button is pressed
	public boolean isBrewButtonPressed() {
		if(brewButton.isBrewButtonPressed()) {
			return true;
		}
		else
			return false;
	}
	// method to check whether every component is ready to brew
	public boolean isReadyToBrew() {
		if(isWarmerReady()&&isBoilerReady()&&isReceptacleReady()&&isBrewButtonPressed()) {
			valve.open();
			return true;
		}
		else
			return false;
	}
	// method to start brewing process
	public void Brewing(int n) throws InterruptedException {
		if(isReadyToBrew()) {
			
			valve.close();
			boiler.turnOn();
			Thread.sleep(1000);
			System.out.println("Water is boiled");
			Thread.sleep(1000);
			spray=api.getSprayStatus();
			System.out.println("Adjust spray force to "+spray );
			Thread.sleep(1000);
			System.out.println("Start brewing coffee.....");
			isBrewing =true;
			for(int i=1;i<=n;i++) {
				Thread.sleep(1000);
				System.out.println("Brewing in process.... Coffee pot capacity is at "+i+ " cups");
				
			}
			boiler.setVolume(12-n);
		}
		
		else{
			System.out.println("Cannot brew");
			
		}
	}
	// method to complete the brewing cycle
	public void DoneBrewing() throws InterruptedException {
		if(!isFilterHolderReady()) {
			Thread.sleep(1000);
			System.out.println("No Coffee in holder.");
		}
		
		else if(boiler.isOn()&&!valve.isOpen()&&isFilterHolderReady()) {
			boiler=boiler.setEmpty();
			boiler.turnOff();
			indicatorLight.turnOn();
			Thread.sleep(1000);
			System.out.println("Brewing process is completed.");
			
			Thread.sleep(1000);
			System.out.println("Boiler Status: "+(boiler.isEmpty()==true?"Empty":"Not empty"));
			Thread.sleep(1000);
			System.out.println("Boilder Heater status:"+(boiler.isOn()==true?"On":"Off"));
			Thread.sleep(1000);
			System.out.println("Indicator Light status: "+(indicatorLight.isOn()==true?"On":"off"));
			Thread.sleep(1000);
			System.out.println("Coffee is ready!!!");
			boiler.setVolume(0);
		}
		else {
			System.out.println("Not complete");
		}
	
	}
	// method to update the user 's action
	public void getUpdate(CoffeeMakerAPI api) throws InterruptedException {
		this.api=api;
		boiler = api.getBoilerStatus();
		warmerPlate = api.getWarmerPlateStatus();
		brewButton = api.getBrewButtonStatus();
		holder=api.getfilterHolderStatus();
		pot=api.getCoffeePotStatus();
		
		if(warmerPlate.hasNoPot()) {
			Thread.sleep(1000);
			System.out.println("WarmerPlate: Off");
			warmerPlate.turnOff();
			boiler.turnOff();
			Thread.sleep(1000);
			System.out.println("Boiler Heater: Off");
			valve.open();
			Thread.sleep(1000);
			System.out.println("Relief Valve: Opened");
			
			if(indicatorLight.isOn()) {
				Thread.sleep(1000);
				System.out.println("Indicator Light: Off");
				indicatorLight.turnOff();
			}
			
		}
		else if(warmerPlate.hasPartialPot()) {
			Thread.sleep(1000);
			System.out.println("Coffee remaining in the pot.");
			warmerPlate.turnOn();
			Thread.sleep(1000);
			System.out.println("Warmer Plate: On");
			
		}
		else if(warmerPlate.hasEmptyPot()) {
			warmerPlate.turnOff();
			Thread.sleep(1000);
			System.out.println("Warmer Plate: Off");
			
		}
		if(boiler.isEmpty()) {
			boiler= boiler.setEmpty();
			boiler.turnOff();
			Thread.sleep(1000);
			System.out.println("Boiler Heater: Off");
		}
		else if(!boiler.isEmpty()&&!warmerPlate.hasNoPot()) {
			boiler.turnOn();
			Thread.sleep(1000);
			System.out.println("Boiler Heater: On");
			valve.close();
			Thread.sleep(1000);
			System.out.println("Relief Valve: Closed");
		}
		
	
		
	}
	
	public void getPlateStatus() {
		warmerPlate.getStatus();
	}
	// method to stop the brewing process
	public void stopBrewingCycle() {
		if(isBrewing==true) {
			boiler.turnOff();
			valve.open();
			
			if(indicatorLight.isOn()) {
				indicatorLight.turnOff();
			}
		}
		else {
			System.out.println("the brewing cycle is already stop");
		}
	}
	//method to resume the brewing process
	public void resumeBrewingCycle() throws InterruptedException {
		boiler.turnOn();
		valve.close();
		Thread.sleep(1000);
		System.out.println("Coffee Maker resumes brewing process.....");
		Thread.sleep(1000);
		System.out.println("Adjust spray force to "+spray );
		
		for(int i=12-boiler.getVolume()+1;i<=12;i++) {
			Thread.sleep(1000);
			System.out.println("Brewing in process.... Coffee pot capacity is at "+i+ " cups");
			
		}
		boiler.setVolume(0);
		boiler.setEmpty();
	}
	public void getBoilerPotVolume() {
		System.out.println("Pot volume"+ this.pot.getVolume());
		System.out.println("Boiler Volume"+this.boiler.getVolume());
	}
	
	
	
	
}
