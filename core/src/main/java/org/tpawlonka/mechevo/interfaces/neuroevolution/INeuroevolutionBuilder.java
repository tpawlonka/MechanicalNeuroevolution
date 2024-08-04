package org.tpawlonka.mechevo.interfaces.neuroevolution;

public interface INeuroevolutionBuilder extends INeuroevolution {
    INeuroevolutionContext build() throws IllegalStateException;
}
