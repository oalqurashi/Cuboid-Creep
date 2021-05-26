/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.GUI;

import com.sun.opengl.util.Animator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GLJPanel;
import org.Graphics.EventListener;
import org.Graphics.Map;
import org.Graphics.Worm;

public class GUIScreen extends javax.swing.JFrame {
    
    private static GUIScreen screen;
    private Animator animator;
    FileOutputStream mapOutputStream = null;
    ObjectOutputStream mapSave = null;
    Map map;
    int mapNum;
    
    public GUIScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setName("Cuboid Creep");
        LayeredPane.removeAll();
        LayeredPane.add(startGameScreen);
        EventListener el = new EventListener();
        try {
            mapOutputStream = new FileOutputStream("save.ser");
            mapSave = new ObjectOutputStream(mapOutputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventListener.setMapOutputStream(mapOutputStream);
        EventListener.setMapSave(mapSave);
        gameScreenPanel.addGLEventListener(el);
        gameScreenPanel.addKeyListener(el);
        PauseScreenPanel.addGLEventListener(el);
        gLCanvas1.addGLEventListener(el);
        gLCanvas1.addKeyListener(el);
        LayeredPane.addKeyListener(el);
        animator = new Animator(gLCanvas1);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
    }
    
    void changePanel(GLJPanel panel)
    {
        LayeredPane.removeAll();
        LayeredPane.add(panel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }
    
    
    void switchPanel(GLJPanel panel)
    {
        LayeredPane.add(panel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
    }
    private void switch2Panel(GLJPanel panel) {
        int layer = LayeredPane.getLayer(panel);
        LayeredPane.setLayer(panel, layer, 0);
        LayeredPane.remove(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayeredPane = new javax.swing.JLayeredPane();
        gameScreenPanel = new javax.media.opengl.GLJPanel();
        gLCanvas1 = new javax.media.opengl.GLCanvas();
        startGameScreen = new javax.media.opengl.GLJPanel();
        newGameButton = new javax.swing.JButton();
        ExitGameButton = new javax.swing.JButton();
        ContinueButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        ControlLabel = new javax.swing.JLabel();
        tipLabel = new javax.swing.JLabel();
        PauseScreenPanel = new javax.media.opengl.GLJPanel();
        PSExitGameButton = new javax.swing.JButton();
        PSContinueButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        LayeredPane.setPreferredSize(new java.awt.Dimension(1200, 1200));
        LayeredPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                LayeredPaneFocusLost(evt);
            }
        });
        LayeredPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LayeredPaneKeyPressed(evt);
            }
        });

        gameScreenPanel.setPreferredSize(new java.awt.Dimension(1200, 1200));
        gameScreenPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gameScreenPanelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gameScreenPanelFocusLost(evt);
            }
        });
        gameScreenPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameScreenPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout gameScreenPanelLayout = new javax.swing.GroupLayout(gameScreenPanel);
        gameScreenPanel.setLayout(gameScreenPanelLayout);
        gameScreenPanelLayout.setHorizontalGroup(
            gameScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(gameScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gLCanvas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gameScreenPanelLayout.setVerticalGroup(
            gameScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(gameScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gLCanvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startGameScreen.setBackground(new java.awt.Color(255, 255, 255));
        startGameScreen.setPreferredSize(new java.awt.Dimension(1200, 1200));

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        ExitGameButton.setText("Exit Game");
        ExitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitGameButtonActionPerformed(evt);
            }
        });

        ContinueButton.setText("Continue");
        ContinueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Welcome to Cuboid Creep");

        ControlLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ControlLabel.setForeground(new java.awt.Color(255, 255, 255));
        ControlLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ControlLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ControlLabelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ControlLabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ControlLabelComponentShown(evt);
            }
        });

        tipLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tipLabel.setForeground(new java.awt.Color(255, 255, 255));
        tipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipLabel.setText("Tip : Gather 3 coins to get a Dash or go to the Safe Room");

        javax.swing.GroupLayout startGameScreenLayout = new javax.swing.GroupLayout(startGameScreen);
        startGameScreen.setLayout(startGameScreenLayout);
        startGameScreenLayout.setHorizontalGroup(
            startGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startGameScreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(startGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ExitGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(ContinueButton, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addGap(420, 420, 420))
            .addGroup(startGameScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ControlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(startGameScreenLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
            .addGroup(startGameScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        startGameScreenLayout.setVerticalGroup(
            startGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startGameScreenLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(ContinueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ExitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(ControlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(tipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        PauseScreenPanel.setPreferredSize(new java.awt.Dimension(1200, 1200));

        PSExitGameButton.setText("Go to the Menu");
        PSExitGameButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PSExitGameButtonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                PSExitGameButtonAncestorRemoved(evt);
            }
        });
        PSExitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSExitGameButtonActionPerformed(evt);
            }
        });

        PSContinueButton.setText("Continue");
        PSContinueButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PSContinueButtonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                PSContinueButtonAncestorRemoved(evt);
            }
        });
        PSContinueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSContinueButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pause Screen");

        javax.swing.GroupLayout PauseScreenPanelLayout = new javax.swing.GroupLayout(PauseScreenPanel);
        PauseScreenPanel.setLayout(PauseScreenPanelLayout);
        PauseScreenPanelLayout.setHorizontalGroup(
            PauseScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PauseScreenPanelLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(PauseScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PauseScreenPanelLayout.createSequentialGroup()
                        .addGroup(PauseScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSExitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSContinueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(420, 420, 420))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PauseScreenPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PauseScreenPanelLayout.setVerticalGroup(
            PauseScreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PauseScreenPanelLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(PSContinueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(PSExitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        LayeredPane.setLayer(gameScreenPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(startGameScreen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayeredPane.setLayer(PauseScreenPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayeredPaneLayout = new javax.swing.GroupLayout(LayeredPane);
        LayeredPane.setLayout(LayeredPaneLayout);
        LayeredPaneLayout.setHorizontalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayeredPaneLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(startGameScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gameScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PauseScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        LayeredPaneLayout.setVerticalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayeredPaneLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(startGameScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gameScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayeredPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PauseScreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        EventListener.resetMap();
        changePanel(gameScreenPanel);
        animator.start();
        LayeredPane.setFocusable(true);
        LayeredPane.requestFocusInWindow();
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void ExitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitGameButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitGameButtonActionPerformed

    private void ContinueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueButtonActionPerformed
        try {
            mapOutputStream.close();
            mapSave.close();
        } catch (IOException ex) {
            Logger.getLogger(GUIScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
        if(map == null){
            return;
        }
        map.setMapNum(mapNum);
        EventListener.setCurrentMap(map);
        changePanel(gameScreenPanel);
        animator.start();
        LayeredPane.setFocusable(true);
        LayeredPane.requestFocusInWindow();
    }//GEN-LAST:event_ContinueButtonActionPerformed

    public void load() {
        System.out.println("Deserialization started");
        try{
            FileInputStream fis=new FileInputStream("abc.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            FileInputStream fis2=new FileInputStream("abc2.ser");
            ObjectInputStream ois2=new ObjectInputStream(fis2);
            map=(Map)ois.readObject();
            this.mapNum =(Integer) ois2.readObject();
        }catch(IOException e){
            System.out.println(e.toString());
            System.err.println("IOException!!!");
            System.err.println("File not found...");
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException!!!");
        }       
        System.out.println("Deserialization ended");
    }
    
    private void gameScreenPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gameScreenPanelFocusGained
        
    }//GEN-LAST:event_gameScreenPanelFocusGained

    private void gameScreenPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameScreenPanelKeyPressed
        if(evt.getKeyCode() == 80)
        {
            if(LayeredPane.getComponent(0) == gameScreenPanel);
            {
                animator.stop();
                changePanel(PauseScreenPanel);
            }
        }
    }//GEN-LAST:event_gameScreenPanelKeyPressed

    private void PSExitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSExitGameButtonActionPerformed
        LayeredPane.removeAll();
        Worm.resetPosition();
        screen.dispose();
        screen = new GUIScreen();
        screen.setVisible(true);
    }//GEN-LAST:event_PSExitGameButtonActionPerformed

    private void PSContinueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSContinueButtonActionPerformed
        animator.start();
        changePanel(gameScreenPanel);
    }//GEN-LAST:event_PSContinueButtonActionPerformed

    private void LayeredPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LayeredPaneKeyPressed
        if(evt.getKeyCode() == 80)
        {
            if(LayeredPane.getComponent(0) == gameScreenPanel);
            {
                animator.stop();
                changePanel(PauseScreenPanel);
            }
        }
    }//GEN-LAST:event_LayeredPaneKeyPressed

    private void PSContinueButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PSContinueButtonAncestorAdded
        PSContinueButton.setFocusable(true);
        PSContinueButton.requestFocusInWindow();
    }//GEN-LAST:event_PSContinueButtonAncestorAdded

    private void PSExitGameButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PSExitGameButtonAncestorAdded
       PSExitGameButton.setFocusable(true);
       PSExitGameButton.requestFocusInWindow();
    }//GEN-LAST:event_PSExitGameButtonAncestorAdded

    private void PSExitGameButtonAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PSExitGameButtonAncestorRemoved

    }//GEN-LAST:event_PSExitGameButtonAncestorRemoved

    private void PSContinueButtonAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PSContinueButtonAncestorRemoved

    }//GEN-LAST:event_PSContinueButtonAncestorRemoved

    private void ControlLabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ControlLabelComponentShown

    }//GEN-LAST:event_ControlLabelComponentShown

    private void ControlLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ControlLabelAncestorAdded
        ControlLabel.setText("Controls: Up/Down/Left/Right = Arrow Keys \t\t\t\t Dash = Space \t\t\t\t P = Pause");
        ControlLabel.setVisible(true);
        ControlLabel.setFocusable(true);
        ControlLabel.requestFocusInWindow();
    }//GEN-LAST:event_ControlLabelAncestorAdded

    private void gameScreenPanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gameScreenPanelFocusLost

    }//GEN-LAST:event_gameScreenPanelFocusLost

    private void LayeredPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LayeredPaneFocusLost
        if(EventListener.getCurrentMap().getMapNum() == 4){
            animator.stop();
            gameScreenPanel.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LayeredPaneFocusLost

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        
    }//GEN-LAST:event_formFocusLost

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentRemoved

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
            java.util.logging.Logger.getLogger(GUIScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                screen = new GUIScreen();
                screen.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContinueButton;
    private javax.swing.JLabel ControlLabel;
    private javax.swing.JButton ExitGameButton;
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JButton PSContinueButton;
    private javax.swing.JButton PSExitGameButton;
    private javax.media.opengl.GLJPanel PauseScreenPanel;
    private javax.media.opengl.GLCanvas gLCanvas1;
    private javax.media.opengl.GLJPanel gameScreenPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newGameButton;
    private javax.media.opengl.GLJPanel startGameScreen;
    private javax.swing.JLabel tipLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    
}
