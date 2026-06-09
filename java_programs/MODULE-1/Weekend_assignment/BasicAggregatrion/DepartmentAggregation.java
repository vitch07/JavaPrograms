package BasicAggregatrion;

import java.util.ArrayList;
import java.util.List;

public class DepartmentAggregation {
    private String deptname;
    private String headquarters;
    private List<EmployeeAggregation> employees;

    DepartmentAggregation(String deptname, String headquarters) {
        this.deptname = deptname;
        this.headquarters = headquarters;
        this.employees = new ArrayList<>();
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public void addEmployees(EmployeeAggregation e) {
        this.employees.add(e);
    }

    public List<EmployeeAggregation> getEmployees() {
        return this.employees;
    }

    public String toString() {
        String result = "Department " + deptname;
        result += "headquarters" + headquarters;
        result += "Employees ";

        for (EmployeeAggregation e : employees) {
            result += "-" + e + "\n";
        }
        return result;
    }

}
