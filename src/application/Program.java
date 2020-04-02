package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Room Number: "));
			Date checkin = sdf.parse(JOptionPane.showInputDialog(null, "Check-in date (dd/MM/yyyy): "));
			Date checkout = sdf.parse(JOptionPane.showInputDialog(null, "Check-out date (dd/MM/yyyy): "));

			Reservation reservation = new Reservation(number, checkin, checkout);
			JOptionPane.showMessageDialog(null, "Reservation : " + reservation);
			checkin = sdf.parse(JOptionPane.showInputDialog(null, "Check-in date (dd/MM/yyyy): "));
			checkout = sdf.parse(JOptionPane.showInputDialog(null, "Check-out date (dd/MM/yyyy): "));

			reservation.updateDates(checkin, checkout);
			JOptionPane.showMessageDialog(null, "Reservation : " + reservation);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Invalid Format");
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Unexpected Error!!");
		}

	}

}
