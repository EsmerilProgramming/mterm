/*
 * JBoss, Home of Professional Open Source Copyright 2014 Red Hat Inc. and/or its affiliates and
 * other contributors as indicated by the @authors tag. All rights reserved. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License') you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.aesh.mterm.event

import java.awt.event.ActionEvent
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

import javax.swing.AbstractAction
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.KeyStroke

import org.jboss.aesh.mterm.action.ClearAction
import org.jboss.aesh.mterm.action.RunAction
import org.jboss.aesh.mterm.action.TabAction
import org.jboss.aesh.mterm.filter.MtermNavigationFilter

/**
 * @author Helio Frota  00hf11 at gmail.com
 */
class EventConfig {

  private JScrollPane scrollPane
  private JTextArea textArea

  EventConfig(JScrollPane scrollPane, JTextArea textArea) {
    this.scrollPane = scrollPane
    this.textArea = textArea
  }

  void configure() {
    scrollPane.getActionMap().put('unitScrollDown', new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    })

    scrollPane.getActionMap().put('unitScrollUp', new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    })

    textArea.getInputMap().put(KeyStroke.getKeyStroke('ENTER'), 'run')
    textArea.getActionMap().put('run', new RunAction(textArea))
    textArea.getInputMap().put(KeyStroke.getKeyStroke('TAB'), 'tab')
    textArea.getActionMap().put('tab', new TabAction(textArea))
    textArea.getInputMap().put(KeyStroke.getKeyStroke('UP'), 'none')
    textArea.getInputMap().put(KeyStroke.getKeyStroke('DOWN'), 'none')
    textArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK),
            'clear')
    textArea.getActionMap().put('clear', new ClearAction(textArea))

    textArea.setNavigationFilter(new MtermNavigationFilter(textArea))
  }

}
