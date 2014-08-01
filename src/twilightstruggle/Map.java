package twilightstruggle;

import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Map {

    private final String csvFolderPath = "./";
    private final String regionListFilePath = csvFolderPath + "RegionList.csv";
    private final String countryListFilePath = csvFolderPath + "CountryList.csv";

    private HashMap<String,Country> countryMap = new HashMap<String, Country>();
    private HashMap<String,Region> regionMap = new HashMap<String, Region>();

    private Region parseRegion(String regionLine) {
        String[] lineParts = regionLine.split(",");
        String name = lineParts[0];
        Integer presence = Integer.parseInt(lineParts[1]);
        Integer domination = Integer.parseInt(lineParts[2]);
        Integer control = Integer.parseInt(lineParts[3]);
        Integer uncoupableDefconLevel = Integer.parseInt(lineParts[4]);

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
        Region region = regionMap.get(lineParts[1]);
        Integer stab = Integer.parseInt(lineParts[2]);
        Boolean isBattleground = "b".equals(lineParts[3]);

        return new Country()
                .setName(name)
                .setRegion(region)
                .setStability(stab)
                .setIsBattleground(isBattleground);
    }

    private Country enterCountryIntoMap(Country country) {
        countryMap.put(country.getName().toLowerCase(), country);
        return country;
    }

    private Region enterRegionIntoMap(Region region) {
        regionMap.put(region.getName().toLowerCase(), region);
        return region;
    }

    private void buildRegionMap() throws Exception {
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
    }

    private void buildMap() throws Exception {
        buildRegionMap();
        buildCountryHashMap();
    }
}


