import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Customer class
class Customer {
    public int id;
    public String name;
}

// Order class
class Order {
    public Customer customer;
    public int amount;
    public Date date;
}

// Reporting interface
interface IReporting {
    void addOrder(Order order);
    int totalOrderAmountPerCustomer(int customerId);
    int totalOrderAmountOnDate(Date date);
    List<Order> getOrders(int customerId);
}

// Reporting class implementing IReporting
class Reporting implements IReporting {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public int totalOrderAmountPerCustomer(int customerId) {
        return orders.stream()
                .filter(order -> order.customer.id == customerId)
                .mapToInt(order -> order.amount)
                .sum();
    }

    @Override
    public int totalOrderAmountOnDate(Date date) {
        return orders.stream()
                .filter(order -> order.date.equals(date))
                .mapToInt(order -> order.amount)
                .sum();

    }

    @Override
    public List<Order> getOrders(int customerId) {
        return orders.stream()
                .filter(order -> order.customer.id == customerId)
                .toList();
    }
}

// Solution class with main method
public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);

        List<Customer> customers = new ArrayList<>();
        Reporting reporting = new Reporting();

        // Read number of customers
        int count = Integer.parseInt(br.readLine().trim());

        // Read customer details
        for (int i = 0; i < count; i++) {
            String[] customerInfo = br.readLine().trim().split(" ");
            Customer customer = new Customer();
            customer.id = Integer.parseInt(customerInfo[0]);
            customer.name = customerInfo[1];
            customers.add(customer);
        }

        // Read number of orders
        int orderCount = Integer.parseInt(br.readLine().trim());

        // Read order details
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        for (int i = 0; i < orderCount; i++) {
            String[] orderInfo = br.readLine().trim().split(" ");

            int customerId = Integer.parseInt(orderInfo[0]);
            Customer customer = customers.stream()
                    .filter(c -> c.id == customerId)
                    .findFirst()
                    .orElse(null);

            if (customer != null) {
                Order order = new Order();
                order.customer = customer;
                order.amount = Integer.parseInt(orderInfo[1]);
                order.date = dateFormat.parse(orderInfo[2]);
                reporting.addOrder(order);
            }
        }

        // Read date parameter
        String dateStr = br.readLine().trim();
        Date date = dateFormat.parse(dateStr);

        // Output total order amount on the given date
        int totalAmountOnDate = reporting.totalOrderAmountOnDate(date);
        textWriter.println(dateStr + ":" + totalAmountOnDate);

        // Close resources
        textWriter.close();
        br.close();
    }
}
