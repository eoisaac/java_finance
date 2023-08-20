package org.eoisaac;

import javax.swing.*;
import org.eoisaac.views.AppFrame;

public class Main {
  public static void main(String[] args) {

    SwingUtilities.invokeLater(
        () -> {
          AppFrame appFrame = new AppFrame();
          appFrame.setVisible(true);
        });
  }
}
