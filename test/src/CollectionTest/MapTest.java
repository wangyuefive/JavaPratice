package CollectionTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapTest {
	
	public static void main(String[] args){
		Map<String, Employee> staff = new HashMap<String, Employee>();
		
		staff.put("1736", new Employee("陈强", 2000));
		staff.put("1737", new Employee("路明", 2000));
		staff.put("1738", new Employee("史庆超", 2000));
		staff.put("1739", new Employee("汪月", 2000));
		
		System.out.println(staff);
		
		staff.remove("1738");
		
		System.out.println(staff);
		
		Set<String> keys = staff.keySet();
		for(String key:keys)
			System.out.println(key);
		
		Collection<Employee> values = staff.values();
		for(Employee value : values)
			System.out.println(value);
		
		Set<Map.Entry<String, Employee>> sets = staff.entrySet();
		for(Entry<String, Employee> set : sets)
		{
			System.out.println(set.getKey() + "-->" + set.getValue());
		}	
		
		System.out.println(staff.get("1739"));
		
		System.out.println(staff.containsKey("1740"));
	}

}
