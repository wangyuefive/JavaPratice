package ActionTest;

public class PairTest {
	
	public static void main(String[] args)
	{
		String[] words = {"wangyue","dashi","luming","chengqiang"};
		pair<String> mm = Array.minmax(words);
		System.out.print("min = " + mm.getfirst()+"\n");
		System.out.print("max = " + mm.getsecond() + "\n");
		
	}

}

class Array
{
	public static <T extends Comparable> pair<T> minmax(T[] a)
	{
		if(a ==null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		
		for(int i =0 ; i <a.length ; i++)
		{
			if(min.compareTo(a[i]) > 0)
				min = a[i];
			if(max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new pair<T>(min,max);
	}
}
