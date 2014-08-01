package SomeTest;

public class Bc {
	
	/**
	 * 10进制字符串 转化为16进制字符串 如 “5060” --->0x13c4(不包括0x)
	 * @param str
	 * @return
	 */
	private static String hexToString(String str)
	{
		int num = Integer.parseInt(str); 
		return String.format("%1$02X", num);
	}
	
	/**
	 * 将10进制字符串变成指定长度length的16进制字符串
	 * 如  “5060”（五千六十）---->  “000013C4”
	 * @param str
	 * @param length
	 * @return
	 */
	static String formatString(String str , int length)
	{
		StringBuilder result = new StringBuilder();
		String hexstr = hexToString(str);
		for(int i = 0; i < length-hexstr.length() ; i++)
			result.append("0");
		result.append(hexstr);
		return result.toString();
	}

}
