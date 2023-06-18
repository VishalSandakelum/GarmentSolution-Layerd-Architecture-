package lk.ijse.garment.dao;

import lk.ijse.garment.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory(){
        return daoFactory==null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoType {
        SUPPLIER,EMPLOYEE,MATERIAL,CLOTHES,QUERY,ORDER,CUSTOMER,EMPLOYEEPAY
    }

    public <SuperDao>SuperDao getDao(DaoType type){
        switch (type){
            case SUPPLIER:
                return (SuperDao) new SupplierDaoImpl();
            case EMPLOYEE:
                return (SuperDao) new EmployeeDaoImpl();
            case MATERIAL:
                return (SuperDao) new MaterialDaoImpl();
            case CLOTHES:
                return (SuperDao) new ClothesDaoImpl();
            case QUERY:
                return (SuperDao) new OtherQueryDaoImpl();
            case ORDER:
                return (SuperDao) new OrderDaoImpl();
            case CUSTOMER:
                return (SuperDao) new CustomerDaoImpl();
            case EMPLOYEEPAY:
                return (SuperDao) new EmployeePayDaoImpl();
            default:
                return null;
        }
    }

}
