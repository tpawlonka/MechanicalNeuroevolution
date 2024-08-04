package org.tpawlonka.mechevo.neuroevolution;

import org.tpawlonka.mechevo.interfaces.simulation.adapters.ISimulation;
import org.tpawlonka.mechevo.interfaces.neuroevolution.INeuroevolutionContext;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.*;
import org.tpawlonka.mechevo.interfaces.neuroevolution.components.ISelector;

import java.util.LinkedHashMap;

public class NeuroevolutionContext implements INeuroevolutionContext {
    private IPopulation population;
    private IFitness fitness;
    private ISelector selector;
    private IMutator mutator;
    private ICrossover crossover;
    private IEncoder encoder;
    private IDecoder decoder;
    private ISimulation simulation;

    private LinkedHashMap<Integer, IPopulation> populationHistory;

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
    public void setSelector(ISelector selector) {
        this.selector = selector;
    }

    @Override
    public void setEncoder(IEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void setDecoder(IDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public void setMutator(IMutator mutator) {
        this.mutator = mutator;
    }

    @Override
    public void setFitness(IFitness fitness) {
        this.fitness = fitness;
    }

    @Override
    public void setCrossover(ICrossover crossover) {
        this.crossover = crossover;
    }

    @Override
    public void setPopulation(IPopulation population) {
        this.population = population;
    }

    @Override
    public void setSimulation(ISimulation simulation) {
        this.simulation = simulation;
    }

    public IPopulation getPopulation() {
        return this.population;
    }

    @Override
    public void firstGeneration() {
        this.simulation.evaluateFitness(this.population);
        this.populationHistory.putLast(0, this.population.clone());
    }

    private void newGeneration() {
        IPopulation selected = this.selector.select(this.population);
        IPopulation mutated = this.mutator.mutateAll(selected);
        this.population = this.crossover.cross(mutated);
        this.simulation.evaluateFitness(this.population);
        this.populationHistory.putLast(this.populationHistory.size(), this.population.clone());
    }

}
