package org.tpawlonka.mechevo.interfaces.neuroevolution;

import org.tpawlonka.mechevo.interfaces.neuroevolution.components.IPopulation;

public interface INeuroevolutionContext extends INeuroevolution {
    IPopulation getPopulation();
    void firstGeneration();
}
