package com.demo.availabilityservice.service

import com.demo.availabilityservice.domain.CheckInOut
import com.demo.availabilityservice.domain.HotelAvailabilityConverter
import com.demo.availabilityservice.model.HotelAvailability
import com.demo.availabilityservice.repository.HotelAvailabilityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*


@Service
class AvailabilityService {


    @Autowired
    lateinit var repository: HotelAvailabilityRepository

    @Autowired
    lateinit var hotelAvailabilityConverter: HotelAvailabilityConverter

    fun searchByAvailability(
        location: String,
        checkIn: String,
        checkOut: String
    ): MutableList<Int> {
        val listOfHotels: Iterable<HotelAvailability> = getData()
        val checkInDate = LocalDate.parse(checkIn)
        val checkOutDate = LocalDate.parse(checkOut)
        val hotelIds: MutableList<Int> = mutableListOf()
        for (hotel in listOfHotels) {
            if (hotel.location == location) {
                var freeTime: Boolean =
                    hasFreeRoom(hotel, checkInDate, checkOutDate)
                if (freeTime) {
                    hotelIds.add(hotel.id)
                }
            }
        }


        return hotelIds
    }

    fun hasFreeRoom(
        hotel: HotelAvailability,
        checkInDate: LocalDate,
        checkOutDate: LocalDate
    ): Boolean {
        var freeTime: Boolean = false
        for (checkInAndOut in hotel.checkInOutDates) {
            if (checkInAndOut.checkIn <= checkInDate && checkInAndOut.checkOut >= checkOutDate) {
                freeTime = true
            }
        }
        return freeTime
    }

    fun saveDummyData(): String {
        repository.saveAll(
            listOf(
                HotelAvailability(
                    0, "Budapest",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,6),
                            LocalDate.of(2022,6,22)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,25),
                            LocalDate.of(2022,7,10)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,22)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Budapest",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,15),
                            LocalDate.of(2022,6,25)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,27),
                            LocalDate.of(2022,7,15)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,16),
                            LocalDate.of(2022,7,23)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Belgrad",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,22),
                            LocalDate.of(2022,6,25)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,28),
                            LocalDate.of(2022,7,15)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,23)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Budapest",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,8),
                            LocalDate.of(2022,6,25)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,18),
                            LocalDate.of(2022,7,15)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,23)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Szeged",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,5),
                            LocalDate.of(2022,6,25)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,25),
                            LocalDate.of(2022,7,15)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,25)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Frankfurt",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,4),
                            LocalDate.of(2022,6,22)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,22),
                            LocalDate.of(2022,7,18)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,25)
                        )
                    )
                ),
                HotelAvailability(
                    0, "Taiwan",
                    mutableListOf(
                        CheckInOut(
                            LocalDate.of(2022,6,4),
                            LocalDate.of(2022,6,22)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,6,22),
                            LocalDate.of(2022,7,18)
                        ),
                        CheckInOut(
                            LocalDate.of(2022,7,11),
                            LocalDate.of(2022,7,25)
                        )
                    )
                )
            )
        )
        return "Done"
    }

    fun getData(): Iterable<HotelAvailability> {
        return repository.findAll()
    }
}