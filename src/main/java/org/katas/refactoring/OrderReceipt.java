package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String createReceiptString() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.getTotalAmount());
            output.append('\n');

            double salesTax = lineItem.getTotalAmount() * 0.10;
            totSalesTax += salesTax;
            totalAmount += lineItem.getTotalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }
}