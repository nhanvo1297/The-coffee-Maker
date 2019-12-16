// Indicator class represents for indicator light of coffee maker
package Indicator;
import OnOffDevice.OnOffDevice;

public class IndicatorLight implements OnOffDevice{
	IndicatorStatus status;
	// default constructor
	public IndicatorLight(){
		this.status = IndicatorStatus.Off;
	}
	// Method to set state of indicator light (On)
	public void turnOn() {
		status=IndicatorStatus.On;
	}
	// Method to set state of indicator light (Off)
	public void turnOff() {
		status=IndicatorStatus.Off;
	}
	//Method to check the light on or off
	public boolean isOn() {
		if(status.getIndicatorStatus()==IndicatorStatus.On) {
			return true;
		}
		else
			return false;
	}
	
	
}
