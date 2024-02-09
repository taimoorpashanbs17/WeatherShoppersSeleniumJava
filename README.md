
# Weather Shopper Web Automation

Automation Framework for Web app of [Weather Shopper](https://weathershopper.pythonanywhere.com/), where It has covered almost all important features of Home Page, SunScreens, Moisturizers and Cart Pages. 



## Tech Stack

**Client** : Java

**Server** : Selenium

**Reports** : Allure Reports

**Browser** : Chrome, Firefox, Edge and Safari

**OS** : Any (Windows, Mac OSX, Linux)

## Testing Scope

Following Test cases have been implemented.
- **From Home Page** : Shop for moisturizers if the weather is below 19 degrees. Shop for SunScreens if the weather is above 34 degrees.
- **From Moisturizers Page** : Add two moisturizers to your cart. First, select the least expensive moisturizer that contains Aloe. For your second moisturizer, select the least expensive moisturizer that contains almond. Click on cart when you are done.
- **From SunScreen Page** : Add two sunscreens to your cart. First, select the least expensive sunscreen that is SPF-50. For your second sunscreen, select the least expensive sunscreen that is SPF-30. Click on the cart when you are done.
- **From Cart Page** : Verify that the shopping cart looks correct. Then, fill out your payment details and submit the form. You can Google for 'Stripe test card numbers' to use valid cards. Note: The payment screen will error 5% of the time by design



## Installation and Execution

Clone the Project within your local directory

```bash
  git clone https://github.com/taimoorpashanbs17/WeatherShoppersSeleniumJava.git
```
Navigate to Folder

```bash
  cd WeatherShoppersSeleniumJava
```

Install all maven dependencies
```bash
  mvn clean install -DskipTests
```


## Running Tests

All Important Test cases , which are defined on 'Testing Scope', are mentioned in ```testng.xml``` file.


```bash
  mvn clean test 
```
By Default 'Chrome' browser will start initiated with all test execution.

But Firefox can also be started with following command:

```bash
  mvn test -Dbrowser="firefox" 
```

It supports 'Firefox', 'Edge' and 'Safari' browsers. and mention browser names in lower case, like `safari`, `firefox`, `edge`. 


And if you want to run with headless, you have to pass arguments with ```headless``` and run command like:

```bash
  mvn test -Dheadless="yes" 
```
By Default, it will run 'Chrome' browser, but if you want to run with 'Firefox', then run:

```bash
  mvn test -Dbrowser="firefox" -Dheadless="yes" 
```



## Generating Allure Report

In Order to generate Allure Reports, run following command:
```bash
  allure serve
```


## Report 

### Allure Report
![Screenshot 2023-03-01 at 10.48.33 PM.png](src%2Fmain%2Fresources%2FScreenshot%202023-03-01%20at%2010.48.33%20PM.png)

## 🔗 Get In Touch with me
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/taimoor-pasha-a2294878/)

