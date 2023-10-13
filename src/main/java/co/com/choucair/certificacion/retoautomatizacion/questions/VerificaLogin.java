package co.com.choucair.certificacion.retoautomatizacion.questions;

import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class VerificaLogin {



    public static Question<String> value(){

        return TheTarget.textOf(Home.BTNLOGOUT);

    }



}
