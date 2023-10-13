package co.com.choucair.certificacion.retoautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class cart {

    public static final Target PLACEORDER=Target.the("placeorder").locatedBy("//*[text()='Place Order']");
    public static final Target NAVCART=Target.the("nav cart ").locatedBy("//a[@id='cartur']");
 //FORMULARIO
   public static final Target FORMNAME=Target.the("usuario").locatedBy("//*[@id='name']");
   public static final Target FORMCOUNTRY=Target.the("pais").locatedBy("//*[@id='country']");
   public static final Target FORMCITY=Target.the("ciudad").locatedBy("//*[@id='city']");
   public static final Target FORMCARD=Target.the("tarjeta").locatedBy("//*[@id='card']");
   public static final Target FORMMONTH=Target.the("mes").locatedBy("//*[@id='month']");
   public static final Target FORYEAR=Target.the("ano").locatedBy("//*[@id='year']");//
 //REALIZAR COMPRA
   public static final Target PURCHASE=Target.the("comprar").locatedBy("//*[contains(@onclick, 'purchaseOrder()')]");
   public static final Target FACTURE=Target.the("factura").locatedBy("//*[text()='Thank you for your purchase!']");
   public static final Target OKCOMPRA=Target.the("okcompra").locatedBy("//*[text()='OK']");
   public static final Target CLOSEFORM=Target.the("closeform").locatedBy("//*[text()='Close'])[3]");
}




