package org.tpawlonka.mechevo.simulation.sadboxes;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.Simulation;
import org.tpawlonka.mechevo.interfaces.simulation.sandboxes.Sandbox;

public abstract class AbstractSandbox implements Sandbox {
    Simulation simulation;
    @Override
    public void setAdapter(Simulation simulation) {
        this.simulation = simulation;
    }
}
