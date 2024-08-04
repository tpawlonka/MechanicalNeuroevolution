package org.tpawlonka.mechevo.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.ISimulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.INeuroevolutionContext;
import org.tpawlonka.mechevo.interfaces.neuroevolution.INeuroevolutionBuilder;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.ISelector;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;

import java.util.Objects;
import java.util.stream.Stream;

public class NeuroevolutionBuilder implements INeuroevolutionBuilder {
    private IPopulation population;
    private IFitness fitness;
    private ISelector selector;
    private IMutator mutator;
    private ICrossover crossover;
    private IEncoder encoder;
    private IDecoder decoder;
    private ISimulation simulation;

    private boolean nullCheck() {
        return Stream.of(
            this.population,
            this.fitness,
            this.selector,
            this.mutator,
            this.crossover,
            this.encoder,
            this.decoder).allMatch(Objects::isNull);
    }

    public INeuroevolutionContext build() throws IllegalStateException {
        if (!this.nullCheck()) {
            throw new IllegalStateException("Neuroevolution builder failed to build: missing components");
        }
        NeuroevolutionContext neuroevolution = new NeuroevolutionContext();
        neuroevolution.setCrossover(this.crossover);
        neuroevolution.setEncoder(this.encoder);
        neuroevolution.setDecoder(this.decoder);
        neuroevolution.setFitness(this.fitness);
        neuroevolution.setPopulation(this.population);
        this.selector.setFitnessFunction(this.fitness);
        neuroevolution.setSelector(this.selector);
        neuroevolution.setMutator(this.mutator);
        this.simulation.setFitnessFunction(this.fitness);
        neuroevolution.setSimulation(this.simulation);
        return neuroevolution;
    }

    public void setPopulation(IPopulation population) {
        this.population = population;
    }

    public void setFitness(IFitness fitness) {
        this.fitness = fitness;
    }

    public void setSelector(ISelector selector) {
        this.selector = selector;
    }

    public void setMutator(IMutator mutator) {
        this.mutator = mutator;
    }

    public void setCrossover(ICrossover crossover) {
        this.crossover = crossover;
    }

    public void setEncoder(IEncoder encoder) {
        this.encoder = encoder;
    }

    public void setDecoder(IDecoder decoder) {
        this.decoder = decoder;
    }

    public void setSimulation(ISimulation simulation) {
        this.simulation = simulation;
    }
}
