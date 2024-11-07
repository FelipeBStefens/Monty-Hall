// The package;
package MontyHallParadox;

// The class;
public class MontyHallClass {
	
	// Random number global;
	private int randomNumberDoor;
	private int choosedDoor;
	private int alternativeDoor;
	public int[] arrayDoor = {1, 2, 3};
	
	// Constructor;
	public MontyHallClass(int randomNumberDoor, int choosedDoor) {
		if (randomNumberDoor > 3) {
			randomNumberDoor = 3;
		}
		else if (randomNumberDoor < 1) {
			randomNumberDoor = 1;
		}
		if (choosedDoor > 3) {
			choosedDoor = 3;
		}
		else if (choosedDoor < 1) {
			choosedDoor = 1;
		}
		this.randomNumberDoor = randomNumberDoor;
		this.choosedDoor = choosedDoor;
	}
	
	// Getter;
	public int getRandomNumberDoor() {
		return randomNumberDoor;
	}
	public int getChoosedDoor() {
		return choosedDoor;
	}
	
	// Open the other goat door;
	public int goatDoor() {
		if (arrayDoor[0] != randomNumberDoor && arrayDoor[0] != choosedDoor) {
			return arrayDoor[0];
		}
		else if (arrayDoor[1] != randomNumberDoor && arrayDoor[1] != choosedDoor) {
			return arrayDoor[1];
		}
		else {
			return arrayDoor[2];
		}
	}
	
	// Question if the person want to change the door;
	public int wantChange(String condicional) {
		if (condicional.equalsIgnoreCase("No")) {
			alternativeDoor = choosedDoor;
			return (int)alternativeDoor;
		}
		else if (condicional.equalsIgnoreCase("Yes")) {
			if (goatDoor() == arrayDoor[0]) {
				if (choosedDoor == arrayDoor[1]) {
					alternativeDoor = arrayDoor[2];
					return (int)alternativeDoor;
				}
				else {
					alternativeDoor = arrayDoor[1];
					return (int)alternativeDoor;
				}
			}
			else if (goatDoor() == arrayDoor[1]) {
				if (choosedDoor == arrayDoor[0]) {
					alternativeDoor = arrayDoor[2];
					return (int)alternativeDoor;
				}
				else {
					alternativeDoor = arrayDoor[0];
					return (int)alternativeDoor;					}
				}
			else {
				if (choosedDoor == arrayDoor[1]) {
					alternativeDoor = arrayDoor[0];
					return (int)alternativeDoor;
				}
				else {
					alternativeDoor = arrayDoor[1];
					return (int)alternativeDoor;
				}
			}
		}
		else {
			alternativeDoor = choosedDoor;
			return (int)alternativeDoor;
		}
	}
	
	// Open the door;
	public String openDoor() {
		if (randomNumberDoor == choosedDoor) {
			return "You open the right door, so you won the car!!";
		}
		else {
			return "You choosed the wrong door, so you won the goat!!";
		}
	}

}
