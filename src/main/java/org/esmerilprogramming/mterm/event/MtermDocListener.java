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
package org.esmerilprogramming.mterm.event;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.esmerilprogramming.mterm.Mterm;

/**
 * Custom implementation of DocumentListener.
 *
 * @author <a href="mailto:00hf11@gmail.com">Helio Frota</a>
 */
public class MtermDocListener implements DocumentListener {

  @Override
  public void changedUpdate(DocumentEvent e) {

  }

  @Override
  public void insertUpdate(DocumentEvent e) {

  }

  @Override
  public void removeUpdate(DocumentEvent e) {

    String PS1 = Mterm.buildPS1();
    try {
      if (e.getDocument().getText(0,  PS1.length() + 1).equals(PS1)) {
        
      }
    } catch (BadLocationException e1) {
      // TODO Auto-generated catch block
     
    }
    
  }

}
