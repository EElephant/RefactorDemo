package rentalstore;

public class NormalStatement extends Statement {
    @Override
    protected String valueOfEachTitle(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    @Override
    protected String generateFooter(int frequentRenterPoints, double totalAmount) {
        String footer = "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints + " frequent renter points";
        return footer;
    }

    @Override
    protected String valueOfHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
