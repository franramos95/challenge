# challenge
Automation Challenge Code

The solution made by using Selenium WebDrive, Java 8 and eclipse IDE.
I follow the follow filters options:
    • Fun Things To Do (the Spa and wellness centre's filter didn't exist anymore)
    • Star rating
And I create two test cases:
    • iChooseFiveStartsAndSeeTheHotelTest - Verify when I select the 5 starts rating than I validate if the The Savoy Hotel show up and the George Limerick Hotel dind't show up.
    • iChooseSaunaAndSeeTheHotelTest - verify when I select the sauna option than I validate if the Limerick Strand Hotel show up and the George Limerick Hotel dind't show up.
    
Using the Java Streams Api was possible to interate the webElement and verify a list of hotels.

To run the automated test 
    • go to command line
    • enter in the folder that you saved the project
    • and run the follow command "mvn clean install"
    
    
