package org.tpawlonka.mechevo.simulation.adapters;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.ISimulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IFitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IPopulation;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.ISandbox;

public class Box2DSim implements ISimulation {
    IFitness fitness;
    ISandbox sandbox;

    @Override
    public void setFitnessFunction(IFitness fitnessFunction) {
        this.fitness = fitnessFunction;
    }

    @Override
    public void evaluateFitness(IPopulation population) {

    }

    @Override
    public void setSandbox(ISandbox sandbox) {
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
