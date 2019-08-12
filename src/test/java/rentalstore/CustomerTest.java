package rentalstore;


import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer = new Customer("Ethan");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = new NormalStatement().statement(customer);
        assertEquals("Rental Record for Ethan\nAmount owed is 0.0\nYou earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = movieBuilder( 0, 1, new RegularMovie("Avenger1"));
        String statement =new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + regularMovie.getTitle() + "\t2.0\n" +
                             "Amount owed is 2.0\n" +
                             "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = movieBuilder(0, 3, new RegularMovie("Avenger1"));

        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + regularMovie.getTitle() + "\t3.5\n" +
                             "Amount owed is 3.5\n" +
                             "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = movieBuilder(1, 1, new NewReleaseMovie("Avenger1"));

        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                             "Amount owed is 3.0\n" +
                             "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = movieBuilder(1, 2, new NewReleaseMovie("Avenger1"));

        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                             "Amount owed is 6.0\n" +
                             "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = movieBuilder(2, 1, new ChildrenMovie("Avenger1"));

        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                             "Amount owed is 1.5\n" +
                             "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = movieBuilder(2, 4, new ChildrenMovie("Avenger1"));

        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                             "Amount owed is 3.0\n" +
                             "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_two_child_movie_each_for_4_day() {
        Movie childrenMovie1 = movieBuilder(2, 4, new ChildrenMovie("Avenger1"));
        Movie childrenMovie2 = movieBuilder(2, 4, new ChildrenMovie("Avenger1"));
        String statement = new NormalStatement().statement(customer);

        assertEquals("Rental Record for Ethan\n" +
                             "\t" + childrenMovie1.getTitle() + "\t3.0\n" +
                             "\t" + childrenMovie2.getTitle() + "\t3.0\n" +
                             "Amount owed is 6.0\n" +
                             "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new ChildrenMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = new HtmlStatement().statement(customer);

        assertEquals("<H1>Rentals for <EM>Ethan</EM></H1><P>\n" +
                             "Titanic: 3.0<BR>\n" +
                             "<P>You owe<EM>3.0</EM><P>\n" +
                             "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }



    private Movie movieBuilder(int priceCode, int dayRented, Movie movie) {
        Movie regularMovie = movie;
        Rental oneDayRental = new Rental(regularMovie, dayRented);
        customer.addRental(oneDayRental);
        return regularMovie;
    }
}
