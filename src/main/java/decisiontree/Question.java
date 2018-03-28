package decisiontree;

import jdk.internal.util.xml.impl.Input;

import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkNotNull;

public class Question<Input, Output> implements DecisionTree<Input, Output> {

    private Predicate <Input> predicate;
    private DecisionTree<Input, Output> yes ;
    private DecisionTree<Input, Output> no;


    public Question(Predicate<Input> predicate) {
        checkNotNull(predicate, "Question cannot be null");
        this.predicate = predicate;
    }

    @Override
    public DecisionTree<Input, Output> yes() {
        return yes;
    }

    @Override
    public DecisionTree<Input, Output> no() {
        return no;
    }

    @Override
    public void yes(DecisionTree<Input, Output> answer) {
        yes = answer;
    }

    @Override
    public void no(DecisionTree<Input, Output> answer) {
        no = answer;
    }

    @Override
    public Output ask(Input input) {
        return predicate.test(input) ? yes.ask(input) : no.ask(input);
    }
}
