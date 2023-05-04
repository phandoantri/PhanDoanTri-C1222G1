package com.example.ss2_bai_2.service;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorService implements ICalculatorService {
    @Override
    public int result(String calculate, int number1, int number2) {
        switch (calculate) {
            case "cong":
                return number1 + number2;
            case "tru":
                return number1 - number2;
            case "nhan":
                return number1 * number2;
            case "chia":
                return number1 / number2;
        }
        return 0;
    }
}
