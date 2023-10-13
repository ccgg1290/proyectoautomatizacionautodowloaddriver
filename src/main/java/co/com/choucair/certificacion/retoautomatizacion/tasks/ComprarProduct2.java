package co.com.choucair.certificacion.retoautomatizacion.tasks;

import co.com.choucair.certificacion.retoautomatizacion.interactions.ManejoAlertas;
import co.com.choucair.certificacion.retoautomatizacion.models.FcomprarProduct;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Prod;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.cart;
import co.com.choucair.certificacion.retoautomatizacion.utils.Sleep;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class ComprarProduct2 implements Task {


    private  List<FcomprarProduct> data;

    public ComprarProduct2(List<FcomprarProduct> data2) {
        this.data = data2;
    }

    public static  ComprarProduct2 comprarProducto(DataTable data){

        return Tasks.instrumented(ComprarProduct2.class,data);
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
        //System.out.println("antes de la alerta");
        //System.out.println(ManejoAlertas.mensajeAlerta());
        ManejoAlertas.aceptarAlerta();

        actor.attemptsTo(
                //ir la carrito de compras
                Click.on(Prod.NAVCART),
                Click.on(cart.PLACEORDER),
                //llenar formulario de compra
                WaitUntil.the(cart.FORMNAME, isCurrentlyVisible()).forNoMoreThan(10).seconds(),

                SendKeys.of("name").into(cart.FORMNAME),
                SendKeys.of("country").into(cart.FORMCOUNTRY),
                SendKeys.of("city").into(cart.FORMCITY),
                SendKeys.of("card").into(cart.FORMCARD),
                SendKeys.of("month").into(cart.FORMMONTH),
                SendKeys.of("year").into(cart.FORYEAR)


        );
        Sleep.sleep(10);
        actor.attemptsTo(
                // finalizar compra
                Click.on(cart.PURCHASE),
                WaitUntil.the(cart.OKCOMPRA, isCurrentlyVisible()),
                //Click.on(cart.PURCHASE)
                Click.on(cart.OKCOMPRA)
        );
    }





}
