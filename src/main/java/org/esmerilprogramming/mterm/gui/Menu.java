/*
 * Copyright 2014 EsmerilProgramming.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.esmerilprogramming.mterm.gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import org.esmerilprogramming.mterm.action.menu.MenuBaseAction;
import org.esmerilprogramming.mterm.util.MtermUtil;

/**
 * The menu class.
 *
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
public class Menu {

  private JMenuBar menuBar;

  public Menu() {
    menuBar = new JMenuBar();
  }

  public Menu addMenu(String m) {
    menuBar.add(new JMenu(m));
    return this;
  }

  public Menu addSubMenu(int index, String sm) {
    menuBar.getMenu(index).add(new JMenuItem(sm));
    return this;
  }
  
  public Menu addSubMenu(int index, String sm, ImageIcon icon) {
    menuBar.getMenu(index)
    .add(new JMenuItem(new MenuBaseAction(sm, icon)));
    return this;
  }
  
  public Menu addSubMenu(int index, MenuBaseAction menuAction) {
    menuBar.getMenu(index).add(new JMenuItem(menuAction));
    return this;
  }

  public JMenuBar create() {
    registerActions();
    return this.menuBar;
  }

  private void registerActions() {
   
    this.menuBar.getMenu(4).getItem(0).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {

        try {
          ((MtermUI) menuBar.getParent().getParent().getParent())
              .getTextArea()
              .getDocument()
              .remove(
                  0,
                  ((MtermUI) menuBar.getParent().getParent().getParent()).getTextArea()
                      .getDocument().getLength());
          System.out.print(MtermUtil.INSTANCE.getPs1());
        } catch (BadLocationException e) {
          new MessageDialog().error(e.getMessage());
        }

      }
    });

    this.menuBar.getMenu(4).getItem(1).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {


        String newTitle =
            (String) JOptionPane.showInputDialog(null, "Title:", "Set Title",
                JOptionPane.PLAIN_MESSAGE, null, null, ((JFrame) menuBar.getParent().getParent().getParent()).getTitle());

        if ((newTitle != null) && (!newTitle.isEmpty())) {
          ((JFrame) menuBar.getParent().getParent().getParent()).setTitle(newTitle);
          return;
        }

      }
    });

    this.menuBar.getMenu(5).getItem(0).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        String url = "https://github.com/EsmerilProgramming/mterm";
        try {
          if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
          } else {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("firefox -new-window " + url);
          }
        } catch (Exception e) {
          new MessageDialog().error(e.getMessage());
        }
      }
    });

    this.menuBar.getMenu(5).getItem(1).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
          sb.append(" ");
        }
        sb.append("\n-=-=-=-= Mterm =-=-=-=-");
        sb.append("\n\n\nA simple java terminal emulator");
        for (int i = 0; i < 10; i++) {
          sb.append(" ");
        }
        for (int i = 0; i < 5; i++) {
          sb.append("\n");
        }
        sb.append("Created by Helio Frota");
        new MessageDialog().info(sb.toString());
      }
    });

  }

}
