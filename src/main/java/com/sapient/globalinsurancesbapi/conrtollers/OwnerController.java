package com.sapient.globalinsurancesbapi.conrtollers;

import com.sapient.globalinsurancesbapi.models.College;
import com.sapient.globalinsurancesbapi.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/colleges")
public class OwnerController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping({"/v1.0"})
    @CrossOrigin("*")
    public ResponseEntity<?> addCollege(@Valid @RequestBody College college){

        College collegeObj =this.collegeService.addCollege(college);
        if(collegeObj !=null){
            return ResponseEntity.status(HttpStatus.OK).body(collegeObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("College Not Added");
    }

    @GetMapping({"/v1.0"})
    @CrossOrigin("*")
    public List<College> getAllColleges(){
        return this.collegeService.getAllColleges();
    }

    @GetMapping({"/v1.0/{collegeId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> getCollegeById(@PathVariable("collegeId") long collegeId){
        College collegeObj =this.collegeService.getCollegeById(collegeId);
        if(collegeObj !=null){
            return ResponseEntity.status(HttpStatus.OK).body(collegeObj);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("College Data Not found");
    }

    @DeleteMapping({"/v1.0/{collegeId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> deleteCollegeById(@PathVariable("collegeId") long collegeId){

        if(this.collegeService.deleteCollegeById(collegeId)){
            return ResponseEntity.status(HttpStatus.OK).body("College removed ");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("College Not found");
    }


    @PutMapping({"/v1.0/{collegeId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> updateCollegeById(@PathVariable("collegeId") long mobileNo,
                                                   @RequestParam(name = "email") String email){
        College college =this.collegeService.updateCollegeEmail(mobileNo,email);

        if(college !=null){
            return ResponseEntity.status(HttpStatus.OK).body(college);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("College Not found");
    }
}
