package com.example.final_project.service;

import com.example.final_project.model.Person;
import com.example.final_project.model.Values;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
@Data
@RequiredArgsConstructor
public class ProjectService {

    public ResponseEntity checkBarMitzvah(Person person) {
        if (person.getName().isEmpty()) {
            return new ResponseEntity<>("no name", HttpStatus.UNAUTHORIZED);
        } else {
            if (person.getAge() >= 13) {
                return new ResponseEntity<>("Over bar mitzvah.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Under bar mitzvah.", HttpStatus.OK);
            }
        }
    }

    public ResponseEntity getTime() {
        return new ResponseEntity(new Timestamp(System.currentTimeMillis()), HttpStatus.OK);
    }

    public ResponseEntity doMath( Values values, String operation, double x) {
        double[] newVales = values.getValues();
        if (operation.equals("add")) {
            for (int i = 0; i < values.getValues().length; i++) {
                newVales[i] = values.getValues()[i] + x;
            }
        } else if (operation.equals("subtract")) {
            for (int i = 0; i < newVales.length; i++) {
                newVales[i] = values.getValues()[i] - x;
            }
        } else if (operation.equals("multiply")) {
            for (int i = 0; i < values.getValues().length; i++) {
                newVales[i] = values.getValues()[i] * x;
            }
        } else if (operation.equals("divide")) {
            for (int i = 0; i < values.getValues().length; i++) {
                newVales[i] = values.getValues()[i] / x;
            }
        }
        return new ResponseEntity<>(newVales, HttpStatus.OK);
    }
}