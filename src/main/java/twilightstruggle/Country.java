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
    private Boolean isBattleground;

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public static void setBoard(Board board) {
        Country.board = board;
    }

    public Integer getInfluenceUSA() {
        return influenceUSA;
    }

    public Country setInfluenceUSA(Integer influenceUSA) {
        this.influenceUSA = influenceUSA;
        return this;
    }

    public Integer getInfluenceUSSR() {
        return influenceUSSR;
    }

    public Country setInfluenceUSSR(Integer influenceUSSR) {
        this.influenceUSSR = influenceUSSR;
        return this;
    }

    public Integer getStability() {
        return stability;
    }

    public Country setStability(Integer stability) {
        this.stability = stability;
        return this;
    }

    public Set<AbstractCountry> getNeighbors() {
        return neighbors;
    }

    public Country setNeighbors(Set<AbstractCountry> neighbors) {
        this.neighbors = neighbors;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Boolean getIsBattleground() {
        return isBattleground;
    }

    public Country setIsBattleground(Boolean isBattleground) {
        this.isBattleground = isBattleground;
        return this;
    }

    public Country setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Country() {
        influenceUSA = new Integer(0);
        influenceUSSR = new Integer(0);
        stability = null;
    }

    protected void addNeighbor(Country neighbor) {
        this.neighbors.add(neighbor);
    }

    public boolean isCoupable() {
        return this.region.isCoupable();             
    }
}

