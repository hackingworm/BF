import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRManager {
    public static double averageSalary(List<Employee> employees) {
        List<Integer> salaries = employees.stream()
                .map(Employee::getSalary)
                .toList();
        return salaries.stream().reduce(0, (partial, salary) -> partial + salary)
                / salaries.size();
    }

    public static List<Employee> highPaids(List<Employee> employees, int limit) {
        return employees.stream()
                .filter(employee -> limit < employee.getSalary())
                .toList();
    }

    public static List<Employee> nameStartsWith(List<Employee> employees, char c) {
        return employees.stream()
                .filter(employee -> c == employee.getName().charAt(0))
                .toList();
    }

    public static String concatenateNames(List<Employee> employees) {
        String concatenated = employees.stream()
                .map(Employee::getName)
                .reduce("", (partial, name) -> partial + " " + name);
        return concatenated.trim();
    }

    public static Map<String, Employee> toMap(List<Employee> employees) {
        Map<String, Employee> map = new HashMap<>();
        employees.forEach(employee -> map.put(employee.getName(), employee));
        return map;
    }
}
