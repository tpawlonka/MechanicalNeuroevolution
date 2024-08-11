package org.tpawlonka.mechevo.interfaces.simulation.adapters;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Fitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Population;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.Sandbox;

public interface Simulation {
    void setFitnessFunction(Fitness fitnessFunction);
    void evaluateFitness(Population population);
    void setSandbox(Sandbox sandbox);
    void dryRun();
    void runOne();
}
