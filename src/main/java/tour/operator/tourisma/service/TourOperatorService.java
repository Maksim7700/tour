package tour.operator.tourisma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.operator.tourisma.model.tour.TourOperator;
import tour.operator.tourisma.repository.TourOperatorRepository;

import java.util.List;

@Service
public class TourOperatorService {
    
    @Autowired
    private TourOperatorRepository tourOperatorRepository;
    
    public List<TourOperator> findAll() {
        
        return tourOperatorRepository.findAll();
    }
    
    public TourOperator findTourOperatorByCompanyName(String companyName) {
        
        return tourOperatorRepository.findTourOperatorByCompanyName(companyName);
    }
    
    public void deleteTourOperator(TourOperator tourOperator){
        
        tourOperatorRepository.delete(tourOperator);
    }
    
    public void updateTourOperator(String companyName, TourOperator tourOperator) {
        
        TourOperator operator = findTourOperatorByCompanyName(companyName);
        operator.setTours(tourOperator.getTours());
        operator.setCompanyName(tourOperator.getCompanyName());
        tourOperatorRepository.save(operator);
    }
    
    public void save(TourOperator tourOperator) {
        
        tourOperatorRepository.save(tourOperator);
    }
    
    
}
