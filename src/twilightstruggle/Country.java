package twilightstruggle;

import java.util.Set;

public class Country extends AbstractCountry {
    private static Board board;
    private String name;
    private Integer influenceUSA;
    private Integer influenceUSSR;
    private Integer stability;
    private Set<AbstractCountry> neighbors;
    private Region region;

    public static void setBoard(Board board) {
        Country.board = board;
    }

    public Integer getInfluenceUSA() {
        return influenceUSA;
    }

    public void setInfluenceUSA(Integer influenceUSA) {
        this.influenceUSA = influenceUSA;
    }

    public Integer getInfluenceUSSR() {
        return influenceUSSR;
    }

    public void setInfluenceUSSR(Integer influenceUSSR) {
        this.influenceUSSR = influenceUSSR;
    }

    public Integer getStability() {
        return stability;
    }

    public void setStability(Integer stability) {
        this.stability = stability;
    }

    public Set<AbstractCountry> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<AbstractCountry> neighbors) {
        this.neighbors = neighbors;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Country() {
        influenceUSA = new Integer(0);
        influenceUSSR = new Integer(0);
        stability = null;
    }

    public Country(String name, int stability) {
        this();
        this.name = name;
        this.stability = stability;
    }

    protected void addNeighbor(Country neighbor) {
        this.neighbors.add(neighbor);
    }

    public boolean isCoupable() {
        return this.region.isCoupable();             
    }
}

