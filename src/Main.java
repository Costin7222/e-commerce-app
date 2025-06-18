public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem(10.99);
        order.addItem(8.99);
        order.addItem(200);
        order.addItem(2.99);
        order.addItem(7.99);
        order.addItem(1.99);

        // $20 discount and free shipping applied
        System.out.println(order);


        order.detach(priceObserver);
        order.addItem(10);

        // $20 discount not applied anymore
        System.out.println(order);
    }
}
