package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class VentanaSerieF extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Num1;
	private JTextField txt_Num2;
	private JTextField txt_Iteraciones;
	private JTextArea txtar_Serie;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSerieF frame = new VentanaSerieF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaSerieF() {
		setTitle("Juan Badillo 19100148");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_Num1 = new JTextField();
		txt_Num1.setBounds(98, 11, 86, 20);
		contentPane.add(txt_Num1);
		txt_Num1.setColumns(10);
		
		txt_Num2 = new JTextField();
		txt_Num2.setBounds(98, 42, 86, 20);
		contentPane.add(txt_Num2);
		txt_Num2.setColumns(10);
		
		txt_Iteraciones = new JTextField();
		txt_Iteraciones.setBounds(98, 73, 86, 20);
		contentPane.add(txt_Iteraciones);
		txt_Iteraciones.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero 1");
		lblNewLabel.setBounds(10, 14, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 2");
		lblNewLabel_1.setBounds(10, 45, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Iteraciones");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 76, 78, 14);
		contentPane.add(lblNewLabel_2);
						
	//Boton Generar	
		JButton btn_Generar = new JButton("Generar");
		btn_Generar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtar_Serie.setText("");
				
				String StrFnM1 = txt_Num1.getText(); //Lee Primer numero de la secuencia de fibonacci 
		        String  StrFnM2 = txt_Num2.getText(); //Lee Segundo numero de la secuencia de fibonacci 		        
		        String Strn = txt_Iteraciones.getText();; //Lee Largo de la secuencia

				int FnM1 = Integer.parseInt(StrFnM1); //Primer numero de la secuencia de fibonacci a Int
				int FnM2 = Integer.parseInt(StrFnM2); //Segundo numero de la secuencia de fibonacci a Int
				int n = Integer.parseInt(Strn);  //Largo de la secuencia a Int
				
				String serieF = ""; //Crea cadena de la serie
				serieF = serieF + FnM1; //Concatena en la cadena el primer numero
				serieF = serieF +", "+ FnM2; //Concatena en la cadena el segundo numero
				
				
				//Crea la secuencia de Fibonnaci
		        int i = 0;
		        while (i<n) {
		            int Fn = FnM1 + FnM2;  //Suma los dos numeros anteriores
		            FnM1 = FnM2; //Guarda el numero previo a la suma en la secuencia
		            FnM2 = Fn; //Guarda el valor de la suma
		            
		            serieF = serieF +", "+ Fn; //Concatena en la cadena
	            
		            i++;    
		        }
		        
		      txtar_Serie.setText(serieF);
			}
		});
		btn_Generar.setBounds(219, 10, 89, 23);
		contentPane.add(btn_Generar);
		
	//Boton Salir
		JButton btn_Salir = new JButton("Salir");
		btn_Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_Salir.setBounds(219, 41, 89, 23);
		contentPane.add(btn_Salir);
		
		txtar_Serie = new JTextArea();
		txtar_Serie.setBounds(10, 104, 341, 54);
		contentPane.add(txtar_Serie);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
	}
}
