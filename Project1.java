class Employee {
    int empNo;
    String empName;
    String joinDate;
    char desigCode;
    String department;
    int basic;
    int hra;
    int it;

    Employee(int empNo, String empName, String joinDate, char desigCode,
             String department, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.desigCode = desigCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}

public class Project1 {
    public static void main(String[] args) {

        Employee[] emp = {
            new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman", "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
        };

        if (args.length == 0) {
            System.out.println("Please enter Employee ID");
            return;
        }

        int empId = Integer.parseInt(args[0]);
        boolean found = false;

        for (Employee e : emp) {
            if (e.empNo == empId) {
                found = true;

                String designation = "";
                int da = 0;

                switch (e.desigCode) {
                    case 'e':
                        designation = "Engineer";
                        da = 20000;
                        break;
                    case 'c':
                        designation = "Consultant";
                        da = 32000;
                        break;
                    case 'k':
                        designation = "Clerk";
                        da = 12000;
                        break;
                    case 'r':
                        designation = "Receptionist";
                        da = 15000;
                        break;
                    case 'm':
                        designation = "Manager";
                        da = 40000;
                        break;
                }

                int salary = e.basic + e.hra + da - e.it;

                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
                System.out.println(
                        e.empNo + "\t" +
                        e.empName + "\t\t" +
                        e.department + "\t\t" +
                        designation + "\t\t" +
                        salary);

                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + empId);
        }
    }
}
