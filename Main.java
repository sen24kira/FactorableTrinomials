/**
 * @(#)Main.java
 *
 *
 * @Peter Zhu
 * @version 1.00 2018/3/2
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main{
	public static void main(String[] args){
		JFrame frame = new JFrame("Factorable Trinomials Finder v3.1.1 by Peter Zhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(new FPanel());
        frame.pack();
        frame.setVisible(true);
	}
}