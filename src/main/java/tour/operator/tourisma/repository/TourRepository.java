package tour.operator.tourisma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.operator.tourisma.model.tour.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    Tour findTourByName(String name);
}
