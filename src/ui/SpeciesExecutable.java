package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerSpecies();
				break;
			case 2:
				editSpecies();
				break;
			case 3:
				deleteSpecies();
				break;
			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}

	public void registerSpecies() {
		reader.nextLine();

		System.out.println("Type the new Species' name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.nextLine();

		System.out.println("Type the Species' class: (1. Flora Herbario, 2. Fauna)");
		int species_choice = reader.nextInt();

		if(species_choice == 1){
			reader.nextLine();
			// boolean flowers, boolean fruits, double maxHeight
			System.out.println("If the Species has flowers, type (true), else type (false): ");
			boolean flowers = reader.nextBoolean();

			System.out.println("If the Species has fruits, type (true), else type (false): ");
			boolean fruits = reader.nextBoolean();

			System.out.println("Type the Species' maximum height (cm): ");
			double maxHeight = reader.nextDouble();

			if(speciesController.registerSpecies(name, scientificName, flowers, fruits, maxHeight)){
				System.out.println("Species' been stored Successfully!");
			}else{
				System.out.println("Error. Your new Species couldn't be stored :(");
			}

		}else if(species_choice == 2){
			reader.nextLine();

			//boolean migratory, double maxWeight
			System.out.println("If the Species is migratory, type (true), else type (false)");
			boolean migratory = reader.nextBoolean();

			System.out.println("Type the Species' maximum weight (kg)");
			double maxWeight = reader.nextDouble();

			if(speciesController.registerSpecies(name, scientificName, migratory, migratory, maxWeight)){
				System.out.println("Species' been stored Succesfully!");
			}else{
				System.out.println("Error. The new Species couldn't be stored :(");
			}

		}else{
			System.out.println("Type a VALID CLASS");
			registerSpecies();
		}

	}

	public void editSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Type the number that corresponds to the Species you're looking for");
			int numSpecies = reader.nextInt();

			reader.nextLine();

			System.out.println("Type the new name of the Species: ");
			String newName = reader.nextLine();

			System.out.println("Type the new Scientific name of the Species: ");
			String newScientificName = reader.nextLine();

			if(speciesController.getInstanceOfSpecies(numSpecies)){
				//boolean flowers, boolean fruits, double maxHeight
				System.out.println("If the Species has flowers, type (true), else type (false):");
				boolean flowers = reader.nextBoolean();

				System.out.println("If the Species has fruits, type (true), else type (false): ");
				boolean fruits = reader.nextBoolean();

				System.out.println("Type the new Species' maximum height");
				double newMaxHeight = reader.nextDouble();

				if(speciesController.editSpecies(numSpecies, newName, newScientificName,flowers, fruits, newMaxHeight)){
					System.out.println("Species' been updated Successfully!");
				}else{
					System.out.println("Species was not found");
				}

			}else{
				//boolean migratory, double maxWeight

				System.out.println("If the Species is migratory, type (true), else type (false)");
				boolean newmigratory = reader.nextBoolean();

				System.out.println("Type the Species' maximum weight (kg)");
				double newmaxWeight = reader.nextDouble();

				if(speciesController.editSpecies(numSpecies, newName, newScientificName, newmigratory, newmaxWeight)){
					System.out.println("Species' been updated Successfully!");
				}else{
					System.out.println("Species was not found.");
				}
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Species to delete: ");
			int specie = reader.nextInt();

			if(speciesController.deleteSpecies(specie)){
				System.out.println("Species deleted Successfully.");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {

		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("Species: ");
			int specie = reader.nextInt();

			System.out.println(speciesController.showSpecies(specie));

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
