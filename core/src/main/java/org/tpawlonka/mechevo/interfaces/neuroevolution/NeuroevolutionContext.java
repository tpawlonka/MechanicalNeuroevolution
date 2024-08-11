package org.tpawlonka.mechevo.interfaces.neuroevolution;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Population;

public interface NeuroevolutionContext extends Neuroevolution {
    Population getPopulation();
    void firstGeneration();
}
