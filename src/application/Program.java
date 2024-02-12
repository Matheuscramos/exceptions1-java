package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());

		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		// aqui eu testo se a data de do chekout e depois da do checkin
		// usando a funão (!checkout.after(checkin)) que esta dentro do if(){}
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation" + reservation);
			System.out.println();

			System.out.println("Enter data to update the reservation:  ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());

			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();// new Date() pega a hora de agora!
			// este if()checa se a data do checkin  for antes de agora, e a data checkout for antes de agora
			// vai dar erro porque a reserva não pode ser feita.
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {

				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation" + reservation);
			}
		}

		sc.close();

	}

}
