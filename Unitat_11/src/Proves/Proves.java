package Proves;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proves {

	/////// //   // /////// /////  ///////  //   //     ////// ///////   /////  /////// //  //////
	//      ///  //   //   //   // //   //  ///  //    //      //   //  //   // //      // //
	/////   //// //   //   //   // //////   //// //    // //// //////   /////// /////   // //
	//      // ////   //   //   // //   //  // ////    //   // //   //  //   // //      // //
	/////// //  ///   //    /////  //    // //  ///     ////// //    // //   // //      //  //////

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new FlowLayout());
		JButton boto1 = new JButton("Acceptar");
		JButton boto2 = new JButton("Cancel·lar");
		
		// Afegir botó dins el panell.
		panel.add(boto1);
		panel.add(boto2);
		
		// Assignar mida de la finestra.
		frame.setSize(500,300);
		
		frame.setVisible(true); // fer visible.

	}

}
