package observerDemo;

public class testObserver {
	
	public static void main(String[] args) {
		Heater heater = new Heater();
		Display display = new Display();
		Alarm alarm = new Alarm();
		heater.addObserver(display);
		display.addObserver(alarm);
		heater.boilWater();
		}
	}