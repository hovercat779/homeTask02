package dao;

import entity.CustomersEntity;
import entity.OfficesEntity;
import entity.OrdersEntity;
import entity.SalesrepsEntity;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

/**
 * Created by hovercat on 06.06.16.
 */
public class DAOquery {

    public static List<CustomersEntity> getAllCustomers() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<CustomersEntity> entities = null;
        try {
            entities = session.createCriteria(CustomersEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entities;

    }



    public static List<SalesrepsEntity> getAllReps() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SalesrepsEntity> entity = null;
            try{

                entity = session.createCriteria(SalesrepsEntity.class).list();

            }catch (HibernateException e) {
                e.printStackTrace();
            }finally{
                session.close();
            }

        return entity;

    }


 public static List<OfficesEntity> getOffices(){
     SessionFactory factory = HibernateUtil.getSessionFactory();
     Session session = factory.openSession();
     List<OfficesEntity> entities = null;

     try {
         entities = session.createCriteria(OfficesEntity.class,"off").list();
//         criteria.setFetchMode("off.of", FetchMode.EAGER);

     }catch (Exception e) {
         e.printStackTrace();
     } finally {
         session.close();
     }
     return entities;

 }

//    Вывести список заказов, сделанных на прошлой неделе, включая следую­ щую информацию:
//    стоимость заказа, имя клиента, сделавшего заказ, и на­ звание заказанного товара (таблицы ORDERS, CUSTOMERS и PRODUCTS).

    public static List<OrdersEntity> getOrd(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<OrdersEntity> entities = null;


        try{
            SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD");

            Date date1 = sd.parse("2007-12-31");
            Date date2 = sd.parse("2008-01-24");
            Criteria criteria = session.createCriteria(OrdersEntity.class);
            criteria.addOrder(Order.asc("cust"));
            criteria.add(Restrictions.between("orderDate", date1, date2));
            entities = criteria.list();


        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

       for (OrdersEntity entity : entities) {

           System.out.println(entity.getOrderDate() + " - " + entity.getAmount() + " - " + entity.getOrd().getCompany() + " - " + entity.getO().getDescription());
        }

        return entities;
    }

}
