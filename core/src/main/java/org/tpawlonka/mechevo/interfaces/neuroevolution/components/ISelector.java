package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

public interface ISelector {
    IPopulation select(IPopulation population);

    void setFitnessFunction(IFitness fitness);
}
