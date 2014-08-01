package ThreadTest;

public class TransferRunnable implements Runnable {
	public TransferRunnable(Bank b,int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount =max;
	}
	
	public void run() {
		int toAccount = (int)(bank.size()*Math.random());
		double amount =(maxAmount+10000) *Math.random();	
		try {
			bank.transfer(fromAccount, toAccount, amount);
			Thread.sleep((int)(DELAY *Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 1000;
}