package tour.operator.tourisma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.operator.tourisma.model.tour.Tour;
import tour.operator.tourisma.repository.TourRepository;

import java.util.List;

@Service
public class TourService {
    
    @Autowired
    private TourRepository tourRepository;
    
    public List<Tour> findAllTours() {
        
        return tourRepository.findAll();
    }
    
    public Tour findTourByName(String name) {
        
        return tourRepository.findTourByName(name);
    }
    
    public void save(Tour tour) {
        
        tourRepository.save(tour);
    }
    
    public void updateTour(String name, Tour tour) {
        
        Tour t = tourRepository.findTourByName(name);
        t.setTourType(tour.getTourType());
        t.setName(tour.getName());
        t.setTourOperator(tour.getTourOperator());
        tourRepository.save(t);
    }
    
    public void deleteTour(Tour tour) {
    
        tourRepository.delete(tour);
    }
}
