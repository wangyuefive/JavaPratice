package Decorator;

public abstract class Noodle {  
    private String description ;
    
    public String getDescription()
    {
    	return this.description;
    }
    public void setDescription(String s)
    {
    	this.description = s;
    }
    
    public String getDescriptin(){  
        return description;  
    }  
     
   public abstract double cost();  
 
}  