package qlnhansu;
import java.util.*;
import static java.lang.System.*;

public class HumanResources {
    private int id;

    private String name;
    private int numberPhone;
    private int numberDayWork;
    private int salary1Day;

    private final Scanner mScan = new Scanner(in);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getNumberDayWork() {
        return numberDayWork;
    }

    public void setNumberDayWork(int numberDayWork) {
        this.numberDayWork = numberDayWork;
    }

    public int getSalary1Day() {
        return salary1Day;
    }

    public void setSalary1Day(int salary1Day) {
        this.salary1Day = salary1Day;
    }

    public HumanResources() {

    }

    public HumanResources(int _id, String _name, int _numberPhone, int _numberDayWork, int _salary1Day) {
        this.id = _id;
        this.name = _name;
        this.numberPhone = _numberPhone;
        this.numberDayWork = _numberDayWork;
        this.salary1Day = _salary1Day;
    }

    public int calculateSalaryMonth() {
        return this.getNumberDayWork() * this.getSalary1Day();
    }
}
