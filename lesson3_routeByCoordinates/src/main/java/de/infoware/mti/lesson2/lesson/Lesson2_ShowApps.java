package de.infoware.mti.lesson2.lesson;

import androidx.fragment.app.Fragment;

public class Lesson2_ShowApps extends Lesson{
    public Lesson2_ShowApps(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
    }

    @Override
    public void doSomething() {

    }
}
