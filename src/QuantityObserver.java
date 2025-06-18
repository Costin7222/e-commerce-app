public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getOrderQuantity() > 5)
            order.setShippingCost(0);
    }
}
