package dao;

import entity.OfficesEntity;
import entity.OrdersEntity;
import entity.SalesrepsEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */

@SuppressWarnings("ALL")
public class DAOquery {

    //    Вывести список служащих и офисов, в которых они работают (таблицы SALESREPS И OFFICES).

    public static void getRepCity() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<SalesrepsEntity> entity = null;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(SalesrepsEntity.class).list();
            for (SalesrepsEntity salesrepsEntity : entity) {
                System.out.println(salesrepsEntity.getName() + " - " + salesrepsEntity.getSl().getCity());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //    Вывести список заказов, сделанных на прошлой неделе, включая следую­ щую информацию:
    //    стоимость заказа, имя клиента, сделавшего заказ, и на­ звание заказанного товара (таблицы ORDERS, CUSTOMERS и PRODUCTS).

    public static void getOrderWithInfo() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entities = null;


        try (Session session = factory.openSession()) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

            Date date1 = sd.parse("2007-12-31");
            Date date2 = sd.parse("2008-01-24");
            Criteria criteria = session.createCriteria(OrdersEntity.class);
            criteria.addOrder(Order.asc("orderDate"));
            criteria.add(Restrictions.between("orderDate", date1, date2));
            entities = criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        }

        for (OrdersEntity entity : entities) {

            System.out.println(entity.getOrderDate() + " - " + entity.getAmount() + " - " + entity.getOrd().getCompany()
                    + " - " + entity.getO().getDescription());
        }

    }

    //    Показать все заказы, принятые в восточном регионе, в том числе
    //    описания товаров и имена служащих, принявших заказы (таблицы ORDERS, SALESREPS, OFFICES И PRODUCTS).


    public static void getOrdedWithRegion() {
        //TODO

        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entities;

        try (Session session = factory.openSession()) {

            Criteria c = session.createCriteria(OrdersEntity.class, "orders");
            c.createAlias("orders.or", "empl");
            c.createAlias("empl.sl", "office");
            c.add(Restrictions.eq("office.region", "Eastern"));

            entities = c.list();

            for (OrdersEntity entity : entities) {
                System.out.println(entity.getOrderNum() + " - "
                        + entity.getO().getDescription() + " - "
                        + entity.getOr().getName() + " - "
                        + entity.getOr().getSl().getRegion());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    Перечислитъ все заказы, включая номер и стоимостъ заказа, а та же имя и лимит кредита клиента, сделавшего заказ

    public static void getOrderWithCost() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entities = null;

        try (Session session = factory.openSession()) {
            entities = session.createCriteria(OrdersEntity.class).list();

            for (OrdersEntity entity : entities) {
                System.out.println(entity.getOrderNum() + ": order number - "
                        + entity.getAmount() + ": amount - " + entity.getOrd().getCompany() +
                        ": customer name - " + entity.getOrd().getCreditLimit() + ": credit limit");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //        Вывести список всех служащих с городами и регионами, в которых они работают.

    public static void getRepCityRegion() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<SalesrepsEntity> entity = null;
        try (Session session = factory.openSession()) {

            entity = session.createCriteria(SalesrepsEntity.class).list();

            for (SalesrepsEntity salesrepsEntity : entity) {
                System.out.println(salesrepsEntity.getName() + " - " + salesrepsEntity.getSl().getCity()
                        + " - " + salesrepsEntity.getSl().getRegion());
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

//    Вывести список офисов с именами и должностями их руководителей.

    public static void getOffTitle() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<SalesrepsEntity> entity = null;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(SalesrepsEntity.class).list();
            for (SalesrepsEntity salesrepsEntity : entity) {
                System.out.println(salesrepsEntity.getSl().getCity() + " - " + salesrepsEntity.getName()
                        + " - " + salesrepsEntity.getTitle());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //Перечислитъ офисы, план прод  которых превы�иает $600ООО.

    public static void getOffSal() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OfficesEntity> entity = null;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(OfficesEntity.class)
                    .add(Restrictions.between("sales", BigDecimal.valueOf(600000), BigDecimal.valueOf(1000000))).list();
            for (OfficesEntity officesEntity : entity) {
                System.out.println(officesEntity.getCity() + " - " + officesEntity.getSales());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //Вывести список всех заказов, включая  стоимости и описания товаров.

    public static void getOrdDesc() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entity;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(OrdersEntity.class).list();

            for (OrdersEntity ordersEntity : entity) {
                System.out.println(ordersEntity.getOrderNum() + " - " + ordersEntity.getO().getDescription() + " - "
                        + ordersEntity.getAmount());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    //Вывести список заказов стоимостью выше $25ООО,
    // включающий имя служащего , принявшего заказ, и имя клиента, сделавшего его.

    public static void getOrdAm() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entity = null;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(OrdersEntity.class)
                    .add(Restrictions.between("amount", BigDecimal.valueOf(25000), BigDecimal.valueOf(10000000))).list();

            for (OrdersEntity ordersEntity : entity) {
                System.out.println(ordersEntity.getOrderNum() + " - " + ordersEntity.getO().getDescription()
                        + " - " + ordersEntity.getAmount() + " - " + ordersEntity.getOr().getName()
                        + " - " + ordersEntity.getOrd().getCompany());
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

//    Вывести список заказов стоимостъю выше $25ООО, включающий имя клиента,
//    и имя служащего , закрепленного за этим клиентом.

    public static void getOrdCust() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entity;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(OrdersEntity.class)
                    .add(Restrictions.between("amount", BigDecimal.valueOf(25000), BigDecimal.valueOf(10000000))).list();
            for (OrdersEntity ordersEntity : entity) {
                System.out.println(ordersEntity.getOrderNum() + " :number - "
                        + ordersEntity.getAmount() + " :amount - "
                        + ordersEntity.getOrd().getCompany() + " :customer - "
                        + ordersEntity.getOr().getName() + " :manager");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

//    Вывести список заказов стоимостью выше $25 ООО, включающий имя клиента, сде­лавшего заказ,
//    имя закрепленного за ним служащего и офис, в котором работает этот служащий.

    public static void getOrdOff() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entity;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(OrdersEntity.class)
                    .add(Restrictions.between("amount", BigDecimal.valueOf(25000), BigDecimal.valueOf(10000000))).list();
            for (OrdersEntity ordersEntity : entity) {
                System.out.println(ordersEntity.getOrderNum() + " :number - "
                        + ordersEntity.getAmount() + " :amount - "
                        + ordersEntity.getOrd().getCompany() + " :customer - "
                        + ordersEntity.getOr().getName() + " :manager - "
                        + ordersEntity.getOr().getSl().getCity() + " :office");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


//    Найти все заказы, полученные в тот день, когда на работу был принят новый слу­жащий

    public static void getOrdDate() { //p169

        //TODO
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<SalesrepsEntity> entity;

        try (Session session = factory.openSession()) {

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sd.parse("2006-11-14");

            entity = session.createCriteria(SalesrepsEntity.class).add(Restrictions.eq("hireDate", date)).list();

            for (SalesrepsEntity salesrepsEntity : entity) {
                System.out.println();
            }
        } catch (HibernateException | ParseException e) {
            e.printStackTrace();
        }
    }

//    Перечислить все комбинации служащих и офисов, где плановый объем продаж служащего больше,
//    чем план како-либо офиса, независимо от места работы служащего.

    public static void getRepOffTarg() {
        //TODO
        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<SalesrepsEntity> entity;

        try (Session session = factory.openSession()) {
            entity = session.createCriteria(SalesrepsEntity.class).list();
            for (SalesrepsEntity salesrepsEntity : entity) {
                System.out.println(salesrepsEntity.getName() + " - "
                        + salesrepsEntity.getSl().getCity() + " - "
                        + salesrepsEntity.getHireDate());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static List<OrdersEntity> test() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        List<OrdersEntity> entities;

        try (Session session = factory.openSession()) {

            Criteria c = session.createCriteria(OrdersEntity.class, "orders");
            c.createAlias("orders.or", "empl");
            c.createAlias("empl.sl", "office");
            c.add(Restrictions.eq("office.region", "Eastern"));

            return c.list();

//           (order.class -> salesrep.class emplNum) Dokument.class is mapped to Role roleId
//           (salesrep.class -> office.class office) Role.class has a ContactPerson contactId
//           (office.class region) Contact.class FirstName LastName

//            Criteria c = session.createCriteria(Dokument.class, "dokument");
//            c.createAlias("dokument.role", "role"); // inner join by default
//            c.createAlias("role.contact", "contact");
//            c.add(Restrictions.eq("contact.lastName", "Test"));
//            return c.list();
        }

    }


}
