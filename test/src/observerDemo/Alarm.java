package observerDemo;

import java.util.Observable;
import java.util.Observer;

public class Alarm implements Observer {
	
	public void makeAlarm() {
		System.out.println("������...ˮ�Ѿ��տ� ");
	}
	
	public void update(Observable o, Object arg) {
		makeAlarm();
	}
}