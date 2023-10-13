package co.com.choucair.certificacion.retoautomatizacion.utils;

public class Sleep {

    public static void sleep(int segundos){

        int milisegundos=((segundos * 1000));
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
