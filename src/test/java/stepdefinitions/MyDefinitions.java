package stepdefinitions;


//import co.com.choucair.certificacion.retoautomatizacion.models.FcomprarProduct;
import co.com.choucair.certificacion.retoautomatizacion.questions.VerificaLogin;
import co.com.choucair.certificacion.retoautomatizacion.questions.VerificarCompra;
import co.com.choucair.certificacion.retoautomatizacion.questions.VerificarCompra2;
import co.com.choucair.certificacion.retoautomatizacion.tasks.ComprarProduct;
//import co.com.choucair.certificacion.retoautomatizacion.tasks.ComprarProduct2;
import co.com.choucair.certificacion.retoautomatizacion.tasks.Login;
import co.com.choucair.certificacion.retoautomatizacion.tasks.Register;
import co.com.choucair.certificacion.retoautomatizacion.utils.EnviromentContants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyDefinitions {
    @Before
    public void initialConfiguration() {
        OnStage.setTheStage(new OnlineCast());
    }


    // ESCENARIO 1  REGISTRO
    /*
    @Dado("que cristian gualtero ingresa a la app")
    public void queCristianGualteroIngresaALaApp() {
        OnStage.theActorCalled(EnviromentContants.ACTOR).wasAbleTo(Open.url(EnviromentContants.ENVIRONMENT_URL));
    }

    @Cuando("se registra llenando los campos de registro")
    public void seRegistraLlenandoLosCamposDeRegistro(DataTable data) {
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(Register.registerPage(newdata));
    }

    @Entonces("el registro es exitoso")
    public void elRegistroEsExitoso() {

    }

}
*/


    // ESCENARIO 2 LOGIN
    @Dado("que cristian gualteros ingresa a la app")
    public void queCristianGualterosIngresaALaApp() {
        OnStage.theActorCalled(EnviromentContants.ACTOR).wasAbleTo(Open.url(EnviromentContants.ENVIRONMENT_URL));

    }

    @Cuando("Cristian ba al modulo de login Y digita sus credenciales")
    public void cristianBaAlModuloDeLoginYDigitaSusCredenciales(DataTable data) {
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(Login.intoPage(newdata));
        //theActorInTheSpotlight().attemptsTo(ComprarProducto.comprarProducto());
    }

    @Entonces("verifica que pudo ingresar correctamente y ve su nombre en el homepage")
    public void verificaQuePudoIngresarCorrectamenteYVeSuNombreEnElHomepage() {

        System.out.println(" El texto del elemento es: " + VerificaLogin.value().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(seeThat("cuando el boton log out  esta habilitado su texto ", VerificaLogin.value(), equalTo("Log out")));

    }


}


/*
    //ESCENARIO 3 compra
    @Dado("que un usuario  se encuentra en  el  home page")
    public void queUnUsuarioSeEncuentraEnElHomePage() {
        OnStage.theActorCalled(EnviromentContants.ACTOR).wasAbleTo(Open.url(EnviromentContants.ENVIRONMENT_URL));
    }
    @Cuando("Se dirige al modulo phones y escoge un producto para comprar")
     public void seDirigeAlModuloPhonesYEscogeUnProductoParaComprar(DataTable data) {
        List<Map<String, String>> newdata = data.asMaps();
        theActorInTheSpotlight().attemptsTo(ComprarProduct.comprarProducto(newdata));

    }
    @Entonces("realiza la compra")
    public void realizaLaCompra() {
        //System.out.println("heyyyyyyyyyyy by "+VerificarCompra.value()+"    target"+VerificarCompra2.value());
        //System.out.println(" El texto del elemento es: "+ VerificarCompra.value().answeredBy(theActorInTheSpotlight()));
        System.out.println(" El texto del elemento esSS: "+ VerificarCompra2.value().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(seeThat("cuando se imprime la factura  aparece el texto: ", VerificarCompra2.value(),equalTo ("Thank you for your purchase!")));

    }



// escenario  3.2


}
 */


