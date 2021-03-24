package com.freelancer.hashan;

import com.freelancer.hashan.model.Person;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends VerticalLayout {

    private List<Person> personList = new ArrayList<>();

    public MainView() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));

        for (int i = 0; i <= 1000; i++) {
            personList.add(new Person(i, "Test" + i));
        }

        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(personList);

        add(button);
        add(grid);
    }
}
