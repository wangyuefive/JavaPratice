package Decorator;


public class JiDan extends Material{  
    
    
    public JiDan(Noodle noodle){  
        super(noodle);  
    }  
  
    @Override  
    public String getDescriptin() {  
        return noodle.getDescriptin()+" + ����";  
          
    }  
  
    @Override  
    public double cost() {  
        return noodle.cost()+1.5;  
    }  
      
}  