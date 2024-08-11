package org.tpawlonka.mechevo.interfaces.neuroevolution.components;

import java.io.Serializable;

public interface Population extends Cloneable, Serializable, Iterable<Individual> {
    Population clone();
}
