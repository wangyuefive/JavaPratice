package ThreadTest;


public class Bank {
	
	private final double[] accounts;
	
	public Bank(int n, double initBalance){
		accounts = new double[n];
		for(int i =0; i < n; i++)
			accounts[i] = initBalance;
	}
	
	public synchronized void transfer(int from,int to, double amount) throws InterruptedException {
		
		if(accounts[from] < amount) 
			wait();
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d", amount,from,to);
		accounts[to] += amount;
		System.out.printf(" Total Balance %10.2f\n", getTotalBalance());
		notifyAll();		
	}
	
	public synchronized double getTotalBalance(){
		double sum = 0;
		
		for(double a: accounts)
			sum +=a;
		return sum;
	}
	
	public int size(){
		return accounts.length;
	}
	
	public static void main(String[] args){
		Bank b = new Bank(100, 1000);
		int i ;
		for(i=0 ; i< 100 ; i++){
			TransferRunnable r = new TransferRunnable(b, i, 1000);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
