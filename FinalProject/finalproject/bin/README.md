# Project: BIG BANK

# State of the program
	What you see in this directory is the 90% complete backend portion of the project that contains all design patterns used
	and also the database interactions. Since we were unable to link the front end portion successfully we modified all of
	the backend code, this directory, and added 'App.java' to simulate a small control flow of how the program would work
	in conjunction with the front end. 

# Patterns Used
	1. Observer: found in NotificationCenter.java and Customer.java
			- NotificationCenter would listen to a customer and be notified if the customer overdrafted
	2. Decorator Pattern: Found in Customer.java and Subscription directories
			- we have defined some subscription services that we would use to decorate generic subscriptions with a special label giving class
	3. Singleton: Used to instantiate a data handler for all database interactions. 
			- created a single instance to handle all databsae interaction

# How to Run 
	hit the run button located in 'App.java' located between line 19 and 20. Maven must be installed!
		Since this is a small simulation, switch between interacting as a customer by setting 
	'customerID' variable to 0 or 1 on line 28 in App.java. 0  = employee account, and 1 = customer Account


# Tools
	* Maven 
	* Java 
	* Apache / Tomcat 
	* Python
	* HTML/CSS
	* Numpy/Matplotlib
	* MongoDB 



# Collaborators
Jonathan Phouminh
email: joph0114

Zachary Chommala
Bao Nguyen
