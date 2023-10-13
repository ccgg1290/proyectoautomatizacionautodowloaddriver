package co.com.choucair.certificacion.retoautomatizacion.questions;

import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerificarRegistro implements Question<String> {

    public static Question<String> value(){
        return new VerificarRegistro();

    }


    // public static  By LOGIN =By.xpath("//a[@id=\"login2\"]");
    @Override
    public String answeredBy(Actor actor) {


        return BrowseTheWeb.as(actor).find(Home.LOGIN).getText();

    }


/*

    public String answeredBy(Actor actor) {

        WebDriver driver = getDriver();
        Alert alert = driver.switchTo().alert();
        alert.getText();

        public static String valueAlert(){
            alert.getText();
            System.out.println("Esta es ek texto de la alarte "+alert.getText());
            return alert.getText();
        }


        return BrowseTheWeb.as(actor).find(Home.LOGIN).getText();

    }
*/

}
