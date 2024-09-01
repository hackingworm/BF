import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 80000));
        employees.add(new Employee("George", 70000));
        employees.add(new Employee("Sarah", 100000));

        System.out.println("Average salary: " + HRManager.averageSalary(employees));

        List<Employee> selected = HRManager.highPaids(employees, 80000);
        selected.forEach(employee -> System.out.println(employee.getName()));

        Map<String, Employee> map = HRManager.toMap(employees);
        System.out.println(map);

        selected = HRManager.nameStartsWith(employees, 'B');
        selected.forEach(employee -> System.out.println(employee.getName()));

        System.out.println(HRManager.concatenateNames(employees));
    }
}
