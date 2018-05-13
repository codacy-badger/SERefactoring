
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental arg) {
		rentals.add(arg);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> enum_rentals = Collections.enumeration(rentals);
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental rental = (Rental) enum_rentals.nextElement();
			thisAmount = rental.getAmount();
			frequentRenterPoints++;
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
				frequentRenterPoints++;
			result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;

	}

}
