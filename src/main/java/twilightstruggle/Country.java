package twilightstruggle;

import twilightstruggle.exception.TwilightException;

import java.util.*;

public class Country extends AbstractCountry {
    private static Board board;
    private java.util.Map<Side,Integer> influence;
    private Integer stability;
    private Region region;
    private Boolean isBattleground;

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public static void setBoard(Board board) {
        Country.board = board;
    }

    public Integer getInfluence(Side side) {
        return this.influence.get(side);
    }

    public Integer getStability() {
        return stability;
    }

    protected Country setStability(Integer stability) {
        this.stability = stability;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Boolean getIsBattleground() {
        return isBattleground;
    }

    protected Country setIsBattleground(Boolean isBattleground) {
        this.isBattleground = isBattleground;
        return this;
    }

    protected Country setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Country() {
        influence = new HashMap<Side, Integer>();
        influence.put(board.getUsa(), 0);
        influence.put(board.getUssr(), 0);
        stability = null;
    }

    public Boolean isCountry() {
        return true;
    }

    public Boolean isSuperpower() {
        return false;
    }

    public Boolean hasInfluence(Side side) {
        return getInfluence(side) > 0;
    }

    public Country playerPlacesInfluence(Side side, Integer additionalInfluence) throws TwilightException {
        for (AbstractCountry neighbor : getNeighbors()) {
            if (neighbor.hasInfluence(side)) {
                influence.put(side, influence.get(side) + additionalInfluence);
                return this;
            }
        }

        throw new TwilightException("Cannot place influence as neighboring countries don't have any influence.");
    }

    public Boolean isCoupable() {
        return this.region.isCoupable();             
    }

}

