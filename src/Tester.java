import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tester {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Resistor Program");
		frame.setSize(600, 250);
		frame.setResizable(false);
		JTextField ohms = new JTextField();
		JTextField colors = new JTextField();

		ohms.setText("Ohms");
		ohms.setColumns(10);
		colors.setText("ColorCode");
		colors.setColumns(20);

		JPanel textPanel = new JPanel();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		DecodeResistorColors h = new DecodeResistorColors();

		JTextArea text = new JTextArea();

		JButton button = new JButton("Convert");
		JButton clearBut=new JButton("Clear");
		clearBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colors.setText("");
				ohms.setText("");
				
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ohms.getText().equals("") && colors.getText().equals("")){
					ohms.setText("ERROR");
					colors.setText("ERROR");
				}
				else if(ohms.getText().equals(""))
				{
					ohms.setText(h.decodeResistorColors(colors.getText()));
				}
				else if(colors.getText().equals("")){
					colors.setText(h.encodeResistorColors(ohms.getText()));
				}

			}
		});

		text.setText(
				"	The basic resistor color codes are: black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9 "
						+ "Each resistor will have at least three bands, with the first and second bands indicating the first two digits of the ohms value, and the third indicating the power of ten to multiply them by, for example a resistor with the three bands 'yellow violet black' would be 47 * 10^0 ohms, or 47 ohms."
						+ "Most resistors will also have a fourth band that is either gold or silver, with gold indicating plus or minus 5% tolerance, and silver indicating 10% tolerance. Resistors that do not have a fourth band are rated at 20% tolerance. NOTE: Encoding only works with gold band resistors"
						+ "NOTE: This program will only handle resistors less than 999Million Ohms");

		text.setSize(550, 100);
		text.setLineWrap(true);
		text.setEditable(false);
		text.setWrapStyleWord(true);
		textPanel.add(text);
		textPanel.add(colors);
		textPanel.add(ohms);
		textPanel.add(button);
		textPanel.add(clearBut);
		contentPane.add(textPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
