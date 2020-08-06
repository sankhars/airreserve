package alti.san.airbooking.repository;


import alti.san.airbooking.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The interface Reservation repository.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface ReservationRepository extends CrudRepository<Reservation, String> {

    /**
     * Search for reservations list.
     *
     * @param passengerId  the passenger id
     * @param price    the dest from
     * @param dest_to      the dest to
     * @param flightNumber the flight number
     * @return the list
     */
    List<Reservation> searchForReservations(@Param("flightNumber") String flightNumber, @Param("price") String price,
                                            @Param("airlinename") String airlinename,@Param("departuretime") String departuretime,
                                            @Param("arrivaltime") String arrivaltime,@Param("duration") String duration,
                                            @Param("no_stops") String no_stops,@Param("totalresults") String totalresults);


}

