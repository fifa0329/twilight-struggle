package twilightstruggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by emilguliyev on 8/1/14.
 */
public abstract class AbstractCountry {
    abstract public Boolean isCountry();
    abstract public Boolean isSuperpower();

    private List<AbstractCountry> neighbors = new ArrayList<AbstractCountry>();

    protected String name;
    public String getName() {
        return name;
    }

    public List<AbstractCountry> getNeighbors() {
        return neighbors;
    }

    abstract public Boolean hasInfluence(Side side);

    protected void addNeighbor(AbstractCountry neighbor) {
        this.neighbors.add(neighbor);
    }
}
