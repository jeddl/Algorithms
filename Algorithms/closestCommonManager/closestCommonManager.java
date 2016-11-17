public static class Employee {
		 
    private final int id;
    private final String name;
    private final List<Employee> reports;
 
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.reports = new ArrayList<Employee>();
    }
 
    /**
     * @return an integer ID for this employee, guaranteed to be unique.
     */
    public int getId() {
        return id;
    }
 
    /**
     * @return a String name for this employee, NOT guaranteed to be unique.
     */
    public String getName() {
        return name;
    }
 
    /**
     * @return a List of employees which report to this employee.  This list may be empty, but will
     *         never be null.
     */
    public List<Employee> getReports() {
        return reports;
    }
 
    /**
     * Adds the provided employee as a report of this employee. 
     */
    public void addReport(Employee employee) {
        reports.add(employee);
    }
}

private static void moveUp(Stack<Employee> path, int diff){
    while (diff > 0 && !path.isEmpty()) {
        path.pop();
        diff--;
    }
}

private static boolean dfsIsManager(Employee root, Employee target, Stack<Employee> path) {
    path.push(root);
    if (root.getId() == target.getId()) {
        return true;
    }
    
    for (Employee r : root.getReports()) {
        boolean result = dfsIsManager(r, target, path);
        if (result) {
            return true;
        }
    }
    
    path.pop();
    
    return false;
}

public static Employee closestCommonManager(Employee ceo, Employee employee1, Employee employee2) {
    Stack<Employee> path1 = new Stack<Employee>();
    Stack<Employee> path2 = new Stack<Employee>();
    
    Employee root = ceo;
    
    dfsIsManager(root, employee1, path1);
    dfsIsManager(root, employee2, path2);
    
    if (path1.peek().getId() == employee1.getId() && path2.peek().getId() == employee2.getId()) {
        int size1 = path1.size();
        int size2 = path2.size();
        int diff = Math.abs(size2-size1);
        
        if (size1 > size2) {
            moveUp(path1, diff);
        }
        else {
            moveUp(path2, diff);
        }
        
        while (path1.peek().getId() != path2.peek().getId()) {
            path1.pop();
            path2.pop();
        }
        
        if (path1.size() > 0){ 
            return path1.pop();
        }
    }
    return null;
}