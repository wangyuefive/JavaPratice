package Tree;

public class test {
	
	public static void main(String[] args){
		String str= "2014-07-11 16:34:21";
		String str2="07/11/14 04:34:21 PM";
		System.out.println(test.dateChange_1(str));	
		System.out.println(test.dateChange_2(str2));
		
		String str3 = "192.216.3.145";
		String[] ll = str3.split("\\.");
		System.out.println(ll.length);
	}
	
	private static String dateChange_1(String origdate){
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
    	if(hour.compareTo("12") > 0)
    	{
    		APM = "PM";
    		hour = "0"+(Integer.parseInt(hour)-12);
    	}
    	result = moth+"/"+day+"/"+year+" "+hour+":"+minute+":"+sec+" "+APM;
    	return result;
    }
	
	 private static String dateChange_2(String origdate){
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
	    	if(APM.equals("PM"))
	    		hour = ""+(Integer.parseInt(hour)+12);
	    	result = year + "-" + moth + "-"+ day+" " + hour+ ":"+ minute+":"+sec;
	    	return result;
	    }

}
