package com.example.demo.Repositories;

import com.example.demo.Classes.EducationResume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<EducationResume, Long> {

}
