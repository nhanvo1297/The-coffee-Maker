/* This class represents for spray in coffee maker
 * 
 */
package Spray;

public class Spray {
	SprayState state;
	private int x;
	public Spray() {
		state=SprayState.mediumSpray;
	}
	public void setSpray(int x)  {
		if(x==0) {
			
			state=SprayState.lowLightSpray;
		}
		else if(x==1) {
			state=SprayState.mediumSpray;
		}
		else if(x==2) {
			state=SprayState.fastStrongSpray;
		}
	}
	public SprayState getSprayState() {
		return state;
	}
	public String toString() {
		if(state==SprayState.lowLightSpray) {
			return "Low Light Spray";
		}
		else if(state==SprayState.mediumSpray) {
			return "Medium Spray";
		}
		else
			return "Strong Spray";
	}
}
