import ENUMS.WorkerLevel;
import Entities.Department;
import Entities.HourContract;
import Entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department´s name:");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.println("Name:");
        String name = sc.nextLine();

        System.out.println("Level: ");
        String workerLevel = sc.nextLine().toUpperCase();

        System.out.println("Base salary:");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.println("How many contracts to this worker?");
        Integer n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.println("Enter contract # " + (i+1) + " data:" );
            System.out.println("Date(dd/MM/yyyy):");
            Date contractDate = sdf.parse(sc.next());

            System.out.println("Value per hour:");
            Double valuePerHour = sc.nextDouble();

            System.out.println("Duration (hours):");
            Integer hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter month and year to calculate income(MM/YYYY):");
        String monthAndYear = sc.next();

        Integer month = Integer.parseInt(monthAndYear.substring(0,2));
        Integer year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartament().getName());
        System.out.println("Income for: " + monthAndYear);
        System.out.println(String.format("%.2f", worker.income(year, month)));

    }
}
