package Decorator;

public abstract class Material extends Noodle{  
   
	Noodle noodle;  
      
    public Material(Noodle noodle){  
        this.noodle = noodle;  
    }  
      
    public abstract String  getDescriptin();  
  
}  