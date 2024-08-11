package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

public interface Mutator {
    Population mutateAll(Population population);
    Individual mutateOne(Individual individual);
}
