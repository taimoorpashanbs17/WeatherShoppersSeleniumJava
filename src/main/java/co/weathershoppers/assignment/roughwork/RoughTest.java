package co.weathershoppers.assignment.roughwork;

import co.weathershoppers.assignment.WeatherShoppersTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class RoughTest extends WeatherShoppersTestBase {

    public static void main (String[] args) throws InterruptedException {
        startWebBrowser();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);

        getWebDriver().get("https://weathershopper.pythonanywhere.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Buy moisturizers']")));
        WebElement moisButton = getWebDriver().findElement(By.xpath("//button[normalize-space()='Buy moisturizers']"));
        moisButton.click();
        ArrayList<String> moisturizersNames = new ArrayList<>();
        List<WebElement> namesOfMois = driver.get().findElements(By.xpath("//div/div/p[1]"));
        for (WebElement element : namesOfMois){
            moisturizersNames.add(element.getText());
        }
        System.out.println(moisturizersNames);
//        List<String> almondMoisturizersNames = new ArrayList<>();
//        for (String s : moisturizersNames) {
//            if (s.contains("almond")) {
//                almondMoisturizersNames.add(s);
//            }
//        }
//        while(almondMoisturizersNames){
//
//            for (String s : moisturizersNames) {
//                if (s.contains("almond")) {
//                    almondMoisturizersNames.add(s);
//                }
//                getWebDriver().navigate().refresh();
//            }
//        }
//        System.out.println(almondMoisturizersNames);

//        ArrayList<String> moisturizersPrices = new ArrayList<>();
//        List<WebElement> pricesOfMois = driver.get().findElements(By.xpath("//div/div/p[2]"));
//        for (WebElement element : pricesOfMois){
//            moisturizersPrices.add(element.getText());
//        }
//        Pattern p = Pattern.compile("[0-9]+$");
//        List<Integer> numbers = moisturizersPrices.stream()
//                .map(p::matcher)
//                .filter(Matcher::find)
//                .map(m -> parseInt(m.group()))
//                .collect(Collectors.toList());
//
//        Map<String, Integer> moisturizerNameAndPrice = new TreeMap<>();
//        for(int i = 0; i < moisturizersNames.size(); i++) moisturizerNameAndPrice.put(moisturizersNames.get(i), numbers.get(i));
//
//        System.out.println(moisturizerNameAndPrice);
//        String prefix = "almond";
//        List<String> aloeNamesList = new ArrayList<>();
//        List<Integer> aloeListValues = new ArrayList<>();
//        for (String key : moisturizerNameAndPrice.keySet()) {
//            if(key.contains(prefix)) {
//                aloeNamesList.add(key);
//            }
//        }
//        for (String values : aloeNamesList) {
//            aloeListValues.add(moisturizerNameAndPrice.get(values));
//        }
//
//        Map<Integer, String> aloeMoisturizerNameAndPrice = new TreeMap<>();
//        for(int i = 0; i < aloeListValues.size(); i++) aloeMoisturizerNameAndPrice.put(aloeListValues.get(i), aloeNamesList.get(i));
//
//        System.out.println(aloeMoisturizerNameAndPrice);
//        try {
//            String lowestPrice = String.valueOf(Collections.min(aloeListValues));
//            String aloeName = aloeMoisturizerNameAndPrice.get(parseInt(lowestPrice));
//            int indexOfAloe = moisturizersNames.indexOf(aloeName) + 1;
//            WebElement selectedAloe = getWebDriver().findElement(By.xpath("(//button[@class='btn btn-primary'][normalize-space()='Add'])[" + indexOfAloe + "]"));
//            selectedAloe.click();
//        }
//        catch (java.util.NoSuchElementException e){
//            e.getStackTrace();
//        }

        Thread.sleep(2000);


        getWebDriver().quit();
    }
}
