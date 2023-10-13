package co.com.choucair.certificacion.retoautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Prod {

    public static final Target ADDTOCAR=Target.the("agreagr al carrito").locatedBy("//*[text()='Add to cart']");
    public static final Target NAVCART=Target.the("navcart").locatedBy("//a[@id='cartur']");
}

