package qlnhansu;

import java.util.ArrayList;

public class Manager extends HumanResources {
    public int numberStaff;

    public Manager() {
        super();
    }

    public Manager(int _numberStaff) {
        super();
        this.numberStaff = _numberStaff;
    }

    public Manager(int _id, String _name, int _numberPhone, int _numberDayWork, int _salary1Day/*, int _numberStaff*/) {
        super(_id, _name, _numberPhone, _numberDayWork, _salary1Day);
        /*this.numberStaff = _numberStaff;*/
    }

    @Override
    public int calculateSalaryMonth() {
        //this.setSalary1Day(200);
        return super.calculateSalaryMonth();
    }

    public void updateNumberStaff(ArrayList<Staff> listStaff){
        ArrayList<Staff> listStaffAfter = new ArrayList<Staff>();
        for (Staff staff : listStaff){
            if (staff.idManager == this.getId()) listStaffAfter.add(staff);
        }
        this.numberStaff = listStaffAfter.size();
    }

    public int numberStaff(){
        return this.numberStaff;
    }

}
