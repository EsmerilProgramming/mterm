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
package org.esmerilprogramming.mterm.action.menu;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import org.esmerilprogramming.mterm.gui.MessageDialog;

/**
 * Menu MenuPasteAction class.
 *
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
@SuppressWarnings("serial")
public class MenuPasteAction extends MenuBaseAction {

  private JTextArea textArea;

  public MenuPasteAction(String text, ImageIcon icon, JTextArea textArea) {
    super(text, icon);
    this.textArea = textArea;
  }

  public void actionPerformed(ActionEvent e) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable transferable = clipboard.getContents(null);
    try {
      String clip = transferable.getTransferData(DataFlavor.stringFlavor).toString();
      textArea.replaceRange(clip, textArea.getSelectionStart(), textArea.getSelectionEnd());
    } catch (UnsupportedFlavorException | IOException ex) {
      new MessageDialog().error(ex.getMessage());
    }
  }
}