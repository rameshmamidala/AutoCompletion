# AutoCompletion
A sample project for getting the city suggestions for below problem statement

# Requirement
Many situations in web applications arise when a user is prompted to fill in some text in a form where the text is expected to be one of a fixed number of strings. This could be people names, profession names, cities, countries, etc. A common interface in this kind of "choose from a large but fixed set" scenario is to let the user type a few characters and provide completion suggestions. You are to design and implement a backend API that provides such auto completion suggestions for cities in India.

1.     You're free to pick a list of cities from the web. For example  - https://data.gov.in/resources/all-india-pincode-directory/download

2.     The api end point is expected to be like "/suggest_cities?start=che&atmost=5". The "start" parameter gives the characters that the city starts with and the "atmost" parameter gives the maximum number of suggestions needed.

3.     The response is to be returned as a plain text (mime "text/plain") with each line containing one suggestion.

# Technologies Used
I implemented the project as Spring Boot application. Which is having the REST API for below services.

# End Points
For text/plain response
http://localhost:8080/AutoCompletion/suggest_cities?start=s&atmost=2

For application/json response
http://localhost:8080/AutoCompletion/suggest_cities_json?start=s&atmost=2 

# Local Setup
1.     Check out the code base from https://github.com/rameshmamidala/AutoCompletion.git 
2.     Import the project as Maven in Eclipse IDE
3.     Build the project with clean install maven goals
4.     Run the Project as Java Application (choose com.ramesh.core.Application as main class) 
5.     Use any REST client to test the above mentioned URL end points

