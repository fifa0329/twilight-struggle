package twilightstruggle;

/**
 * Created by emilguliyev on 8/1/14.
 */
public class Superpower extends AbstractCountry {
    public Boolean isCountry() {
        return false;
    }
    public Boolean isSuperpower() {
        return true;
    }

    public Superpower setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean hasUsInfluence() {
        return Constants.usaName.equals(getName());
    }

    public Boolean hasUssrInfluence() {
        return Constants.ussrName.equals(getName());
    }
}
