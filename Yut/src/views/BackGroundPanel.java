package views;

import models.Yut;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class BackGroundPanel extends JPanel{
  private BufferedImage img;
  private String playerNumber;
  private String pieceNumber;

  public BackGroundPanel() {

    try {
      String path = BackGroundPanel.class.getResource("").getPath();
      img = ImageIO.read(new File(path + "mainBackGround.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setGUI() {
    JLabel initialString = new JLabel("Yut-No-Ri");

    initialString.setFont(new Font("Consolas", Font.BOLD, 40));
    initialString.setForeground(new Color(0x99191c));
    initialString.setVerticalAlignment(SwingConstants.CENTER);
    initialString.setHorizontalAlignment(SwingConstants.CENTER);

    setLayout(new BorderLayout(10, 10));
    setBorder(new EmptyBorder(100 , 100, 100, 100));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.setLayout(new GridLayout(3, 1));
    buttonPanel.add(initialString);

    JPanel enterBtnPanel = new JPanel();
    enterBtnPanel.setOpaque(false);
    enterBtnPanel.setLayout(new BorderLayout());
    enterBtnPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

    JButton enter= new JButton("enter");

    Color pink = new Color(255,160,154);
    Color red = new Color(165, 8, 33);

    enter.setBackground(pink);
    enter.setForeground(Color.WHITE);
    enter.setBorder(new LineBorder(red));

    enter.setOpaque(true);
    enterBtnPanel.add(enter);

    JTextField playerNumberInput = new JTextField("Type # player!");
    JTextField pieceNumberInput = new JTextField("Type # number!");
    buttonPanel.add(playerNumberInput, BorderLayout.SOUTH);
    buttonPanel.add(pieceNumberInput, BorderLayout.SOUTH);

    class UIclick implements MouseListener {
      @Override
      public void mouseClicked(MouseEvent e) {
        YutGui.mainFrame.setVisible(false);

        if (e.getSource().equals(enter)) {
          YutGui.setupYutGUI();
        }
      }
      @Override
      public void mousePressed(MouseEvent e) {
      }
      @Override
      public void mouseReleased(MouseEvent e) {
      }
      @Override
      public void mouseEntered(MouseEvent e) {
      }
      @Override
      public void mouseExited(MouseEvent e) {
      }
    }

    enter.addMouseListener(new UIclick());

    //INPUT TEXT AREA
    playerNumberInput.setBackground(Color.BLUE);
    pieceNumberInput.setBackground(Color.BLUE);

    playerNumberInput.setForeground(Color.WHITE);
    pieceNumberInput.setForeground(Color.WHITE);

    buttonPanel.add(initialString);
    buttonPanel.add(enterBtnPanel, BorderLayout.NORTH);

    add(buttonPanel);
  }

  public BufferedImage getBackgroundImage() {
    return img;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, this);
  }
}
