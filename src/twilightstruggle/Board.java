package twilightstruggle;

public class Board {
    private Side ussr;
    private Side usa;
    private Integer defcon;
    private Integer turn;
    private Integer actionRound;
    private Map map;

    public Side getUssr() {
        return ussr;
    }

    public void setUssr(Side ussr) {
        this.ussr = ussr;
    }

    public Side getUsa() {
        return usa;
    }

    public void setUsa(Side usa) {
        this.usa = usa;
    }

    public Integer getDefcon() {
        return defcon;
    }

    public void setDefcon(Integer defcon) {
        this.defcon = defcon;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Integer getActionRound() {
        return actionRound;
    }

    public void setActionRound(Integer actionRound) {
        this.actionRound = actionRound;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
