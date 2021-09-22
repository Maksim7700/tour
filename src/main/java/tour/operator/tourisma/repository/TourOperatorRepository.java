package tour.operator.tourisma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.operator.tourisma.model.tour.TourOperator;

@Repository
public interface TourOperatorRepository extends JpaRepository<TourOperator, Integer> {
    TourOperator findTourOperatorByCompanyName(String companyName);
}
