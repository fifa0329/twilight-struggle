package twilightstruggle;

import java.util.Set;

public class Region {
    private static Board board;
    private Set<Country> countries;
    private String name;
    private Integer presence;
    private Integer domination;
    private Integer control;
    private Integer uncoupableDefconLevel;
    private boolean hasScoringCard;

    public Region(String name, Integer presence, Integer domination, Integer control, Integer uncoupableDefconLevel,) {

    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        Region.board = board;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getDomination() {
        return domination;
    }

    public void setDomination(int domination) {
        this.domination = domination;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getHasScoringCard() {
        return hasScoringCard;
    }

    public void setHasScoringCard(int hasScoringCard) {
        this.hasScoringCard = hasScoringCard;
    }

    public int getUncoupableDefconLevel() {
        return uncoupableDefconLevel;
    }

    public void setUncoupableDefconLevel(int uncoupableDefconLevel) {
        this.uncoupableDefconLevel = uncoupableDefconLevel;
    }

    public boolean isCoupable() {
        return uncoupableDefconLevel < board.getDefcon();
    }
}
