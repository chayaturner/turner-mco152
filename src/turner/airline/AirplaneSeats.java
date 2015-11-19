package turner.airline;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private int rows;
	private int columns;
	private HashMap<String, Boolean> airplane;

	private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.airplane = new HashMap<String, Boolean>();

		StringBuilder builder = new StringBuilder();

		for (int row = 1; row <= rows; row++) {
			for (int col = 0; col <= rows; row++) {
				builder.append(letters[col]);
				builder.append(Integer.toString(row));
				airplane.put(builder.toString(), false);
				builder.setLength(0);
			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
	SeatOutOfBoundsException {

		if (airplane.containsKey(seatName)) {
			throw new SeatOutOfBoundsException();
		}

		if (airplane.get(seatName) == true) {
			throw new AlreadyReservedException();
		} else {
			airplane.put(seatName, true);
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return airplane.get(seatName);
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {

		StringBuilder builder1 = new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		builder2.append(" ");
		for (int i = 0; i <= rows; i++) {
			builder2.append(letters[i]);
		}
		builder2.append("\\n");

		for (int row = 1; row <= rows; row++) {
			builder2.append(row);
			builder2.append(" ");
			for (int col = 0; col < columns; col++) {
				builder1.setLength(0);
				builder1.append(letters[col]);
				builder1.append(Integer.toString(row));

				if (airplane.get(builder1.toString()) == true) {
					builder2.append("#");
				} else {
					builder2.append("o");
				}
			}
			builder2.append("\n");
		}

		return builder2.toString();

	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {

		ArrayList<String> group = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int row = 1; row <= rows; row++) {
			int count = 0;
			for (int col = 0; col < columns; col++) {
				builder.setLength(0);
				builder.append(letters[col]);
				builder.append(Integer.toString(row));
				if (airplane.get(builder.toString()) == false) {
					group.add(builder.toString());
					count++;
				} else if (airplane.get(builder.toString()) == true) {
					break;
				}
			}
			if (count == numberOfSeatsTogether) {
				for (String seat : group) {
					reserve(seat);
				}
				return group;
			}
		}
		throw new NotEnoughSeatsException();
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return !airplane.containsValue(false);
	}

}
