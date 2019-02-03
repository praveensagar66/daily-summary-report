=============
Requirements:
==============

The Business user would like to see the Total Transaction Amount of each unique product they have done for the day
The Business user would like a program that can read in the Input file and generate a daily summary report
The Daily summary report should be in CSV format (called Output.csv) with the following specifications

The CSV has the following Headers
- Client_Information
- Product_Information
- Total_Transaction_Amount

Client_Information should be a combination of the CLIENT TYPE, CLIENT NUMBER, ACCOUNT NUMBER, SUBACCOUNT NUMBER fields from Input file
Product_Information should be a combination of the EXCHANGE CODE, PRODUCT GROUP CODE, SYMBOL, EXPIRATION DATE
Total_Transaction_Amount should be a Net Total of the (QUANTITY LONG - QUANTITY SHORT) values for each client per product

Notes: Each Record in the input file represents ONE Transaction from the client for a particular product. Please focus on code re-usability. 

=========
Classes:
=========
Main class - DailySummaryReport.java

============
Assumptions:
============
1. The combination of CLIENT TYPE, CLIENT NUMBER, ACCOUNT NUMBER, SUBACCOUNT NUMBER fields is taken as a unique client.
2. The combination of EXCHANGE CODE, PRODUCT GROUP CODE, SYMBOL, EXPIRATION DATE fields is taken as a unique product.
3. Total_Transaction_Amount is assumed to get negative as we are doing the net total of (QUANTITY LONG - QUANTITY SHORT) values.

==========
Solution : 
==========
1. Read the Input file using the readers.

2. Get the fields from fixed width file by using the file specifications and store them in seperate variables.
		
3. Place the final required fields in a list to process them.
	
4. Iterate through the list as per the business requirement to calculate the total transaction amount per client per product.

5. Verify if the client is already present in a Map. If not present insert the new client and product data into the map.

6. If the client is already present, verify if the product is already present in the inner map.

7. If the product is already present, get the current transaction amount and add it to the new transaction amount. 

8. Update the product with updated transaction amount.

9. If the product is not present, add the incoming data to product information.

10. Iterate the final map and write the output data to a csv file using opencsv.
