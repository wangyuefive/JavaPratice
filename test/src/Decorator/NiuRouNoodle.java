package Decorator;

public class NiuRouNoodle extends Noodle{  
    public NiuRouNoodle(){  
        super.setDescription("ţ����");
    }  
  
    @Override  
    public double cost() {  
        return 7.5;  
    }  
      
} 