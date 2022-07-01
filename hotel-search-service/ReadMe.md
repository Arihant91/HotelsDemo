GET request:
- location (String)
- checkInDate (String)
- checkOutDate (String)


Response:
- List of hotel cards details

HotelCardDetails
- hotelName (String)
- location - city (String) - Optional
- Amenities (List of String) - eg. Pool, Hot tub
- Description (String)
- Rating
- Price details
    - nightly
    - total (nightly + taxes and fees)
- imageUrl

ContentService:
GET request:
- location
- checkInDate
- checkOutDate

repsonse:
- List of hotels

PriceDisplayService:
GET request:
- hotelId
- checkInDate (optional)
- checkOutDate (optional)

Response:
formatted prices
nightly
total (nightly + taxes and fees)

