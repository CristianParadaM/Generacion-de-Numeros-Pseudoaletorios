package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

import model.Congruencial;
import model.DistribucionNormal;
import model.DistribucionUniforme;
import model.Minimos_Cuadrados;
import view.JFrameMain;
import view.utils.Constants;

/**
 * 
 * Clase que se se encarga de la coordinacion entre el modelo y la vista
 * 
 * @author Cristian David Parada Martinez, Daniel Felipe Suarez Bohorquez
 *         ,Julian Steven Huertas Henao
 */
public class Controller implements ActionListener {

    private JFrameMain view;
    private Minimos_Cuadrados minimos_Cuadrados;
    private static Controller controller = null;
    private ArrayList<Object[]> info;
    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private String[] columNames;

    /*
     * metodo que se encarga de obtener una nueva instancia de la clase controller
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /*
     * metodo que inicializa la vista
     */
    public void initApp() {
        view = JFrameMain.getInstance();
        view.init();
    }

    /**
     * metodo main de la aplicacion
     * 
     * @param args
     */
    public static void main(String[] args) {
        Controller.getInstance().initApp();
    }

    /**
     * Metodo se usa para detectar y manejar eventos,
     * los cuales tienen lugar cuando se produce una acción sobre un elemento del
     * programa,
     * en este caso, establece que generacion de metodo se realizará.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constants.COMMAND_GENERATE_METHOD_ONE -> generateMethodOne();
            case Constants.COMMAND_GENERATE_CONGR_M1 -> generateMethodTwoM1();
            case Constants.COMMAND_GENERATE_CONGR_M2 -> generateMethodOneM2();
            case Constants.COMMAND_GENERATE_METHOD_ONE_U -> generateMethodOneU();
            case Constants.COMMAND_GENERATE_CONGR_U_M1 -> generateCongrUM1();
            case Constants.COMMAND_GENERATE_CONGR_U_M2 -> generateCongrUM2();
            case Constants.COMMAND_GENERATE_METHOD_ONE_NOR -> generateMediosNormal();
            case Constants.COMMAND_GENERATE_CONGR_N_M1 -> generateCongr1Normal();
            case Constants.COMMAND_GENERATE_CONGR_N_M2 -> generateCongr2Normal();
        }
    }

    /**
     * Metodo que se encarga de generar numeros pseudo aleatorios congruenciales
     * multiplicativos que siguen la distribuicion mormal.
     */
    private void generateCongr1Normal() {
        try {
            int mean = Integer.parseInt(view.getMean());
            int sd = Integer.parseInt(view.getSD());
            int t = Integer.parseInt(view.getTN());
            int g = Integer.parseInt(view.getGN2());

            if (g > t) {
                Congruencial congruencial = new Congruencial(t, g);
                DistribucionNormal distribucionNormal = new DistribucionNormal(mean, sd, congruencial.getRi());
                columNames = new String[] { "i", "xi", "Ri", "Ni" };
                info = new ArrayList<Object[]>();
                merge(info, congruencial.congruenciaMultiplicativo(), distribucionNormal.generateNi(), false);
                LinkedHashMap<String, Integer> map = distribucionNormal.calculateFrequencies();
                x = new ArrayList<Double>();
                y = new ArrayList<Double>();
                convert(x, map, true);
                convert(y, map, false);
                view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
            } else {
                view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo que se encarga de generar numeros pseudo aleatorios congruenciales
     * lineales que siguen la distribuicion mormal.
     */
    private void generateCongr2Normal() {
        try {
            int mean = Integer.parseInt(view.getMean());
            int sd = Integer.parseInt(view.getSD());
            int k = Integer.parseInt(view.getKN());
            int c = Integer.parseInt(view.getCN());
            int g = Integer.parseInt(view.getGN1());

            if (c % 2 != 0) {
                if (g > k && g > c) {
                    Congruencial congruencial = new Congruencial(k, c, g);
                    DistribucionNormal distribucionNormal = new DistribucionNormal(mean, sd, congruencial.getRi());
                    columNames = new String[] { "i", "xi", "Ri", "Ni" };
                    info = new ArrayList<Object[]>();
                    merge(info, congruencial.congruenciaLineal(), distribucionNormal.generateNi(), false);
                    LinkedHashMap<String, Integer> map = distribucionNormal.calculateFrequencies();
                    x = new ArrayList<Double>();
                    y = new ArrayList<Double>();
                    convert(x, map, true);
                    convert(y, map, false);
                    view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
                } else {
                    view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                view.alert(Constants.ERROR_IMPAR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * metodo que genera numeros pseudo aleatorios que siguen la distribucion
     * normal en un rango de valores por medio del metodo de cuadrados medios
     */
    private void generateMediosNormal() {
        try {
            int mean = Integer.parseInt(view.getMean());
            int sd = Integer.parseInt(view.getSD());
            int seed = Integer.parseInt(view.getSeedN());
            boolean fill = view.getFillN();
            if (seed + "".length() > 3) {

                Minimos_Cuadrados cuadrados = new Minimos_Cuadrados(seed, fill);
                DistribucionNormal distribucionNormal = new DistribucionNormal(mean, sd, cuadrados.getRi());
                columNames = new String[] { "i", "Xi", "Xi^2", "Dig.", "Extraccion", "Ri", "Ni" };
                info = new ArrayList<Object[]>();
                merge(info, cuadrados.generateNumbers(), distribucionNormal.generateNi(), true);
                LinkedHashMap<String, Integer> map = distribucionNormal.calculateFrequencies();
                x = new ArrayList<Double>();
                y = new ArrayList<Double>();
                convert(x, map, true);
                convert(y, map, false);
                view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);

            } else {
                view.alert(Constants.ERROR_SEED, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * metodo que genera numeros pseudo aleatorios que siguen la distribucion
     * uniforme en un rango de valores por medio del metodo congruencial lineal
     */
    private void generateCongrUM1() {
        try {
            int min = Integer.parseInt(view.getMinU());
            int max = Integer.parseInt(view.getMaxU());
            int k = Integer.parseInt(view.getKU());
            int c = Integer.parseInt(view.getCU());
            int g = Integer.parseInt(view.getGU1());

            if (min < max) {
                if (min != max) {
                    if (c % 2 != 0) {
                        if (g > k && g > c) {
                            Congruencial congruencial = new Congruencial(k, c, g);
                            DistribucionUniforme distribucionUniforme = new DistribucionUniforme(min, max,
                                    congruencial.getRi());
                            columNames = new String[] { "i", "xi", "Ri", "Ni" };
                            info = new ArrayList<Object[]>();
                            merge(info, congruencial.congruenciaLineal(),
                                    distribucionUniforme.generatePseudorandomNumbers(), false);
                            LinkedHashMap<String, Integer> map = distribucionUniforme.calculateFrequencies();
                            x = new ArrayList<Double>();
                            y = new ArrayList<Double>();
                            convert(x, map, true);
                            convert(y, map, false);
                            view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
                        } else {
                            view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        view.alert(Constants.ERROR_IMPAR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * metodo que genera numeros pseudo aleatorios que siguen la distribucion
     * uniforme en un rango de valores por medio del metodo congruencial
     * multiplicativo
     */
    private void generateCongrUM2() {
        try {
            int min = Integer.parseInt(view.getMinU());
            int max = Integer.parseInt(view.getMaxU());
            int t = Integer.parseInt(view.getTU());
            int g = Integer.parseInt(view.getGU2());

            if (min < max) {
                if (min != max) {
                    if (g > t) {
                        Congruencial congruencial = new Congruencial(t, g);
                        DistribucionUniforme distribucionUniforme = new DistribucionUniforme(min, max,
                                congruencial.getRi());
                        columNames = new String[] { "i", "xi", "Ri", "Ni" };
                        info = new ArrayList<Object[]>();
                        merge(info, congruencial.congruenciaMultiplicativo(),
                                distribucionUniforme.generatePseudorandomNumbers(), false);
                        LinkedHashMap<String, Integer> map = distribucionUniforme.calculateFrequencies();
                        x = new ArrayList<Double>();
                        y = new ArrayList<Double>();
                        convert(x, map, true);
                        convert(y, map, false);
                        view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
                    } else {
                        view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * metodo que genera numeros pseudo aleatorios que siguen la distribucion
     * uniforme en un rango de valores por medio del metodo de cuadrados medios
     */
    private void generateMethodOneU() {
        try {
            int min = Integer.parseInt(view.getMinU());
            int max = Integer.parseInt(view.getMaxU());
            int seed = Integer.parseInt(view.getSeedU());
            boolean fill = view.getFillU();
            if (min < max) {
                if (min != max) {
                    if (seed + "".length() > 3) {
                        Minimos_Cuadrados cuadrados = new Minimos_Cuadrados(seed, fill);
                        DistribucionUniforme distribucionUniforme = new DistribucionUniforme(min, max,
                                cuadrados.getRi());
                        columNames = new String[] { "i", "Xi", "Xi^2", "Dig.", "Extraccion", "Ri", "Ni" };
                        ArrayList<Object[]> info = new ArrayList<Object[]>();
                        merge(info, cuadrados.generateNumbers(), distribucionUniforme.generatePseudorandomNumbers(),
                                true);
                        LinkedHashMap<String, Integer> map = distribucionUniforme.calculateFrequencies();
                        x = new ArrayList<Double>();
                        y = new ArrayList<Double>();
                        convert(x, map, true);
                        convert(y, map, false);
                        view.showMethod(Constants.METHOD_TWO, info, columNames, x, y);
                    } else {
                        view.alert(Constants.ERROR_SEED, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    view.alert(Constants.ERROR_MIN_MAX_I, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                view.alert(Constants.ERROR_MIN_MAX, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convert(ArrayList<Double> x2, LinkedHashMap<String, Integer> map, boolean b) {
        map.forEach((k, v) -> {
            if (b) {
                x2.add(Double.parseDouble(k.split("-")[1]));
            } else {
                x2.add((double) v);
            }
        });
    }

    private void merge(ArrayList<Object[]> info2, ArrayList<Object[]> generateNumbers,
            double[] generatePseudorandomNumbers, boolean b) {
        Object[] aux = null;
        for (int i = 0; i < generatePseudorandomNumbers.length; i++) {
            Object[] numbers = generateNumbers.get(i);
            if (b) {
                aux = new Object[] { numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5],
                        generatePseudorandomNumbers[i] };
            } else {
                aux = new Object[] { numbers[0], numbers[1], numbers[2], generatePseudorandomNumbers[i] };
            }
            info2.add(aux);
        }
    }

    /*
     * Metodo que se encarga de generar numeros pseudo aleatorios congruenciales
     * lineales
     */
    private void generateMethodTwoM1() {
        try {
            int k = Integer.parseInt(view.getKM1());
            int c = Integer.parseInt(view.getCM1());
            int g = Integer.parseInt(view.getGM1());

            if (c % 2 != 0) {
                view.highlightM2M1(1, 0);
                if (g > k && g > c) {
                    view.highlightM2M1(0, 0);
                    view.highlightM2M1(1, 0);
                    view.highlightM2M1(2, 0);
                    view.highlightM2M1(3, 0);
                    view.highlightM2M1(4, 0);
                    Congruencial congruencial = new Congruencial(k, c, g);
                    ArrayList<Object[]> info = congruencial.congruenciaLineal();
                    columNames = new String[] { "i", "xi", "Ri" };
                    view.showMethod(Constants.METHOD_ONE, info, columNames, x, y);
                } else {
                    view.highlightM2M1(0, 1);
                    view.highlightM2M1(1, 1);
                    view.highlightM2M1(2, 1);
                    view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                view.highlightM2M1(1, 1);
                view.alert(Constants.ERROR_IMPAR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.highlightM2M1(0, 1);
            view.highlightM2M1(1, 1);
            view.highlightM2M1(2, 1);
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Metodo que se encarga de generar numeros pseudo aleatorios congruenciales
     * multiplicativos
     */
    private void generateMethodOneM2() {
        try {
            int t = Integer.parseInt(view.getTM2());
            int g = Integer.parseInt(view.getGM2());
            if (g > t) {
                view.highlightM2M2(0, 0);
                view.highlightM2M2(1, 0);
                view.highlightM2M2(2, 0);
                view.highlightM2M2(3, 0);
                Congruencial congruencial = new Congruencial(t, g);
                ArrayList<Object[]> info = congruencial.congruenciaMultiplicativo();
                columNames = new String[] { "i", "xi", "Ri" };
                view.showMethod(Constants.METHOD_ONE, info, columNames, x, y);
            } else {
                view.highlightM2M2(0, 1);
                view.highlightM2M2(1, 1);
                view.alert(Constants.ERROR_G, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            view.highlightM2M2(0, 1);
            view.highlightM2M2(1, 1);
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo de generacion de numeros pseudo aleatorios por medio del metodo de
     * cuadrados medios.
     */
    private void generateMethodOne() {
        try {
            int seed = Integer.parseInt(view.getSeed());
            boolean fill = view.getFill();
            if (seed + "".length() > 3 && seed % 2 == 0) {
                view.highlightM1(0, 0);
                view.highlightM1(1, 0);
                view.highlightM1(2, 0);
                minimos_Cuadrados = new Minimos_Cuadrados(seed, fill);
                columNames = new String[] { "i", "Xi", "Xi^2", "Dig.", "Extraccion", "Ri" };
                view.showMethod(Constants.METHOD_ONE, minimos_Cuadrados.generateNumbers(), columNames, x, y);
            } else {
                view.highlightM1(0, 1);
                view.alert(Constants.ERROR_SEED, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            view.highlightM1(0, 1);
            view.alert(Constants.ERROR_EMPTY_TEXT, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }

    }
}
