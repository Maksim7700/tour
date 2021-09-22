package tour.operator.tourisma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tour.operator.tourisma.model.tour.Tour;
import tour.operator.tourisma.model.user.User;
import tour.operator.tourisma.service.TourService;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class TourController {
    
    @Autowired
    private TourService tourService;
    
    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> getAllTours() {
        
        return new ResponseEntity<>(tourService.findAllTours(), HttpStatus.OK);
    }
    
    @GetMapping("/tour/{name}")
    public ResponseEntity<Tour> getTourByName(@PathVariable("name") String name) {
        
            return new ResponseEntity<>(tourService.findTourByName(name), HttpStatus.OK);
        
    }
    
    @PostMapping("/tour")
    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
        
        tourService.save(tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    
    @PutMapping("/tour/{name}")
    public ResponseEntity<Tour> updateTour(@PathVariable("name") String name, @RequestBody Tour tour) {
    
        tourService.updateTour(name, tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    
    @DeleteMapping("/tour/{name}")
    public ResponseEntity<String> deleteTour(@PathVariable("name") String name) {
        
        Tour tour = tourService.findTourByName(name);
        if (isNull(tour)) {
            return new ResponseEntity<>("Tour not found", HttpStatus.OK);
        } else {
            tourService.deleteTour(tour);
            return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
        }
    }
   
}
