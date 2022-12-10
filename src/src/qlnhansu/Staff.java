package qlnhansu;

public class Staff extends HumanResources implements Comparable<Object>{
    //public int idManager = 0000;
    public Integer idManager = null;

    public Staff() {
        super();
    }

    public Staff(int _id, String _name, int _numberPhone, int _numberDayWork, int _salary1Day /*,int _idManager*/) {
        super(_id, _name, _numberPhone, _numberDayWork, _salary1Day);
        //this.idManager = _idManager;
    }

    @Override
    public int calculateSalaryMonth() {
        this.setSalary1Day(100);
        return super.calculateSalaryMonth();
    }

    public String toString() {
        return this.getName() + " ma id : " + this.getId();
    }

    @Override
    public int compareTo(Object o) {
        Staff f = (Staff) o;
        return this.getNumberDayWork() - f.getNumberDayWork() ;
    }
}
