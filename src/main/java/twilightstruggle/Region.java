package twilightstruggle;

import java.util.*;

public class Region {
    private static Board board;
    private List<Country> countries = new ArrayList<Country>();
    private String name;
    private Integer presence;
    private Integer domination;
    private Integer control;
    private Integer uncoupableDefconLevel;
    private boolean hasScoringCard;

    public Region() { }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        Region.board = board;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Region setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }

    public int getPresence() {
        return presence;
    }

    public Region setPresence(int presence) {
        this.presence = presence;
        return this;
    }

    public int getDomination() {
        return domination;
    }

    public Region setDomination(int domination) {
        this.domination = domination;
        return this;
    }

    public int getControl() {
        return control;
    }

    public Region setControl(int control) {
        this.control = control;
        return this;
    }

    public boolean getHasScoringCard() {
        return hasScoringCard;
    }

    public Region setHasScoringCard(boolean hasScoringCard) {
        this.hasScoringCard = hasScoringCard;
        return this;
    }

    public int getUncoupableDefconLevel() {
        return uncoupableDefconLevel;
    }

    public Region setUncoupableDefconLevel(int uncoupableDefconLevel) {
        this.uncoupableDefconLevel = uncoupableDefconLevel;
        return this;
    }

    public Country addCountry(Country country) {
        countries.add(country);
        return country;
    }

    public Boolean isCoupable() {
        return uncoupableDefconLevel < board.getDefcon();
    }
}
