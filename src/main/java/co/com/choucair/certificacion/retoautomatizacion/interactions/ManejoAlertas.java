package co.com.choucair.certificacion.retoautomatizacion.interactions;

import net.serenitybdd.screenplay.Question;
import org.apache.hc.core5.http.nio.ssl.BasicServerTlsStrategy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static net.serenitybdd.core.Serenity.getDriver;

public class ManejoAlertas {


    // decirle a selenium que obtenga el control sobre la pagina -- que esta siendo manejada por serenity



    public static void aceptarAlerta(){
        WebDriver driver = getDriver();
        //Alert alert = driver.switchTo().alert().accept();
        //alert.accept();
        driver.switchTo().alert().accept();

    }

    public static String mensajeAlerta(String  textcompare){

        WebDriver driver = getDriver();
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Este es el mensaje de la alerta "+alertText);
        boolean compare= alertText.equals(textcompare);
        System.out.println("La comparacion fue  "+compare);



        return driver.switchTo().alert().getText();


    }



}
