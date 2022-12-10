package qlnhansu;

public class Director extends HumanResources {
    private int numberStock;

    public Director() {
        super();
    }

    public Director(int numberStock) {
        super();
        this.numberStock = numberStock;
    }

    public Director(int _id, String _name, int _numberPhone, int _numberDayWork, int _salary1Day, int _numberStock) {
        super(_id, _name, _numberPhone, _numberDayWork, _salary1Day);
        this.numberStock = _numberStock;
    }

    public int getNumberStock() {
        return this.numberStock;
    }

    @Override
    public int calculateSalaryMonth() {
        //this.setSalary1Day(300);
        return super.calculateSalaryMonth();
    }
}
