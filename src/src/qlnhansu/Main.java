package qlnhansu;

import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void addMember(ArrayList<Director> listdirector, ArrayList<Manager> listmanager, ArrayList<Staff> liststaff) {
        System.out.print("Ban chon so de them |   Khong them ban chon so 0 \n 1.Them giam doc\n 2.Them truong phong\n 3.Them nhan vien\n");
        int n = input.nextInt();
        switch (n){
            case 1:
                System.out.print("Ma so Giam Doc (5 chu so): ");
                int idDirector = input.nextInt();
                input.nextLine();
                System.out.print("Ho ten Giam Doc : ");
                String nameDirector = input.nextLine();
                System.out.print("So dien thoai Giam Doc (9 chu so): ");
                int numberPhone = input.nextInt();
                System.out.print("So ngay lam viec cua Giam Doc trong thang: ");
                int numDayWork  = input.nextInt();
                System.out.print("So co phan cua Giam Doc trong cty theo dv (%): ");
                int numStock = input.nextInt();
                Director director = new Director(idDirector, nameDirector, numberPhone, numDayWork, 300, numStock);
                listdirector.add(director);
                break;
            case 2:
                System.out.print("Ma so Truong Phong (5 chu so): ");
                int idManager = input.nextInt();
                input.nextLine();
                System.out.print("Ho ten Truong Phong : ");
                String nameManager = input.nextLine();
                System.out.print("So dien thoai Truong Phong (9 chu so): ");
                int nphoneManager = input.nextInt();
                System.out.print("So ngay lam viec cua Truong Phong trong thang: ");
                int ndayWork  = input.nextInt();
                Manager manager = new Manager(idManager, nameManager, nphoneManager, ndayWork, 200);
                listmanager.add(manager);
                break;
            case 3:
                System.out.print("Ma so Nhan Vien thu (5 chu so): ");
                int idStaff = input.nextInt();
                input.nextLine();
                System.out.print("Ho ten Nhan Vien : ");
                String nameStaff = input.nextLine();
                System.out.print("So dien thoai Nhan Vien (9 chu so): ");
                int nphoneStaff = input.nextInt();
                System.out.print("So ngay lam viec cua Nhan Vien trong thang: ");
                int ndayWorkStaff  = input.nextInt();
                Staff staff = new Staff(idStaff, nameStaff, nphoneStaff, ndayWorkStaff, 100);
                liststaff.add(staff);
                break;
        }
    }
    public static void removeMember(ArrayList<Director> listdirector, ArrayList<Manager> listmanager, ArrayList<Staff> liststaff) {
        System.out.print("Ban chon so de xoa | Ban khong xoa ban chon so 0\n 1.Xoa giam doc\n 2.Xoa truong phong\n 3.Xoa nhan vien\n");
        int n = input.nextInt();
        switch (n){
            case 1:
                if (listdirector.size() < 1) {
                    System.out.println("Khong co giam doc de xoa");
                    break;
                } else {
                    ArrayList<Director> listRemove = new ArrayList<Director>();
                    System.out.println("Danh sach ma id cac giam doc");
                    for (Director director : listdirector) {
                        System.out.println(director.getId() + " : " + director.getName());
                    }
                    System.out.println("Chon ma de xoa");
                    int id_remove = input.nextInt();
                    for (Director director : listdirector) {
                        if (director.getId() == id_remove)
                            listRemove.add(director);
                    }
                    for (Director director : listRemove) {
                        listdirector.remove(director);
                    }
                }
                break;
            case 2:
                if (listmanager.size() < 1) {
                    System.out.println("Khong co truong phong de xoa");
                    break;
                } else {
                    ArrayList<Manager> listRemoveManager = new ArrayList<Manager>();
                    System.out.println("Danh sach ma id cac truong phong");
                    for (Manager manager : listmanager) {
                        System.out.println(manager.getId() + " : " + manager.getName());
                    }
                    System.out.println("Chon ma de xoa");
                    int idMana_remove = input.nextInt();
                    for (Manager manager : listmanager) {
                        if (manager.getId() == idMana_remove)
                            listRemoveManager.add(manager);
                    }
                    for (Manager manager : listRemoveManager) {
                        listmanager.remove(manager);
                        for (Staff staff : liststaff) {
                            //if (staff.idManager == manager.getId()) staff.idManager = 0000;
                            if (staff.idManager == manager.getId()) staff.idManager = null;
                        }
                    }
                }
                break;
            case 3:
                if (listdirector.size() < 1) {
                    System.out.println("Khong co nhan vien de xoa");
                    break;
                } else {
                    ArrayList<Staff> listRemoveStaff = new ArrayList<Staff>();
                    System.out.println("Danh sach ma id cac truong phong");
                    for (Staff staff : liststaff) {
                        System.out.println(staff.getId() + " : " + staff.getName());
                    }
                    System.out.println("Chon ma de xoa");
                    int idStaff_remove = input.nextInt();
                    for (Staff staff : liststaff) {
                        if (staff.getId() == idStaff_remove)
                            listRemoveStaff.add(staff);
                    }
                    for (Staff staff : listRemoveStaff) {
                        liststaff.remove(staff);
                    }
                }
                break;
        }
    }

    public static int countSalaryAll(ArrayList<Director> directors, ArrayList<Manager> managers, ArrayList<Staff> staffs){
        int salaryAll = 0;
        for (Director director : directors) {
            salaryAll += director.calculateSalaryMonth();
        }
        for (Manager manager : managers) {
            salaryAll += manager.calculateSalaryMonth();
        }
        for (Staff staff: staffs) {
            salaryAll += staff.calculateSalaryMonth();
        }

        return salaryAll;
    }

    public static void findMaxSalary_Staff(ArrayList<Staff> staffs) {
        Staff maxSalary = staffs.stream().max(Comparator.comparingInt(Staff::calculateSalaryMonth)).get();
        System.out.println("Nhan vien luong cao nhat la " + maxSalary.getName());
    }

    public static void findManyStaff_Manager(ArrayList<Manager> managers) {
        Manager mostStaff = managers.stream().max(Comparator.comparingInt(Manager::numberStaff)).get();
        System.out.println("Truong phong nhieu nhan vien nhat la " + mostStaff.getName() + "  ma id " + mostStaff.getId());
    }

    public static ArrayList<Staff> orderStaffFollowName(ArrayList<Staff> staffs) {
        ArrayList<String> nameStaff = new ArrayList<String>();
        for (Staff staff : staffs) {
            nameStaff.add(staff.getName());
        }
        Collections.sort(nameStaff);

        ArrayList<Staff> sorted_Staff = new ArrayList<Staff>();
        for (String name : nameStaff) {
            for (Staff staff : staffs) {
                if (staff.getName() == name) sorted_Staff.add(staff);
            }
        }
        staffs = sorted_Staff;
        System.out.println("Chon 4 de xem ket qua sap xep ");
        return staffs;
    }

    public static void orderStaffFollowSalary(ArrayList<Staff> staffs) {
        Collections.sort(staffs);
        System.out.println("Chon 4 de xem ket qua sap xep ");
    }

    public static void findManyStock_Director(ArrayList<Director> directors) {
        Director mostStock = directors.stream().max(Comparator.comparingInt(Director::getNumberStock)).get();
        System.out.println("Giam doc nhieu co phan nhat la : " + mostStock.getName() + "||  Ma id : " + mostStock.getId());
    }

    public static void incomeEachDirector(Company company, ArrayList<Director> directors, int countSalaryAll) {
        float profit = company.turnoverMonth * 1000000 - countSalaryAll;
        for (Director director : directors) {
            float income = director.calculateSalaryMonth() + (profit * director.getNumberStock()) / 100;
            System.out.println("Thu nhap giam doc " + director.getName() + " : " +(int) income + "000");
        }
    }

    public static void menu() {
        System.out.println("-------------------------------Moi ban chon so--------------------------------------");
        System.out.println("1.Nhap thong tin cong ty");
        System.out.println("2.Phan bo Nhan vien vào Truong phong");
        System.out.println("3.Them, xoa thong tin mot nhan su");
        System.out.println("4.Xuat ra thong tin toan bo nguoi trong cong ty");
        System.out.println("5.Tinh và xuat tong luong cho toan cong ty");
        System.out.println("6.Tim Nhan vien thuong có luong cao nhat");
        System.out.println("7.Tim Truong Phong có số luong nhan vien duoi quyen nhieu nhat");
        System.out.println("8.Sap xep nhan vien toan cong ty theo thứ tự abc");
        System.out.println("9.Sap xep nhan vien toan cong ty theo thứ tự luong giam dần");
        System.out.println("10.Tim Giam Đoc co so luong co phan nhieu nhat");
        System.out.println("11.Tinh và Xuat tong thu nhap của tung Giam Đoc");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("Moi ban nhap so");
    }


    public static void enterNumberToChose() {
        boolean isExit = false;
        ArrayList<Staff> listStaff = new ArrayList<Staff>();
        ArrayList<Manager> listManager = new ArrayList<Manager>();
        ArrayList<Director> listDirector = new ArrayList<Director>();
        Director director = null;
        Company company = null;
        Manager manager = null;
        Staff staff = null;
        int salaryAll = 0;
        int chose;
        do {
            menu();
            chose = input.nextInt();
            switch (chose) {
                case 0: isExit =true;
                    break;
                case 1:
                    System.out.print("Nhap ten cong ty : ");
                    input.nextLine();
                    String nameCompany = input.nextLine();
                    System.out.print("Nhap ma so thue cong ty : ");
                    int txcCompany = input.nextInt();
                    System.out.print("Doanh thu thang cua cong ty theo dv (tien ty) : ");
                    int turnoverCompany = input.nextInt();
                    company = new Company(nameCompany, txcCompany, turnoverCompany);
                    //
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print("So Giam Doc trong cty : ");
                    int numDirector = input.nextInt();
                    for(int i = 1; i <= numDirector; i++) {
                        System.out.print("Ma so Giam Doc thu " + i + " (5 chu so): ");
                        int idDirector = input.nextInt();
                        input.nextLine();
                        System.out.print("Ho ten Giam Doc : ");
                        String nameDirector = input.nextLine();
                        System.out.print("So dien thoai Giam Doc (9 chu so): ");
                        int numberPhone = input.nextInt();
                        System.out.print("So ngay lam viec cua Giam Doc thu " + i + " trong thang: ");
                        int numDayWork = input.nextInt();
                        System.out.print("So co phan cua Giam Doc thu " + i + " trong cty theo dv (%): ");
                        int numStock = input.nextInt();
                        director = new Director(idDirector, nameDirector, numberPhone, numDayWork, 300, numStock);
                        listDirector.add(director);
                    }

                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print("So Truong Phong trong cty : ");
                    int numManager = input.nextInt();
                    for(int i = 1; i <= numManager; i++){
                        System.out.print("Ma so Truong Phong thu "+ i +" : ");
                        int idManager = input.nextInt();
                        System.out.print("Ho ten Truong Phong thu "+ i +" : ");
                        input.nextLine();
                        String nameManager = input.nextLine();
                        System.out.print("So dien thoai Truong Phong thu "+ i +" : ");
                        int nphoneManager = input.nextInt();
                        System.out.print("So ngay lam viec Truong Phong thu "+ i +" : ");
                        int ndayWork  = input.nextInt();
                        manager = new Manager(idManager, nameManager, nphoneManager, ndayWork, 200);
                        listManager.add(manager);
                        }
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print("So luong nhan vien trong cty : ");
                    int numStaff = input.nextInt();
                    for(int i = 1; i <= numStaff; i++){
                        System.out.print("Ma so Nhan Vien thu "+ i +" : ");
                        int idStaff = input.nextInt();
                        System.out.print("Ho ten Nhan Vien thu "+ i +" : ");
                        input.nextLine();
                        String nameStaff = input.nextLine();
                        System.out.print("So dien thoai Nhan Vien thu "+ i +" : ");
                        int nphoneStaff = input.nextInt();
                        System.out.print("So ngay lam viec Nhan Vien thu "+ i +" : ");
                        int ndayWork  = input.nextInt();
                        staff = new Staff(idStaff, nameStaff, nphoneStaff, ndayWork, 100);
                        listStaff.add(staff);
                    }
                    break;

                case 2:
                    System.out.println("Danh sach ma id T_Phong: " );
                    for (Manager manager1 : listManager) {
                        System.out.println(manager1.getId() + " : \t" + "So N_vien cua T_Phong nay la : " + manager1.numberStaff);
                    }
                    for (Staff staff1 : listStaff) {
                        System.out.println("\nDay la ten NV: " + staff1.getName() + "  ||\t Ma so NV: " + staff1.getId() + "\t\tMa id T_Phong hien tai la " + staff1.idManager);
                        System.out.println("Chon ma id T_Phong de phan bo ");
                        int idManageChose = input.nextInt();
                        staff1.idManager = idManageChose;
                    }
                    for (Manager manager2 : listManager) {
                        manager2.updateNumberStaff(listStaff);
                    }
                    break;
                case 3:
                    addMember(listDirector,listManager,listStaff);
                    removeMember(listDirector,listManager,listStaff);
                    break;
                case 4:
                    System.out.println("| Ma so giam doc |\t "+ "| Ho ten giam doc \t\t\t|" + "|   Sdt giam doc   |" + "| So ngay lam viec cua giam doc |");
                    for (Director direc : listDirector){
                        System.out.println("|  "+ direc.getId() +"\t\t |"  +"\t | \t"+ direc.getName()
                                +" \t\t\t|" + "|\t  " + direc.getNumberPhone() +" \t   |" + "|  \t"+ direc.getNumberDayWork()+" \t\t\t\t\t\t\t|" );
                    }

                    System.out.println("| Ma so truong phong |\t "+ "| Ho ten truong phong \t\t\t|" + "|   Sdt truong phong   |"
                                     + "| So ngay lam viec cua truong phong |  " + "| So nhan vien cua truong phong  |");
                    for (Manager mana : listManager){
                        System.out.println("|    " + mana.getId() +"\t\t |"  + "\t | \t" + mana.getName()
                                + " \t\t\t| |\t  " + mana.getNumberPhone() +" \t   ||  \t\t"+ mana.getNumberDayWork() + " \t\t\t\t\t\t\t|  | " + mana.numberStaff + "\t\t\t\t\t\t\t|");
                    }

                    System.out.println("| Ma so nhan vien |\t "+ "| Ho ten nhan vien \t\t\t|" + "|  Sdt nhan vien   |"
                                     + "| So ngay lam viec cua nhan vien |  " + "| Ma so truong phong cua nhan vien  |");
                    for (Staff staf : listStaff){
                        System.out.println("|    " + staf.getId() +"\t\t |"  + "\t | \t" + staf.getName()
                                + " \t\t\t| |\t  " + staf.getNumberPhone() +" \t\t   ||  \t\t"+ staf.getNumberDayWork() + " \t\t\t\t\t\t\t|  | " + staf.idManager + " \t\t\t\t\t\t\t|");
                    }
                    break;
                case 5:
                    salaryAll = countSalaryAll(listDirector, listManager, listStaff);
                    System.out.println("Tong luong toan cty : " + salaryAll + ".000");
                    break;
                case 6:
                    findMaxSalary_Staff(listStaff);
                    break;
                case 7:
                    findManyStaff_Manager(listManager);
                    break;
                case 8:
                    listStaff = orderStaffFollowName(listStaff);
                    break;
                case 9:
                    orderStaffFollowSalary(listStaff);
                    break;
                case 10:
                    findManyStock_Director(listDirector);
                    break;
                case 11:
                    if (salaryAll == 0) {
                        System.out.println("Chon 5 de tinh tong luong toan cty truoc");
                        break;
                    }
                    incomeEachDirector(company, listDirector, salaryAll);
                    break;
            }

        } while (!isExit);

    }
    public static void main(String[] args) {
        enterNumberToChose();
    }
}
