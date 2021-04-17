package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String result = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Введите операцию для вычисления:");
        String stroka = in.nextLine();
        switch (sign_search(stroka)){
            case 0:
                result=calculate(stroka,"*");
                break;
            case 1:
                result=calculate(stroka,"/");
                break;
            case 2:
                result=calculate(stroka,"-");
                break;
            case 3:
                result=calculate(stroka,"+");
                break;
            case -1:
                System.out.printf("Ошибка использования операторов");
                break;
        }
        if (result=="-1") {
            System.out.printf("Ошибка 1 использования чисел");
        } else  if (result=="0") {
            System.out.printf("Ошибка 2 использования чисел");
                     } else if (result!="") {
            System.out.printf("Результат: %s",result);
        }

    }

    static String convert(int result) {
        String[] rimX = new String[]{"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String result_rim = "";
        if (result<=11) {
            result_rim=rimX[result];
        } else if (result>11 && result<20) {
                   result_rim="X"+rimX[(result %10)];
                   } else if (result>=20 && result<30) {
                            result_rim="XX"+rimX[(result %10)];
                            }else if (result>=30 && result<40) {
                                    result_rim="XXX"+rimX[(result %10)];
                                    }
                                   else if (result>=40 && result<50) {
                                     result_rim="XL"+rimX[(result %10)];
                                          }
                                        else if (result>=50 && result<60) {
                                              result_rim="L"+rimX[(result %10)];
                                          }
                                               else if (result>=60 && result<70) {
                                                       result_rim="LX"+rimX[(result %10)];
                                                      }
                                                      else if (result>=70 && result<80) {
                                                              result_rim="LXX"+rimX[(result %10)];
                                                              }
                                                           else if (result>=80 && result<90) {
                                                                     result_rim="LXXX"+rimX[(result %10)];
                                                                   }
                                                                  else if (result>=90 && result<100) {
                                                                          result_rim="XC"+rimX[(result %10)];
                                                                      } else if (result==100) {
                                                                                   result_rim = "C";
                                                                                }


        return result_rim;
    }


    static String calculate(String str, String sign_value) {
        String[] rimX = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        String result_Str = "";
        String str1 = str.substring(0, str.indexOf(sign_value));
        String str2 = str.substring((str.indexOf(sign_value) + 1), str.length());

        for (int i = 0; i < 10; i++) {
            if (str1.equals(rimX[i])) {
                num1 = i + 1;
            }
            if (str2.equals(rimX[i])) {
                num2 = i + 1;
            }
        }
        if (num1 == 0 ^ num2 == 0) {
            result_Str = "-1";
        } else {
            if (num1 != 0 && num2 != 0) {
                switch (sign_value) {
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "+":
                        result = num1 + num2;
                        break;
                }
                result_Str = convert(result);
            } else if (Integer.parseInt(str1) > 0 && Integer.parseInt(str2) > 0 && Integer.parseInt(str1) < 11 && Integer.parseInt(str2) < 11) {
                num1 = Integer.parseInt(str1);
                num2 = Integer.parseInt(str2);
                switch (sign_value) {
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "+":
                        result = num1 + num2;
                        break;
                }
                result_Str = Integer.toString(result);
            } else result_Str = "0";
        }
        return result_Str;
    }


    static int sign_search(String str) {
         String[] sign = new String[]{ "*", "/", "-", "+"};
         int sum_search=0;
         int sign_index=-1;
         String sign_found = "";
            for (int i = 0; i < 4; i++) {
            if ((str.indexOf(sign[i]) == str.lastIndexOf(sign[i])) && (str.indexOf(sign[i]) !=-1)) {
                sign_index=i;
                sum_search++;}
            }
         if (sum_search!=1) {
             sign_index=-1;
    }
        return sign_index;
    }
}
