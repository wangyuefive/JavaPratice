package SomeTest;

public class datachange {
	
	public static void main(String[] args){
		
		String str = "2014-07-11 12:34:21";
		String str2 = dateChange_1(str);
		String str3 = dateChange_2(str2);
		System.out.println(str2);
		System.out.println(str3);
		short s1 = 1;
		s1 = (short) (s1 +1);
		
	}
	
	 /**
     * 日期格式转换
     * 例如：2014-07-11 16:34:21 ----> 07/11/14 04:34:21 PM
     * @param origdate
     * @return
     */
	 public static String dateChange_1(String origdate){
	    	String result = "";
	    	String date = origdate.split(" ")[0];
	    	String time = origdate.split(" ")[1];
	 
	    	String year = date.split("-")[0].substring(2);
	    	String moth = date.split("-")[1];
	    	String day =  date.split("-")[2];
	    	
	    	String APM = "AM";
	    	String hour = time.split(":")[0];
	    	String minute =time.split(":")[1];
	    	String sec = time.split(":")[2];
	    	if(hour.compareTo("12") >= 0)
	    	{
	    		APM = "PM";
	    		if(hour.compareTo("12") > 0)
	    			hour = "0"+(Integer.parseInt(hour)-12);
	    	}
	    	result = moth+"/"+day+"/"+year+" "+hour+":"+minute+":"+sec+" "+APM;
	    	return result;
	    }
	 
	 /**
	     * 日期格式转换
	     * 例如：07/11/14 04:34:21 PM--->2014-07-11 16:34:21 
	     * @param origdate
	     * @return
	     */
	    public static  String dateChange_2(String origdate){
	    	String result = "";
	    	String date = origdate.split(" ")[0];
	    	String time = origdate.split(" ")[1];
	    	String APM = origdate.split(" ")[2];
	 
	    	String year = "20"+date.split("/")[2];
	    	String moth = date.split("/")[0];
	    	String day =  date.split("/")[1];
	    	
	    	String hour = time.split(":")[0];
	    	String minute =time.split(":")[1];
	    	String sec = time.split(":")[2];
	    	if(APM.equals("PM") && !hour.equals("12"))  //对于12:35：01 PM的特殊情况
	    		hour = ""+(Integer.parseInt(hour)+12);
	    	result = year + "-" + moth + "-"+ day+" " + hour+ ":"+ minute+":"+sec;
	    	return result;
	    }

}
