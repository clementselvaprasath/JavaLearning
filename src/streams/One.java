package streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class One {

	public static Map<String, Integer> priorityValue = new HashMap<String, Integer>();
	public static Map<String, Integer> runningCount = new HashMap<String, Integer>();
	public static Map<String, Integer> throttleValue = new HashMap<String, Integer>();
	static {
		priorityValue.put("ECI_BOT", 1);
		priorityValue.put("MSM", 5);
		priorityValue.put("MSR", 6);
		// New Label
		//priorityValue.put("DEVXDASH", 9);
		priorityValue.put("", 15);
		priorityValue.put("ECI_BOT_JIRA", 16);
	}
	
	static {
		runningCount.put("ECI_BOT", 9);
		runningCount.put("MSM", 9);
		runningCount.put("MSR", 9);
		runningCount.put("DEVXDASH", 9);
		runningCount.put("ECI_BOT_JIRA", 9);
	}
	
	static {
		throttleValue.put("ECI_BOT", 10);
		throttleValue.put("MSM", 10);
		throttleValue.put("MSR", 10);
		throttleValue.put("DEVXDASH", 10);
		throttleValue.put("ECI_BOT_JIRA", 10);
	}
	
	public static void main(String[] args) {
		//Nested For loop
		int [] intArray = {1,7,8,9};
		Arrays.stream(intArray)
		.forEach(e -> {
			IntStream.range(0, e)
			.forEach(i -> {System.out.print("*");});
			System.out.println("");
		});
		
		
/*		List<String> myList =
				Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList
		.stream()
		.filter(s -> s.startsWith("c"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);*/
		//=================================================================================
		// LIST to LIST
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );
		// convert inside the map() method directly.
        List<StaffPublic> result1 = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            return obj;
        }).collect(Collectors.toList());

        //System.out.println(result1);
        
      //=================================================================================
        // MAP to MAP
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        //System.out.println(collect); //output : {2=heroku.com}
      //=================================================================================
        // MAP to MAP
        
        Map<Integer, String> random = new HashMap<Integer, String>();
        for (int i = 0; i < 10; i++) {
            random.put((int)(Math.random() * 100), String.valueOf((int) (Math.random() * 100)));
        }

        System.out.println("Initial Map: " + Arrays.toString(random.entrySet().toArray()));

        Map<Integer, String> sortedMap =
                random.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        //=================================================================================
        //LIST to MAP //GropingBy
        Map<Character, List<String>> result10 = Stream
        	      .of( "Apple", "Ananas", "Mango", "Banana","Beer")
        	      .sorted()
        	      .collect(Collectors.groupingBy(it -> it.charAt(0)));

        	//System.out.println(result10);

        //=================================================================================
		List<Task> taskList = new ArrayList<>();
		taskList.add(new Task("taskId1", "ECI_BOT", "3"));
		taskList.add(new Task("taskId2", "MSM", "5"));
		taskList.add(new Task("taskId3", "ECI_BOT_JIRA", "2"));
		taskList.add(new Task("taskId4", "ECI_BOT_JIRA", "2"));
		taskList.add(new Task("taskId5", "ECI_BOT", "3"));
		taskList.add(new Task("taskId6", "MSR", "6"));
		taskList.add(new Task("taskId7", "MSM", "5"));
		taskList.add(new Task("taskId8", "MSR", "6"));
		taskList.add(new Task("taskId9", "DEVXDASH", "7"));
		taskList.add(new Task("taskId10", "MSM", "5"));
		taskList.add(new Task("taskId11", "DEVXDASH", "7"));
		taskList.add(new Task("taskId12", "MSR", "6"));
		taskList.add(new Task("taskId13", "DEVXDASH", "7"));
		taskList.add(new Task("taskId14", "ECI_BOT", "3"));
		taskList.add(new Task("taskId15", "ECI_BOT", "3"));
		taskList.add(new Task("taskId16", "", "3"));
		taskList.add(new Task("taskId17", null, "3"));	
		
		
		
		
        Map<String, List<Task>> result =
        		taskList.stream().collect(Collectors.groupingBy(Task::getLabel));		
        System.out.println(result);
        
        for(Map.Entry<String,List<Task>> r : result.entrySet()){
        	String labelKey = r.getKey();
        	if(runningCount.get(labelKey) != null && throttleValue.get(labelKey) != null  ){
        		//&& runningCount.get(labelKey) < throttleValue.get(labelKey)
        		//&& r.getValue().size() > throttleValue.get(labelKey)
        		List listTasks = r.getValue();
        		//System.out.println("listTasks.size()   --- "+listTasks.size());
        		//System.out.println("  -- "+runningCount.get(labelKey).intValue());
        		//System.out.println("  -- "+throttleValue.get(labelKey).intValue());
        		if(runningCount.get(labelKey).intValue() < throttleValue.get(labelKey).intValue() ){
        			//&& (throttleValue.get(labelKey) - runningCount.get(labelKey)) < listTasks.size()
        			//System.out.println("IF condition");
        			listTasks.subList((throttleValue.get(labelKey) - runningCount.get(labelKey) < listTasks.size() ? throttleValue.get(labelKey) - runningCount.get(labelKey) :listTasks.size()), listTasks.size()).clear();
        		}
        		else
        			listTasks.subList(0, listTasks.size()).clear();
        		//System.out.println("listTasks.size() 1  --- "+listTasks.size());
        		//result.put(labelKey, listTasks);
        	}
        }
        System.out.println(result);
        //=================================================================================
        // Checking with each TASK throttle value with priorityValue
/*        Map<String, List<Task>> result1212 = taskList.stream().filter((f) -> {
        	int prValue = (priorityValue.get(f.getLabel()) != null) ? priorityValue.get(f.getLabel()) : 0;
        	if (Integer.parseInt(f.getThrottle()) < prValue) 
        		return true;
			return false;
        }).collect(Collectors.groupingBy(Task::getLabel));	
        System.out.println(result1212);*/
        
        
        // Example for Reducing
/*		Comparator<Task> byHeight = Comparator.comparing(Task::getThrottle);
        Map<String, Optional<Task>> result111 =
        		taskList.stream().collect(Collectors.groupingBy(Task::getLabel, Collectors.reducing(BinaryOperator.maxBy(byHeight))));		
        //System.out.println(result111);        
*/        
        //=================================================================================        
        int runningCount = 6; 
        Predicate<Task> throttleFilter = p -> (new Integer(p.getThrottle())) > runningCount;
        
/* System.out.println(result.entrySet().stream()
        		.map( (map) -> {
        			return map.getValue().stream().filter(ch -> {
        				final int prValue = priorityValue.get(ch.getLabel());
        				if (Integer.parseInt(ch.getThrottle()) < prValue) return true;
        				return false;        				
        			});
        		})
        		.collect(Collectors.groupingBy(Task::getLabel))
        		);*/

/*        System.out.println(result.entrySet().stream()
        		.filter((f) -> {
        			f.getValue().stream().filter((f1) -> {
        				final int prValue = priorityValue.get(f1.getLabel());
        				if (Integer.parseInt(f1.getThrottle()) < prValue) return true;
        				return false;
        			});
        		})
        		.collect(Collectors.toMap(Map.Entry::getKey ,e ->e))
        		);*/
        
        //System.out.println(taskList.stream().filter(throttleFilter).collect(Collectors.toList()));
        
        
        List<Task> distinctElements = taskList.stream().filter(distinctByKey(p -> p.getLabel())).collect(Collectors.toList());
        
        List<String> distinctLabel = taskList.stream().filter(distinctByKey(p -> p.getLabel())).map(p1 -> p1.getLabel()).collect(Collectors.toList());
        
        //System.out.println(distinctLabel);
        

	}
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}

class Task {

    private String taskId;
    private String label = "ondemand";
    private String throttle;

    public Task(String taskId, String label, String throttle) {
        this.taskId = taskId;
        if (label !=  null && !label.equals(""))
        	this.label = label;
        this.throttle = throttle;
    }

    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getThrottle() {
		return throttle;
	}

	public void setThrottle(String throttle) {
		this.throttle = throttle;
	}

	@Override
    public String toString() {
        return "Task{" +
               "taskID='" + taskId + '\'' +
               ", label='" + label + '\'' +
               ", throttle='" + throttle + '\'' +
               '}';
    }
}

 class Staff {

    private String name;
    private int age;
    private BigDecimal salary;
	//...
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Staff(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
    
}
 
 class StaffPublic {

	    private String name;
	    private int age;
	    private String extra;
	    //...
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getExtra() {
			return extra;
		}
		public void setExtra(String extra) {
			this.extra = extra;
		}
		
		public StaffPublic() {
			super();
			// TODO Auto-generated constructor stub
		}
		public StaffPublic(String name, int age, String extra) {
			super();
			this.name = name;
			this.age = age;
			this.extra = extra;
		}
	    
	}