import java.util.ArrayList;
import java.util.List;

// Component Interface
// Defines common operations for both individual Employees (Leaf)
// and Departments (Composite)
interface OrganizationComponent {
    void displayInfo();      // Show details of the component
    double calculateSalary(); // Calculate salary (for Employee or sum for Department)
}

// Leaf Class
// Represents individual Employees that don't have child components
class Employee implements OrganizationComponent {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

// Composite Class
// Represents a Department which can contain Employees (Leaf)
// or other Departments (Composite)
class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> members; // Can be Employee or Department

    Department(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    // Add a member (Employee or Department) to this Department
    public void addMember(OrganizationComponent member) {
        members.add(member);
    }

    @Override
    public void displayInfo() {
        System.out.println("Department: " + name);
        for (OrganizationComponent member : members) {
            member.displayInfo(); // Delegates to child components
        }
    }

    @Override
    public double calculateSalary() {
        double total = 0.0;
        for (OrganizationComponent member : members) {
            total += member.calculateSalary(); // Sum of all members' salaries
        }
        return total;
    }
}

// Client Code (Demo)
public class CompanyDemo {
    public static void main(String[] args) {

        // Creating individual employees
        OrganizationComponent nikhil = new Employee("Nikhil", 2_000_000);
        OrganizationComponent kriti = new Employee("Kriti", 1_700_000);

        // Creating Marketing Department and adding employees
        Department marketing = new Department("Marketing");
        marketing.addMember(nikhil);
        marketing.addMember(kriti);

        // Creating Social Media Department with its employees
        OrganizationComponent vihaan = new Employee("Vihaan", 1_000_000);
        OrganizationComponent kelly = new Employee("Kelly", 1_100_000);

        Department socialMedia = new Department("Social Media");
        socialMedia.addMember(vihaan);
        socialMedia.addMember(kelly);

        // Nesting Social Media Department under Marketing Department
        marketing.addMember(socialMedia);

        // Display details of Social Media Dept
        System.out.println("== Social Media Department ==");
        socialMedia.displayInfo();
        System.out.println("Total Salary (Social Media): " + socialMedia.calculateSalary());

        System.out.println("\n== Marketing Department ==");
        marketing.displayInfo();
        System.out.println("Total Salary (Marketing): " + marketing.calculateSalary());

        System.out.println("\n== Individual Employee ==");
        vihaan.displayInfo();
    }
}
