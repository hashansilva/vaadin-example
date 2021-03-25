package com.freelancer.hashan;

import com.freelancer.hashan.model.Country;
import com.freelancer.hashan.soap.ws.client.generated.CountryInfoService;
import com.freelancer.hashan.soap.ws.client.generated.CountryInfoServiceSoapType;
import com.freelancer.hashan.soap.ws.client.generated.TCountryCodeAndName;
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

    private List<Country> countries = new ArrayList<>();

    public MainView() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));

        CountryInfoService countryInfoService = new CountryInfoService();
        CountryInfoServiceSoapType countryInfoServiceSoapType = countryInfoService.getCountryInfoServiceSoap();

        List<TCountryCodeAndName> countryList = countryInfoServiceSoapType.listOfCountryNamesByCode().getTCountryCodeAndName();
        countryList.forEach(country -> {
            countries.add(new Country(country.getSISOCode(), country.getSName()));
        });

        Grid<Country> grid = new Grid<>(Country.class);
        grid.setItems(countries);

        add(button);
        add(grid);
    }
}
