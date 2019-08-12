package rentalstore;

public class HtmlStatement extends Statement {
    @Override
    protected String valueOfEachTitle(Rental each, double thisAmount) {
        return each.getMovie().getTitle() + ": " + thisAmount + "<BR>\n";
    }

    @Override
    protected String generateFooter(int frequentRenterPoints, double totalAmount) {
        String footer = "<P>You owe<EM>" + totalAmount + "</EM><P>\n";
        footer += "On this rental you earned <EM>" + frequentRenterPoints + "</EM> frequent renter points<P>";
        return footer;
    }

    @Override
    protected String valueOfHeader(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
