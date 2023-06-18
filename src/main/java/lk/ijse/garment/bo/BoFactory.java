package lk.ijse.garment.bo;

import lk.ijse.garment.bo.custom.SupplierBo;
import lk.ijse.garment.bo.custom.impl.*;
import lk.ijse.garment.dao.custom.impl.ClothesDaoImpl;
import lk.ijse.garment.dao.custom.impl.EmployeeDaoImpl;
import lk.ijse.garment.dao.custom.impl.SupplierDaoImpl;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBoFactory(){
        return boFactory ==null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoType {
        SUPPLIER,EMPLOYEE,MATERIAL,CLOTHES,ORDER,CUSTOMER,EMPLOYEEPAY,INCOME
    }

    public <SuperDao>SuperDao getBo(BoType type){
        switch (type){
            case SUPPLIER:
                return (SuperDao) new SupplierBoImpl();
            case EMPLOYEE:
                return (SuperDao) new EmployeeBoImpl();
            case MATERIAL:
                return (SuperDao) new MaterialBoImpl();
            case CLOTHES:
                return (SuperDao) new ClothesBoImpl();
            case ORDER:
                return (SuperDao) new OrderBoImpl();
            case CUSTOMER:
                return (SuperDao) new CustomerBoImpl();
            case EMPLOYEEPAY:
                return (SuperDao) new EmployeePayBoImpl();
            case INCOME:
                return (SuperDao) new IncomeBoImpl();
            default:
                return null;
        }
    }

}
