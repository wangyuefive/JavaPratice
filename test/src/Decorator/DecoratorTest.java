package Decorator;

public class DecoratorTest {

    public static void main(String[] args) {  
        Noodle noodle = new JiDanNoodle();  
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
  
        noodle = new JiDan(noodle);// ��һ������  
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
  
        noodle = new NiuRou(noodle);//���ټӷ�ţ�⡣�Ǻ�  
          
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
          
        //����㻹������Ļ��������ԼӸ��������ӵ��˸���������ͳ�ţ����...  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",�۸� " + noodle.cost());  
        
  
    }  
}
