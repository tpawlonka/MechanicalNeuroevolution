package org.tpawlonka.mechevo.interfaces.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.Simulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;

public interface Neuroevolution {
    void setSelector(Selector selector);
    void setEncoder(Encoder encoder);
    void setDecoder(Decoder decoder);
    void setMutator(Mutator mutator);
    void setFitness(Fitness fitness);
    void setCrossover(Crossover crossover);
    void setPopulation(Population population);
    void setSimulation(Simulation simulation);
}
