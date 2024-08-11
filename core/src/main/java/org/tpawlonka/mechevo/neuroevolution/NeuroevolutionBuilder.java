package org.tpawlonka.mechevo.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.Simulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.NeuroevolutionContext;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Selector;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;

import java.util.Objects;
import java.util.stream.Stream;

public class NeuroevolutionBuilder implements org.tpawlonka.mechevo.interfaces.neuroevolution.NeuroevolutionBuilder {
    private Population population;
    private Fitness fitness;
    private Selector selector;
    private Mutator mutator;
    private Crossover crossover;
    private Encoder encoder;
    private Decoder decoder;
    private Simulation simulation;

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

    public NeuroevolutionContext build() throws IllegalStateException {
        if (!this.nullCheck()) {
            throw new IllegalStateException("Neuroevolution builder failed to build: missing components");
        }
        org.tpawlonka.mechevo.neuroevolution.NeuroevolutionContext neuroevolution = new org.tpawlonka.mechevo.neuroevolution.NeuroevolutionContext();
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

    public void setPopulation(Population population) {
        this.population = population;
    }

    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public void setMutator(Mutator mutator) {
        this.mutator = mutator;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
