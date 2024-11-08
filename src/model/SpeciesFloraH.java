package model;

public class SpeciesFloraH extends Species {
    // Si tiene o no flores, Si tiene o no frutas y la altura máxima que puede alcanzar un espécimen de la especie.
    private boolean flowers;
    private boolean fruits;
    private double maxHeight;

    public SpeciesFloraH(String name, String sci_Name, boolean flowers, boolean fruits, double maxHeight){
        super(name, sci_Name);

        this.flowers = flowers;
        this.fruits = fruits;
        this.maxHeight = maxHeight;
    }

    public boolean isFlowers() {
        return flowers;
    }

    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public boolean isFruits() {
        return fruits;
    }

    public void setFruits(boolean fruits) {
        this.fruits = fruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public boolean editSpecies(String name, String sci_Name, boolean flowers, boolean fruits, double maxHeight){
        setName(name);
        setScientificName(sci_Name);
        setFlowers(flowers);
        setFruits(fruits);
        setMaxHeight(maxHeight);
        return true;
    }

    
}
