
package Decorator;

public class NiuRou extends Material{  
    
    public NiuRou(Noodle noodle){  
        super(noodle);  
    }  
  
    @Override  
    public String getDescriptin() {  
        return noodle.getDescriptin()+" + ţ��";  
    }  
  
    @Override  
    public double cost() {  
          return noodle.cost()+2.0;  
    }  
      
}  