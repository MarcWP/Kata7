/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata7.view;

import kata7.model.Histogram;

/**
 *
 * @author usuario
 */
public interface HistogramDisplay {
    public Histogram histogram();
    public void show (Histogram histogram);
}
