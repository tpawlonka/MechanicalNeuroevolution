package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

import java.io.Serializable;

public interface IPopulation extends Cloneable, Serializable, Iterable<IIndividual> {
    IPopulation clone();
}
