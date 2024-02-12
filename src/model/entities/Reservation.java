package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	// calculando a diferença de duas datas.
	// esse calculo e feito por milisegindos
	public long duration() {
		// getTime()me devolve a quantidade de milisegundo da data.
		long diff =  checkout.getTime() - checkin.getTime();
		// diff e a quantidade de milisegundos
		// a TimeUnit e um tipo enumerado complexo que contem algumas operações
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		// convert(diff, TimeUnit.MICROSECONDS) esta operação converte os milesegundos
		// do diff,e dias
	}

	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {

		return "Room "
		+ roomNumber 
		+ ", check-in: " 
		+ sdf.format(checkin) 
		+ ", check-out: " 
		+ sdf.format(checkout)
		+ ", " 
		+ duration() + " nigths";
	}

}
