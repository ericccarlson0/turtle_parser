//package visualizer;
//
//import execution.Executable;
//import execution.ExecutableSuperClass;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import parserModel.TreeParser;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.util.Duration;
//import parserModel.TurtleContext;
//import parserModel.exceptions.ParsingException;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Controller {
//    private TreeParser myTreeParser;
//    private Visualizer myVisualizer;
//    private List<Executable> history;
//    private List<Executable> executables;
//    private static final Map<String, Class<?>[]> positionParams = Map.of(
//            "setPosition", new Class<?>[]{double.class,double.class,double.class,double.class,double.class},
//            "setTurtleAngle", new Class<?>[]{double.class, double.class, double.class},
//            "hide", new Class<?>[]{double.class, double.class},
//            "clearScreen", new Class<?>[]{double.class});
//
//
//    public Controller () {
//        myTreeParser = new TreeParser();
//        myVisualizer = new Visualizer();
//        myVisualizer.setVariableList(myTreeParser.observableVariables());
//        myVisualizer.setCommandList(myTreeParser.observableCommands());
//        myVisualizer.setLanguageOptions(myTreeParser.getLanguageOptions());
//        myVisualizer.getLanguageProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                myTreeParser.setLanguage(newValue);
//            }
//        });
//        executables = new ArrayList<>();
//        history = new ArrayList<>();
//        myContext = new VisualContext(myVisualizer, executables);
//        start();
//    }
//
//    private void start() {
//        KeyFrame frame = new KeyFrame(Duration.millis(10), e -> { step(); });
//        Timeline animation = new Timeline();
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.getKeyFrames().add(frame);
//        animation.play();
//    }
//
//    private void step () {
//        if(!myVisualizer.getCommand().equals("")) {
//            try{
//            List<Executable> newCommands = myTreeParser.parseString(myVisualizer.getCommand());
//            for(Executable toExecute : newCommands) {
//                try {
//                    Method animationMethod = myVisualizer.getClass().getDeclaredMethod(toExecute.getCommand(), positionParams.get(toExecute.getCommand()));
//                    List<Double> params = new ArrayList<>(List.of(toExecute.getArgs()));
//                    params.add(1.0);
//                    animationMethod.invoke(myVisualizer, params.toArray());
//                    myVisualizer.addExecutedHistory(toExecute.toString());
//                } catch (Exception e) {
//                    System.out.println(toExecute.getCommand());
//                    e.printStackTrace();
//                }
//            }
//            } catch (ParsingException e){
//
//            }
//            myVisualizer.run();
//            myVisualizer.resetCommand();
//            //root.execute(myContext);
//        if (myVisualizer.playHistory()){
//            if (history.size() != 0) {
//                System.out.println(history.get(0)); // *** testing...
//                history.get(0).run(myVisualizer);
//                history.remove(0);
//            } else {
//                myVisualizer.stopHistory();
//            }
//        }
//        String currCommand = myVisualizer.getCommand();
//        if (! currCommand.equals("")) {
//            double result = myTreeParser.parseString(currCommand, myContext);
//            myVisualizer.resetCommand();
//            // root.execute(myContext);
//        } else if (! executables.isEmpty()) {
//            ExecutableSuperClass currExecutable = executables.get(0);
//            currExecutable.run(myVisualizer);
//            myVisualizer.addExecutedHistory(currExecutable.getString());
//            history.add(currExecutable);
//            executables.remove(0);
//        }
//    }
//}