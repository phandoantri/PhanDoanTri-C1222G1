package com.example.ss2_bai_2.service;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorService implements ICalculatorService {
    @Override
    public int result(String calculate, int firstNumber, int secondNumber) {
        switch (calculate) {
            case "cong":
                return firstNumber + secondNumber;
            case "tru":
                return firstNumber - secondNumber;
            case "nhan":
                return firstNumber * secondNumber;
            case "chia":
                return firstNumber / secondNumber;
        }
        return 0;
    }
}
