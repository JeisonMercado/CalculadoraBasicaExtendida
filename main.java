import caculadorabasicaextendida.Calculadora;
import caculadorabasicaextendida.ConversorTemperatura;
import caculadorabasicaextendida.Raizcuadrada_Exponente;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Main
 * ----------
 * Ventana principal de la aplicación. Tiene 3 pestañas:
 *   1. Calculadora (suma, resta, multiplicación, división)
 *   2. Conversor de temperatura (Fahrenheit <-> Celsius)
 *   3. Raíz cuadrada y exponente
 *
 * Esta clase implementa ActionListener directamente, así que todos
 * los botones se manejan en un solo método: actionPerformed().
 * Ahí se revisa, con "if / else if", cuál botón fue presionado.
 *
 * @author Asignacion1
 */
public class main implements ActionListener {

    // Objetos que contienen la lógica (uno por cada clase de operaciones)
    private Calculadora calculadora = new Calculadora();
    private ConversorTemperatura conversor = new ConversorTemperatura();
    private Raizcuadrada_Exponente raizExp = new Raizcuadrada_Exponente();

    // --- Componentes de la pestaña Calculadora ---
    private JTextField campoNum1;
    private JTextField campoNum2;
    private JTextField campoResultado;
    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;

    // --- Componentes de la pestaña Conversor ---
    private JTextField campoTemperatura;
    private JTextField campoResultadoConversor;
    private JButton botonFaC;
    private JButton botonCaF;

    // --- Componentes de la pestaña Raíz y Exponente ---
    private JTextField campoRaiz;
    private JTextField campoResultadoRaiz;
    private JButton botonRaiz;
    private JTextField campoBase;
    private JTextField campoExponente;
    private JTextField campoResultadoExp;
    private JButton botonExponente;

    /**
     * Método principal: crea el objeto Main y arranca la ventana.
     */
    public static void main(String[] args) {
        main aplicacion = new main();
        aplicacion.iniciar();
    }

    /**
     * Construye la ventana con las 3 pestañas y la muestra en pantalla.
     */
    public void iniciar() {
        JFrame ventana = new JFrame("Calculadora y Conversor de Temperatura");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(350, 400);
        ventana.setLocationRelativeTo(null);

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.addTab("Calculadora", crearPanelCalculadora());
        pestañas.addTab("Conversor", crearPanelConversor());
        pestañas.addTab("Raiz y Exponente", crearPanelRaizExponente());

        ventana.add(pestañas);
        ventana.setVisible(true);
    }

    /**
     * Crea el panel de la calculadora (suma, resta, multiplicación, división).
     * Se usa un GridLayout simple: una columna, un componente debajo de otro.
     */
    private JPanel crearPanelCalculadora() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        panel.add(new JLabel("Número 1:"));
        campoNum1 = new JTextField();
        panel.add(campoNum1);

        panel.add(new JLabel("Número 2:"));
        campoNum2 = new JTextField();
        panel.add(campoNum2);

        botonSumar = new JButton("Sumar (+)");
        botonSumar.addActionListener(this);
        panel.add(botonSumar);

        botonRestar = new JButton("Restar (-)");
        botonRestar.addActionListener(this);
        panel.add(botonRestar);

        botonMultiplicar = new JButton("Multiplicar (x)");
        botonMultiplicar.addActionListener(this);
        panel.add(botonMultiplicar);

        botonDividir = new JButton("Dividir (/)");
        botonDividir.addActionListener(this);
        panel.add(botonDividir);

        panel.add(new JLabel("Resultado:"));
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        panel.add(campoResultado);

        return panel;
    }

    /**
     * Crea el panel del conversor de temperatura.
     */
    private JPanel crearPanelConversor() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        panel.add(new JLabel("Temperatura:"));
        campoTemperatura = new JTextField();
        panel.add(campoTemperatura);

        botonFaC = new JButton("Fahrenheit a Celsius");
        botonFaC.addActionListener(this);
        panel.add(botonFaC);

        botonCaF = new JButton("Celsius a Fahrenheit");
        botonCaF.addActionListener(this);
        panel.add(botonCaF);

        panel.add(new JLabel("Resultado:"));
        campoResultadoConversor = new JTextField();
        campoResultadoConversor.setEditable(false);
        panel.add(campoResultadoConversor);

        return panel;
    }

    /**
     * Crea el panel de raíz cuadrada y exponente.
     */
    private JPanel crearPanelRaizExponente() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        panel.add(new JLabel("Número:"));
        campoRaiz = new JTextField();
        panel.add(campoRaiz);

        botonRaiz = new JButton("Calcular raíz cuadrada");
        botonRaiz.addActionListener(this);
        panel.add(botonRaiz);

        panel.add(new JLabel("Resultado raíz:"));
        campoResultadoRaiz = new JTextField();
        campoResultadoRaiz.setEditable(false);
        panel.add(campoResultadoRaiz);

        panel.add(new JLabel("Base:"));
        campoBase = new JTextField();
        panel.add(campoBase);

        panel.add(new JLabel("Exponente:"));
        campoExponente = new JTextField();
        panel.add(campoExponente);

        botonExponente = new JButton("Calcular potencia");
        botonExponente.addActionListener(this);
        panel.add(botonExponente);

        panel.add(new JLabel("Resultado potencia:"));
        campoResultadoExp = new JTextField();
        campoResultadoExp.setEditable(false);
        panel.add(campoResultadoExp);

        return panel;
    }

    /**
     * Este método se ejecuta cada vez que se presiona cualquier botón
     * de la aplicación. Usamos "if / else if" para saber cuál botón fue.
     */
    public void actionPerformed(ActionEvent e) {

        // ---------- Botones de la calculadora ----------
        if (e.getSource() == botonSumar) {
            try {
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                double resultado = calculadora.sumar(num1, num2);
                campoResultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese números válidos.");
            }

        } else if (e.getSource() == botonRestar) {
            try {
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                double resultado = calculadora.restar(num1, num2);
                campoResultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese números válidos.");
            }

        } else if (e.getSource() == botonMultiplicar) {
            try {
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                double resultado = calculadora.multiplicar(num1, num2);
                campoResultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese números válidos.");
            }

        } else if (e.getSource() == botonDividir) {
            try {
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                double resultado = calculadora.dividir(num1, num2);
                campoResultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese números válidos.");
            } catch (ArithmeticException ex) {
                // Aquí se muestra el mensaje de error de división entre cero
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        // ---------- Botones del conversor de temperatura ----------
        } else if (e.getSource() == botonFaC) {
            try {
                double fahrenheit = Double.parseDouble(campoTemperatura.getText());
                double celsius = conversor.fahrenheitACelsius(fahrenheit);
                campoResultadoConversor.setText(celsius + " °C");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }

        } else if (e.getSource() == botonCaF) {
            try {
                double celsius = Double.parseDouble(campoTemperatura.getText());
                double fahrenheit = conversor.celsiusAFahrenheit(celsius);
                campoResultadoConversor.setText(fahrenheit + " °F");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }

        // ---------- Botones de raíz cuadrada y exponente ----------
        } else if (e.getSource() == botonRaiz) {
            try {
                double numero = Double.parseDouble(campoRaiz.getText());
                double resultado = raizExp.raizCuadrada(numero);
                campoResultadoRaiz.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else if (e.getSource() == botonExponente) {
            try {
                double base = Double.parseDouble(campoBase.getText());
                double exponente = Double.parseDouble(campoExponente.getText());
                double resultado = raizExp.calcularExponente(base, exponente);
                campoResultadoExp.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese números válidos.");
            }
        }
    }
}
