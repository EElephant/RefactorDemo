package rentalstore;

public class ChildrenMovie extends Movie{
    public ChildrenMovie(String title) {
        super(title);
    }

    protected double calculateThisAmount(int dayRented) {
        double thisAmount = 1.5;
        if (dayRented > 3) {
            thisAmount += (dayRented - 3) * 1.5;
        }
        return thisAmount;
    }
}
