package co.com.choucair.certificacion.retoautomatizacion.tasks;

import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Prod;
import co.com.choucair.certificacion.retoautomatizacion.utils.EnviromentContants;
import co.com.choucair.certificacion.retoautomatizacion.utils.Sleep;
//import groovy.console.ui.SystemOutputInterceptor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class Login implements Task {

    private final List<Map<String, String>> data;

    public Login(List<Map<String, String>> data) {
        this.data = data;
    }

    public static Login intoPage(List<Map<String, String>> data) {
        return Tasks.instrumented(Login.class,data);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Click.on(Home.LOGIN2),
                //Click.on(Home.LOGINUSERNAME),
                //SendKeys.of(EnviromentContants.USER).into(Home.LOGINUSERNAME),
                //SendKeys.of(EnviromentContants.PASSWORD).into(Home.LOGINPASSWORD),
                SendKeys.of(data.get(0).get("user")).into(Home.LOGINUSERNAME),
                SendKeys.of(data.get(0).get("pass")).into(Home.LOGINPASSWORD),
                Click.on(Home.BTNLOGIN)
                //espere a que nose atraviese una alerta y yo le haga click donde no es
                //WaitUntil.the(Home.LOGINMODULO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                //Click.on(Home.LOGINMODULO),
                //Click.on(Home.LOGIN)

                //WaitUntil.the(Home.BTNLOGOUT, isCurrentlyVisible()).forNoMoreThan(10).seconds()
        );


        //Sleep.sleep(25);
        System.out.println("esperando andoo");





    }






}
