package rentalstore;

public class NewReleaseMovie extends Movie{

    public NewReleaseMovie(String title) {
        super(title);
    }

    protected double calculateThisAmount(int dayRented) {
        return dayRented * 3;
    }
}
