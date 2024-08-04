package org.tpawlonka.mechevo.neuroevolution.components.selectors.decorators;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IFitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IPopulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.ISelector;

public class CullingDecorator implements ISelector {
    ISelector selector;
    IFitness fitness;
    double percentCutoff = 20;

    CullingDecorator(ISelector selector) {
        this.selector = selector;
    }

    @Override
    public IPopulation select(IPopulation population) {
        return this.selector.select(this.cull(population));
    }

    @Override
    public void setFitnessFunction(IFitness fitness) {
        this.fitness = fitness;
    }

    public void setPercentCutoff(double percentCutoff) {
        if (percentCutoff < 0 || percentCutoff > 1) {
            throw new IllegalArgumentException();
        }
        this.percentCutoff = percentCutoff;
    }

    private IPopulation cull(IPopulation population) {
        return population;
    }
}
