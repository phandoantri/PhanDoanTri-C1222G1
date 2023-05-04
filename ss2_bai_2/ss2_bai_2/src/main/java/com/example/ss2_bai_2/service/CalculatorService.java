package com.example.ss2_bai_2.service;

import com.example.ss2_bai_2.repository.CalculatorRepository;
import com.example.ss2_bai_2.repository.ICalculatorRepository;

public class CalculatorService implements ICalculatorService{
    private ICalculatorRepository iCalculatorRepository=new CalculatorRepository();
    @Override
    public int result(String calculate, int number1, int number2) {
        return iCalculatorRepository.result(calculate,number1,number2);
    }
}
