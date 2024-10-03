package Entities;

import ENUMS.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setDepartament(Department departament) {
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Department getDepartament() {
        return departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }


    public Double income(Integer year, Integer month) {
        Double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_month = cal.get(Calendar.MONTH) + 1;
            int c_year = cal.get(Calendar.YEAR);
            if (c_month == month && c_year == year) {
                sum = baseSalary + c.totalValue();
            }
        }
        return sum;
    }

}
