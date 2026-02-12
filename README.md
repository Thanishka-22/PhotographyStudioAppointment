📌 Project Description  

This is a Java-based Photography Studio Booking System developed using JDBC and Oracle Database.  
The application helps manage customers and studio bookings by allowing users to book, reschedule, and cancel photography sessions.  
It follows a layered architecture using Bean, DAO, Service, and Utility layers with proper validation and exception handling.  


✨ Features  

 Add and manage customer details  
 Book photography studio slots  
 Prevent overlapping time slots on the same date  
 Reschedule existing bookings  
 Cancel bookings with status update  
 Input validation for date and time  
 Oracle database integration using JDBC  
 Console-based application  


🛠️ Technologies Used  
Java (JDK 8+)  
JDBC  
Oracle Database (XE)  
Eclipse IDE  

🗃️ Database Tables  
📸 CUSTOMER_TBL  

| Column Name       | Data Type | Description    |  
| ----------------- | --------- | -------------- |  
| CUSTOMER_ID       | VARCHAR2  | Primary Key    |  
| FULL_NAME         | VARCHAR2  | Customer Name  |  
| EMAIL             | VARCHAR2  | Email Address  |  
| MOBILE            | VARCHAR2  | Contact Number |  
| PREFERRED_PACKAGE | VARCHAR2  | Package Type   |  

📷 BOOKING_TBL  

| Column Name  | Data Type | Description                      |  
| ------------ | --------- | -------------------------------- |  
| BOOKING_ID   | NUMBER    | Primary Key                      |  
| CUSTOMER_ID  | VARCHAR2  | Foreign Key                      |  
| SHOOT_DATE   | DATE      | Date of Photoshoot               |  
| START_TIME   | VARCHAR2  | Session Start Time               |  
| END_TIME     | VARCHAR2  | Session End Time                 |  
| PACKAGE_TYPE | VARCHAR2  | Photography Package              |  
| STATUS       | VARCHAR2  | BOOKED / RESCHEDULED / CANCELLED |  

![Screenshot 1](https://github.com/user-attachments/assets/23a68e26-e38e-4eba-97a2-30c14a16b9b0)
![Screenshot 2](https://github.com/user-attachments/assets/abb1cb57-ab68-4fb0-b2f7-6a834d289a5c)
![Screenshot 3](https://github.com/user-attachments/assets/798eb4c4-863e-46e5-bd9d-2bcac1eee6b7)





