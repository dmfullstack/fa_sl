# Foodie_App

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.5.0.

## Development server

Run `npm serve` for a dev server. Navigate to `http://localhost:3000/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running lint

Run `npm run lint` to check linting errors.(https://eslint.org/).

## Running unit tests

Run `npm run test` to execute both Mocha and angular test cases [Mocha] & [Karma] (https://mochajs.org/) & (https://karma-runner.github.io) 

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Command used to generate this project
Project is originally generated usign Angular CLI, and was added the express part manually

## The Zomato API to be used as data source
- To get zomato location id use the following end point of location API provided by Zomato, user needs to provide API key in headers. [https://developers.zomato.com/api/v2.1/locations?query='city name']
- To get list of restaurant use the following rest-endpoint [https://developers.zomato.com/api/v2.1/search?entity_id=3&entity_type=city&q=mumbai&sort=rating].
- The location input can be specified using Zomato location ID or coordinates. Cuisine / Establishment / Collection IDs can be obtained from respective api calls. 
- Get up to 100 restaurants by changing the 'start' and 'count' parameters with the maximum value of count being 20. Partner Access is required to access photos and reviews.
Examples:
To search for 'Italian' restaurants in 'Manhattan, New York City', set cuisines = 55, entity_id = 94741 and entity_type = zone
To search for 'cafes' in 'Manhattan, New York City', set establishment_type = 1, entity_type = zone and entity_id = 94741
Get list of all restaurants in 'Trending this Week' collection in 'New York City' by using entity_id = 280, entity_type = city and collection_id = 1
- To get restaurant reviews using the Zomato restaurant ID  Only 5 latest reviews are available under the Basic API plan.. [https://developers.zomato.com/api/v2.1/reviews?res_id='resturant id'].
- Get a list of all cuisines of restaurants listed in a city. The location/city input can be provided in the following ways -
  Using Zomato City ID
  Using coordinates of any location within a city
  List of all restaurants serving a particular cuisine can be obtained using '/search' API with cuisine ID and location details. [https://developers.zomato.com/api/v2.1/cuisines?city_id='cityid'&lat='lattitude'&lon='longitude']

P.S :- You need to generate the API_KEY for the above endpoints and replace 
`<<api_key>>` with it.

## To register for an API key, follow these steps:

You need to visit to [zomato] (https://developers.zomato.com/api) and login with either google account or facebook acoount.

- After login,click on "Generate API key" and follow the instaruction to fill necessary details.
-Once necessary details are filled, a prompt will appear on the screen which will have API key. Kindly make sure you save it for your future use as well.
-One can make 1000 calls per day using API key.


Read ME Updated With Instructions
**********************************


FOR UI We have Angular

To start the angular application we need to run ng serve from the terminal .The application will get started in localhost:4200


FOR SERVICE WE HAVE SPRING BOOT APPLICTAION

For getting the details related to the restaurant we are using a third party API(Zomato) .The establish a connection between UI and thirdparty we are using the spring boot application.
We have used the inbuilt server to run the application and this will get loaded in localhost:8889
MYSQL Database :foodieApp
MYSQL_USER : root
MYSQL_PASSWORD : root

TO RUN THE UNIT TEST CASE

npm run test

TO RUN THE E2E TEST CASE

npm run e2e



To Create the Foodie App as part of the SBA, Created the below 3 different components

HOME


This will be the default page loaded when we start the application.This page will display the restaurants in the near by city(I have defaulted the near by city to Kochin) 
by consuming a service.
Restaurant Details will be displayed in a card format.Along with the other setails such as Resturant Name,Cost Of two etc will have button 'Add Favourite'
On Click of 'Add Favourite' the Restuarant Id and Name will be saved to the database and the button will be changed to 'Remove Favourite'
On Click of 'Remove Favourite' the selected Restuarant will be removed from favourite list and button will be changed to 'Add Favourite'


SEARCH

On Load of this plage two input field will be displayed One for City and other for Cuisine.User can search for restaurants based on these.
If the both the values are entered will fetch the restaurants form the city having this cuisine.
Here also Restaurant Details will be displayed in a card format.Along with the other setails such as Resturant Name,Cost Of two etc will have button 'Add Favourite'
On Click of 'Add Favourite' the Restuarant Id and Name will be saved to the database and the button will be changed to 'Remove Favourite'
On Click of 'Remove Favourite' the selected Restuarant will be removed from favourite list and button will be changed to 'Add Favourite'

FAVOURITE

In this page we will display all the restaurant added to the Favourite list search/home page.
Along with the resturant details we have 'Remove Favourite' button which will be used to remove the restuarant from the favourite list.

DETAIL

This page will be displayed on click of the Restaurant card ina any of the previous page
Here In this page we will display the details regarding the selected restuarant.Here we will display the user reviews and comments added.
This page we have text area where user can update the comments related to the restuarant and comments entered will be saved in the database.

*************************************************************UPDATED WITH DOCKERIZING THE APPLICATION ***************************************************************************
The FoodiApp Application has been Dockerized and Please use the below steps to run the application

mvn clean install - To package the api jar

docker-compose build - To both API Service(Spring Boot App) and Front End(Angular)

docker-compose up - To run the application

If any MySQL Instance is started in port 3306, we need to stop this as Docker compose will start an instance on its own.

Use the command sudo service mysql stop to stop the MySQL Instance Running.

In the browser type htpp://localhost:4200 and We will be able to navigate to the application





