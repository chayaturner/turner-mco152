package turner.airline;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private String[] englishLetters = { "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };

	private int rows;
	private int columns;
	private HashMap<String, Integer> map;
	private ArrayList<String> seats;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		this.map = new HashMap<String, Integer>();

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; i++)
				map.put(englishLetters[i], numbers[i]);
		}

		this.seats = new ArrayList<String>();
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
	private int getNumericValue(String seatName){
		int numericValue = 0;
		
		for(int i = 0; i < columns; i++){
			numericValue = map.get(seatName.charAt(0));
		}
		
		return numericValue;
	}
	
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {

		if (isReserved(seatName) == true) {
			throw new AlreadyReservedException();
		}
		
		if (getNumericValue(seatName) > columns || seatName.charAt(1) > rows) {
			throw new SeatOutOfBoundsException();
		}

		seats.add(seatName);

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return seats.contains(seatName);
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
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
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
		//if isReserved(), add # to the builder in that position
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < columns; i++){
			builder.append(map.get(i));
		}
		builder.append("\\n");
		
		String seat = "";
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
			builder.append(i);
			seat = String.valueOf(i) + map.get(j);
			if(isReserved(seat)){
				builder.append("#");
			} else {
				builder.append("o");
			}
			}
			builder.append("\\n");
		}
		
	 return builder.toString();
	 
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
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		//check if there are numberOfSeatsTogether in a row
		//by checking if there that amount of seats in a row !isReserved()
		
		//	StringBuilder builder = new StringBuilder();
		//  ArrayList<String> groupSeats = new ArrayList<String>();
		
		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (String seat : seats) {
			if (!isReserved(seat)) {
				return false;
			}
		}
		return true;
	}

}
