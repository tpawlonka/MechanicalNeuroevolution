package org.tpawlonka.mechevo.interfaces.simulation.adapters;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IFitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IPopulation;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.ISandbox;

public interface ISimulation {
    void setFitnessFunction(IFitness fitnessFunction);
    void evaluateFitness(IPopulation population);
    void setSandbox(ISandbox sandbox);
    void dryRun();
    void runOne();
}
