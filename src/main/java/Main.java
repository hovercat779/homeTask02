import dao.DAOquery;
import entity.CustomersEntity;
import entity.OfficesEntity;
import entity.OrdersEntity;
import entity.SalesrepsEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
public class Main {

    public static void main(String[] args) {

//        List<SalesrepsEntity> reps = DAOquery.getAllReps();
//        for (SalesrepsEntity entity : reps) {
//            String city = entity.getSl() == null ? "" : entity.getSl().getCity();
//            System.out.println(entity.getName()+ " - " + city);
//        }


//        List allReps = DAOquery.getAllReps();
//        for (Object rep : allReps) {
//            System.out.println(rep);
//        }

//        List<CustomersEntity> customers = DAOquery.getAllCustomers();
//        for (CustomersEntity customer : customers) {
//            System.out.println(customer);
//        }

//        List<OfficesEntity> offices = DAOquery.getOffices();
//        for (OfficesEntity office : offices) {
//            System.out.println(office.getCity());
//            for (SalesrepsEntity s :office.getOf()){
//                System.out.println(s.getName());
//            }
//            System.out.println("-------------------------------------");
//
//        }

        DAOquery.getOrd();

    }

}
