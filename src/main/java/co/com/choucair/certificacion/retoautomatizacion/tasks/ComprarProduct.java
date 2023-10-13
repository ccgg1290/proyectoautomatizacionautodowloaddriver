package co.com.choucair.certificacion.retoautomatizacion.tasks;

import co.com.choucair.certificacion.retoautomatizacion.interactions.ManejoAlertas;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Prod;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.cart;
import co.com.choucair.certificacion.retoautomatizacion.utils.Sleep;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class ComprarProduct implements Task {



    private final List<Map<String, String>> data;

    public ComprarProduct(List<Map<String, String>> data) {
        this.data = data;
    }

    public static ComprarProduct comprarProducto(List<Map<String, String>> newdata) {
        return Tasks.instrumented(ComprarProduct.class,newdata);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {


        //Elegir producto e inciar la compra
        actor.attemptsTo(

                Click.on(Home.COMPRAPHONES),
                WaitUntil.the(Home.COMPRAPHONE, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(Home.COMPRAPHONE),
                WaitUntil.the(Prod.ADDTOCAR, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(Prod.ADDTOCAR)
        );
        // Esperar que aparezca la alerta
        Sleep.sleep(2);
        //cerrar la alerta
        System.out.println("antes de la alerta");
        System.out.println("mensaje de la alerta"+ManejoAlertas.mensajeAlerta("hhh"));
        ManejoAlertas.aceptarAlerta();

        actor.attemptsTo(
                //ir la carrito de compras
                Click.on(Prod.NAVCART),
                Click.on(cart.PLACEORDER),
                //llenar formulario de compra
                WaitUntil.the(cart.FORMNAME, isCurrentlyVisible()).forNoMoreThan(10).seconds(),

                SendKeys.of(data.get(0).get("name")).into(cart.FORMNAME),
                SendKeys.of(data.get(0).get("country")).into(cart.FORMCOUNTRY),
                SendKeys.of(data.get(0).get("city")).into(cart.FORMCITY),
                SendKeys.of(data.get(0).get("card")).into(cart.FORMCARD),
                SendKeys.of(data.get(0).get("month")).into(cart.FORMMONTH),
                SendKeys.of(data.get(0).get("year")).into(cart.FORYEAR)

        );
        Sleep.sleep(3);
        actor.attemptsTo(
                // finalizar compra
                Click.on(cart.PURCHASE),
                WaitUntil.the(cart.OKCOMPRA, isCurrentlyVisible())
                //Click.on(cart.PURCHASE)
                //Click.on(cart.OKCOMPRA)
        );
    }





}
