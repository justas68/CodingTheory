/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.gui;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;

import codingtheory.logic.Channel;
import codingtheory.logic.Decoder;
import codingtheory.logic.Encoder;
import codingtheory.logic.Matrix;
import codingtheory.logic.Util;
import codingtheory.logic.Vector;

/**
 * @author tvari
 */
public class MainScreen extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	private Matrix matrix;
	private Decoder decoder;
	private Encoder encoder;
	private Channel channel;

	public MainScreen() {
		initComponents();
		this.setTitle("Pagrindinis langas");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	//Automatiškai generuotas kodas
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		Issaugoti = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		messageField = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		errorProbabilityField = new javax.swing.JTextField();
		sendButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		errorArrayField = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		messageAfterField = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		messageBeforeField = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		decodedMessaageField = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel3.setText("Generuojanti matrica:");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel1.setText("Kodo ilgis n:");

		jLabel2.setText("Dimensija k:");

		Issaugoti.setText("Išsaugoti");
		Issaugoti.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IssaugotiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel2)
								.addGap(18, 18, 18)
								.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(30, 30, 30)
								.addComponent(jLabel3)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(Issaugoti, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1419, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(jLabel1)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2)
												.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(25, 25, 25)
												.addComponent(Issaugoti, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
		);

		jLabel4.setText("Žinutė:");

		jLabel5.setText("Kanalo klaidos tikimybė:");

		sendButton.setText("Siųsti");
		sendButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendButtonActionPerformed(evt);
			}
		});

		jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel6.setText("Klaidų vektorius:");

		jLabel7.setText("Užkoduota žinutė po siuntimo:");

		jButton3.setText("Tęsti");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel8.setText("Užkoduota žinutė prieš siuntimą:");

		messageBeforeField.setEditable(false);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel8)
										.addComponent(jLabel6)
										.addComponent(jLabel7))
								.addGap(18, 18, 18)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(messageAfterField, javax.swing.GroupLayout.PREFERRED_SIZE, 405,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(errorArrayField, javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
														.addComponent(messageBeforeField, javax.swing.GroupLayout.Alignment.LEADING))
												.addGap(70, 70, 70)
												.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(messageBeforeField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel8))
								.addGap(18, 18, 18)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jLabel7)
												.addGap(29, 29, 29))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(errorArrayField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton3)
														.addComponent(jLabel6))
												.addGap(18, 18, 18)
												.addComponent(messageAfterField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap(27, Short.MAX_VALUE))))
		);

		jLabel9.setText("Dekoduota žinutė: ");

		decodedMessaageField.setEditable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel9)
								.addGap(41, 41, 41)
								.addComponent(decodedMessaageField, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addGap(28, 28, 28)
												.addComponent(jLabel4)
												.addGap(22, 22, 22)
												.addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, 292,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jLabel5)
												.addGap(15, 15, 15)
												.addComponent(errorProbabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(96, 96, 96)
												.addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
								.addGap(77, 77, 77))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4)
										.addComponent(jLabel5)
										.addComponent(errorProbabilityField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(sendButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel9)
										.addComponent(decodedMessaageField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(40, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	//Išsaugo parametrus
	private void IssaugotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssaugotiActionPerformed
		//Paima parametrus iš formos
		String matrix = jTextArea1.getText();
		int n = Integer.parseInt(jTextField1.getText());
		int k = Integer.parseInt(jTextField2.getText());
		//Jeigu matricja nesuvesta, generuoja atsitiktinę standartinę matricą.
		if (matrix.isEmpty()) {
			this.matrix = new Matrix(n, k);
			this.encoder = new Encoder(this.matrix);
			this.decoder = new Decoder(this.matrix);
			for (int i = 0; i < this.matrix.getRows(); i++) {
				for (int j = 0; j < this.matrix.getColumns(); j++) {
					matrix += String.valueOf(this.matrix.getData()[i][j]);
					if (j != this.matrix.getColumns() - 1) matrix += " ";
				}
				if (i != this.matrix.getRows() - 1) matrix += System.lineSeparator();
			}
			jTextArea1.setText(matrix);
		} else {
			//Jeigu matrica buvo suvesta, tada ją validuojame
			List<String> rows = Arrays.asList(matrix.split("\\r?\\n"));
			List<List<String>> matrixSplitted = rows.stream()
					.map(row -> Arrays.asList(row.split(" ")))
					.collect(Collectors.toList());
			if (rows.size() != k) {
				JOptionPane.showMessageDialog(null, "Matrica neatitinka dimensijos parametro!");
				return;
			}
			if (matrixSplitted.stream().anyMatch(row -> row.size() != n)) {
				JOptionPane.showMessageDialog(null, "Matricos eilutėje per mažai arba per daug simbolių!");
				return;
			}
			//Paverčia matricą į Integer tipą
			List<List<Integer>> matrixAsIntegers = matrixSplitted.stream()
					.map(row -> row.stream()
							.map(Integer::parseInt)
							.collect(Collectors.toList()))
					.collect(Collectors.toList());
			if (matrixAsIntegers.stream()
					.flatMap(Collection::stream)
					.anyMatch(number -> number != 0 && number != 1)) {
				JOptionPane.showMessageDialog(null, "Skaičiai turi buti 1 arba 0!");
				return;
			}
			//Išsaugo parametrus
			int[][] matrixAsArray = listToArray(matrixAsIntegers);
			this.matrix = new Matrix(matrixAsArray);
			this.encoder = new Encoder(this.matrix);
			this.decoder = new Decoder(this.matrix);
		}
		JOptionPane.showMessageDialog(null, "Parametrai sėkmingai išsaugoti");
		//Atidaro kitus langus
		MessageFrame messageFrame = new MessageFrame(this.matrix, this.encoder, this.decoder);
		messageFrame.setVisible(true);
		PhotoFrame photoFrame;
		photoFrame = new PhotoFrame(this.matrix, this.encoder, this.decoder);
		photoFrame.setVisible(true);
	}//GEN-LAST:event_IssaugotiActionPerformed


	//Siunčia įvestą dvejatainę žinutę, atvaizduoja klaidų vektoriu ir žinutę gautą po išsiuntimo (prieš tai ją užkodavus)
	private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
		String messageString = messageField.getText().replace(" ", "");
		//Išsaugo klaidos tikimybę ir sukonfiguruoja kanalą
		double errorProbability = Double.parseDouble(errorProbabilityField.getText().replace(",", "."));
		this.channel = new Channel(errorProbability);
		//Patikrina ar įvesta žinutė yra tinkamo ilgio
		if (messageString.length() != this.matrix.getRows()) {
			JOptionPane.showMessageDialog(null, "Neteisinga žinutė!");
			return;
		}
		//Iš žinutės sukuria vektoriu
		Vector v = new Vector(messageString);

		//Užkoduoja žinutę, siunčia ją kanalu ir atvaizduoja gautus rezultatus
		int[] message = v.getArray();
		int[] encodedMessage = this.encoder.encode(message).getArray();
		messageBeforeField.setText(Util.joinArray(encodedMessage));
		int[] errorArray = channel.sendMessage(encodedMessage);
		errorArrayField.setText(Util.joinArray(errorArray));
		messageAfterField.setText(Util.joinArray(encodedMessage));

	}//GEN-LAST:event_sendButtonActionPerformed

	//Dekoduoja žinutę ir ją atvaizduoja
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		Vector encodedMessage = new Vector(messageAfterField.getText().replace(" ", ""));
		Vector decodedMessage = this.decoder.decodeVector(encodedMessage);
		decodedMessaageField.setText(Util.joinArray(decodedMessage.getArray()));
	}//GEN-LAST:event_jButton3ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(() -> new MainScreen().setVisible(true));
	}

	//Sąrašą konvertuoja į masyvą
	private int[][] listToArray(List<List<Integer>> list) {
		int[][] array = new int[list.size()][list.get(0).size()];
		for (int i = 0; i < list.size(); i++) {
			List<Integer> row = list.get(i);
			for (int j = 0; j < row.size(); j++) {
				array[i][j] = row.get(j);
			}
		}
		return array;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	//Generuotas kodas
	private javax.swing.JButton Issaugoti;
	private javax.swing.JTextField decodedMessaageField;
	private javax.swing.JTextField errorArrayField;
	private javax.swing.JTextField errorProbabilityField;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField messageAfterField;
	private javax.swing.JTextField messageBeforeField;
	private javax.swing.JTextField messageField;
	private javax.swing.JButton sendButton;
	// End of variables declaration//GEN-END:variables
}
