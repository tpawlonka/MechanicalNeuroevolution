package org.tpawlonka.mechevo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.tpawlonka.mechevo.gui.fields.filters.DecimalsOnlyFilter;
import org.tpawlonka.mechevo.gui.fields.filters.FilterCompositor;
import org.tpawlonka.mechevo.gui.fields.filters.IntegersOnlyFilter;
import org.tpawlonka.mechevo.gui.fields.filters.NumericRangeFilter;

import java.util.stream.Stream;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private double uiScale = 1;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        Table root = new Table();
        root.setFillParent(true);
        root.pad(50);

        //todo: clean up block declarations

        //Left panel labels
        Label[] labels = getLabels();
        Stream.of(labels).forEach(l -> l.setAlignment(Align.right));

        //Left panel controls
        Label emptyLabel = new Label("test", skin);
        TextField generationsField = new TextField("500", skin);
        TextField popSizeField = new TextField("50", skin);
        TextField prototypeButton = new TextField("Show", skin);
        TextField simulationTimeField = new TextField("3600", skin);
        Table coefficientsTable = new Table();
        TextField mutationChanceField = new TextField("0.1", skin);
        SelectBox<Label> mutationRollStratBox = new SelectBox<Label>(skin);
        TextField mutationMaxChangeField = new TextField("0.1", skin);
        Dialog saveLocationDialog = new Dialog("~/Mechevo/Saves", skin);
        Dialog loadedSaveDialog = new Dialog("none", skin);
        SelectBox<Label> gfxModeSelect = new SelectBox<>(skin);
        TextButton simDataButton = new TextButton("Show", skin);

        //Embedded table
        coefficientsTable.defaults().width((int)(30*this.uiScale));
        TextField coefW = new TextField("0.1", skin);
        coefW.setAlignment(Align.center);
        TextField coefE = new TextField("0.1", skin);
        coefE.setAlignment(Align.center);
        TextField coefD = new TextField("0.1", skin);
        coefD.setAlignment(Align.center);
        Label lcoefW = new Label("W", skin);
        lcoefW.setAlignment(Align.center);
        Label lcoefE = new Label("E", skin);
        lcoefE.setAlignment(Align.center);
        Label lcoefD = new Label("E", skin);
        lcoefD.setAlignment(Align.center);
        Widget[] coefficientsWidgets = {lcoefW, coefW, lcoefE, coefE, lcoefD, coefD};
        Stream.of(coefficientsWidgets).forEach(coefficientsTable::add);

//        todo: fix dialogs
//        Actor[] paramWidgets = {emptyLabel, generationsField, popSizeField, prototypeButton, simulationTimeField,
//            controlsTable, mutationChanceField, mutationRollStratBox, mutationMaxChangeField, saveLocationDialog,
//            loadedSaveDialog, gfxModeSelect, simDataButton};
        Actor[] paramWidgets = {emptyLabel, generationsField, popSizeField, new Label("", skin), simulationTimeField,
            coefficientsTable, mutationChanceField, mutationRollStratBox, mutationMaxChangeField, new Label("", skin),
            new Label("", skin), gfxModeSelect, simDataButton};

        IntegersOnlyFilter integersOnlyFilter = new IntegersOnlyFilter();
        DecimalsOnlyFilter decimalsOnlyFilter = new DecimalsOnlyFilter();
        FilterCompositor coefFilter = new FilterCompositor(decimalsOnlyFilter,
            new NumericRangeFilter<>(0.0, 1.0, NumericRangeFilter.Mode.Inclusive));
        bindFilter(integersOnlyFilter, generationsField, popSizeField, simulationTimeField);
        bindFilter(decimalsOnlyFilter, mutationChanceField, mutationMaxChangeField);
        bindFilter(coefFilter, coefW, coefE, coefD);


        Table paramsTable = new Table();
//        root.setDebug(true);
//        paramsTable.setDebug(true);
        Table paramsTableLabels = new Table();
        Table paramsTableFields = new Table();
//        paramsTableLabels.setDebug(true);
//        paramsTableFields.setDebug(true);
        paramsTable.defaults().space(10).expandY().fillY();

        paramsTableLabels.defaults().expand().width((int)(170*this.uiScale)).height((int)(40*this.uiScale)).space(10);
        Stream.of(labels).forEach(l -> paramsTableLabels.add(l).row());

        paramsTableFields.defaults().expand().fillX().height((int)(40*this.uiScale)).space(10);
        Stream.of(paramWidgets).forEach(w -> paramsTableFields.add(w).row());



        paramsTable.add(paramsTableLabels);
        paramsTable.add(paramsTableFields);
        root.add(paramsTable).expand().left();


        TextButton startButton = new TextButton("Start", skin);
        startButton.setName("startButton");
        root.defaults().width((int)(80*this.uiScale)).height((int)(40*this.uiScale)).expand().space(10f);
        root.add(startButton);
        root.defaults().reset();

        root.pack();
        stage.addActor(root);

        Gdx.input.setInputProcessor(stage);
    }

    private Label[] getLabels() {
        Label paramsLabel = new Label("Experiment parameters", skin);
        Label generationsLabel = new Label("Generations: ", skin);
        Label popSizeLabel = new Label("Population size: ", skin);
        Label prototypeLabel = new Label("Loaded body prototype: ", skin);
        Label simulationTimeLabel = new Label("Simulation time: ", skin);
        Label coefficientsLabel = new Label("Coefficients: ", skin);
        Label mutationChanceLabel = new Label("Mutation chance: ", skin);
        Label mutationRollStratLabel = new Label("Mutation rolling strategy: ", skin);
        Label mutationMaxChangeLabel = new Label("Mutation max delta: ", skin);
        Label saveLocationLabel = new Label("Save files directory: ", skin);
        Label loadedSaveLabel = new Label("Loaded save file: ", skin);
        Label gfxModeLabel = new Label("Graphics mode: ", skin);
        Label simDataLabel = new Label("Simulation details: ", skin);

        paramsLabel.setName("paramsLabel");
        generationsLabel.setName("generationsLabel");
        popSizeLabel.setName("popSizeLabel");
        prototypeLabel.setName("prototypeLabel");
        simulationTimeLabel.setName("simulationTimeLabel");
        coefficientsLabel.setName("coefficientsLabel");
        mutationChanceLabel.setName("mutationChanceLabel");
        mutationRollStratLabel.setName("mutationRollStratLabel");
        mutationMaxChangeLabel.setName("mutationMaxChangeLabel");
        saveLocationLabel.setName("saveLocationLabel");
        loadedSaveLabel.setName("loadedSaveLabel");
        gfxModeLabel.setName("gfxModeLabel");
        simDataLabel.setName("simDataLabel");

        return new Label[]{paramsLabel, generationsLabel, popSizeLabel, prototypeLabel, simulationTimeLabel,
            coefficientsLabel, mutationChanceLabel, mutationRollStratLabel, mutationMaxChangeLabel, saveLocationLabel,
            loadedSaveLabel, gfxModeLabel, simDataLabel};
    }

    public static void bindFilter(TextField.TextFieldFilter filter, TextField... fields) {
        Stream.of(fields).forEach(field -> field.setTextFieldFilter(filter));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
