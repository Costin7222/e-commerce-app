public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        double totalPrice = order.getTotalPrice();
        if (totalPrice > 200)
            totalPrice -= 20;
        order.setTotalPrice(totalPrice);
    }
}
