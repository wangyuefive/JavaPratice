package Decorator;

public class DecoratorTest {

    public static void main(String[] args) {  
        Noodle noodle = new JiDanNoodle();  
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
  
        noodle = new JiDan(noodle);// 加一个鸡蛋  
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
  
        noodle = new NiuRou(noodle);//我再加分牛肉。呵呵  
          
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
          
        //如果你还不满组的话，还可以加个鸡蛋，加到八个鸡蛋，你就成牛人了...  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
        
        noodle = new JiDan(noodle);
        
        System.out.println(noodle.getDescriptin() + ",价格 " + noodle.cost());  
        
  
    }  
}
