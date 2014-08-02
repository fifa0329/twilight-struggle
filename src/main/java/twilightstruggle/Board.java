package twilightstruggle;

import twilightstruggle.exception.TwilightException;

public class Board {
    private static Side ussr;
    private static Side usa;
    private static Side turn;
    private static Integer defcon;
    private static Integer turnTrack;
    private static Integer actionRoundTrack;
    private static Integer vpTrack;
    private static Map map;

    public Board() throws Exception {
        defcon = Constants.DEFCON_PEACE;
        turnTrack = 1;
        actionRoundTrack = Constants.HEADLINE_PHASE;
        vpTrack = 0;
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

    public Map getMap() {
        return map;
    }

    public Board giveVP(Side side, Integer vps) throws TwilightException {
        if (Constants.usaName.equals(side.getName())) {
            vpTrack += vps;
        } else if (Constants.ussrName.equals(side.getName())) {
            vpTrack -= vps;
        } else {
            throw new TwilightException("Side is neither USA or USSR.");
        }

        return this;
    }

    public Integer unmetRequiredMilitaryOperations(Side side) {
        Integer difference = getDefcon() - side.getMilitaryOperations();
        return Math.max(difference, 0);
    }

    public Board newTurn() throws TwilightException {
        giveVP(usa, unmetRequiredMilitaryOperations(ussr));
        giveVP(ussr, unmetRequiredMilitaryOperations(usa));

        return this;
    }
}
