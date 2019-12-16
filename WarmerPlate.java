package WarmerPlate;
import Heater.HeaterPlateState;
import Sensor.WarmerPlateStatus;
import OnOffDevice.OnOffDevice;

public class WarmerPlate implements OnOffDevice {
	HeaterPlateState hs;
	WarmerPlateStatus ws;
	public WarmerPlate() {
		ws=WarmerPlateStatus.warmerEmpty;
		hs=HeaterPlateState.Off;
	}
	
	public WarmerPlate(WarmerPlateStatus ws, HeaterPlateState hs) {
		this.hs=hs;
		this.ws=ws;
	}
	// Method to check empty pot
	public boolean hasEmptyPot() {
		if(ws.getWarmerPlateStatus()==WarmerPlateStatus.potEmpty) {
			return true;
		}
		else
			return false;
	}
	//method to check whether pot on warmer
	public boolean hasNoPot() {
		if(ws.getWarmerPlateStatus()==WarmerPlateStatus.warmerEmpty) {
			return true;
		}
		else
			return false;
	}
	//Method to check pot on warmer
	public boolean hasPartialPot() {
		if(ws.getWarmerPlateStatus()==WarmerPlateStatus.potNotEmpty) {
			return true;
		}
		else
			return false;
	}
	//Method to turn on heater plate
	public void turnOn() {
		this.hs=HeaterPlateState.On;
	}
	//Method to turn off heater plate
	public void turnOff() {
		this.hs=HeaterPlateState.Off;
	}
	// method to check heater status on or off
	public boolean isOn() {
		if(hs.getHeaterPlateState()==HeaterPlateState.On) {
			return true;
		}
		else
			return false;
	}
	// method to put empty pot on plate
	public void setEmptyPot() {
		ws=WarmerPlateStatus.potEmpty;
	}
	// method to remove pot
	public void setNoPot() {
		ws=WarmerPlateStatus.warmerEmpty;
	}
	// method to set non empty pot 
	public void setPartialPot() {
		ws=WarmerPlateStatus.potNotEmpty;
	}
	public void getStatus() {
		System.out.println(ws);
		System.out.println(hs);
	}
}
