package rentalstore;

public abstract class Statement {

    public String statement(Customer customer) {
        int frequentRenterPoints = 0;
        String result = valueOfHeader(customer);
        double totalAmount = 0;
        for (Rental each : customer.getRentals()) {
            double thisAmount = each.getThisAmountByMovieType();
            frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints, each);
            result += valueOfEachTitle(each, thisAmount);
            totalAmount += thisAmount;
        }

        result += generateFooter(frequentRenterPoints, totalAmount);
        return result;
    }

    protected abstract String valueOfEachTitle(Rental each, double thisAmount);
    private int addFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints++;
        if (isNewReleaseMovieRentalOverOneDay(each)) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private boolean isNewReleaseMovieRentalOverOneDay(Rental each) {
        return (each.getMovie() instanceof NewReleaseMovie) && each.getDayRented() > 1;
    }

    protected abstract String generateFooter(int frequentRenterPoints, double totalAmount);

    protected abstract String valueOfHeader(Customer customer);

}
