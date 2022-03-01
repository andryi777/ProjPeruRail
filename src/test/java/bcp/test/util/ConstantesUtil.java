package bcp.test.util;

public class ConstantesUtil {

	/*******************************
	 * Datos de Pasajero Adulto
	 ******************************/
	
	public static String nomAdulto = "Christian";
	public static String apeAdulto = "Maury";
	public static String fecNacimientoAdulto = "21-08-1987";
	public static String nacionalidadAdulto = "Peru";
	public static String tipoDocumentoAdulto = "Identification Card";
//	public static String nroDocAdulto = "43585211";
	public static String sexoAdulto = "Male";
	public static String telefonoAdulto = "987987987";
	public static String correoAdulto = "test@test.com";


	/*******************************
	 * Datos de Pasajero Nino
	 ******************************/
	
	public static String nomNino = "Andrea";
	public static String apeNino = "Perez";
	public static String fecNacimientoNino = "10-09-2010";
	public static String nacionalidadNino = "Peru";
	public static String tipoDocumentoNino = "Identification Card";
	public static String nroDocNino = "76543210";
	public static String sexNino = "Female";


	/*******************************
	 * Datos de Tarjeta Credito
	 ******************************/
									   
	public static String nroTarjeta = "4111111111111111";
	public static String mesVencimiento = "12";
	public static String anioVencimiento = "24";
	public static String codigoSeguridad = "741";
	public static String nombreTarjeta = "Juan Perez";



	/*******************************
	 * Obtener nombre de mes por nro de Mes
	 ******************************/
	
	public static String mesAbreviado = "";
	public static String mesCompleto = "";
	
	public static void setNombreMes(String nroMes) {
		switch (nroMes) {
            case "01":
            	mesAbreviado="Jan";
            	mesCompleto="January";
            	break;
            case "02":
            	mesAbreviado="Feb";
            	mesCompleto="February";
                break;
            case "03":
            	mesAbreviado="Mar";
            	mesCompleto="March";
                break;
            case "04":
            	mesAbreviado="Apr";
            	mesCompleto="April";
                break;
            case "05":
            	mesAbreviado="May";
            	mesCompleto="May";
                break;
            case "06":
            	mesAbreviado="Jun";
            	mesCompleto="June";
                break;
            case "07":
            	mesAbreviado="Jul";
            	mesCompleto="July";
                break;
            case "08":
            	mesAbreviado="Aug";
            	mesCompleto="August";
                break;
            case "09":
            	mesAbreviado="Sep";
            	mesCompleto="September";
                break;
            case "10":
            	mesAbreviado="Oct";
            	mesCompleto="October";
                break;
            case "11":
            	mesAbreviado="Nov";
            	mesCompleto="November";
                break;
            case "12":
            	mesAbreviado="Dec";
            	mesCompleto="December";
                break;
        }
	}
	
}
