package co.weathershoppers.assignment.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static co.weathershoppers.assignment.WeatherShoppersTestBase.getWebDriver;


public class DataStructureHelpers {
    public static ArrayList<String> generateTextList(List<WebElement> elementList){
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : elementList){
            arrayList.add(element.getText());
        }
        return  arrayList;
    }

    public static TreeMap<String, Integer> generateHashMapFromTwoArrayListWithStringAndInteger(List<String> keyList,
                                                                                        List<Integer> keyValueList){
        TreeMap<String, Integer> newTreeMap = new TreeMap<>();
        for(int i = 0; i < keyList.size(); i++) newTreeMap.put(keyList.get(i), keyValueList.get(i));
        return newTreeMap;
    }

    public static ArrayList<Integer> createListOfNumbers(List<String> listOfPrices){
        Pattern p = Pattern.compile("[0-9]+$");
        List<Integer> listOfNumber =  listOfPrices.stream()
                .map(p::matcher)
                .filter(Matcher::find)
                .map(m -> Integer.parseInt(m.group()))
                .collect(Collectors.toList());
        return (ArrayList<Integer>) listOfNumber;
    }

    public static TreeMap<Integer, String > generateHashMapFromTwoArrayListWithIntegerAndString(List<Integer> keyList,
                                                                                         List<String> keyValueList){
        TreeMap<Integer, String> newTreeMap = new TreeMap<>();
        for(int i = 0; i < keyList.size(); i++) newTreeMap.put(keyList.get(i), keyValueList.get(i));
        return newTreeMap;
    }

    public static List<String> generateListOfNamesFromTreeMap(String textContainingOf, TreeMap<String, Integer> givenTreeMap){
        List<String> namesList = new ArrayList<>();
        for (String key : givenTreeMap.keySet()) {
            if(key.contains(textContainingOf)) {
                namesList.add(key);
            }
        }
        return namesList;
    }

    public static List<Integer> generateListOfPricesFromListAndTreeMap(TreeMap<String, Integer> givenTreeMap,
                                                                      List<String> givenList){
        List<Integer> priceList = new ArrayList<>();
        for (String values : givenList) {
            priceList.add(givenTreeMap.get(values));
        }
        return priceList;
    }

    public static void addLeastExpensiveProductOnCart(List<Integer> listOfProductPrices, TreeMap<Integer, String>treeMapOfProduct,
                                               List<String> listOfProductNames, String productName){
        try{
            Integer leastExpensivePrice = Collections.min(listOfProductPrices);
            String nameOfProduct = treeMapOfProduct.get(leastExpensivePrice);
            int productIndex = listOfProductNames.indexOf(nameOfProduct) + 1;
            WebElement productAddButton = getWebDriver().findElement(By.xpath(
                    "(//button[@class='btn btn-primary'][normalize-space()='Add'])[" + productIndex + "]"));
            productAddButton.click();
        }
        catch (NoSuchElementException e) {
            System.out.println("Unable to Find "+productName+", due to "+e.getMessage());
        }
    }
}
