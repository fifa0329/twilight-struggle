package twilightstruggle;

import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;

public class Map {
    private final String resourcePath = "src/main/resources/";
    private final String regionListFilePath = resourcePath + "RegionList.csv";
    private final String countryListFilePath = resourcePath + "CountryList.csv";
    private final String adjacencyListFilePath = resourcePath + "AdjacencyList.csv";

    private HashMap<String,AbstractCountry> countryMap = new HashMap<String, AbstractCountry>();
    private HashMap<String,Region> regionMap = new HashMap<String, Region>();

    public Collection<AbstractCountry> getCountries() {
        return countryMap.values();
    }

    public Collection<Region> getRegions() {
        return regionMap.values();
    }

    private Region parseRegion(String regionLine) {
        String[] lineParts = regionLine.split(",");
        String name = lineParts[0];

        Integer presence;
        Integer domination;
        Integer control;
        Integer uncoupableDefconLevel;

        if ("-".equals(lineParts[1])) {
            presence = 0;
            domination = 0;
            control = 0;
        } else {
            presence = Integer.parseInt(lineParts[1]);
            domination = Integer.parseInt(lineParts[2]);
            control = Integer.parseInt(lineParts[3]);
        }

        uncoupableDefconLevel = Integer.parseInt(lineParts[4]);

        return new Region()
                .setName(name)
                .setPresence(presence)
                .setDomination(domination)
                .setControl(control)
                .setUncoupableDefconLevel(uncoupableDefconLevel);
    }

    private Country parseCountry(String countryLine) {
        String[] lineParts = countryLine.split(",");
        String name = lineParts[0];
        Region region = regionMap.get(lineParts[1].toLowerCase());
        Integer stab = Integer.parseInt(lineParts[2]);
        Boolean isBattleground = "b".equals(lineParts[3]);

        return new Country()
                .setName(name)
                .setRegion(region)
                .setStability(stab)
                .setIsBattleground(isBattleground);
    }

    private Pair<AbstractCountry,AbstractCountry> parseAdjacency(String adjacencyLine) throws Exception {
        String[] lineParts = adjacencyLine.split(",");

        if (lineParts.length != 2) {
            throw new Exception("Adjacency List is not formatted correctly.");
        }

        AbstractCountry countryA = countryMap.get(lineParts[0].toLowerCase());
        AbstractCountry countryB = countryMap.get(lineParts[1].toLowerCase());
        return new Pair<AbstractCountry, AbstractCountry>(countryA, countryB);
    }

    private Country addCountryToRespectiveRegion(Country country) {
        Region myRegion = regionMap.get(country.getRegion().getName().toLowerCase());
        myRegion.addCountry(country);

        if ("SoutheastAsia".equals(myRegion.getName())) {
            regionMap.get("asia").addCountry(country);
        } else if ("WesternEurope".equals(myRegion.getName())) {
            regionMap.get("europe").addCountry(country);
        } else if ("EasternEurope".equals(myRegion.getName())) {
            regionMap.get("europe").addCountry(country);
        }

        return country;
    }

    private AbstractCountry enterCountryIntoMap(AbstractCountry abstractCountry) {
        countryMap.put(abstractCountry.getName().toLowerCase(), abstractCountry);

        if (abstractCountry.isCountry()) {
            addCountryToRespectiveRegion((Country) abstractCountry);
        }

        return abstractCountry;
    }

    private Region enterRegionIntoMap(Region region) {
        regionMap.put(region.getName().toLowerCase(), region);
        return region;
    }

    private void makeNeighbors(Pair<AbstractCountry,AbstractCountry> countryPair) throws Exception {
        countryPair.fst.addNeighbor(countryPair.snd);
        countryPair.snd.addNeighbor(countryPair.fst);
    }

    private void buildRegionHashMap() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(regionListFilePath));

        String line;
        while ((line = br.readLine()) != null) {
            enterRegionIntoMap(parseRegion(line));
        }
        br.close();
    }

    private void buildCountryHashMap() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(countryListFilePath));

        String line;
        while ((line = br.readLine()) != null) {
            enterCountryIntoMap(parseCountry(line));
        }
        br.close();

        Superpower USA = new Superpower().setName("US");
        Superpower USSR = new Superpower().setName("USSR");

        enterCountryIntoMap(USA);
        enterCountryIntoMap(USSR);
    }

    private void buildAdjacencies() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(adjacencyListFilePath));

        String line;
        while ((line = br.readLine()) != null) {
            makeNeighbors(parseAdjacency(line));
        }
        br.close();
    }

    private void buildMap() throws Exception {
        buildRegionHashMap();
        buildCountryHashMap();
        buildAdjacencies();
    }

    public Map() throws Exception {
        buildMap();
    }
}


