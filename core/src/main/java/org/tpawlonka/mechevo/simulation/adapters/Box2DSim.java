package org.tpawlonka.mechevo.simulation.adapters;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.Simulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Fitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Population;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.Sandbox;

public class Box2DSim implements Simulation {
    Fitness fitness;
    Sandbox sandbox;

    @Override
    public void setFitnessFunction(Fitness fitnessFunction) {
        this.fitness = fitnessFunction;
    }

    @Override
    public void evaluateFitness(Population population) {

    }

    @Override
    public void setSandbox(Sandbox sandbox) {
        this.sandbox = sandbox;
        this.sandbox.setAdapter(this);
    }

    @Override
    public void dryRun() {

    }

    @Override
    public void runOne() {

    }
}
