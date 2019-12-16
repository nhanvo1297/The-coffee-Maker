/* This enumeration class represents for boiler status ( contains water or not)
 * @author Nhan Vo
 */

package Sensor;

public enum BoilerStatus {
	boilerEmpty, boilerNotEmpty ;	// only two states.
	public BoilerStatus getBoilerStatus() {
		return this;
	}
}
