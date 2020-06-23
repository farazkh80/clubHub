--READ ME--


ClubHub is an admin/client based project developed in JAVA, with the use of JDK libraries and MySql database configuration with the motivation of developing a club/extracurricular portal for schools to list out and manage the clubs available in their  school and give the chance to students to explore the different clubs and join them if interested.


ClubHub's front end is designed for both an admin and a student who would be the potential clients of this project.


What are its functionalities?


-On the admin side, an admin can change password, add an admin, see the list of admins and delete an admin by going through the required verification steps. An admin also has the authority to manage the clubs by adding new clubs, editing their information, adding/deleting posts to the clubs’ newsletter, and see the list of club members, adding members and deleting them.


-On the client side, students can see the full list of available clubs in their school, they can check out the club newsletters and posts as well as joining a club if they want to do so.


What design is used in the program development?


The main design is based on object-oriented programming, each class having the following functionalities:


* clubHub class is the main class as it is only meant to ask the user if they are the admin or a student.


* adminEngine class handles the admin operations and calls upon other objects (classes) in different scenarios.


   * adminEngine calls upon the club class in case of any operations related to club information.
      * club class calls upon the dataBaseCon class to implement the adjustments initiated by adminEngine in the clubs database.
   * adminEngine calls upon the admin class in case of any operations related to the admin information.
      * admin  class calls upon the dataBaseCon class to implement the adjustments initiated by adminEngine in the admins database.








* studentEngine class handles the student operations and calls upon other objects (classes) in different scenarios.


   * studentEngine calls upon the club class in case of the student requesting to see the full list of available clubs or posts.
      * club class calls upon the dataBaseCon class to select and display the club information from the database.
   * studentEngine calls upon the student class in case of a student joining a club.
      * student class calls upon the dataBaseCon class to add the student as a member to the clubs’ database..




NOTE:


Please note that this application wouldn’t work unless you install the MySql database on your computer, add JDK java library and configure it properly and finally adjust the databaseCon class correspondingly.


Please find a reference video in the following link about how to download the Mysql database and add JDK library to configure your connection: 


Video for installing Mysql database: https://youtu.be/BOUMR85B-V0


Video for adding JDK library: https://youtu.be/9rTJa4l8YQ0 


You can also simply watch the following video to see how the program works completely.


Video of the program: https://youtu.be/vbvoH8yJ_Bc
