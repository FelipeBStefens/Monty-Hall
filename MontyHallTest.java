// The package;
package MontyHallParadox;

// The importation;
import java.util.*;
import javax.swing.JOptionPane;

// The class;
public class MontyHallTest {
	
	// Main method;
	public static void main(String[] args) throws Exception {
		
		// Defining the write door in the Monty Hall with the class Random and Scanner;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		// What the person wants to do, if it's play the game or see the probabilities;
		int message = JOptionPane.showConfirmDialog
				(null, "Do you want to see the probabilities or play the game? Yes or No?", "Monty Hall project", JOptionPane.YES_NO_OPTION);
		
		if (message == JOptionPane.YES_OPTION) {
			String stringMaxValue = JOptionPane.showInputDialog(null, "What's the integer max value?", "Monty Hall project", JOptionPane.DEFAULT_OPTION);
			
			if (Integer.parseInt(stringMaxValue) <= 0) {
				JOptionPane.showMessageDialog(null, "Invalid value...");
			}
			else {
				int intDoorChange = JOptionPane.showConfirmDialog(null, "Do you want to change the door?", "Monty Hall project", JOptionPane.YES_NO_OPTION);
				if (intDoorChange == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, MontyHallProbabilities.changingDoorsProbabilities(Integer.parseInt(stringMaxValue), "Yes"));
				}
				else {
					JOptionPane.showMessageDialog(null, MontyHallProbabilities.changingDoorsProbabilities(Integer.parseInt(stringMaxValue), "No"));
				}
			}
		}
		
		// If it's to play the game;
		else {
			
			// Defining the right answer;
			int rightRandom = random.nextInt(3);
			
			// Presenting the program and saying the door;
			String messageStart = JOptionPane.showInputDialog(null, "Hello, this is the Mounty Hall Program, basically, it has 3 doors, the door 1, door 2 ans door 3!! "
					+ "You need to choose one of this doors.\nAfter this, I will show to you one door that has a Goat, and you can change the door. "
					+ "If you choose the wrong door, you will win a GOAT, \n"
					+ "but if you choose the right door, you will win a CAR!! So, choose one door...", "Monty Hall project", JOptionPane.DEFAULT_OPTION);
			
			// Using the MountyHallClass with the constructor;
			MontyHallClass montyHall = new MontyHallClass(rightRandom, Integer.parseInt(messageStart));
			
			JOptionPane.showMessageDialog(null, String.format("You choose the %s door,%n and now it will open the %d door, IT'S A GOAT!!", 
					messageStart, montyHall.goatDoor()));
			
			// Questioning if do you want 
			int sameOrNot = JOptionPane.showConfirmDialog
					(null, "Now, do you want to change the door or stay in the same? Yes or no?", "Monty Hall project", JOptionPane.YES_NO_OPTION);
			
			if (sameOrNot == JOptionPane.YES_OPTION) {
				montyHall.wantChange("Yes");
			}
			else {
				montyHall.wantChange("No");
			}
	
			// Open the door and saying the result;
			JOptionPane.showMessageDialog(null, montyHall.openDoor());
			
			// Closing the Scanner class;
			scanner.close();
		}
	}
}
