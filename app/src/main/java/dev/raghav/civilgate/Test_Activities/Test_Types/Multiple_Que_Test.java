package dev.raghav.civilgate.Test_Activities.Test_Types;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import dev.raghav.civilgate.R;

import static dev.raghav.civilgate.Test_Activities.Main_Test_Activity.queposition;
import static dev.raghav.civilgate.Test_Activities.Main_Test_Activity.questionsJJavaLinkedList;

public class Multiple_Que_Test extends Fragment {
    TextView que_txt;
    RadioGroup radio_grp;
    RadioButton ans1,ans2,ans3,ans4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View MultipleView = inflater.inflate(R.layout.multiple_que , container , false);
        que_txt = MultipleView.findViewById(R.id.que_txtview);
        radio_grp = MultipleView.findViewById(R.id.radio_grp);
        ans1= MultipleView.findViewById(R.id.ans1);
        ans2= MultipleView.findViewById(R.id.ans2);
        ans3= MultipleView.findViewById(R.id.ans3);
        ans4= MultipleView.findViewById(R.id.ans4);
        que_txt.setText(questionsJJavaLinkedList.get(queposition).getQue());
        ans1.setText(questionsJJavaLinkedList.get(queposition).getAns_1());
        ans2.setText(questionsJJavaLinkedList.get(queposition).getAns_2());
        ans3.setText(questionsJJavaLinkedList.get(queposition).getAns_3());
        ans4.setText(questionsJJavaLinkedList.get(queposition).getAns_4());
//        radio_grp.findViewById(R.id.ans1);
//        radio_grp.findViewById(R.id.ans2);
//        radio_grp.findViewById(R.id.ans3);
//        radio_grp.findViewById(R.id.ans3);

        return MultipleView;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {

        super.onAttachFragment(childFragment);
    }
}
