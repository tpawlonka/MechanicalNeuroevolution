package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

import org.tpawlonka.mechevo.interfaces.Topology;

import java.io.Serializable;

public interface Individual extends Cloneable, Serializable {
    void setFitness(double fitness);
    void setBodyTopology(Topology topology);
    void setNeuralTopology(Topology topology);

    double getFitness();
    Topology getBodyTopology();
    Topology getNeuralTopology();
}
