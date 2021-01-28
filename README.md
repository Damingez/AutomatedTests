Rest-assured and Selenium
====================

 Automated testing with REST Assured and Selenium WebDriver
 
 ## Prerequisites
 
 - Git
 - JDK 12 is set in POM, if You wanna change it to lower (but >= 8) it should work fine.
 - Maven
 - IntelliJ 
 - Terminal
 - Firefox 85.0 (64 bit) / Chrome browser (88.0.4324.104) 
 
 ## Run tests in terminal
 
 - Open Terminal
 - Run `git clone <repository url>`
 - Navigate to `AutomatedTests`
 - make sure that proper gecko/chromedriver is choosen in `AutomatedTests/utilities/file`
   This can be configured in `pathToDriver` variable located in `AutomatedTests/src/test/java/com/kowalix/ui/manage/Application.java`
   Also remember to add rights to execute for driver  `chmod +x geckodriver`
 - Run `./mvn clean test` for linux , `mvn clean test` for Windows
 
 ## Running individual tests in IntelliJ
 
 - Open IntelliJ
 - Import Maven project
 - Run one of Java files located in `com.kowalix.ui.tests` or  `com.kowalix.apiTests`  packages 
 
