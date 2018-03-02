/**
 * @(#)FPanel.java
 *
 *
 * @Peter Zhu
 * @version 1.00 2018/3/2
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FPanel extends JPanel { //Panel
    private JButton find;
    private JLabel labelAdd,labelSta;
    private JPanel buttonPanel;
	public JLabel labelRst[] = new JLabel[200];

    public FPanel() {

        find = new JButton("Find!!");
        ButtonListener listener = new ButtonListener();
        find.addActionListener(listener);

        JLabel labelintro1 = new JLabel("Go find the trinomials!!"); //Introduc

        labelSta = new JLabel("");
        labelAdd = new JLabel("");

        buttonPanel = new JPanel(); //Action button
        buttonPanel.setPreferredSize(new Dimension(400, 50));
        buttonPanel.setBackground(Color.white);
        buttonPanel.add(find);

        JPanel panelRst = new JPanel(); //Result panel
        panelRst.setPreferredSize(new Dimension(1000,1000));
        panelRst.setBackground(Color.white);

        JLabel Rstlabel = new JLabel("RESULT :");
		panelRst.add(Rstlabel);
        Rstlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        panelRst.add(labelAdd);

        for(int p=1;p<labelRst.length;p++){
        labelRst[p] = new JLabel("...");
        panelRst.add(labelRst[p]);
        labelRst[p].setFont(new Font("Verdana", Font.BOLD, 20));
        labelRst[p].setForeground(Color.red);
        }

        labelAdd.setFont(new Font("Verdana", Font.BOLD, 20));
        labelAdd.setForeground(Color.red);

        JPanel panelSta = new JPanel(); //Status panel
        panelSta.setPreferredSize(new Dimension(140, 60));
        panelSta.setBackground(Color.white);
        panelSta.add(labelSta);
        labelSta.setFont(new Font("Arial", Font.BOLD, 14));

        setPreferredSize(new Dimension(1500, 1000)); //JFrame content
        setBackground(Color.white);
        add(labelintro1);
        add(buttonPanel);
        add(panelRst);
        add(panelSta);
        }

        public class ButtonListener implements ActionListener{

        public JOptionPane jop;
        int inpt = Integer.parseInt(JOptionPane.showInputDialog(jop,"What's the integer?"));
		int nmb,f=1,n=1,goo;//initialization

        public void actionPerformed(ActionEvent event) {

        	String ipt = new Integer(inpt).toString(); //Transf to string
        	Object choice = event.getSource();
			nmb=Math.abs(inpt);


			if (choice == find) //Button choice
                goo = 1;

            switch (goo) {
            case 1:

            	String rst[] = new String[labelRst.length]; //Array

            	if(inpt!=0)
            	labelSta.setText(ipt);

            	if(inpt==0)
            	labelSta.setText("ERROR");

            	for(f= 1;f<=nmb;f++){//Check the factor
					if(nmb%f== 0 && f<=Math.sqrt(nmb)){ //Assign

						String b1 = new Integer((nmb/f)-f).toString();
						String b2 = new Integer((nmb/f)+f).toString();

						if(inpt<-1&&(nmb/f)!=f){ //Negative
							rst[n]="x^2+"+ b1 +"x-"+nmb+"   "+"x^2-"+b1+"x-"+nmb+"   ";
							n++;
						}
						if(inpt>=1){ //Postive
							rst[n]="x^2+"+ b2 +"x+" +nmb+"   "+"x^2-" + b2 + "x+" +nmb+"   ";
							n++;
						}
						if(inpt<0&&((nmb/f)-f)==0){ //Perfect sqr
								labelAdd.setText("x^2-" + nmb +" ");}
					}
            	}

            	for(int p =1;p<labelRst.length;p++)
            		labelRst[p].setText(rst[p]);
            	break;
            	}
            }
       }
 }

