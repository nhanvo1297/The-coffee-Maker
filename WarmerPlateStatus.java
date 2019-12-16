/* This enumeration class represent for WarmerPlate status
 *  warmer plate has 3 states, warmer plate empty, plate contains empty pot, plate contains partial pot.
 * @author Nhan Vo
 */
package Sensor;

public enum WarmerPlateStatus {
	warmerEmpty, potEmpty, potNotEmpty;
	public WarmerPlateStatus getWarmerPlateStatus() {
		return this;
	}
}
