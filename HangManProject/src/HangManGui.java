
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
//import java.util.logging.Level;
//import java.util.lLabel;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JOptionPaners;

////in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
/////**
// *
// * @author theo
// */
public class HangManGui extends javax.swing.JDialog implements ActionListener {

    /**
     * Creates new form HangManGui
     */
    public void initHighScore(){
        
    }
    public void initChooseWord(){
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public HangManGui(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        intialize();

    }

// 
//    public void e() {
//        HangManLogic obj = new HangManLogic(word);
//        obj.turnIntoArr();
//        words.setText(obj.showArr());
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        words = new javax.swing.JLabel();
        scoreLable = new javax.swing.JLabel();
        attemptsLabel = new javax.swing.JLabel();
        noose = new javax.swing.JLabel();
        mis = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        highScore = new javax.swing.JPanel();
        addWord = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        text.setToolTipText("");
        text.setActionCommand("");
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });
        getContentPane().add(text);
        text.setBounds(10, 190, 110, 70);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("enter");
        jButton2.setFocusCycleRoot(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(120, 190, 110, 70);

        words.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        getContentPane().add(words);
        words.setBounds(0, 50, 450, 120);

        scoreLable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scoreLable.setText("score:");
        getContentPane().add(scoreLable);
        scoreLable.setBounds(0, 330, 70, 50);

        attemptsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attemptsLabel.setText("Attempts:");
        getContentPane().add(attemptsLabel);
        attemptsLabel.setBounds(0, 380, 110, 50);

        noose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/post(2).PNG"))); // NOI18N
        getContentPane().add(noose);
        noose.setBounds(480, 30, 250, 280);

        mis.setText("missed letters: ");
        getContentPane().add(mis);
        mis.setBounds(440, 380, 270, 90);

        timer.setText("Timer:");
        getContentPane().add(timer);
        timer.setBounds(0, 430, 150, 90);
        getContentPane().add(highScore);
        highScore.setBounds(0, 0, 800, 540);
        getContentPane().add(addWord);
        addWord.setBounds(0, 0, 710, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_textActionPerformed
    public String[] clearArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        return arr;
    }

    public void intialize() {
        String te = "";
        while (!te.equals("")) {
            te = JOptionPane.showInputDialog("input word");
            if (!te.equals("")) {
                break;
            }
        }
        word = te;
        picFileI = 0;
        word = JOptionPane.showInputDialog("input word");
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (click) {
            boolean chec = obj.check(text.getText());
            //if its more than 1 letter 
            if (text.getText().length() > 1) {
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
                    attempts = attempts - 1;
                    missedLetters[arr] = text.getText();
                    System.out.println(missedLetters[arr]);
                    mis.setText(missedLetters[arr]);
                    arr++;

                    String t = "";
                    for (int i = 0; i < arr; i++) {
                        t += " " + missedLetters[i];
                        System.out.println(missedLetters[i]);

                    }
                    mis.setText("missed letters: " + t);

                    JOptionPane.showMessageDialog(null, "wrong letter", "Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                    //if it goes over the array exception 
                    try {
                        noose.setIcon(new ImageIcon(pictureFiles[picFileI]));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "you lose, the word was" + word, "Dialog",
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

            //runs check
//            if (chec) {
//                words.setText(obj.showArr());
//                score = score + 1;
//                scoreLable.setText("score: " + Integer.toString(score));
//
//            } else {
//                //if letter worng
//                attempts = attempts - 1;
//                missedLetters[arr] = text.getText();
//                System.out.println(missedLetters[arr]);
//                mis.setText(missedLetters[arr]);
//                arr++;
//
//                String t = "";
//                for (int i = 0; i < arr; i++) {
//                    t += " " + missedLetters[i];
//                    System.out.println(missedLetters[i]);
//
//                }
//                mis.setText("missed letters: " + t);
//
//                JOptionPane.showMessageDialog(null, "wrong letter", "Dialog",
//                        JOptionPane.INFORMATION_MESSAGE);
//                //if it goes over the array exception 
//                try {
//                    noose.setIcon(new ImageIcon(pictureFiles[picFileI]));
//
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "you lose, the word was" + word, "Dialog",
//                            JOptionPane.INFORMATION_MESSAGE);
//                    int dialogButton = JOptionPane.showConfirmDialog(null, "play again", "play again",
//                            JOptionPane.YES_NO_OPTION);
//                    if (dialogButton == JOptionPane.YES_OPTION) {
//                        noose.setIcon(new ImageIcon("src/post(2).png"));
//                        intialize();
//                    } else {
//                        System.exit(0);
//                    }
//                }
//
//                attemptsLabel.setText("attempts: " + Integer.toString(attempts));
//                picFileI++; //for the files
//            }
            //Tells if win
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

        } else {
            JOptionPane.showMessageDialog(null, "press start please", "Dialog",
                    JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//        //  answer.setText(t);
////        e();
//        //update();
//        //  String word = JOptionPane.showInputDialog("input word");
//        // e(word);
//
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HangManGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HangManGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HangManGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HangManGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                HangManGui dialog = new HangManGui(new javax.swing.JFrame(), true);
////                MultiThread th = new MultiThread();
//////                initComponets();
////                th.start();
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addWord;
    private javax.swing.JLabel attemptsLabel;
    private javax.swing.JPanel highScore;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel mis;
    private javax.swing.JLabel noose;
    private javax.swing.JLabel scoreLable;
    private javax.swing.JTextField text;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel words;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public void run() {
//        System.out.println("test");
//    }
}