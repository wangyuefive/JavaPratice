package ActionTest;


public class pair<T>{

	public pair()
	{
		first =null;
		second = null;
	}
	
	public pair(T first,T second)
	{
		this.first = first;
		this.second = second;
	}
	
	public T getfirst(){return first;}	
	public T getsecond(){return second;}
	
	public void setfirst(T first){this.first = first;}
	public void setsecond(T second){this.second = second;}
	
	private T first;
	private T second;
}
