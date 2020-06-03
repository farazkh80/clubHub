package clubhub;

public class club {

    private static int clubId;
    private static String clubName;
    private static int clubSize;
    private static String clubManager;
    private static String clubLocation;
    dataBaseCon club = new dataBaseCon();

    public void addClub(String name, int size, String manager, String location) {

        clubName = name;
        clubSize = size;
        clubManager = manager;
        clubLocation = location;

        club.insertData(clubName, clubSize, clubManager, clubLocation);

    }

    public void getClubData() {

        club.getData();
    }

    public String changeName(int currentId, String newName) {

        clubName = newName;
        club.updateDataName(currentId, newName);
        return clubName;

    }

    public int changeSize(int currentId, int newSize) {

        clubSize = newSize;
        club.updateDataSize(currentId, newSize);
        return clubSize;

    }

    public String changeManager(int currentId, String newManager) {

        clubManager = newManager;
        club.updateDataManager(currentId, newManager);
        return clubManager;

    }

    public String changeLocation(int currentId, String newLocation) {

        clubLocation = newLocation;
        club.updateDataLocation(currentId, newLocation);
        return clubLocation;

    }

    public int addMember(int numberOfNewMembers) {

        clubSize += numberOfNewMembers;
        return clubSize;
    }

}
