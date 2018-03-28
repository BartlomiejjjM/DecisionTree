package decisiontree;

import static com.google.common.base.Preconditions.checkNotNull;

public class Answer<Input, Output> implements DecisionTree<Input, Output> {

   private Output answer;

    public Answer(Output answer) {
        checkNotNull(answer, "Answer cannot be null");
        this.answer = answer;
    }


    @Override
    public DecisionTree<Input, Output> yes() {
        return new Answer<>(answer);
    }

    @Override
    public DecisionTree<Input, Output> no() {
        return new Answer<>(answer);
    }

    @Override
    public void yes(DecisionTree<Input, Output> answer) {
        throw new UnsupportedOperationException("Answer cannot answer itself.");
    }

    @Override
    public void no(DecisionTree<Input, Output> answer) {
        throw new UnsupportedOperationException("Answer cannot answer itself.");
    }

    @Override
    public Output ask(Input input) {
        return answer;
    }
}
