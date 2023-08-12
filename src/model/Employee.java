package model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String Department;
    private String email;
    private Double salary;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String department, String email, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Department = department;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "model.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Department='" + Department + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
