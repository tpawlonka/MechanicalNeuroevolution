package org.tpawlonka.mechevo.interfaces.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.ISimulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;

public interface INeuroevolution {
    void setSelector(ISelector selector);
    void setEncoder(IEncoder encoder);
    void setDecoder(IDecoder decoder);
    void setMutator(IMutator mutator);
    void setFitness(IFitness fitness);
    void setCrossover(ICrossover crossover);
    void setPopulation(IPopulation population);
    void setSimulation(ISimulation simulation);
}
