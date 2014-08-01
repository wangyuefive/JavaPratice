package SomeTest;

public class Bc {
	
	/**
	 * 10�����ַ��� ת��Ϊ16�����ַ��� �� ��5060�� --->0x13c4(������0x)
	 * @param str
	 * @return
	 */
	private static String hexToString(String str)
	{
		int num = Integer.parseInt(str); 
		return String.format("%1$02X", num);
	}
	
	/**
	 * ��10�����ַ������ָ������length��16�����ַ���
	 * ��  ��5060������ǧ��ʮ��---->  ��000013C4��
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
