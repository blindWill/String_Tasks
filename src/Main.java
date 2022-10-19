import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isContinue = true;
        int chosenTask;
        do {
            System.out.println(
                    "#1 - The date is represented by a line of the form \"15 июля 2016\". " +
                    "Convert it into digital format \"15.07.2016\".\n" +
                    "#2 - The date is represented by a string of the form \"15.07.2016\". " +
                    "Translate it into string format of \"15 июля 2016.\"\n" +
                    "#3 - The phone number is given by the line of view \"7 (921) 123-45-67\". " +
                    "Convert number to format without brackets, spaces and lines (but with plus).\n" +
                    "#4 - The results of the athlete in the competitions in the long jump are represented " +
                    "by the line of view \"706 - % 717 % 703\". Return the longest jump.\n" +
                    "#5 - The expression \"2 + 31 - 40 + 13\" appears in the line. Return expression value.\n" +
                    "#6 - The line contains the names of the goods and their prices in the format of appearance " +
                    "\"Хлеб 39.9; Молоко 62; Курица 184.0\". Return the name of the most expensive item on the list.\n" +
                    "# - Any number to exit.");
            chosenTask = inputInteger(in);
            switch (chosenTask){
                case 1:
                    performFirstTask();
                    break;
                case 2:
                    performSecondTask();
                    break;
                case 3:
                    performThirdTask();
                    break;
                case 4:
                    performFourthTask();
                    break;
                case 5:
                    performFifthTask();
                    break;
                case 6:
                    performSixthTask();
                    break;
                default:
                    isContinue = false;
                    break;
            }
        }while(isContinue);
    }

    public static void performFirstTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your date: ");
        String date = in.nextLine();
        if (isStringDateValid(date)){
            System.out.println(digitizeDate(date));
        }else{
            System.out.println("Wrong Input");
        }
    }

    public static String digitizeDate(String date){
        final int firstSpace = date.indexOf(" ");
        String day = date.substring(0, firstSpace);
        if (day.length() == 1){
            day = "0" + day;
        }
        final int secondSpace = date.lastIndexOf(" ");
        String month = date.substring(firstSpace + 1, secondSpace);
        final String year = date.substring(secondSpace + 1);
        month = digitizeMonth(month);
        return day + "." + month + "." + year;
    }

    public static String digitizeMonth(String date){
        switch (date){
            case "января": {
                return "01";
            }
            case "февраля": {
                return "02";
            }
            case "марта": {
                return "03";
            }
            case "апреля": {
                return "04";
            }
            case "мая": {
                return "05";
            }
            case "июня": {
                return "06";
            }
            case "июля": {
                return "07";
            }
            case "августа": {
                return "08";
            }
            case "сентября": {
                return "09";
            }
            case "октября": {
                return "10";
            }
            case "ноября": {
                return "11";
            }
            case "декабря": {
                return "12";
            }
            default:
                return "0";
        }
    }

    public static boolean isStringDateValid(String date){
        if (date.matches("\\d{1,2}\\s[а-я]{3,8}\\s\\d{1,4}")){
            final String[] dateArray = date.split(" ");
            return isDayAndMonthValid(dateArray[0], digitizeMonth(dateArray[1]), dateArray[2]);
        }else{
            return false;
        }
    }
    public static boolean isDayAndMonthValid(String day, String month, String year){
        switch (month){
            case "01":
            case "03":
            case "05":
            case "07":
            case "08":
            case "10":
            case "12":{
                if (Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1)
                    return false;
                else
                    break;
            }
            case "02": {
                if ((Integer.parseInt(day) > 29 && (Integer.parseInt(year) % 4 == 0)) || Integer.parseInt(day) < 1
                    || (Integer.parseInt(day) > 28 && (Integer.parseInt(year) % 4 != 0)))
                    return false;
                else
                    break;
            }
            case "04":
            case "06":
            case "09":
            case "11":{
                if (Integer.parseInt(day) > 30 || Integer.parseInt(day) < 1)
                    return false;
                else
                    break;
            }
            case "0":
                return false;
        }
        return true;
    }

    public static void performSecondTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your date: ");
        final String date = in.nextLine();
        if (isDigitDateValid(date)){
            System.out.println(dateStringConversion(date));
        }else{
            System.out.println("Wrong Input");
        }
    }

    public static boolean isDigitDateValid(String date){
        if (date.matches("\\d{2}\\.\\d{2}\\.\\d{1,4}")){
            final String[] dateArray = date.split("\\.");
            return isDayAndMonthValid(dateArray[0], dateArray[1], dateArray[2]);
        }
        else{
            return false;
        }
    }

    public static String dateStringConversion(String date){
        final String firstSymbol = date.substring(0, 1);
        final int firstDot = date.indexOf(".");
        final String day= (firstSymbol.equals("0")) ? date.substring(1, firstDot) : date.substring(0, firstDot);
        final int secondDot = date.lastIndexOf(".");
        String month = date.substring(firstDot + 1, secondDot);
        final String year = date.substring(secondDot + 1);
        month = monthStringConversion(month);
        return day + " " + month + " " + year;
    }

    public static String monthStringConversion(String date){
        switch (date){
            case "01": {
                return "января";
            }
            case "02": {
                return "февраля";
            }
            case "03": {
                return "марта";
            }
            case "04": {
                return "апреля";
            }
            case "05": {
                return "мая";
            }
            case "06": {
                return "июня";
            }
            case "07": {
                return "июля";
            }
            case "08": {
                return "августа";
            }
            case "09": {
                return "сентября";
            }
            case "10": {
                return "октября";
            }
            case "11": {
                return "ноября";
            }
            case "12": {
                return "декабря";
            }
            default:
                return "0";
        }
    }

    public static void performThirdTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your phone number(from 9 to 15 digits): ");
        final String phoneNumber = in.nextLine();
        if (isPhoneNumberValid(phoneNumber)){
            System.out.println(convertPhoneNumberFormat(phoneNumber));
        }else{
            System.out.println("Wrong Input");
        }
    }

    public static boolean isPhoneNumberValid(String phoneNumber){
        if (phoneNumber.matches("\\s*-*(\\+\\d{1,3})?\\s*-*(\\(\\d{1,3}\\))?\\s*-*(\\d*\\s*-*)*")){
            Pattern pattern = Pattern.compile("\\d");//\s*\d|\d
            Matcher matcher = pattern.matcher(phoneNumber);
            int counter = 0;
            while (matcher.find()){
                counter++;
            }
            return counter >= 3 && counter <= 15;
        }else{
            return false;
        }
    }

    public static StringBuilder convertPhoneNumberFormat(String phoneNumber){
        Pattern pattern = Pattern.compile("\\s*\\+\\d+|\\d+");
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder convertedPhoneNumber = new StringBuilder();
        while (matcher.find()){
            convertedPhoneNumber.append(matcher.group());
        }
        return convertedPhoneNumber;
    }

    public static void performFourthTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input jump results: ");
        final String jumpResults = in.nextLine();
        if (isJumpResultsValid(jumpResults)){
            System.out.println(getMaxNumber(jumpResults));
        }else{
            System.out.println("Wrong Input");
        }
    }

    public static boolean isJumpResultsValid(String jumpResults){
        return jumpResults.matches("((\\d{2,3}|%|-)\\s)*(\\d{2,3}|-|%)");
    }

    public static int getMaxNumber(String jumpResults){
        String[] strNumbers = jumpResults.split("\\s\\D*");
        int highestResult = 0;
        int currentNumber;
        for (String strNumber: strNumbers) {
            currentNumber = Integer.parseInt(strNumber);
            if (currentNumber > highestResult){
                highestResult = currentNumber;
            }
        }
        return highestResult;
    }

    public static void performFifthTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your expression: ");
        final String expression = in.nextLine();
        try{
            if(isExpressionValid(expression)){
                System.out.println(findValueOfExpression(expression));
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public static boolean isExpressionValid(String expression) throws IllegalArgumentException{
        if (expression.matches("(\\d+\\s[-+]\\s)*\\d+"))
            return true;
        else
            throw new IllegalArgumentException();

    }

    public static int findValueOfExpression(String expression){
        String[] numbersAndSigns = expression.split(" ");
        int value = Integer.parseInt(numbersAndSigns[0]);
        for (int i = 1; i < numbersAndSigns.length; i += 2){
            if (numbersAndSigns[i].equals("+")){
                value += Integer.parseInt(numbersAndSigns[i + 1]);
            } else if (numbersAndSigns[i].equals("-")) {
                value -= Integer.parseInt(numbersAndSigns[i + 1]);
            }
        }
        return value;
    }

    public static void performSixthTask(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your products list: ");
        final String productList = in.nextLine();
        if (isProductListValid(productList)){
            System.out.println(getMostExpensiveItem(productList));
        }else{
            System.out.println("Wrong Input");
        }
    }

    private static boolean isProductListValid(String productList){
        return productList.matches("([А-Я][а-я]*\\s\\d+(\\.\\d+)?;\\s)*[А-Я][а-я]*\\s\\d+(\\.\\d+)?");
    }
    public static String getMostExpensiveItem(String productList){
        String[] products = productList.split("; ");
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        double highestNumber = 0;
        int mostExpensiveItemIndex = 0;
        for (int i = 0; i < products.length; i++) {
            Matcher matcher = pattern.matcher(products[i]);
            if (matcher.find()){
                if (highestNumber < Double.parseDouble(matcher.group())){
                    highestNumber = Double.parseDouble(matcher.group());
                    mostExpensiveItemIndex = i;
                }
            }
        }
        return products[mostExpensiveItemIndex];
    }

    public static int inputInteger(Scanner in) {
        int num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                num = in.nextInt();
            } catch (IllegalStateException | InputMismatchException e) {
                System.out.println("Wrong input! try again: ");
                in.next();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }
}