package buttons;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Buttons extends JFrame 
{
   private JButton plainJButton; // button with just text
   private JButton fancyJButton; // button with icons

   // ButtonFrame adds JButtons to JFrame
   public Buttons()
   {
      super( "Testing Buttons" );
      setLayout( new FlowLayout() ); // set frame layout

      plainJButton = new JButton( "Bot‹o Padr‹o" ); // button with text
      add( plainJButton ); // add plainJButton to JFrame

      Icon bug1 = new ImageIcon( getClass().getResource( "bug1.gif" ) );
      Icon bug2 = new ImageIcon( getClass().getResource( "bug2.gif" ) );
      fancyJButton = new JButton( "Fancy Button", bug1 ); // set image
      fancyJButton.setRolloverIcon( bug2 ); // set rollover image
      add( fancyJButton ); // add fancyJButton to JFrame

      // create new ButtonHandler for button event handling 
      ButtonHandler handler = new ButtonHandler();
      fancyJButton.addActionListener( handler );
      plainJButton.addActionListener( handler );
   } // end ButtonFrame constructor

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
      // handle button event
      public void actionPerformed( ActionEvent event )
      {
         JOptionPane.showMessageDialog( Buttons.this, String.format(
            "Voc pressionou o bot‹o: %s", event.getActionCommand() ) );
      } // end method actionPerformed
   } // end private inner class ButtonHandler
} // end class ButtonFrame

