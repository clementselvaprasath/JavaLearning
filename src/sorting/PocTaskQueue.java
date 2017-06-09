package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;



/**
 * POC for Task queue in Devrunner Mesos
 */
public class PocTaskQueue {

	public static Map<String, TaskPriority> taskPriority = new HashMap<String, TaskPriority>();
	public static Map<String, Integer> runningCount = new HashMap<String, Integer>();
	
	static {
		runningCount.put("ECI_BOT", 1);
		runningCount.put("MSM", 1);
		runningCount.put("MSR", 1);
		runningCount.put("DEVXDASH", 1);
		runningCount.put("ECI_BOT_JIRA", 1);
	}
	
    public static void main(String[] args) {
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
        
        List<TaskPriority> taskPriorities = new ArrayList<TaskPriority>();
        taskPriorities.add(new TaskPriority("ECI_BOT", 3, 2));
        taskPriorities.add(new TaskPriority("ECI_BOT_JIRA", 16, 2));
        taskPriorities.add(new TaskPriority("MSM", 3, 2));
        taskPriorities.add(new TaskPriority("MSR", 3, 2));
        taskPriorities.add(new TaskPriority("DEVXDASH", 3, 2));
        taskPriorities.add(new TaskPriority("NEW", 20, 2));
        taskPriorities.add(new TaskPriority("ON-DEMAND", 3, 2));
        
        //taskPriority = taskPriorities.stream().collect(Collectors.toMap(TaskPriority::getLabelName, taskPrior -> taskPrior));
        taskPriority = taskPriorities.stream().collect(Collectors.toMap(TaskPriority::getLabelName, Function.identity()));
        
        System.out.println("taskPriority -- "+taskPriority);
        //No NULL in LABEL value ; needs to modify getLabel method in Task class to return 'ondemand' if null / ''
        //taskList.add(new Task("taskId17", null, "3"));
        
       
        Map<String, List<Task>> result =
        		taskList.stream().collect(Collectors.groupingBy(Task::getLabel));

        System.out.println("Grouping by Label - "+result);
        
/*        List<Task> listTasks = null;
        for(Map.Entry<String,List<Task>> r : result.entrySet()){
        	String labelKey = r.getKey();
        	if(runningCount.get(labelKey) != null && throttleValue.get(labelKey) != null  ){
        		listTasks = r.getValue();
        		if(runningCount.get(labelKey).intValue() < throttleValue.get(labelKey).intValue() ){
        			listTasks.subList((throttleValue.get(labelKey) - runningCount.get(labelKey) < listTasks.size() ? throttleValue.get(labelKey) - runningCount.get(labelKey) :listTasks.size()), listTasks.size()).clear();
        		}
        		else
        			listTasks.subList(0, listTasks.size()).clear();
        	}
        }
        System.out.println(result);*/
        //final List<Task> listTasks = null;
        Map<String, List<Task>> resultNew = result.entrySet().stream().collect(Collectors.toMap(
        		(entry) -> entry.getKey(),
        		(entry) -> {
        					String labelKey = entry.getKey();
        					if(runningCount.get(labelKey) != null && taskPriority.get(labelKey).getThrottle() != null  ){
        						List<Task> listTasks = entry.getValue();
        		        		if(runningCount.get(labelKey).intValue() < taskPriority.get(labelKey).getThrottle() ){
        		        			listTasks.subList((taskPriority.get(labelKey).getThrottle() - runningCount.get(labelKey) < listTasks.size() ? (taskPriority.get(labelKey).getThrottle() - runningCount.get(labelKey)) :listTasks.size()), listTasks.size()).clear();
        		        		}
        		        		else
        		        			listTasks.subList(0, listTasks.size()).clear();
        					}
        					return entry.getValue();
        				}
        		));
        System.out.println(resultNew);
        
        Map<String, List<Task>> treeMap = new TreeMap<>(new TaskComparator());
        
		treeMap.putAll(resultNew);
        
        System.out.println("After sorting  - "+treeMap);
        
        // Merge all list to form a queue in cyclic order
        int size = treeMap.entrySet().stream().mapToInt(list -> list.getValue().size()).max().getAsInt();
        System.out.println(" MAX LENGTH -- "+size);
        
        for(int i=0; i<size;i++ ){
        	for(Map.Entry<String, List<Task>> entry : treeMap.entrySet()){
        		if(i < entry.getValue().size()) System.out.println(entry.getValue().get(i));
        	}
        }
    }

     static class TaskComparator implements Comparator<String>{
    	@Override
    	public int compare(String report1, String report2) {
    		int i ;
    		if(taskPriority.get(report1) == null && taskPriority.get(report2) == null) 
    			return 1;
    		else if(taskPriority.get(report1) == null)
    			i = taskPriority.get("DEFAULT").getPriority().compareTo(taskPriority.get(report2).getPriority());
    		else if(taskPriority.get(report2) == null)  
    			i = taskPriority.get(report1).getPriority().compareTo(taskPriority.get("DEFAULT").getPriority());
    		else
    			i = taskPriority.get(report1).getPriority().compareTo(taskPriority.get(report2).getPriority());
    	    if (i == 0) 
    	    	return 1;
    	    return i;
    	}
    }
     private static class TaskPriority{
    	 private String labelName;
    	 private Integer priority;
    	 private Integer throttle;
		public String getLabelName() {
			return labelName;
		}
		public void setLabelName(String labelName) {
			this.labelName = labelName;
		}
		public Integer getPriority() {
			return priority;
		}
		public void setPriority(Integer priority) {
			this.priority = priority;
		}
		public Integer getThrottle() {
			return throttle;
		}
		public void setThrottle(Integer throttle) {
			this.throttle = throttle;
		}
		public TaskPriority(String labelName, Integer priority, Integer throttle) {
			super();
			this.labelName = labelName;
			this.priority = priority;
			this.throttle = throttle;
		}
     }
    private static class Task {

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
/*            return "Task{" +
                   "taskID='" + taskId + '\'' +
                   ", label='" + label + '\'' +
                   ", throttle='" + throttle + '\'' +
                   '}';*/
			return taskId+"-"+label;
        }
    }
}
