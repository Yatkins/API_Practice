This project will be building a Springboot webserver like we’ve done all class. Please use all the best practices we’ve learned over the course of the semester. Server should be running on port 8381.

Create the following endpoints: Please write a full suite of unit tests on ONE endpoint (controller only).

1. POST /api/v1/start

    Body:
   {
    “name”: “string”,
    “Age”: integer
    }
   
    Response:
    
    If name is empty, return a 401 with an error message. 
    
    Otherwise return a 200 and a JSON object with message indicating the user is over bar mitzvah age or not.
  
  2. GET /api/v1/time

     Response:A JSON object with the current timestamp
  
   3.POST /api/v1/{operation}?v1={x}
  
   Body: 
	 {
	 	values: [
	 		decimal, 
	 		decimal 
	 	]
	 }
  
  Operation is a String, x and array values are decimals.
  
There should be a feature flag on this endpoint set in application.yml. 

If the feature flag is off, 
	the endpoint should return a system unavailable error with a message “no math allowed here”.
   
If the feature flag is on:
	Operation can be one of (add, multiply, divide, subtract). 
	The return value should be an array, 
	with the value x applied to each element of the array according to the operation. 
	For example, if the operation is add, x=1, and the array is [4,7,9]. The response should be [5,8,10]
