package com.sapient.globalinsurancesbapi.services;

import com.sapient.globalinsurancesbapi.models.College;
import com.sapient.globalinsurancesbapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private StudentRepository studentRepository;

    //insert

    public College addCollege(College college){
     if(this.getCollegeById(college.getCollegeId()) == null)
         return this.studentRepository.save(college);
     else
         return null;

    }

    //select all
    public List<College> getAllColleges(){
        return this.studentRepository.findAll();
    }

    //select by id
    public College getCollegeById(long collegeId){

        return this.studentRepository.findById(collegeId).orElse(null);
    }

    //delete
    public boolean deleteCollegeById(long collegeId){
        this.studentRepository.deleteById(collegeId);
        if(this.getCollegeById(collegeId)==null)
            return true;
        return false;
    }

    //update

    public College updateCollegeEmail(long collegeId, String email){

        College college = this.getCollegeById(collegeId);
        if(college !=null){
            college.setEmailId(email);
            this.studentRepository.save(college);
            return college;
        }
        return null;
    }


}
