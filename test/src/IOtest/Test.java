package IOtest;
import java.io.File;


public class Test {
 public static void main(String[] args) throws Exception {
  //�ݹ���ʾC���������ļ��м������ļ�
  File root = new File("D:/default");
  showAllFiles(root);
 }
 
 final static void showAllFiles(File dir) throws Exception{
  File[] fs = dir.listFiles();
  for(int i=0; i<fs.length; i++){  
   if(fs[i].isDirectory()){
	   System.out.println(fs[i].getAbsolutePath());
    try{
     showAllFiles(fs[i]);
    }catch(Exception e){}
   }
  }
 }
}