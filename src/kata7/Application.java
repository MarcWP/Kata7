/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata7;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import kata7.application.swing.HistogramPanel;
import kata7.application.swing.Toolbar;
import kata7.control.CalculateCommand;
import kata7.control.Command;
import kata7.view.AttributeDialog;
import kata7.view.HistogramDisplay;
import kata7.view.PopulationDialog;


/**
 *
 * @author usuario
 */
public class Application extends JFrame {
    
    private Map <String,Command> commands = new HashMap<>();
    private AttributeDialog attributeDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay histogramDisplay;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application(){
        this.deployUI();
        this.createCommand();
    }

    private void deployUI() {
        this.setTitle("Histogram viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramaPanel());
        this.getContentPane().add(toolbar(commands),BorderLayout.NORTH);
    }

    private void createCommand() {
        commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }

    private Component toolbar(Map<String, Command> commands) {
       Toolbar panel =new Toolbar(commands);
       this.attributeDialog = (AttributeDialog) panel;
       this.populationDialog=panel;
       return panel;
    }

    private HistogramPanel histogramaPanel() {
        HistogramPanel panel =new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;
    }
}
