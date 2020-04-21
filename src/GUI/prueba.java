/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Luis
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Calendar cal = new GregorianCalendar();
       Calendar cal2 = Calendar.getInstance();
       int anio=cal.get(Calendar.YEAR);
       int dia=cal.get(Calendar.DAY_OF_MONTH);
       int mes=cal.get(Calendar.MONTH);
       int hora=cal.get(Calendar.HOUR);
       int minuto=cal.get(Calendar.MINUTE);
       int segundo=cal.get(Calendar.SECOND);
        System.out.println(anio+"-"+dia+"-"+mes+"   "+hora+":"+minuto+":"+segundo);
        System.out.println(cal2.getTime());
      
    }
    
}
