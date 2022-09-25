package com.example.aahello;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.CarToast;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.Pane;
import androidx.car.app.model.PaneTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;

public class HelloWorldScreen extends Screen {
    public HelloWorldScreen(CarContext carContext) {
        super(carContext);
    }
    public float cantLitros = 0;
    @NonNull
    @Override
    public Template onGetTemplate() {

        Row row = new Row.Builder().setTitle("Calcula tu GAS").addText("Ingresa tus Litros").build();


        //Row litros = new Row.Builder().setTitle(Float.toString(cantLitros)).build();

        Action sumar = new Action.Builder()
                .setOnClickListener(
                        () -> CarToast.makeText(getCarContext(), "Los litros son "+metSuma(), CarToast.LENGTH_LONG).show())
                .setTitle("Sumar")
                .build();



        Action action = new Action.Builder()
                .setOnClickListener(
                        () -> CarToast.makeText(getCarContext(), "Datos Enviados al Servidor", CarToast.LENGTH_SHORT).show())
                .setTitle("Enviar Datos")
                .build();

        return new PaneTemplate.Builder(new Pane.Builder().addRow(row).addAction(sumar).addAction(action).build()).setTitle("FuGas").build();
    }

    private String metSuma() {
        cantLitros = cantLitros+1;
        return Float.toString(cantLitros);
    }

}
