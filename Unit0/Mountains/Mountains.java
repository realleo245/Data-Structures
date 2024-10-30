package Unit0.Mountains;

public class Mountains {
    private int records;
    private int cleanRecords;
    private int corruptRecords;
    private Mountain shortestMountain;
    private Mountain tallestMountain;
    public Mountains() {
        this.records = 0;
        this.cleanRecords = 0;
    }
    public boolean isValid(String line) {
        records++;
        if(isLineValid(line)) {
            cleanRecords++;
            Mountain mountain = new Mountain(line);
            if(shortestMountain == null || mountain.getElevation() < shortestMountain.getElevation()) {
                shortestMountain = mountain;
            }
            if(tallestMountain == null || mountain.getElevation() > tallestMountain.getElevation()) {
                tallestMountain = mountain;
            }
            return true;
        }
        else {
            corruptRecords++;
            return false;
        }
    }
    private boolean isLineValid(String line) {
        try {
            Mountain mountain = new Mountain(line);
            return true;
        }
        catch(RuntimeException e) {
            return false;
        }
    }
    public int getNumRecords() {
        return records;
    }
    public int getCleanRecords() {
        return cleanRecords;
    }
    public int getCorruptRecords() {
        return corruptRecords;
    } 
    public Mountain getShortestMountain() {
        return shortestMountain;
    }
    public Mountain getTallestMountain() {
        return tallestMountain;
    }
    public double getShortestMountainElevation() {
        return shortestMountain.getElevation();
    }
    public double getTallestMountainElevation() {
        return tallestMountain.getElevation();
    }
}