/*	This Boiler class represent for the boiler of CoffeeMaker
 * 	Boiler includes Boilder status(empty and not empty) & Boiler Heater status( On or Off)
 *  the volume is 12
 *  @author Nhan Vo 
 */

package Boiler;
import Sensor.BoilerStatus;
import Volume.Volume;
import Heater.HeaterBoilerState;
import OnOffDevice.OnOffDevice;

public class Boiler implements OnOffDevice,Volume{
	private BoilerStatus bs;
	private HeaterBoilerState hs;
	private int volume=12;
	
	// Default constructor for boiler
	public Boiler(){
		bs=BoilerStatus.boilerEmpty;
		hs=HeaterBoilerState.Off;
	}
	// Custom constructor for boiler
	public Boiler(BoilerStatus bs,HeaterBoilerState hs) {
		this.bs=bs;
		this.hs=hs;
	}
	// Method to check whether boiler is empty or not.
	public boolean isEmpty() {
		if(bs.getBoilerStatus()==BoilerStatus.boilerEmpty) {
			return true;	// return true if boiler is empty
		}
		else
			return false;	// return false if boiler is not empty
	}
	// Method to fill water in to boiler.
	public Boiler fillWater() throws InterruptedException {
		if(isEmpty()) {
			bs=BoilerStatus.boilerNotEmpty;
			for(int i=1;i<=12;i++) {
				Thread.sleep(1000);
				System.out.println("Adding "+i +" cups of water  to boiler...."+
									"\nThe Capacity is now "+i+"/12 cups");
			}
		}
		else {
			for(int i= getVolume();i<=12;i++) {
				Thread.sleep(1000);
				System.out.println("Adding "+i +" cups of water  to boiler...."+
									"\nThe Capacity is now "+i+"/12 cups");
			}
		}
		
		return this;		// return new boiler with full of water
	}
	// method to set the boiler empty
	public Boiler setEmpty() {
		bs=BoilerStatus.boilerEmpty;
		return this;
	}
	// Method to turn on boiler heater.
	public void turnOn() {
		this.hs=HeaterBoilerState.On;
	}
	// Method to turn off boiler heater/
	public void turnOff() {
		this.hs=HeaterBoilerState.Off;
	}
	//Method to check boiler heater is on or off.
	public boolean isOn() {
		if(hs.getHeaterBoilerState()==HeaterBoilerState.On)
			return true;
		else
			return false;
	}
	// Method to check whether the boiler is ready to boil.
	public boolean isReady() {
		if(!isEmpty()) {
			return true;
		}
		else
			return false;
	}
	//Method to get the current volume of boiler.
	public int getVolume() {
		return volume;
	}
	// method to set the volume for boiler/
	public void setVolume(int volume) {
		this.volume=volume;
	}
	// Method to get status of boiler.
	public void getStatus() {
		System.out.println(bs);
		System.out.println(hs);
	}
}
