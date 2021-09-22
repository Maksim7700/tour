package tour.operator.tourisma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.operator.tourisma.model.tour.Tour;
import tour.operator.tourisma.model.tour.TourType;
import tour.operator.tourisma.repository.TourTypeRepository;

import java.util.List;

@Service
public class TourTypeService {
    
    @Autowired
    private TourTypeRepository tourTypeRepository;
    
    public List<TourType> findAll() {
        
        return tourTypeRepository.findAll();
    }
    
    public TourType findTourByName(String name) {
        
        return tourTypeRepository.findTourTypeByName(name);
    }
    
    public void save(TourType tourType){
        
        tourTypeRepository.save(tourType);
    }
    
    public void updateTourType(String name, TourType tourType) {
        
        TourType t = findTourByName(name);
        t.setName(tourType.getName());
        t.setTours(tourType.getTours());
        tourTypeRepository.save(t);
    }
    
    public void deleteTourType(TourType tourType) {
        
        tourTypeRepository.delete(tourType);
    }
}
