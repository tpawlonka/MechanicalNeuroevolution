package org.tpawlonka.mechevo.simulation.sadboxes;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.ISimulation;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.ISandbox;

public abstract class AbstractSandbox implements ISandbox {
    ISimulation simulation;
    @Override
    public void setAdapter(ISimulation simulation) {
        this.simulation = simulation;
    }
}
