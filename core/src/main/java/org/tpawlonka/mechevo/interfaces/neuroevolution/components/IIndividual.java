package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

import org.tpawlonka.mechevo.interfaces.ITopology;

import java.io.Serializable;

public interface IIndividual extends Cloneable, Serializable {
    void setFitness(double fitness);
    void setBodyTopology(ITopology topology);
    void setNeuralTopology(ITopology topology);

    double getFitness();
    ITopology getBodyTopology();
    ITopology getNeuralTopology();
}
