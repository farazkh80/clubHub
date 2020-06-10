package clubhub;

public class club {

    private static int clubId;
    private static String clubName;
    private static int clubSize;
    private static String clubManager;
    private static String clubLocation;
    dataBaseCon db = new dataBaseCon();

    public void addClub(String name, int size, String manager, String location) {

        clubName = name;
        clubSize = size;
        clubManager = manager;
        clubLocation = location;

        db.insertData(clubName, clubSize, clubManager, clubLocation);

    }

    public void getClubData() {

        db.getData();
    }

    public String changeName(int currentId, String newName) {

        clubName = newName;
        db.updateDataName(currentId, newName);
        return clubName;

    }

    public int changeSize(int currentId, int newSize) {

        clubSize = newSize;
        db.updateDataSize(currentId, newSize);
        return clubSize;

    }

    public String changeManager(int currentId, String newManager) {

        clubManager = newManager;
        db.updateDataManager(currentId, newManager);
        return clubManager;

    }

    public String changeLocation(int currentId, String newLocation) {

        clubLocation = newLocation;
        db.updateDataLocation(currentId, newLocation);
        return clubLocation;

    }

    public void deleteClub(int id) {

        clubId = id;
        db.deleteClub(id);

    }

    public int addMember(int numberOfNewMembers) {

        clubSize += numberOfNewMembers;
        return clubSize;
    }

    public void createClubTable(String name) {

        clubName = name;

        db.createTable(clubName);

    }

    public void deleteClubTable(String name) {

        clubName = name;

        db.deleteTable(clubName);

    }

}
