package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

public interface Selector {
    Population select(Population population);

    void setFitnessFunction(Fitness fitness);
}
