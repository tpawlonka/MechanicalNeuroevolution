package org.tpawlonka.mechevo.neuroevolution.components.selectors;


import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Fitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Individual;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Population;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Selector;

public class DefaultSelector implements Selector {
    Fitness fitness;

    @Override
    public Population select(Population population) {
        for (Individual individual: population) {

        }
        return null;
    }

    @Override
    public void setFitnessFunction(Fitness fitness) {
        this.fitness = fitness;
    }
}
