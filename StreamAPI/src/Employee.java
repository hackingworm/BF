import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Employee ep = (Employee)obj;
        return name.equals(ep.getName()) && salary == ep.getSalary();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + salary;
    }

    // For test only
    public String toString() {
        return name + " " + salary;
    }
}
