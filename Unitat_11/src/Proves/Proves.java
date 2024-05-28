package Proves;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class Proves {

	/////// //   // /////// /////  ///////  //   //     ////// ///////   /////  /////// //  //////
	//      ///  //   //   //   // //   //  ///  //    //      //   //  //   // //      // //
	/////   //// //   //   //   // //////   //// //    // //// //////   /////// /////   // //
	//      // ////   //   //   // //   //  // ////    //   // //   //  //   // //      // //
	/////// //  ///   //    /////  //    // //  ///     ////// //    // //   // //      //  //////

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Example menu");
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
		//Build the first menu.
		JMenu menu = new JMenu("A Menu");
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		//a group of JMenuItems
		JMenuItem menuItem = new JMenuItem("A text-only menu item");
		menuItem.getAccessibleContext().setAccessibleDescription(
		"This doesn't really do anything");

		menu.add(menuItem);
		menuItem = new JMenuItem("Another text-only menu item");
		menu.add(menuItem);

		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Another one");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		//a group of check box menu items
		menu.addSeparator();
		JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		menu.add(cbMenuItem);
		cbMenuItem = new JCheckBoxMenuItem("Another one");
		menu.add(cbMenuItem);
		//a submenu
		menu.addSeparator();
		JMenu submenu = new JMenu("A submenu");
		menuItem = new JMenuItem("An item in the submenu");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);
		//Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		"This menu does nothing");

		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		// Assignar mida de la finestra.
		frame.setSize(500,300);
		
		frame.setVisible(true); // fer visible.

	}

}
