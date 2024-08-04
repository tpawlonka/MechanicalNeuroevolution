package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

public interface IMutator {
    IPopulation mutateAll(IPopulation population);
    IIndividual mutateOne(IIndividual individual);
}
