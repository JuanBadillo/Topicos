package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuestionarioJRB extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	protected int indicePregunta = 0;
	protected String respuestaSeleccionada;
	protected int puntuacion = 0;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuestionarioJRB frame = new CuestionarioJRB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	public CuestionarioJRB() {		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 233);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPregunta = new JLabel("lblPregunta");
		lblPregunta.setBounds(10, 11, 526, 28);
		contentPane.add(lblPregunta);
		
		panel = new JPanel();
		panel.setBounds(10, 36, 283, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnIncisoD = new JRadioButton("rdbtnIncisoD");
		rdbtnIncisoD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Alamcena la respuesta seleccionada por el usuario
				respuestaSeleccionada = "D";
			}
		});
		rdbtnIncisoD.setBounds(21, 85, 265, 23);
		panel.add(rdbtnIncisoD);
		
		JRadioButton rdbtnIncisoC = new JRadioButton("rdbtnIncisoC");
		rdbtnIncisoC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Alamcena la respuesta seleccionada por el usuario
				respuestaSeleccionada = "C";
			}
		});
		rdbtnIncisoC.setBounds(21, 59, 265, 23);
		panel.add(rdbtnIncisoC);
		
		JRadioButton rdbtnIncisoB = new JRadioButton("rdbtnIncisoB");
		rdbtnIncisoB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Alamcena la respuesta seleccionada por el usuario
				respuestaSeleccionada = "B";
			}
		});
		rdbtnIncisoB.setBounds(21, 33, 265, 23);
		panel.add(rdbtnIncisoB);
		
		JRadioButton rdbtnIncisoA = new JRadioButton("rdbtnIncisoA");
		rdbtnIncisoA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Alamcena la respuesta seleccionada por el usuario
				respuestaSeleccionada = "A";
			}
		});
		rdbtnIncisoA.setBounds(21, 7, 265, 23);
		panel.add(rdbtnIncisoA);
		
		JLabel lblD = new JLabel("D)");
		lblD.setBounds(10, 89, 29, 14);
		panel.add(lblD);
		
		JLabel lblC = new JLabel("C)");
		lblC.setBounds(10, 63, 29, 14);
		panel.add(lblC);
		
		JLabel lblB = new JLabel("B)");
		lblB.setBounds(10, 37, 29, 14);
		panel.add(lblB);
		
		JLabel lblA = new JLabel("A)");
		lblA.setBounds(10, 11, 29, 14);
		panel.add(lblA);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(131, 156, 90, 14);
		contentPane.add(lblPuntuacion);		
				
		//Grupo de Botones
		//Evita seleccionar mas de una opcion de RadioButton
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnIncisoA);
		group.add(rdbtnIncisoB);
		group.add(rdbtnIncisoC);
		group.add(rdbtnIncisoD);
				
		
		//Arreglo que contiene todas las preguntas del cuestionario
		//Agregar al arreglo para agregar pregunta
		String[] Preguntas = {	
				"Componente de computadora que se encarga de procesar sus instrucciones:", 
				"Memoria en la que se cargan todas las instrucciones que ejecuta la CPU: ", 
				"Es un medio de almacenamiento que permite solo la lectura y no escritura: ", 
				"Es un circuito digital que realiza operaciones aritméticas y operaciones lógicas: ", 
				"Es un coprocesador dedicado al procesamiento de gráficos y operaciones: "
		};
		
		//Arreglo que contiene las respuestas correctas de cada pregunta
		//Agregar al arreglo para agregar respuesta
		String[] Respuestas = {	
				"C", 
				"B", 
				"A", 
				"D", 
				"A" 
		};
		
		//Matriz que contiene las 4 diferentes opciones de respuesta de cada pregunta del cuestionario
		//Agregar a la matriz para agregar respuestas
		String[][] Incisos = {
				{"RAM", "GPU","CPU","El Raton"}, 
				{"ROM", "RAM","USB","SSD"},
				{"ROM", "RAM","USB","SSD"}, 
				{"JavaScript", "Windows Firewall","FPU","ALU"},
				{"GPU", "CPU","Monitor","Tarjeta Madre"}
		};		
		
		lblPuntuacion.setText(puntuacion+"/"+Preguntas.length);
		
		//Crea Botones de Atras y Siguiente
		JButton btnAtras = new JButton("<");
		JButton btnSiguiente = new JButton(">");
		
		//Evento Click Boton Atras
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Disminuye la puntuacion por retroceder en el cuestionario
				puntuacion--;
				
				//Si la puntuacion baja de 0, lo ajusta nuevamente a 0
				if (puntuacion < 0) {puntuacion = 0;};
				
				//Si la puntuacion baja de 0, lo ajusta nuevamente a 0
				lblPuntuacion.setText(puntuacion+"/"+Preguntas.length);
				
				//Disminuye el indice de la pregunta actual para retoceder
				indicePregunta--;
				
				//Si el indice baja de 0, lo ajusta nuevamente a 0
				if (indicePregunta < 0) {indicePregunta = 0;};
				
				//Mantiene el Boton Siguiente visible en pantalla mientras no sea la ultima pregunta
				if (indicePregunta < Preguntas.length-1) {btnSiguiente.setVisible(true);};
				
				//Imprime en pantalla la pregunta y respuestas correspondientes al indice de pregunta actual 
				lblPregunta.setText(Preguntas[indicePregunta]);
				rdbtnIncisoA.setText(Incisos[indicePregunta][0]);
				rdbtnIncisoB.setText(Incisos[indicePregunta][1]);
				rdbtnIncisoC.setText(Incisos[indicePregunta][2]);
				rdbtnIncisoD.setText(Incisos[indicePregunta][3]);				
			}
		});
		btnAtras.setBounds(20, 152, 46, 23);
		contentPane.add(btnAtras);
		
		//Evento Click Boton Siguiente		
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Compara la respuesta seleccionada con la respuesta correcta del indice actual
				//Si son iguales la marca correcta y aumenta la puntuacion
				if (Respuestas[indicePregunta]==respuestaSeleccionada) {puntuacion++;};
				
				//Si la puntuacion baja de 0, lo ajusta nuevamente a 0
				lblPuntuacion.setText(puntuacion+"/"+Preguntas.length);							
				
				//Aumenta el indice de la pregunta actual para avanzar
				indicePregunta++;	
				
				//Oculta el boton siguiente de estar en la ultima pregunta
				if (indicePregunta > Preguntas.length-1) {indicePregunta = Preguntas.length-1;btnSiguiente.setVisible(false);};
				
				//Imprime en pantalla la pregunta y respuestas correspondientes al indice de pregunta actual 
				lblPregunta.setText(Preguntas[indicePregunta]);
				rdbtnIncisoA.setText(Incisos[indicePregunta][0]);
				rdbtnIncisoB.setText(Incisos[indicePregunta][1]);
				rdbtnIncisoC.setText(Incisos[indicePregunta][2]);
				rdbtnIncisoD.setText(Incisos[indicePregunta][3]);				
			}
		});
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setBounds(76, 152, 46, 23);
		contentPane.add(btnSiguiente);
			
		//Imprime la primera pregunta en el indice
		if (indicePregunta == 0) {
			lblPregunta.setText(Preguntas[indicePregunta]);
			rdbtnIncisoA.setText(Incisos[indicePregunta][0]);
			rdbtnIncisoB.setText(Incisos[indicePregunta][1]);
			rdbtnIncisoC.setText(Incisos[indicePregunta][2]);
			rdbtnIncisoD.setText(Incisos[indicePregunta][3]);
		};
	}
}
