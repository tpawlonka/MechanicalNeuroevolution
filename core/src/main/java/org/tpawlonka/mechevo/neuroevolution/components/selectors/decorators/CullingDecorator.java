package org.tpawlonka.mechevo.neuroevolution.components.selectors.decorators;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Fitness;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Population;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Selector;

public class CullingDecorator implements Selector {
    Selector selector;
    Fitness fitness;
    double percentCutoff = 20;

    CullingDecorator(Selector selector) {
        this.selector = selector;
    }

    @Override
    public Population select(Population population) {
        return this.selector.select(this.cull(population));
    }

    @Override
    public void setFitnessFunction(Fitness fitness) {
        this.fitness = fitness;
    }

    public void setPercentCutoff(double percentCutoff) {
        if (percentCutoff < 0 || percentCutoff > 1) {
            throw new IllegalArgumentException();
        }
        this.percentCutoff = percentCutoff;
    }

    private Population cull(Population population) {
        return population;
    }
}
