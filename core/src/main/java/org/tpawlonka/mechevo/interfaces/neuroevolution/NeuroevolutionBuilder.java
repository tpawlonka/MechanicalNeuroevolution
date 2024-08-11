package org.tpawlonka.mechevo.interfaces.neuroevolution;

public interface NeuroevolutionBuilder extends Neuroevolution {
    NeuroevolutionContext build() throws IllegalStateException;
}
