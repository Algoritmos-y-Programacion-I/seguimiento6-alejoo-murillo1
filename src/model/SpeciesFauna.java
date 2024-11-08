package model;

public class SpeciesFauna extends Species {
    // Si es o no migratoria y el peso máximo que puede alcanzar un espécimen de la especie.
    private boolean migratory;
    private double maxWeight;

    public SpeciesFauna(String name, String sci_Name, boolean migratory, double maxWeight){
        super(name, sci_Name);
        this.migratory = migratory;
        this.maxWeight = maxWeight;
    }

    public boolean isMigratory() {
        return migratory;
    }

    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean editSpecies(String name, String sci_Name, boolean migratory, double maxWeight){
        setName(name);
        setScientificName(sci_Name);
        setMigratory(migratory);
        setMaxWeight(maxWeight);
        return true;
    }

    
}
