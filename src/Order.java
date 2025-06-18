import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private List<OrderObserver> observers;

    private int orderNumber;
    private List<Double> orderItems;
    private double totalPrice;
    private int orderQuantity;
    private int shippingCost;

    public Order() {
        observers = new ArrayList<OrderObserver>();

        Random rand = new Random();
        this.orderNumber = rand.nextInt(1000);
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0;
        this.orderQuantity = 0;
        this.shippingCost = 10;
    }

    public void attach(OrderObserver orderObserver) {
        this.observers.add(orderObserver);
    }

    public void detach(OrderObserver orderObserver) {
        this.observers.remove(orderObserver);
    }

    public void addItem(double price) {
        this.orderItems.add(price);
        this.totalPrice = orderItems.stream().mapToDouble(Double::doubleValue).sum();
        this.orderQuantity = orderItems.size();
        this.notifyObservers();
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public List<Double> getOrderItems() {
        return orderItems;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order number: " + this.orderNumber + ", containing " + this.orderQuantity + " item(s) for a total of $" + this.totalPrice + " (+ $" + this.shippingCost + " for shipping)";
    }
}
