package dev.raghav.civilgate.Test_Activities.Test_Types;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.raghav.civilgate.R;

public class Multiple_Que_Test extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View MultipleView = inflater.inflate(R.layout.multiple_que , container , false);
        return MultipleView;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
