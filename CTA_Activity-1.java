package sdmcet.cse.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Oops extends Exception implements ActionListener {
	JFrame f = new JFrame("Student Grading System");
	JLabel l = new JLabel("Grade Calculator");
	JLabel lia1 = new JLabel("Enter IA-1 Marks");
	JLabel lia2 = new JLabel("Enter IA-2 Marks");
	JLabel lia3 = new JLabel("Enter IA-3 Marks");
	JLabel lcta = new JLabel("Enter CTA Marks");
	JLabel lsee = new JLabel("Enter SEE Marks");
	JLabel ltotal = new JLabel();
	JLabel lgrade = new JLabel();
	JLabel lnxt = new JLabel();

	JPanel p = new JPanel();
	JPanel pia1 = new JPanel();
	JPanel pia2 = new JPanel();
	JPanel pia3 = new JPanel();
	JPanel pcta = new JPanel();
	JPanel psee = new JPanel();
	JPanel pbutton = new JPanel();
	JPanel p2 = new JPanel();
	JPanel nxp = new JPanel();

	JButton b1 = new JButton("CALCULATE");

	JTextField fia1 = new JTextField(10);
	JTextField fia2 = new JTextField(10);
	JTextField fia3 = new JTextField(10);
	JTextField fcta = new JTextField(10);
	JTextField fsee = new JTextField(10);

	public Oops() {
		b1.setSize(100, 100);
		f.setVisible(true);
		f.setBounds(200, 200, 500, 500);

		p.add(l);

		pia1.add(lia1);
		pia1.add(fia1);

		pia2.add(lia2);
		pia2.add(fia2);

		pia3.add(lia3);
		pia3.add(fia3);

		pcta.add(lcta);
		pcta.add(fcta);

		psee.add(lsee);
		psee.add(fsee);

		pbutton.add(b1);

		p2.add(ltotal);
		p2.add(lgrade);
		nxp.add(lnxt);

		f.add(p);
		f.add(pia1);
		f.add(pia2);
		f.add(pia3);
		f.add(pcta);
		f.add(psee);
		f.add(pbutton);
		f.add(p2);
		f.add(nxp);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(10, 0));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		b1.addActionListener(this);
		lnxt.setForeground(Color.red);
		lnxt.setFont(new Font("", Font.BOLD, 20));
		l.setFont(new Font("", Font.BOLD, 18));
		ltotal.setFont(new Font("", Font.BOLD, 15));
		lgrade.setFont(new Font("", Font.BOLD, 15));

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b1) {

				int ia1 = Integer.parseInt(fia1.getText());
				int ia2 = Integer.parseInt(fia2.getText());
				int ia3 = Integer.parseInt(fia3.getText());
				int cta = Integer.parseInt(fcta.getText());
				double see = Integer.parseInt(fsee.getText());

				// Validate input marks
				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20 || cta < 0 || cta > 10 || see < 0
						|| see > 100) {
					lnxt.setText("!!! Invalid marks entered !!!");
					return;
				}

				// Calculate CIE
				int cie;
				int sum1, sum2, largest;

				largest = ia1 + ia2;
				sum1 = ia2 + ia3;
				sum2 = ia1 + ia3;

				if (sum1 > largest) {
					largest = sum1;
				}
				if (sum2 > largest) {
					largest = sum2;
				}

				cie = largest + cta;

				// Check if student is detained
				if (cie < 20) {
					lnxt.setText("!! Student is detained from taking SEE !!");
					return;
				}

				// Upgrade SEE marks to 40 if 38 or 39
				if (see == 38 || see == 39) {
					see = 40;
				}

				// Calculate total marks
				double totalMarks = (cie + Math.round(see / 2));
				totalMarks = Math.round(totalMarks);

				// Calculate grade

				String grade;
				if (totalMarks >= 90) {
					grade = "S";
				} else if (totalMarks >= 80) {
					grade = "A";
				} else if (totalMarks >= 70) {
					grade = "B";
				} else if (totalMarks >= 60) {
					grade = "C";
				} else if (totalMarks >= 50) {
					grade = "D";
				} else if (totalMarks >= 40) {
					grade = "E";
				} else {
					grade = "F";
				}
				ltotal.setText("TotalMarks : " + totalMarks);
				lgrade.setText("Grade : " + grade);

				// student failed due to less marks in SEE
				if (see < 38) {
					// String grade="F";
					lgrade.setText("Grade:F");
					lnxt.setText("!!Student failed due to less marks in SEE!!");
					return;
				}
			}
		} catch (NumberFormatException nfe) {
			lnxt.setText("!! Invalid Input !!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Oops();
	}
}
