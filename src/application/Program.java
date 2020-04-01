package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Room Number: "));
		Date checkin = sdf.parse(JOptionPane.showInputDialog(null, "Check-in date (dd/MM/yyyy): "));
		Date checkout = sdf.parse(JOptionPane.showInputDialog(null, "Check-out date (dd/MM/yyyy): "));

		if (!checkout.after(checkin)) {
			JOptionPane.showMessageDialog(null, "Error in reservation!!");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			JOptionPane.showMessageDialog(null, "Reservation : " + reservation);
			checkin = sdf.parse(JOptionPane.showInputDialog(null, "Check-in date (dd/MM/yyyy): "));
			checkout = sdf.parse(JOptionPane.showInputDialog(null, "Check-out date (dd/MM/yyyy): "));

			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				JOptionPane.showMessageDialog(null, "Error in reservation!! Invalid Date");
			} else if (!checkout.after(checkin)) {
				JOptionPane.showMessageDialog(null, "Error in reservation!!");
			}

			reservation.updateDates(checkin, checkout);
			JOptionPane.showMessageDialog(null, "Reservation : " + reservation);
		}
	}

}
