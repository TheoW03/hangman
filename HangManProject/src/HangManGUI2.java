/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jduda
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class HangManGUI2 extends javax.swing.JFrame {

    /**
     * Creates new form HangManGUI2
     */
    public HangManGUI2() {
        initComponents();
        intialize();
//        timerC.start();
    }
    public static String word;
    public static HangManLogic obj;
    public boolean click = false;
    public int score = 0;
    public String[] pictureFiles = {"src/BoodyHead.png", "src/Headbody.png", "src/leg.png", "src/2legs.png",
        "src/arm.png", "src/arm(2).png"};//picture files
    public int attempts = pictureFiles.length;
    public String[] missedLetters = new String[attempts];
    public int arr = 0;

    public int picFileI = 0;
    public int timerInSecs = 0;
    public int timerInMins = 0;

    public void keyPressed(KeyEvent e) {
        System.out.println("press");
    }
    Timer timerC = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (timerInSecs > 60) {
                timerInSecs = 0;
                timerInMins++;
            }
            if (timerInSecs < 10) {
                timer.setText("Timer: " + timerInMins + ":0" + Integer.toString(timerInSecs));

            } else {
                timer.setText("Timer: " + timerInMins + ": " + Integer.toString(timerInSecs));
            }
            timerInSecs++;

        }
    });

    /**
     * This method is called from within the constructor to initialize the
     * form.WARNING: Do NOT modify this code.The content of this method is
     * always regenerated by the Form Editor.
     *
     * @param arr
     * @return
     */
    public String[] clearArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        return arr;
    }

    public void intialize() {
        String te = "";
        try {
            while (te.equals("")) {
                te = JOptionPane.showInputDialog("input word");
            }
        } catch (Exception e) {
            System.exit(0);
        }

        word = te;
        picFileI = 0;
        obj = new HangManLogic(word);
        // attempts = (attempts + word.length()) + 3;
        obj.turnIntoArr();
        String t = obj.showArr();

        words.setText(t);
        click = true;
        scoreLable.setText("score: " + Integer.toString(score));
        attemptsLabel.setText("attempts: " + Integer.toString(attempts));//intialzes program
        timerC.start();
    }

    public void checkTheIn() {
        if (click) {
            boolean chec = obj.check(text.getText());
            //if its more than 1 letter 
            if (text.getText().length() > 1 || text.getText().length() < 1) {
//                chec = false;
                JOptionPane.showMessageDialog(null, "sorry need one letter please", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //runs check
                if (chec) {
                    words.setText(obj.showArr());
                    score = score + 1;
                    scoreLable.setText("score: " + Integer.toString(score));

                } else {
                    //if letter worng
                    try {
                        attempts = attempts - 1;
                        missedLetters[arr] = text.getText();
                        mis.setText(missedLetters[arr]);
                        arr++;
                        String t = "";
                        for (int i = 0; i < arr; i++) {
                            t += " " + missedLetters[i];

                        }
                        mis.setText("missed letters: " + t);

                        JOptionPane.showMessageDialog(null, "wrong letter", "Dialog",
                                JOptionPane.INFORMATION_MESSAGE);
                        //if it goes over the array exception 

                        noose.setIcon(new ImageIcon(pictureFiles[picFileI]));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "you lose, the word was: " + word, "lose",
                                JOptionPane.INFORMATION_MESSAGE);
                        int dialogButton = JOptionPane.showConfirmDialog(null, "play again", "play again",
                                JOptionPane.YES_NO_OPTION);
                        if (dialogButton == JOptionPane.YES_OPTION) {
                            noose.setIcon(new ImageIcon("src/post(2).png"));
                            intialize();
                        } else {
                            System.exit(0);
                        }
                    }

                    attemptsLabel.setText("attempts: " + Integer.toString(attempts));
                    picFileI++; //for the files
                }

            }
            if (obj.win()) {
                missedLetters = clearArr(missedLetters);
                mis.setText("missed letters: ");
                timerC.stop();
                timerInSecs = 0;
                timerInMins = 0;
                //         System.out.println("you win");
                JOptionPane.showMessageDialog(null, "you win", "Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                int dialogButton = JOptionPane.showConfirmDialog(null, "play again", "play again",
                        JOptionPane.YES_NO_OPTION);
                if (dialogButton == JOptionPane.YES_OPTION) {
                    noose.setIcon(new ImageIcon("src/post(2).png"));
                    intialize();
                } else {
                    System.exit(0);
                }

            }
            text.setText("");
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        words = new javax.swing.JLabel();
        scoreLable = new javax.swing.JLabel();
        attemptsLabel = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        noose = new javax.swing.JLabel();
        mis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        text.setToolTipText("");
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });
        getContentPane().add(text);
        text.setBounds(10, 250, 130, 90);

        jButton2.setText("enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 250, 130, 90);
        getContentPane().add(words);
        words.setBounds(0, 0, 440, 250);

        scoreLable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scoreLable.setText("score:");
        getContentPane().add(scoreLable);
        scoreLable.setBounds(0, 340, 90, 70);

        attemptsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptsLabel.setText("attempts");
        getContentPane().add(attemptsLabel);
        attemptsLabel.setBounds(0, 420, 80, 70);

        timer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        timer.setText("timer:");
        getContentPane().add(timer);
        timer.setBounds(0, 500, 130, 70);

        noose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/post(2).PNG"))); // NOI18N
        getContentPane().add(noose);
        noose.setBounds(450, 10, 280, 360);

        mis.setText("missed letters:");
        getContentPane().add(mis);
        mis.setBounds(420, 390, 330, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        checkTheIn();

    }//GEN-LAST:event_textActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        checkTheIn();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(HangManGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangManGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangManGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangManGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangManGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptsLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel mis;
    private javax.swing.JLabel noose;
    private javax.swing.JLabel scoreLable;
    private javax.swing.JTextField text;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel words;
    // End of variables declaration//GEN-END:variables

}