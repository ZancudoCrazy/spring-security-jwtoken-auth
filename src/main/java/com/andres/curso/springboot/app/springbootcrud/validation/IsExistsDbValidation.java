package com.andres.curso.springboot.app.springbootcrud.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andres.curso.springboot.app.springbootcrud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String>{

    @Autowired
    private ProductService service;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(service == null) return true; // Skip validation if service is not available or value is null/blank
        return !service.existsBySku(value);
    }
    
}
