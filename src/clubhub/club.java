package clubhub;

public class club {
    
    //decalres the variables for club class
    private static int clubId;
    private static String clubName;
    private static int clubSize;
    private static String clubManager;
    private static String clubLocation;
    private static String clubPost;
    private static String postDate;

    dataBaseCon db = new dataBaseCon();
    
    //method to add a club 
    public void addClub(String name, int size, String manager, String location) {

        clubName = name;
        clubSize = size;
        clubManager = manager;
        clubLocation = location;
        
        //calls the db object to insert a new club
        db.insertData(clubName, clubSize, clubManager, clubLocation);

    }
    
    //method to get the list of all the current clubs
    public void getClubData() {
         System.out.println("Here is the list of current clubs:\n");
        //calls the db object to get the club list
        db.getData();
    }
    
    //method to change the name of a club
    public String changeName(int currentId, String newName) {

        clubName = newName;
        //calls the db object to update the club name
        db.updateDataName(currentId, newName);
        return clubName;

    }
    
    //method to change the size of the club
    public int changeSize(int currentId, int newSize) {

        clubSize = newSize;
        //calls the db object to change the size of a club
        db.updateDataSize(currentId, newSize);
        return clubSize;

    }
    
    //method to change the name of the manager of a club
    public String changeManager(int currentId, String newManager) {

        clubManager = newManager;
        //calls the db object to change the name of manager
        db.updateDataManager(currentId, newManager);
        return clubManager;

    }
    //method to change the name of the location of a club
    public String changeLocation(int currentId, String newLocation) {

        clubLocation = newLocation;
        //calls the db object to change the location 
        db.updateDataLocation(currentId, newLocation);
        return clubLocation;

    }
    
    //method to delete a club
    public void deleteClub(int id) {

        clubId = id;
        //calls db to delete table for each club
        db.deleteClub(id);

    }
    
    //method to create a seperate table for each club in order to keep the records of their members
    public void createClubTable(String name) {

        clubName = name;
        //calls db to create a member table for each club
        db.createTable(clubName);

    }
    //method to create a seperate table for each club in order to keep the records of their posts
    public void createClubTableForPosts(String name) {

        clubName = name;
        //calls db to create a post table for each club
        db.createTableForPosts(clubName);

    }
    
    //method to delete the club table both member and post tables
    public void deleteClubTable(String name) {

        clubName = name;
        //calls db to delete tables for each club 
        db.deleteTable(clubName);

    }
    
    //method to increae the size of a club when a member gets added
    public void memberAdded(int id) {

        clubId = id;
        //cals db object to update and increase the size of a club
        db.memberIncreased(clubId);

    }
    
    //method to get the list of members for a specific club
    public void memberList(String cName) {
        System.out.println("Here is the list of members:\n\n");
        clubName = cName;
        //cals db object to add a new member
        db.getMemberList(clubName);
    }
    
    //method to add a post to a club's post table
    public void addPost(String cName, String cPost, String pDate){
        
        clubName = cName;
        clubPost = cPost;
        postDate = pDate;
        //cals db object to insert a post
        db.addNewPost(clubName, clubPost, postDate);
        
    }
    
    //method the get posts of a club
    public void getPosts(String cName){
        System.out.println("Here is the list of posts:\n\n");
        clubName = cName;
        //cals db object to get the posts in order of their dates(latest to oldest)
        db.getPostsFromDataBase(clubName);
    }

}
