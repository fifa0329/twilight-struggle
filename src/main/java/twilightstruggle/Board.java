package twilightstruggle;

public class Board {
    private static final Integer HEADLINE_PHASE = 0;
    private static final Integer DEFCON_PEACE = 5;
    private static final Integer DEFCON_NUCLEAR_WAR = 1;

    private static Side ussr;
    private static Side usa;
    private static Side turn;
    private static Integer defcon;
    private static Integer turnTrack;
    private static Integer actionRoundTrack;
    private static Integer victoryTrack;
    private static Map map;

    public Board() throws Exception {
        defcon = DEFCON_PEACE;
        turnTrack = 1;
        actionRoundTrack = HEADLINE_PHASE;
        ussr = new Side()
                .setName("USSR");
        usa = new Side()
                .setName("US");
        map = new Map();
    }

    public Side getUssr() {
        return ussr;
    }
    public Side getUsa() {
        return usa;
    }

    public Integer getDefcon() {
        return defcon;
    }

    public void setDefcon(Integer defcon) {
        this.defcon = defcon;
    }

    public Integer getTurn() {
        return turnTrack;
    }

    public void setTurn(Integer turn) {
        this.turnTrack = turn;
    }

    public Integer getActionRound() {
        return actionRoundTrack;
    }

    public void setActionRound(Integer actionRound) {
        this.actionRoundTrack = actionRound;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
