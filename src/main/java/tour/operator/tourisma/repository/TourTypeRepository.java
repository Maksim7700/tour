package tour.operator.tourisma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.operator.tourisma.model.tour.TourType;

@Repository
public interface TourTypeRepository extends JpaRepository<TourType, Integer> {
    TourType findTourTypeByName(String name);
}
