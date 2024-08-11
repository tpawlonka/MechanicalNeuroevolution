package org.tpawlonka.mechevo.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.Simulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.Selector;

import java.util.LinkedHashMap;

public class NeuroevolutionContext implements org.tpawlonka.mechevo.interfaces.neuroevolution.NeuroevolutionContext {
    private Population population;
    private Fitness fitness;
    private Selector selector;
    private Mutator mutator;
    private Crossover crossover;
    private Encoder encoder;
    private Decoder decoder;
    private Simulation simulation;

    private LinkedHashMap<Integer, Population> populationHistory;

    private boolean continuousMode = false;

    public NeuroevolutionContext() {
        this.populationHistory = new LinkedHashMap<>();
    }

//    @Override
//    public void evolve(int generations) {
//        if (generations == 0) {
//            while (continuousMode) {
//                this.newGeneration();
//            }
//        } else {
//            for (int i = 0; i < generations; i++) {
//                this.newGeneration();
//            }
//        }
//    }

    @Override
    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public void setMutator(Mutator mutator) {
        this.mutator = mutator;
    }

    @Override
    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }

    @Override
    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    @Override
    public void setPopulation(Population population) {
        this.population = population;
    }

    @Override
    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public Population getPopulation() {
        return this.population;
    }

    @Override
    public void firstGeneration() {
        this.simulation.evaluateFitness(this.population);
        this.populationHistory.putLast(0, this.population.clone());
    }

    private void newGeneration() {
        Population selected = this.selector.select(this.population);
        Population mutated = this.mutator.mutateAll(selected);
        this.population = this.crossover.cross(mutated);
        this.simulation.evaluateFitness(this.population);
        this.populationHistory.putLast(this.populationHistory.size(), this.population.clone());
    }

}
