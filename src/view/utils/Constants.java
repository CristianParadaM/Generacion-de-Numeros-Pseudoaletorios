package view.utils;

import java.awt.Color;

import view.JFrameMain;

public class Constants {
	// COMMANDS
	public static final String COMMAND_SWITCH_METHOD_ONE = "COMMAND_SWITCH_METHOD_ONE";
	public static final String COMMAND_SWITCH_METHOD_TWO = "COMMAND_SWITCH_METHOD_TWO";
	public static final String COMMAND_SWITCH_METHOD_THREE = "COMMAND_SWITCH_METHOD_THREE";
	public static final String COMMAND_SWITCH_METHOD_FOUR = "COMMAND_SWITCH_METHOD_FOUR";
	
	public static final String COMMAND_GENERATE_METHOD_ONE = "COMMAND_GENERATE_METHOD_ONE";
	
	public static final String COMMAND_GENERATE_CONGR_M1 = "COMMAND_GENERATE_CONGR_M1";
	public static final String COMMAND_GENERATE_CONGR_M2 = "COMMAND_GENERATE_CONGR_M2";
	
	public static final String COMMAND_ACCORDION_CONGR_M1 = "COMMAND_ACCORDION_CONGR_M1";
	public static final String COMMAND_ACCORDION_CONGR_M2 = "COMMAND_ACCORDION_CONGR_M2";
	
	public static final String COMMAND_ACCORDION_UNI_M1 = "COMMAND_ACCORDION_UNI_M1";
	public static final String COMMAND_ACCORDION_UNI_M2 = "COMMAND_ACCORDION_UNI_M2";
	
	public static final String COMMAND_ACCORDION_UNI_C_M1 = "COMMAND_ACCORDION_UNI_C_M1";
	public static final String COMMAND_ACCORDION_UNI_C_M2 = "COMMAND_ACCORDION_UNI_C_M2";
	
	public static final String COMMAND_GENERATE_METHOD_ONE_U = "COMMAND_GENERATE_METHOD_ONE_U";
	
	public static final String COMMAND_GENERATE_CONGR_U_M1 = "COMMAND_GENERATE_CONGR_U_M1";
	public static final String COMMAND_GENERATE_CONGR_U_M2 = "COMMAND_GENERATE_CONGR_U_M2";
	
	//NORM
	
	public static final String COMMAND_ACCORDION_NOR_M1 = "COMMAND_ACCORDION_NOR_M1";
	public static final String COMMAND_ACCORDION_NOR_M2 = "COMMAND_ACCORDION_NOR_M2";
	
	public static final String COMMAND_ACCORDION_NOR_C_M1 = "COMMAND_ACCORDION_NOR_C_M1";
	public static final String COMMAND_ACCORDION_NOR_C_M2 = "COMMAND_ACCORDION_NOR_C_M2";
	
	public static final String COMMAND_GENERATE_METHOD_ONE_NOR = "COMMAND_GENERATE_METHOD_ONE_NOR";
	
	public static final String COMMAND_GENERATE_CONGR_N_M1 = "COMMAND_GENERATE_CONGR_N_M1";
	public static final String COMMAND_GENERATE_CONGR_N_M2 = "COMMAND_GENERATE_CONGR_N_M2";
	
	// TEXT
	public static final String METHOD_ONE = "Cuadrados Medios";
	public static final String METHOD_TWO = "Congruenciales";
	public static final String VERSION = "Version 1.0";
	public static final String METHOD_THREE = "Distribucion Uniforme";
	public static final String METHOD_FOUR = "Distribucion Normal";
	public static final String GENERATE = "Generar";
	public static final String ENTRIES = "Entradas";
	public static final String INITIAL_SEED = "Semilla inicial";
	public static final String RANGE_MIN = "Rango minimo";
	public static final String RANGE_MAX = "Rango maximo";
	public static final String AUTOFILL = "Autollenado";
	public static final String RADIO_BUTTON_IZQ = "Por izquierda";
	public static final String RADIO_BUTTON_DER = "Por derecha";
	public static final String CONGRUENCIAL_MULTIPLICATIVO = "Congruencial Multiplicativo";
	public static final String CONGRUENCIAL_LINEAL = "Congruencial Lineal";
	public static final String GRAPHIC = "Grafica Generada";
	public static final String NUMBER_G = "Numero g:";
	public static final String NUMBER_C = "Numero c:";
	public static final String NUMBER_K = "Numero k:";
	public static final String NUMBER_T = "Numero t:";
	public static final String NUMEROS_PSEUDO_ALEATORIOS_GENERADOS = "Numeros Pseudo-Aleatorios Generados";
	public static final String MAIN_MENU = "Menu Principal";
	public static final String CHOOSE_OPTION = "A continuacion elija cualquiera de las opciones que se le presentan arriba, que lo llevaran a cada uno de los diferentes metodos de generacion de numeros pseudoaleatorios :)";
	public static final String TITLE_CONGR = "A continuacion elija por cual metodo generar los numeros pseudoaleatorios:";
	public static final String MEAN = "Media:";
	public static final String SD = "Desviacion estandar:";
	
	//ERRORS
	public static final String ERROR = "Error";
	public static final String ERROR_SEED = "El numero semilla debe ser par y mayor a 3 digitos";
	public static final String ERROR_EMPTY_TEXT = "No puede haber campos vacios";
	public static final String ERROR_MIN_MAX_I = "El minimo no puede ser igual al maximo";
	public static final String ERROR_MIN_MAX = "El minimo no puede ser mayor al maximo";
	public static final String ERROR_IMPAR = "El numero c debe ser impar";
	public static final String ERROR_G = "El numero g debe ser mayor a k y c";

	// PLACEHOLDER
	public static final String PLACEHOLDER_SEED = "Numero par - mayor a 3 digitos";
	public static final String PLACEHOLDER_RANGE_MIN = "Digite el rango minimo";
	public static final String PLACEHOLDER_RANGE_MAX = "Digite el rango maximo";
	public static final String PLACEHOLDER_NUMERO_G = "Numero entero mayor a k y c";
	public static final String PLACEHOLDER_NUMERO_C = "Numero enterio positivo impar";
	public static final String PLACEHOLDER_NUMERO_K = "Numero entero positivo";
	public static final String PLACEHOLDER_MEAN = "Digite la media";
	public static final String PLACEHOLDER_SD = "Digite la desviacion estandar";

	// FONT
	public static final String FONT_APP = "Calibri (Cuerpo)";
	public static final int FONT_SIZE_APP_BUTTONS = 12 * JFrameMain.WIDTH_FRAME / 1920;
	public static final int FONT_SIZE_APP_TITLES = 25 * JFrameMain.WIDTH_FRAME / 1920;
	public static final int FONT_SIZE_APP_LABELS = 18 * JFrameMain.WIDTH_FRAME / 1920;
	public static final int FONT_SIZE_APP_PLACEHOLDER = 15 * JFrameMain.WIDTH_FRAME / 1920;

	// COLORS
	public static final Color COLOR_BACKGROUND_GRADIENT_ONE = new Color(57, 55, 55);
	public static final Color COLOR_BACKGROUND_GRADIENT_TWO = new Color(118, 113, 113);
	public static final Color COLOR_BACKGROUND_CONTENT = new Color(59, 56, 56);
	public static final Color COLOR_BUTTONS_METHODS = new Color(88, 84, 84);
	public static final Color COLOR_BUTTONS_METHODS_HOVER = new Color(38, 38, 38);
	public static final Color COLOR_BORDER = new Color(175, 171, 171);

	//PATHS
	public static final String PATH_IMG_LOGO = "/res/logoinicio.png";
	
}
