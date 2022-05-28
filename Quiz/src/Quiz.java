import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
	
	String[] questions = {
							//facil
							"¿Qué país tiene la mayor cantidad de islas en el mundo?",
							"¿Cuántos días le toma a la tierra dar una vuelta a la órbita del sol?",
							"¿Cuál es la obra más famosa de Edvard Munch?",
							"¿Cuál es la capital de Canadá?",
							"¿Cuál es la flor nacional de Japón?",
							//normal
							"¿Cuándo se inauguró el metro de Londres?",
							"Nombra la cordillera más larga (no más alta) del mundo?",
							"¿Dónde se encuentra la fosa más profunda del océano?",
							"¿Cuál es el río más largo del mundo?",
							"¿En qué año se fundó Netflix?",
							//dificil
							"¿De qué ciudad son originarios los Beatles?",
							"¿Cuántas teclas tiene un piano?",
							"¿Cuál es el país más pequeño del mundo?",
							"¿Cuál fue la serie más vista en Netflix en el 2019?",
							"¿Cuántas zonas horarias tiene en Rusia?",
							//experto
							"¿Cuál es la serie de libros mejor vendida del siglo 21?",
							"¿Cuál es el animal nacional de Australia?",
							"Qué artista de graffiti famoso nació en Bristol?",
							"¿Cuándo se publicó la primer edición de la revista Vogue?",
							"¿Cuántas franjas tiene la bandera de Estados Unidos?",
							//maestro
							"¿Cuál es el idioma que tiene más palabras (según su diccionario)?",
							"¿Cómo se llamaba Istanbul antes de 1923?",
							"¿Cuál fue la primer película de Disney?",
							"¿Qué artista pinto el techo de la Capilla Sixtina en Roma? ",
							"¿Quién inventó la cancion The Shape of You?"
	  					};
	String[][] options = {
							//---------------facil
							{"Islandia","jamaica",/**/"Suecia","Bolivia"},
							{"291","128","30",/**/"365"},
							{"La ultima cena",/**/"El grito","El beso","Las meninas"},
							{"Bogotá","Montevideo","Madrid",/**/"Ottawa"},
							{"Margarita",/**/"Cerezo","Hibisco","Hortensia"},
							//---------------normal
							{/**/"1863","1995","1830","1729"},
							{/**/"Los andes","Talamanca","Apalaches ","Himalaya"},
							{"Tonga",/**/"Marianas","Kamchatka","Kuriles"},
							{"Mississippi","Amazona",/**/"Nilo","Yang Tse Kiang"},
							{/**/"1997","2001","2009","2015"},
							//---------------dificil
							{"Barcelona","Beirut",/**/"Liverpool","Amsterdam"},
							{"67","90","76",/**/"88"},
							{/**/"Vaticano","Tuvalu","Liechtenstein","Mónaco"},
							{"Bling Empire",/**/"Stranger Things","Friends","Workin' Moms"},
							{/**/"11","9","8","13"},
							//---------------experto
							{"El Señor de los Anillos","El principito",/**/"Harry Potter","El hobbit"},
							{"Elefante","Perro","Gato",/**/"Canguro"},
							{/**/"Banksy","Muelle","Vhils","Eduardo Kobra"},
							{"1883",/**/"1892","1960","200"},
							{/**/"13","17","16","12"},
							//maestro
							{"Italiano","Frances",/**/"Ingles","Ruso"},
							{/**/"Constantinopla","Grecia","Roma","Venecia"},
							{"Fantasía",/**/"Blanca Nieves","Pinocho","Dumbo"},
							{"Pierre-Auguste","Giotto di Bondone","Picasso, Pablo",/**/"Miguel Ángel"},
							{"Michael Jackson","Adele",/**/"Ed Sheeran","Maluma"}
						};
	
	char[] answers =	{
							'C',
							'D',
							'B',
							'D',
							'B',
							'A',
							'A',
							'B',
							'C',
							'A',
							'C',
							'D',
							'A',
							'B',
							'A',
							'C',
							'D',
							'A',
							'B',
							'A',
							'C',
							'A',
							'B',
							'D',
							'C',
						};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonF = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	JTextField dificulty = new JTextField();
			
			
	//Cuerpo del programa
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0, 0, 1000, 50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(213, 209, 208));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0, 50, 1000, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(213, 209, 208));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);

		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(213, 209, 208));
		answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(213, 209, 208));
		answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(213, 209, 208));
		answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(213, 209, 208));
		answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		number_right.setBounds(400,255,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(400,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		dificulty.setBounds(934,0,50,50);
		dificulty.setForeground(new Color(0,0,0));
		dificulty.setFont(new Font("MV Boli",Font.PLAIN,50));
		dificulty.setEditable(false);

		
		frame.add(dificulty);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		

		if(index>=total_questions) {
			results();
		}else {
			if(index==correct_guesses) {
				textfield.setText("Pregunta "+(index+1));
				textarea.setText(questions[index]);
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
			}else {
				fail();
			}
		}
		if(index>=0) {
			dificulty.setBackground(new Color(204, 255, 103));
			dificulty.setText("F");
		}
		if(index>=5) {
			dificulty.setBackground(new Color(255, 252, 54));
			dificulty.setText("N");
		}
		if(index>=10) {
			dificulty.setBackground(new Color(255, 156, 57));
			dificulty.setText("A");
		}
		if(index>=15) {
			dificulty.setBackground(new Color(255, 105, 57));
			dificulty.setText("D");
		}
		if(index>=20) {
			dificulty.setBackground(new Color(255, 69, 57));
			dificulty.setText("E");
		}
		if(index>=25) {
			dificulty.setBackground(new Color(218, 13, 0));
			dificulty.setText("M");
		}
	}
	
	public void fail() {
		textfield.setForeground(new Color(255, 0, 0));
		textfield.setText("Fallaste");
		
		results();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer= 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonB) {
			answer= 'B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonC) {
			answer= 'C';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonD) {
			answer= 'D';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
		
	}
	
	
	public void displayAnswer() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(1500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(213, 209, 208));
				answer_labelB.setForeground(new Color(213, 209, 208));
				answer_labelC.setForeground(new Color(213, 209, 208));
				answer_labelD.setForeground(new Color(213, 209, 208));
				
				answer = ' ';
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
	
	 pause.setRepeats(false);	
	 pause.start();
		
	}
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}
