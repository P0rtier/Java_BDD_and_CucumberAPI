package com.pluralsight.bdd.smoothieTests;

public class MorningFreshnessMember {

    private String name;
    private SuperSmoothieSchema schema;
    int earnedPoints;
    public MorningFreshnessMember(String name, SuperSmoothieSchema schema) {
        this.name=name;
        this.schema = schema;
    }

    public void orders(Integer amount, String drink) {
        earnedPoints += schema.getPointsFor(drink)*amount;
    }

    public int getPoints() {
        return earnedPoints;
    }

    public MorningFreshnessMember getByName(String name){
        if(name.equals(this.name))
            return this;
        else return null;
    }
}
