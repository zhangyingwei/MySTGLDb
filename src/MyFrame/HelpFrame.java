/*
 * Help.java
 *
 * Created on 2013
 */

package MyFrame;

/**
 *
 * @author  fengche
 */
public class HelpFrame extends javax.swing.JInternalFrame {

	/** Creates new form Help */
	public HelpFrame() {
		initComponents();
		this.setLocation(500, 150);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel_help = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setClosable(true);
		setTitle("\u5e2e\u52a9");

		jLabel_help.setFont(new java.awt.Font("����", 0, 24));
		jLabel_help.setText("\u4f5c\u8005\uff1a\u5f20\u82f1\u4f1f");

		jLabel1.setText("2013.12.17");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(126, 126, 126)
						.addComponent(jLabel_help,
								javax.swing.GroupLayout.PREFERRED_SIZE, 177,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(133, Short.MAX_VALUE)).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(293,
						Short.MAX_VALUE).addComponent(jLabel1).addGap(102, 102,
						102)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(67, 67, 67)
										.addComponent(
												jLabel_help,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												52,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel1).addContainerGap(
												57, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel_help;
	// End of variables declaration//GEN-END:variables

}