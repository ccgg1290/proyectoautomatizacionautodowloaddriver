package co.com.choucair.certificacion.retoautomatizacion.tasks;

import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.utils.Sleep;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class Register implements Task {

    private final List<Map<String, String>> data;

    public Register(List<Map<String, String>> data) {
        this.data = data;
    }

    public static Register registerPage(List<Map<String, String>> data) {
        return Tasks.instrumented(Register.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // decirle a selenium que obtenga el control sobre la pagina -- que esta siendo manejada por serenity
        WebDriver driver = getDriver();
        actor.attemptsTo(
                Click.on(Home.REGISTER),
                WaitUntil.the(Home.REGISTERUSERNAME, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SendKeys.of(data.get(0).get("user")).into(Home.REGISTERUSERNAME),
                SendKeys.of(data.get(0).get("pass")).into(Home.REGISTERPASSWORD),
                Click.on(Home.BTNSIGNIN)
        );

        Sleep.sleep(2);

        //cerrar la alerta
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Sleep.sleep(1);
        //actor.attemptsTo(Click.on(Home.CLOSEFORMREGISTER));


    }


}
