package OOP.EmployeePayrollSystem;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 40, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details...");
        payrollSystem.displayEmployees();
        System.out.println("Removing employee emp2");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining employees");
        payrollSystem.displayEmployees();
    }
}
