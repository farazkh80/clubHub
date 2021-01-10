# ClubHub
ClubHub is an admin/client based project developed in JAVA, with the use of JDK libraries and MySql database configuration with an OOP design.

With the motivation of developing a club/extracurricular portal for schools to list out and manage the clubs available in their  school and give the chance to students to explore the different clubs and join them if interested.


## Configuration

Please note that this application wouldn’t work unless you install the MySql database on your computer, add JDK java library and configure it properly and finally adjust the databaseCon class correspondingly.

Please find a reference video in the following link about how to download the Mysql database and add JDK library to configure your connection: 


Video for installing Mysql database: https://youtu.be/BOUMR85B-V0


Video for adding JDK library: https://youtu.be/9rTJa4l8YQ0

After installing the required JDK library abd MySQL Database shell on your machine, simply run <b>ClubHub.java</b>.


## Video of Program Working

You can also simply watch the following video to see how the program works completely.


Video of the program: https://youtu.be/vbvoH8yJ_Bc

## Usage


-On the admin side, an admin can change password, add an admin, see the list of admins and delete an admin by going through the required verification steps. An admin also has the authority to manage the clubs by adding new clubs, editing their information, adding/deleting posts to the clubs’ newsletter, and see the list of club members, adding members and deleting them.


-On the client side, students can see the full list of available clubs in their school, they can check out the club newsletters and posts as well as joining a club if they want to do so.

## Design


1- Main Classes:


* clubHub class is the main class as it is only meant to ask the user if they are the admin or a student.


* StudentEngine class handles the GET and POST requests to view, add, update, or delete students to clubs.


* adminEngine class handles the GET and POST requests to view, add, update, or delete admins as well as clubs.



2- Sub Classes:

* Club class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting clubs.

  
* Admin class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting admins.

* Student class is consisted of functions which call upon the dataBaseCon class in order to handle operations related to viewing, adding, updating and deleting students.

* DataBaseCon class consisted of functions which directly process the  operations related to viewing, adding, updating and deleting in the MYSQL database.


## License

[MIT](https://choosealicense.com/licenses/mit/)





