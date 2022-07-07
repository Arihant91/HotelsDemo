run mvn install in HotelsDemoApp.

Docker has to be installed for the next part. in the directory named
docker, execute this command:" docker compose up"

Start the microservices(sequence doesn't matter): HotelApplication,
ContentServiceApplication, AvailabilityApplication,
PriceDisplayServiceApplication

Send a request GET request to "http://localhost:8081/getList" address, with the following Query Params
location: "Budapest"
checkInDate: "2022-06-10"
checkOutDate: "2022-06-20"





