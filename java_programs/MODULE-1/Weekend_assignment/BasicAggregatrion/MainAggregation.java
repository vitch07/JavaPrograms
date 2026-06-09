package BasicAggregatrion;

public class MainAggregation {
    public static void main(String[] args){
        DepartmentAggregation dept = new DepartmentAggregation("IT","Bangalore");
        EmployeeAggregation emp1 = new EmployeeAggregation("vishnu","nalaj","1223");
        EmployeeAggregation emp2 = new EmployeeAggregation("vi","Baalaji","1225");
        EmployeeAggregation emp3 = new EmployeeAggregation("veer","suraj","1333");
        EmployeeAggregation emp4 = new EmployeeAggregation("Narmada","gupta","1243");
        EmployeeAggregation emp5 = new EmployeeAggregation("preet","singh","1323");
        EmployeeAggregation emp6 = new EmployeeAggregation("arjun","reddy","2323");
        EmployeeAggregation emp7 = new EmployeeAggregation("vignesh","varma","4323");

        dept.addEmployees(emp1);
        dept.addEmployees(emp2);
        dept.addEmployees(emp3);
        dept.addEmployees(emp4);
        dept.addEmployees(emp5);
        dept.addEmployees(emp6);

        System.out.println(dept);

    }

}
