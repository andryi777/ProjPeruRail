package bcp.test.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import net.serenitybdd.core.annotations.findby.By;

public class GeneralUtil {


    // singleton
    private static GeneralUtil obj = null;

    public GeneralUtil() {
    }

    public static GeneralUtil getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new GeneralUtil();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    // singleton

    public String fechaAgregarTiempo(String fecha, String formato, int cale, int cant) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
            Date date = simpleDateFormat.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(cale, cant);
            date = calendar.getTime();
            fecha = simpleDateFormat.format(date);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return fecha;
    }

    public String concatenarFechaHora(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        string += " " + simpleDateFormat.format(new Date());

        return string;
    }

    

    public List<List<String>> listaPosicion(List<List<String>> lista, int[] arrPos) {
        List<List<String>> listaFinal = new ArrayList<List<String>>();
        List<String> reg = null;

        for (List<String> list : lista) {
            reg = new ArrayList<String>();

            for (int i = 0; i < arrPos.length; i++) {
                reg.add(list.get(arrPos[i]));
            }

            listaFinal.add(reg);
        }

        return listaFinal;
    }

    public String numSinComa(String num) {
        num = num.replace(",", "");
        num = String.valueOf(Double.parseDouble(num));

        return num;
    }

    public String eliminaTabuladoresEspacios(String cadena) {
        return cadena.replaceAll("\\s", "");
    }

    public String fechaMesAnioActual(String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);

        return simpleDateFormat.format(new Date());
    }

    public String identificarCelda(WebElement we, int pos) {
        List<WebElement> tr = we.findElements(By.tagName("tr"));
        List<WebElement> td = tr.get(0).findElements(By.tagName("td"));
        List<WebElement> div = td.get(pos).findElements(By.tagName("div"));

        return div.get(0).getText().trim();
    }

    public String sumarDecimal(String num, double val) {
        num = num.replace(",", "");
        double d = Double.parseDouble(num);
        d += val;
        DecimalFormat df = new DecimalFormat("#0.00");
        String s = df.format(d);
        s = s.replace(",", ".");

        return s;
    }

    public List<String> buscarLista(List<List<String>> listaPrevia, List<String> data) {
        for (List<String> dataPrevia : listaPrevia) {
            if (dataPrevia.get(0).equals(data.get(0))) {
                return dataPrevia;
            }
        }

        return new ArrayList<String>();
    }

    public String reemplazar(String string, String repOld, String repNew) {
        return string.replace(repOld, repNew);
    }

  
    public String sumarAnios(String fecha, int anios) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
        fechaLocal = fechaLocal.plusYears(anios);
        return fechaLocal.format(formateador);
    }

    public String obtenerMontoFormateado(String valor) {
        String[] cadena = valor.split("\\.");
        String part1 = cadena[0];
        String part2 = cadena[1];
        String monto = "";

        if (part2.equals("00")) {
            monto = "S/ " + part1;
        } else {

            String valor1 = Character.toString(part2.charAt(0));
            String valor2 = Character.toString(part2.charAt(1));

            if (valor1 != "0" && valor2.equals("0")) {
                monto = "S/ " + part1 + "." + valor1;
            } else {
                if ((valor1.equals("0") && valor2 != "0") || (valor1 != "0" && valor2 != "0")) {
                    monto = "S/ " + valor;
                }
            }
        }
        return monto;
    }

    public double calcularMontoTarifarioBelmond(String tipoCabina, int nroPasajero) {
    	double montoTotal=0;
    	
    	switch (tipoCabina) {
		case "SUITE CABINS":
			if(nroPasajero==1) montoTotal=2415;
			if(nroPasajero==2) montoTotal=2760;
			if(nroPasajero==3) montoTotal=5175;
			if(nroPasajero==4) montoTotal=5520;
			if(nroPasajero==5) montoTotal=7935;
			if(nroPasajero==6) montoTotal=8280;
			if(nroPasajero==7) montoTotal=10695;
			if(nroPasajero==8) montoTotal=11040;
			if(nroPasajero==9) montoTotal=13455;
			return montoTotal;
	
		case "TWIN BED CABINS":
			if(nroPasajero==1) montoTotal=2154;
			if(nroPasajero==2) montoTotal=2460;
			if(nroPasajero==3) montoTotal=4614;
			if(nroPasajero==4) montoTotal=4920;
			if(nroPasajero==5) montoTotal=7074;
			if(nroPasajero==6) montoTotal=7380;
			if(nroPasajero==7) montoTotal=9534;
			if(nroPasajero==8) montoTotal=9840;
			if(nroPasajero==9) montoTotal=11994;					
			return montoTotal;
			
		case "UNK BED CABINS":
			if(nroPasajero==1) montoTotal=1944;
			if(nroPasajero==2) montoTotal=2220;
			if(nroPasajero==3) montoTotal=4164;
			if(nroPasajero==4) montoTotal=4440;
			if(nroPasajero==5) montoTotal=6384;
			if(nroPasajero==6) montoTotal=6660;
			if(nroPasajero==7) montoTotal=8604;
			if(nroPasajero==8) montoTotal=8880;
			if(nroPasajero==9) montoTotal=10824;
			return montoTotal;
		
		default:
			return montoTotal;
		}
    }
    
    public int getTotalPasajeros(String adultos, String ninos) {
    	int totalPasajeros=0;
    	String pasajeros = adultos.concat("-").concat(ninos);
    	String[] pasajero = pasajeros.split("-");
    	for(int i=0; i<pasajero.length; i++) {
    		totalPasajeros=Integer.parseInt(pasajero[i]) + totalPasajeros;
    	}
    	return totalPasajeros;
    }
    
    public double[] calcularMontoExpedition(int nroAdultos, int nroNinos, double montoIda, double montoVuelta) {
    	double montoIdaNino = Math.round(montoIda/2);
    	double montoVueltaNino = Math.round(montoVuelta/2);;
    	double totales[] = new double[2];
    	 
    	totales[0]= montoIda*nroAdultos + montoIdaNino*nroNinos;
    	totales[1]= montoVuelta*nroAdultos + montoVueltaNino*nroNinos;
    	
    	return totales;
    }
	
}

    
    


