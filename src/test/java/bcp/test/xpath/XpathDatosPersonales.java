package bcp.test.xpath;

public class XpathDatosPersonales {

	private static XpathDatosPersonales obj = null;

	private XpathDatosPersonales() {
	}

	public static XpathDatosPersonales getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XpathDatosPersonales();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/***************************************************
	 * XPath Belmond
	 ***************************************************/

	public String getXpathPasajeroxCabina(int numCabina, String tipoPasajero) {
		final String lblPasajero = "//*[contains(text(),'CABIN" + numCabina
				+ "')]/ following :: div[1]//*[contains(text(),'PASSENGER " + tipoPasajero + "')]";
		return lblPasajero;
	}

	public String lstCabina(int nroCabina) {
		final String lblCabina = "//*[contains(text(),'CABIN" + nroCabina + "')]";
		return lblCabina;

	}

	public String lstPasajeroxCabina(int nroCabina, int nroPasajero) {
		final String lstPasejeroxCabina = "//*[contains(text(),'CABIN" + nroCabina
				+ "')]/ following :: div[1]//*[contains(text(),'PASSENGER " + nroPasajero + "')]";
		return lstPasejeroxCabina;
	}

	public String txtPrimerNombre(int nroCabina, int nroPasajero) {
		final String txtprimerNombre = "//input[@name='txt_nombre[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return txtprimerNombre;
	}

	public String txtApellido(int nroCabina, int nroPasajero) {
		final String txtApellido = "//input[@name='txt_apellido[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return txtApellido;
	}

	public String txtFecNacimiento(int nroCabina, int nroPasajero) {
		final String txtFecNacimiento = "//input[@name='txt_fecha_nacimiento[suite][cab" + nroCabina + "]["
				+ nroPasajero + "]']";
		return txtFecNacimiento;
	}

	public final String cboAnioNacimiento = "//*[@class='ui-datepicker-year']";
	public final String cboMesNacimiento = "//*[@class='ui-datepicker-month']";

	public String cboNacionalidad(int nroCabina, int nroPasajero) {
		final String cboNacionalidad = "//select[@name='sel_nacion[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return cboNacionalidad;
	}

	public String cboTipoDocumento(int nroCabina, int nroPasajero) {
		final String cboTipoDocumento = "//select[@name='sel_tpdoc[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return cboTipoDocumento;
	}

	public String txtNroDocumento(int nroCabina, int nroPasajero) {
		final String txtNroDocumento = "//input[@name='txt_nroid[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return txtNroDocumento;
	}

	public String cboSexo(int nroCabina, int nroPasajero) {
		final String cboSexo = "//select[@name='sel_sexo[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return cboSexo;
	}

	public String txtTelefono(int nroCabina, int nroPasajero) {
		final String txtTelefono = "//input[@name='txt_telefono[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return txtTelefono;
	}

	public String txtCorreo(int nroCabina, int nroPasajero) {
		final String txtCorreo = "//input[@name='txt_mail[suite][cab" + nroCabina + "][" + nroPasajero + "]']";
		return txtCorreo;
	}

	public String txtCorreoConfirmacion(int nroCabina, int nroPasajero) {
		final String txtCorreoConfirmacion = "//input[@name='txt_mail_conf[suite][cab" + nroCabina + "][" + nroPasajero
				+ "]']";
		return txtCorreoConfirmacion;
	}

	public String lblDia(int dia) {
		final String lblDia = "//*[@class='ui-state-default' and text()='" + dia + "']";
		return lblDia;

	}

	public final String lstAnoNac = "//*[@class='ui-datepicker-year']";
	public final String lstMesNac = "//*[@class='ui-datepicker-month']";

	public final String btnContinuar = "//button[text()='  Continue']";

	/***************************************************
	 * XPath Expedition
	 ***************************************************/

	public String lstPasajeroxCabinaExp(int nroPasajero) {
		final String lstPasejeroxCabina = "//*[@class='content-pasajero oculto divPasajero'][" + nroPasajero + "]";
		return lstPasejeroxCabina;
	}

	public String txtPrimerNombreExp(int numPasajero) {
		final String txtPrimerNombreExp = "//input[@id='formPasajero" + numPasajero
				+ "-nomPasajero' and contains(text(),'Name')]";
		return txtPrimerNombreExp;
	}

	public String txtApellidoExp(int numPasajero) {
		final String txtApellidoExp = "//input[@id='formPasajero" + numPasajero
				+ "-apePasajero' and contains(text(),'Surname')]";
		return txtApellidoExp;
	}

	public String txtFechaNacimientoExp(int numPasajero) {
		final String txtFechaNacimientoExp = "//input[@id='formPasajero" + numPasajero
				+ "-fecNacimiento' and contains(text(),'Date of Birth')]";
		return txtFechaNacimientoExp;
	}

	public String txtDiaNacimientoExp(int dia) {
		final String txtDiaNacimientoExp = "//*[@href=\"javascript:js_calendario_asignar_fecha('5');\"]";
		return txtDiaNacimientoExp;
	}

	public final String lstAnoNacExp = "//select[@id='calendario_anio']";
	public final String lstMesNacExp = "//select[@id='calendario_mes']";

	public String cboNacionalidadExp(int numPasajero) {
		final String cboNacionalidadExp = "//select[@id='formPasajero" + numPasajero + "-idPais']";
		return cboNacionalidadExp;
	}

	public String cboTipoDocumentoExp(int numPasajero) {
		final String cboTipoDocumentoExp = "//select[@id='formPasajero" + numPasajero + "-idDocumentoIdentidad']";
		return cboTipoDocumentoExp;
	}

	public String txtNroDocumentoExp(int numPasajero) {

		final String txtNroDocumentoExp = "//input[@id='formPasajero" + numPasajero + "-numDocumentoIdentidad']";
		return txtNroDocumentoExp;
	}

	public String cboSexoExp(int numPasajero) {
		final String cboSexoExp = "//select[@id='formPasajero" + numPasajero + "-idSexo']";
		return cboSexoExp;
	}

	public String txtTelefonoExp(int numPasajero) {
		final String txtTelefonoExp = "//input[@id='formPasajero" + numPasajero + "-numTelefono']";
		return txtTelefonoExp;
	}

	public String txtCorreoExp(int numPasajero) {
		final String txtCorreoExp = "//input[@id='formPasajero" + numPasajero + "-desEmail']";
		return txtCorreoExp;
	}

	public String txtCorreoConfirmacionExp(int numPasajero) {
		final String txtCorreoConfirmacionExp = "//input[@id='formPasajero" + numPasajero + "-desEmailConfirmacion']";
		return txtCorreoConfirmacionExp;
	}

	public final String btnContinuarExp = "//input[@value='Continue']";

}
