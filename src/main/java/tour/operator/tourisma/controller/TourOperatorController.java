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
import tour.operator.tourisma.model.tour.TourOperator;
import tour.operator.tourisma.service.TourOperatorService;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class TourOperatorController {
    
    @Autowired
    private TourOperatorService tourOperatorService;
    
    @GetMapping("/operators")
    public ResponseEntity<List<TourOperator>> getAllTourOperators() {
        
        return new ResponseEntity<>(tourOperatorService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/operator/{name}")
    public ResponseEntity<TourOperator> findOperatorByCompantName(@PathVariable ("name") String companyName) {
        
        return new ResponseEntity<>(tourOperatorService.findTourOperatorByCompanyName(companyName), HttpStatus.OK);
    }
    
    @PostMapping("/operator")
    public ResponseEntity<TourOperator> addOperator(@RequestBody TourOperator tourOperator) {
        
        tourOperatorService.save(tourOperator);
        return new ResponseEntity<>(tourOperator, HttpStatus.OK);
    }
    
    @PutMapping("/operator/{name}")
    public ResponseEntity<TourOperator> updateOperator(@PathVariable("name") String companyName, @RequestBody TourOperator tourOperator) {
        
        tourOperatorService.updateTourOperator(companyName, tourOperator);
        return new ResponseEntity<>(tourOperator, HttpStatus.OK);
    }
    
    @DeleteMapping("/operator/{name}")
    public ResponseEntity<String> deleteOperatorByCompanyName(@PathVariable("name") String companyName) {
    
        TourOperator tourOperator = tourOperatorService.findTourOperatorByCompanyName(companyName);
        if (isNull(tourOperator)) {
            return new ResponseEntity<>("Tour operator not found", HttpStatus.OK);
        } else {
            tourOperatorService.deleteTourOperator(tourOperator);
            return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
        }
    }
}
