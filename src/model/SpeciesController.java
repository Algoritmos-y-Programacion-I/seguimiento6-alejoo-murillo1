package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	public boolean registerSpecies(String name, String scientificName, boolean flowers, boolean fruits, double maxHeight) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new SpeciesFloraH(name, scientificName, flowers, fruits, maxHeight);
				return true;
			}

		}

		return false;

	}

	public boolean registerSpecies(String name, String scientificName, boolean migratory, double maxWeight){
		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new SpeciesFauna(name, scientificName, migratory, maxWeight);
				return true;
			}

		}

		return false;
	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

	public boolean getInstanceOfSpecies(int species){
		Species searchingSpecies = searchSpecies(species);

		if(searchingSpecies instanceof SpeciesFloraH){
			return true;
		}
		return false;
	}

	public Species searchSpecies(int specie){
		if(species.length != 0){
			return species[specie];
		}
		return null;
	}

	public boolean editSpecies(int speciesToSearch, String name, String sciName, boolean flowers, boolean fruits, double maxHeight){
		SpeciesFloraH looked_forSpecies = (SpeciesFloraH)searchSpecies(speciesToSearch);
		if(looked_forSpecies != null){
			return looked_forSpecies.editSpecies(sciName, name, flowers, fruits, maxHeight);
		}
		return false;
	}

	public boolean editSpecies(int specieToSearch, String name, String sci_Name, boolean migratory, double maxWeight){
		SpeciesFauna especieBuscada = (SpeciesFauna)searchSpecies(specieToSearch);

		if(especieBuscada != null){
			return especieBuscada.editSpecies(name, sci_Name, migratory, maxWeight);
		}
		return false;
	}

}
