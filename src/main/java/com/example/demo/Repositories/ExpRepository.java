package com.example.demo.Repositories;

import com.example.demo.Classes.ExpResume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpRepository extends CrudRepository<ExpResume, Long> {
}
