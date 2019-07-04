package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.List;

public class JDBCExecutor {
    public static void main(String[] args) throws SQLInvalidAuthorizationSpecException {
        String pgPassword = System.getenv("PGPASSWORD");
        String pgUser = System.getenv("PGUSER");
        String pgHost = System.getenv("PGHOST");
        String pgDatabase = "hplussport";
        if ((pgPassword == null) ||
                (pgHost == null) ||
                (pgUser == null)) {
            try {
                pgHost = args[0];
                pgUser = args[1];
                pgPassword = args[2];
            } catch (Exception e) {
                throw new SQLInvalidAuthorizationSpecException("\nSet database credentials as environmental variables:\n" +
                        "\tPGHOST,PGUSER,PGPASSWORD\n " +
                        "or send as arguments:\n" +
                        "\targ[0]=PGHOST, arg[1]=PGUSER, arg[2]=PGPASSWORD");
            }
        }

        DatabaseConnectionManager dcm = new DatabaseConnectionManager(pgHost, pgDatabase,
                pgUser, pgPassword);
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            OrderDAO orderDAO = new OrderDAO(connection);

            /*Customer customer = new Customer();
            customer.setFirstName("George");
            customer.setLastName("Washington");
            customer.setEmail("george.washington@wh.gov");
            customer.setPhone("(555)666-4321");
            customer.setAddress("1234 Main St");
            customer.setCity("Mount Vernon");
            customer.setState("VA");
            customer.setZipCode("22121");
            customerDAO.create(customer);*/

            /*Customer customer =customerDAO.findById(10000);
            System.out.println(customer);
            customer.setEmail("gwashington@wh.gov");
            customer = customerDAO.update(customer);
            System.out.println(customer);*/

            /*Order order;
            order = orderDAO.findById(1011);
            System.out.println(order);*/

            /*List<Order> orders = orderDAO.getOrdersForCustomer(789);
            orders.forEach(System.out::println);*/

            /*customerDAO.findAllSorted(20).forEach(System.out::println);*/

            int n = 4;
            System.out.println("Paged");
            for (int i = 1; i < n + 1; i++) {
                System.out.println("=============> Page " + i);
                customerDAO.findAllSortedPaged(4, n).forEach(System.out::println);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
