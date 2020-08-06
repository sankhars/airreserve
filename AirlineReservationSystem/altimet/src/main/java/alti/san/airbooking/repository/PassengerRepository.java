package alti.san.airbooking.repository;

import alti.san.airbooking.model.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


/**
 * The interface Passenger repository.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface PassengerRepository extends CrudRepository<Passenger, String> {

    @Query(value = "SELECT DISTINCT * FROM airline.passenger p, airline.reservation r WHERE p.id = r.id AND r.order_no = :orderNumber",
            nativeQuery = true)
    Passenger getPassengerByOrderNo(@Param("orderNumber") String orderNumber);

}
