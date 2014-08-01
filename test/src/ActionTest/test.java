package ActionTest;

import java.util.ArrayList;

/**
 * 测试 基本数据类型的变量的数据传递
 *     和对象引用的数据传递
 * @author wangyue
 *
 */
public class test {
	
	public static void main(String[] args)
	{
		int x = 1;
		Integer y = new Integer(10);
		ArrayList<String> list = new ArrayList<String>();
		
		change1(list, "123");
		change2(x,100);
		change3(y,100);
		xx test = new xx(list);
		test.add("hdiaso");
		System.out.print(list + " " + x + " "+ y);
	}
	
	private static void change1(ArrayList<String> list, String str) {
		list.add(str);
	}
	
	private static void change2(int x , int value){
		x = value;
	}
	private static void change3(Integer x , int value){
		x = value;
	}
	
}
