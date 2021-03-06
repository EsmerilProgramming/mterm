/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.aesh.mterm.action.menu

import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.event.ActionEvent

import javax.swing.ImageIcon
import javax.swing.JOptionPane
import javax.swing.JTextArea

/**
 * @author Helio Frota  00hf11 at gmail.com
 */
class MenuFontAction extends MenuBaseAction {

  JTextArea textArea

  MenuFontAction(String text, ImageIcon icon, JTextArea textArea) {
    super(text, icon)
    this.textArea = textArea
  }

  @Override
  void actionPerformed(ActionEvent e) {

    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().availableFontFamilyNames
    String selectedFont = (String) JOptionPane.showInputDialog(null,
        'Font:',
        'Set Font',
        JOptionPane.INFORMATION_MESSAGE,
        null,
        fonts,
        fonts[getCurrentFontIndex(fonts)])

    if (selectedFont) {
      Font currentFont = textArea.font
      textArea.setFont(new Font(selectedFont, currentFont.style, currentFont.size))
    }

  }

  private int getCurrentFontIndex(String[] fonts) {
    int result = 0
    for (int i = 0; i < fonts.length; i++) {
      if (fonts[i] == textArea.font.name) {
        result = i
      }
    }
    result
  }
}
