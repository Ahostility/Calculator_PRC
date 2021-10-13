package com.example.calculator;

import static java.lang.Double.parseDouble;
import java.util.Arrays;
import android.util.Log;

public class Calc {
    private Double[] operands;
    private String result;

    public void onClickPlus(String input_str){
        if (OnStart(input_str)){
            Double operand_1 = operands[operands.length - 1];
            Double operand_2 = operands[operands.length - 2];
            Double dubl_result = operand_1 + operand_2;;
            result = dubl_result.toString();
        }
        return;
    }

    public void onClickMinus(String input_str){
        if (OnStart(input_str)){
            Double operand_1 = operands[operands.length - 1];
            Double operand_2 = operands[operands.length - 2];
            Double dubl_result = operand_1 - operand_2;;
            result = dubl_result.toString();
        }
        return;
    }

    public void onClickUmnojit(String input_str){
        if (OnStart(input_str)){
            Double operand_1 = operands[operands.length - 1];
            Double operand_2 = operands[operands.length - 2];
            Double dubl_result = operand_1 * operand_2;;
            result = dubl_result.toString();
        }
        return;
    }

    public void onClickRazdelit(String input_str){
        if (OnStart(input_str)){
            Double operand_1 = operands[operands.length - 1];
            Double operand_2 = operands[operands.length - 2];
            Double dubl_result = operand_1 / operand_2;
            result = dubl_result.toString();
        }
        return;
    }

    private Boolean OnStart(String input_str){
        if (input_str.length() == 0) {
            result = "Нет операндов!";
            return false;
        }

        try {
            GetOperands(input_str);
            String str_operand = Arrays.toString(operands);
            Log.i("Operand", str_operand);

            if (operands.length == 0){
                result = "Нет операндов!";
                return false;
            }
            else if (operands.length == 1){
                result = operands[0].toString();
                return false;
            }
            else{
                return true;
            }
        }
        catch (Exception e){
            Log.e("Ошибка", e.getMessage());
            result = "Нет выражения!";
            return false;
        }
    }

    private void GetOperands(String input_RPN){
        String[] str_operands = input_RPN.split(" ");

        Double[] dobl_operands = new Double[str_operands.length];
        int count_operand = 0;

        for (int i = 0; i < str_operands.length; i++){
            char[] char_operand = str_operands[i].toCharArray();
            if (Character.isDigit(char_operand[0])) {
                dobl_operands[i] = parseDouble(str_operands[i].toString());
                count_operand++;
            }
        }

        operands = new Double[count_operand];
        for (int i = 0; i < count_operand; i++){
            operands[i] = (double) dobl_operands[i];
        }
    }

    public String getResult(){
        return result;
    }

    public String ResultOutput(){
        StringBuilder str_operands = new StringBuilder();
        for (int i = 0; i < operands.length - 2; i++){
            str_operands.append(operands[i].toString());
            str_operands.append(" ");
        }
        str_operands.append(result);
        return str_operands.toString();
    }
}


   /* public void onClickStart(String input_RPN){
        if (input_RPN.length() == 0) {
            result = "Нет выражения!";
            return;
        }

        try {
            GetOperands(input_RPN);
            GetOperators(input_RPN);

            String str_operand = Arrays.toString(operands);
            String str_operator = Arrays.toString(operators);

            Log.i("Operand", str_operand);
            Log.i("Operator", str_operator);

            result = String.valueOf(Counting()); //Возвращаем результат
        }
        catch (Exception e){
            Log.e("Ошибка", e.getMessage());
            result = "Нет выражения!";
        };
    }



    private void GetOperators(String input_RPN){
        String[] str_operators = input_RPN.split(" ");

        Character[] char_operators = new Character[str_operators.length];
        int index_operator = 0;
        for (int i = 0; i < str_operators.length; i++){
            Character char_operator = str_operators[i].toCharArray()[0];
            if (!(Character.isDigit(char_operator))){
                char_operators[index_operator] = char_operator;
                index_operator++;
            }

        }

        operators = new Character[index_operator];
        for (int i = 0; i < index_operator; i++){
            operators[i] = char_operators[i];
        }

    //Метод, вычисляющий значение выражения, уже преобразованного в постфиксную запись
    private double Counting(){
        for (int i = 0; i < operators.length; i++) {
            double operand_1 = (double) operands[i];
            double operand_2 = (double) operands[i+1];
            switch (operators[i]) {
                case '+':
                    operands[i+1] = operand_1 + operand_2;
                    break; case '-': operands[i+1] = operand_1 - operand_2;
                    break; case '*': operands[i+1] = operand_1 * operand_2;
                    break; case '/': operands[i+1] = operand_1 / operand_2;
                    break;
            }
        }
        return operands[operators.length];
    }
    */