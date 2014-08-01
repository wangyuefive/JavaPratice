package SomeTest;

public class StringAdd {
	
	
	public static void main(String[] args)
	{
		String tempstr = "abcdefghijklmnopqrstuvwxyz";
        int times = 50;
        long lstart1 = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < times; i++) {
            str += tempstr;
        }
        long lend1 = System.currentTimeMillis();
        long time = (lend1 - lstart1);
        System.out.println(time + "\n");
        
     
        long lstart2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(tempstr);
        }
        long lend2 = System.currentTimeMillis();
        long time2 = (lend2 - lstart2);
        System.out.println(time2 + "\n");
        //String str1 = sb.toString();
        //System.out.println(str1 + "\n");
        
        String str11 = "5060";
        System.out.println( Bc.formatString(str11 , 8) );   
     
	}

	
}
