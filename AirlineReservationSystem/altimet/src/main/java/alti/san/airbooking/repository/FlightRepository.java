package alti.san.airbooking.repository;

import alti.san.airbooking.model.Flight;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


/**
 * The interface Flight repository.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface FlightRepository extends CrudRepository<Flight, String> {
}
