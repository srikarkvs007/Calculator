import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
	
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[12];
	JButton addButton,subButton,mulButton,divButton,powButton;
	JButton decButton,equButton,DelButton,clrButton,negButton;
	JButton sqrtButton,logButton;
	JPanel panel;
	
    Font myFont = new Font("Ink free",Font.ITALIC,30);
	
	double num1=0,num2,result=0;
	char operator;
	
	
	Calculator(){

		frame = new JFrame("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,570);
		frame.setLayout(null);
	
		textfield = new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(true);
	
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		DelButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		powButton = new JButton("^");
		sqrtButton = new JButton("√");
		logButton = new JButton("log");
	
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = DelButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = powButton;
		functionButtons[10] = sqrtButton;
		functionButtons[11] = logButton;
	
		for(int i =0; i<12; i++) { 
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
	
		negButton.setBounds(50, 430, 100, 50);
		powButton.setBounds(150, 430, 100, 50);
		DelButton.setBounds(250, 490, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		sqrtButton.setBounds(50, 490, 100, 50);
		decButton.setBounds(160, 490, 100, 50);
		equButton.setBounds(270, 490, 100, 50);
		logButton.setBounds(150,490,100,50);

		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
	
		frame.add(panel);
		frame.add(powButton);
		frame.add(sqrtButton);
		frame.add(logButton);
		frame.add(DelButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
				case '^':
				result = Math.pow(num1, num2);
				break;
			case '√':
			    result = Math.sqrt(num1);
				break;
			}
			textfield.setText(String.valueOf(result)); 
			num1 = result;
			
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==DelButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
				
			}
		}
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			
		}
		if (e.getSource() == powButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}
		if(e.getSource() == sqrtButton) {
			operator = '√';
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
	}
	    if(e.getSource() == logButton) {
		num1 = Double.parseDouble(textfield.getText());
		result = Math.log10(num1);
		textfield.setText(String.valueOf(result));
	}
  }
 
}
