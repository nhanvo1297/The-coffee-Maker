package ReliefValve;
import OpenCloseDevice.OpenCloseDevice;

public class ReliefValve implements OpenCloseDevice{
	ReliefValveSensor sensor;
	
	public ReliefValve() {
		sensor = ReliefValveSensor.Close;
	}
	
	public void open() {
		sensor=ReliefValveSensor.Open;
	}
	public void close() {
		sensor=ReliefValveSensor.Close;
	}
	public boolean isOpen() {
		if(sensor.getRVStatus()==ReliefValveSensor.Open) {
			return true;
		}
		else
			return false;
	}
}
