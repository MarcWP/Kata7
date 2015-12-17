/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata7.control;

import kata7.application.swing.HistogramPanel;
import kata7.model.Histogram;
import kata7.view.HistogramBuilder;
import kata7.view.PopulationDialog;
import kata7.view.AttributeDialog;
import kata7.view.HistogramDisplay;

/**
 *
 * @author usuario
 */
public class CalculateCommand implements Command {

    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramDisplay display;

    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramDisplay display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }

    @Override
    public void execute() {
        Histogram histogram = new HistogramBuilder(populationDialog.population()).build(attributeDialog.attribute());
        display.show(histogram);
    }
}
