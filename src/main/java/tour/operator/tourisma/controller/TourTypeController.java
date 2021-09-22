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
import tour.operator.tourisma.model.tour.TourType;
import tour.operator.tourisma.service.TourTypeService;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class TourTypeController {
    
    @Autowired
    private TourTypeService tourTypeService;
    
    @GetMapping("/types")
    public ResponseEntity<List<TourType>> getAllTypes() {
        
        return new ResponseEntity<>(tourTypeService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/type/{name}")
    public ResponseEntity<TourType> getTourTypeByName(@PathVariable("name") String name) {
        
        return new ResponseEntity<>(tourTypeService.findTourByName(name), HttpStatus.OK);
    }
    
    @PostMapping("type")
    public ResponseEntity<TourType> addTourType(@RequestBody TourType tourType) {
        
        tourTypeService.save(tourType);
        return new ResponseEntity<>(tourType, HttpStatus.OK);
    }
    
    @PutMapping("/type/{name}")
    public ResponseEntity<TourType> updateTourType(@PathVariable("name") String name, @RequestBody TourType tourType) {
    
        tourTypeService.updateTourType(name, tourType);
        return new ResponseEntity<>(tourType, HttpStatus.OK);
    }
    
    @DeleteMapping("/type/{name}")
    public ResponseEntity<String> deleteTourType(@PathVariable("name") String name) {
        
        TourType tourType = tourTypeService.findTourByName(name);
        if (isNull(tourType)) {
            return new ResponseEntity<>("Tour type not found", HttpStatus.OK);
        } else {
            tourTypeService.deleteTourType(tourType);
            return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
        }
        
    }
}
