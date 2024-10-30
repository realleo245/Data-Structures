package Unit0.Mountains;

public class Mountain {
    private String country;
    private String type;
    private String name;
    private double latitude;
    private double longitude;
    private double elevation;
    public Mountain(String line) {
        String[] record = line.split("\t");
        if(record.length != 6) {
            throw new RuntimeException("Not 6 records: " + record.length);
        }
        this.country = record[0];
        this.type = record[1];
        this.name= record[2];
        try {
            this.latitude = Double.parseDouble(record[3]);
        }
        catch(Exception e) {
            throw new RuntimeException("Unable to parse latitude" + record[3]);
        }
        if(latitude < -90 || latitude > 90) {
            throw new RuntimeException("Latitude out of range");
        }
        try {
            this.longitude = Double.parseDouble(record[4]);
        }
        catch(Exception e) {
            throw new RuntimeException("Unable to parse longitude" + record[4]);
        }
        if(longitude < -180 || longitude > 180) {
            throw new RuntimeException("Longitude out of range");
        }
        try {
            this.elevation = Double.parseDouble(record[5]);
        }
        catch(Exception e) {
            try {
                if(record[5].charAt(record[5].length() - 1) == 'm') {
                    this.elevation = Double.parseDouble(record[5].substring(0, record[5].length() - 1).trim());
                }
                else if(record[5].endsWith("ft")) {
                    // convert ft to m
                    this.elevation = Double.parseDouble(record[5].substring(0, record[5].length() - 2).trim()) / 3.28;
                }
            } 
            catch(Exception ex) {
                throw new RuntimeException("Invalid elevation: " + record[5]);
            }
        }
    }
    public String getCountry() {
        return this.country;
    }
    public String getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public double getElevation() {
        return this.elevation;
    }
}