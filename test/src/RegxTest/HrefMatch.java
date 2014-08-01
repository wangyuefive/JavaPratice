package RegxTest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * �ҳ�һ����ҳ�е��������Ӳ���ӡ��
 * @author wangyue
 *
 */
public class HrefMatch {

	private static Logger log = Logger.getLogger(HrefMatch.class);
	
	public static void main(String[] args) throws IOException{
		String urlstr = "http://www.ifeng.com"; 
		URL url = new URL(urlstr);
		
		InputStreamReader in = new InputStreamReader(url.openStream(),"UTF-8");
		
		StringBuilder input = new StringBuilder();
		int ch;
		while((ch=in.read())!=-1){
			input.append((char)ch);
		}
		
		String patternstr = "\\bhref\\s*=\\s*(\"[^\"]*|[^\\s]*)\"" ;  //������ʽ ��ҳURL
		Pattern pattern = Pattern.compile(patternstr);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			String matchstr = input.substring(start,end);
			log.info(matchstr);
		}
		in.close();
	}
}
