package twilightstruggle;

import java.util.Set;

public class Side {
    private String name;
    private Integer spaceRaceCounter;
    private Integer militaryOperations;
    private Set<Card> hand;
    private Die die;

    public Side() {
        spaceRaceCounter = 0;
        militaryOperations = 0;
        die = new Die();
    }

    public String getName() {
        return name;
    }

    public Side setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSpaceRaceCounter() {
        return spaceRaceCounter;
    }

    public Side setSpaceRaceCounter(Integer spaceRaceCounter) {
        this.spaceRaceCounter = spaceRaceCounter;
        return this;
    }

    public Integer getMilitaryOperations() {
        return militaryOperations;
    }

    public Side setMilitaryOperations(Integer militaryOperations) {
        this.militaryOperations = militaryOperations;
        return this;
    }

    public Side addMilitaryOperations(Integer militaryOperations) {
        this.militaryOperations += militaryOperations;
        return this;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public Side setHand(Set<Card> hand) {
        this.hand = hand;
        return this;
    }

    public Die getDie() {
        return die;
    }

    public Side setDie(Die die) {
        this.die = die;
        return this;
    }
}

