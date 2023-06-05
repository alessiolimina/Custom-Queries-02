package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository <Flight, Long>, JpaSpecificationExecutor<Flight> {

    @Query("SELECT flight FROM Flight flight WHERE flight.status IN (:p1, :p2)")
    List<Flight> getCustomFlight(String p1, String p2);

    Page<Flight> findAllByStatus(FlightStatus status, PageRequest of);

}
