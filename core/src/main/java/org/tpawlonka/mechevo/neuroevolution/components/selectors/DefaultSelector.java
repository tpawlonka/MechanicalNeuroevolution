package org.tpawlonka.mechevo.neuroevolution.components.selectors;


import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IFitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IIndividual;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IPopulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.ISelector;

public class DefaultSelector implements ISelector {
    IFitness fitness;

    @Override
    public IPopulation select(IPopulation population) {
        for (IIndividual individual: population) {

        }
        return null;
    }

    @Override
    public void setFitnessFunction(IFitness fitness) {
        this.fitness = fitness;
    }
}
