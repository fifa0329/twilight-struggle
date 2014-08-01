package twilightstruggle;

import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Map {

    private HashMap<String,Country> countryMap = new HashMap<String, Country>();
    private HashMap<String,Region> regionMap = new HashMap<String, Region>();

    private void enterCountry(String countryName, Integer stability) {
        countryMap.put(countryName.toLowerCase(), new Country(countryName, stability));
    }

    private void buildRegionMap() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("CountryList.csv"));

        String line;

        while ((line = br.readLine()) != null) {
            regionMap.put(line, new Region());
        }

    }

    private void buildCountryHashMap() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("CountryList.csv"));

        String line;

        while ((line = br.readLine()) != null) {
            String[] lineParts = line.split(",");
            String name = lineParts[0];
            String region = lineParts[1];
            Integer stab = Integer.parseInt(lineParts[2]);
            boolean battleground = lineParts[3] == "b";
        }
    }

    private Region buildEurope() {
        return null;
    }

    private Region buildEasternEurope() {
        return null;
    }

    private Region buildWesternEurope() {
        return null;
    }

    private Region buildAsia() {
        return null;
    }

    private Region buildSoutheastAsia() {
        return null;
    }

    private Region buildMiddleEast() {
        return null;
    }

    private Region buildAfrica() {
        return null;
    }

    private Region buildCentralAmerica() {
        return null;
    }

    private Region buildSouthAmerica() {
        return null;
    }

    public Map buildMap() {
        return null;
    }
}


