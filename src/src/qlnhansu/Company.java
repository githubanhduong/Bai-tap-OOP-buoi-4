package qlnhansu;

public class Company {
    public String nameCompany;
    public int taxCode;
    public float turnoverMonth;

    public Company() {
    }

    public Company(String _nameCompany, int _taxCode, int _turnoverMonth){
        this.nameCompany = _nameCompany;
        this.taxCode = _taxCode;
        this.turnoverMonth = _turnoverMonth;
    }

}
