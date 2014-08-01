package observerDemo;

import java.util.Observable;
import java.util.Observer;

public class Display extends Observable implements Observer {
		private String status = "δ��";
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public void displayTemputer(int temperature) {
			if (temperature > 95) {
				this.setStatus("����");
				this.setChanged();
				this.notifyObservers();
			}
			System.out.println("״̬��" + status + " �����¶ȣ�" + temperature + "");
		}
		
		public void update(Observable o, Object arg) {
			displayTemputer(((Heater) o).getTemperature());//���ﲻ�Ǻܺ�
		}
	}